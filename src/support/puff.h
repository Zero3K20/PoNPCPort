/*
 * puff.h
 * Copyright (C) 2002-2013 Mark Adler
 * For conditions of distribution and use, see copyright notice in puff.c
 * version 2.3, 21 Jan 2013
 */

#ifndef PUFF_H
#define PUFF_H

#ifdef __cplusplus
extern "C" {
#endif

/* Compress source[0..sourcelen-1] into dest[0..destlen-1].  *destlen and
   *sourcelen are updated to the size compressed and decompressed.  On entry,
   the lengths are the sizes of the output and input buffers.  Returns zero on
   success, negative if there was an error in the source data, or a positive
   error otherwise.  If a convenient int type is used, the values are:
      2:  available inflate data did not terminate
      1:  output space exhausted before completing inflate
      0:  successful inflate
     -1:  invalid block type (type == 3)
     -2:  stored block length did not match one's complement
     -3:  dynamic block code description: too many length or distance codes
     -4:  dynamic block code description: code lengths codes incomplete
     -5:  dynamic block code description: repeat lengths with no first length
     -6:  dynamic block code description: repeat more than specified lengths
     -7:  dynamic block code description: invalid literal/length or distance code
     -8:  dynamic block code description: missing end-of-block code
     -9:  invalid literal/length or distance code in fixed or dynamic block
    -10:  distance is too far back in fixed or dynamic block
 */
int puff(unsigned char *dest,           /* pointer to destination pointer */
         unsigned long *destlen,        /* amount of output space */
         const unsigned char *source,   /* pointer to source data pointer */
         unsigned long *sourcelen);     /* amount of input available */

#ifdef __cplusplus
}
#endif

#endif /* PUFF_H */
