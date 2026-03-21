#!/usr/bin/env python3
"""
extract_assets.py
=================
Unpack PoN.sp and PoN.jar into the data/ subdirectories that the PC port
reads at runtime.  Run this once from the repository root:

    python3 tools/extract_assets.py

Output
------
  data/sp/00.bin … data/sp/39.bin   — 40 raw binary entries from PoN.sp
  data/jar/**                        — resource files from PoN.jar
                                       (.class files and Thumbs.db excluded)

PoN.sp format
-------------
  Bytes 0-299    : 75 big-endian int32 "dat" header
  dat[16..55]    : sizes (bytes) of the 40 packed entries
  Byte offset    : entries start at SP_DATA_START = 3544

PoN.jar format
--------------
  Standard ZIP / JAR.  The inner .jar files (quest/scenario) are kept as-is.
"""

import os
import struct
import zipfile

REPO_ROOT = os.path.dirname(os.path.abspath(__file__))
# Resolve the actual repo root (script lives one level down in tools/)
REPO_ROOT = os.path.dirname(REPO_ROOT)

SP_PATH  = os.path.join(REPO_ROOT, "PoN.sp")
JAR_PATH = os.path.join(REPO_ROOT, "PoN.jar")
SP_OUT   = os.path.join(REPO_ROOT, "data", "sp")
JAR_OUT  = os.path.join(REPO_ROOT, "data", "jar")

SP_DATA_START = 3544   # byte offset where the 40 entries begin
NUM_ENTRIES   = 40
SIZE_BASE_IDX = 16     # dat[16..55] hold the 40 entry sizes

SKIP_EXT   = {".class"}
SKIP_NAMES = {"Thumbs.db"}


def extract_sp() -> None:
    os.makedirs(SP_OUT, exist_ok=True)
    with open(SP_PATH, "rb") as f:
        sp = f.read()

    dat = struct.unpack(">75I", sp[:300])

    offsets = [SP_DATA_START]
    for i in range(1, NUM_ENTRIES):
        offsets.append(offsets[-1] + dat[SIZE_BASE_IDX + i - 1])

    print(f"Extracting {NUM_ENTRIES} SP entries …")
    for n in range(NUM_ENTRIES):
        size = dat[SIZE_BASE_IDX + n]
        path = os.path.join(SP_OUT, f"{n:02d}.bin")
        if size == 0:
            open(path, "wb").close()
            print(f"  {n:02d}.bin  (empty placeholder)")
        else:
            blob = sp[offsets[n]: offsets[n] + size]
            with open(path, "wb") as f:
                f.write(blob)
            print(f"  {n:02d}.bin  {size:7d} B  @ offset {offsets[n]}")


def extract_jar() -> None:
    os.makedirs(JAR_OUT, exist_ok=True)
    print(f"\nExtracting PoN.jar resources …")
    with zipfile.ZipFile(JAR_PATH) as z:
        for info in z.infolist():
            name = info.filename
            if name.endswith("/"):
                continue
            if os.path.basename(name) in SKIP_NAMES:
                continue
            _, ext = os.path.splitext(name)
            if ext.lower() in SKIP_EXT:
                continue
            dest = os.path.join(JAR_OUT, name)
            os.makedirs(os.path.dirname(dest), exist_ok=True)
            with z.open(info) as src, open(dest, "wb") as dst:
                dst.write(src.read())
            print(f"  {name}")


if __name__ == "__main__":
    extract_sp()
    extract_jar()
    print("\nDone.  Commit the data/ directory alongside the source.")
