cmake_minimum_required(VERSION 3.16)
project(PoNPCPort VERSION 1.0 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(SDL2 REQUIRED)
find_package(SDL2_mixer REQUIRED)
find_package(SDL2_ttf REQUIRED)
find_package(SDL2_image REQUIRED)
find_package(ZLIB REQUIRED)
find_package(PkgConfig REQUIRED)
pkg_check_modules(LIBZIP REQUIRED libzip)

set(PLATFORM_SOURCES
    platform/Graphics.cpp
    platform/Image.cpp
    platform/Audio.cpp
    platform/Input.cpp
    platform/Resources.cpp
    platform/Font.cpp
)

set(GAME_SOURCES
    src/cpp/main.cpp
    src/cpp/Skill.cpp
    src/cpp/Waza.cpp
    src/cpp/Mail.cpp
    src/cpp/Tip.cpp
    src/cpp/Okimono.cpp
    src/cpp/BtPanel.cpp
    src/cpp/Edit.cpp
    src/cpp/Folder.cpp
    src/cpp/Rock.cpp
    src/cpp/Ene.cpp
    src/cpp/CpDataDownload.cpp
    src/cpp/Attack.cpp
    src/cpp/CpCanvas.cpp
)

add_executable(PoNPCPort ${PLATFORM_SOURCES} ${GAME_SOURCES})

target_include_directories(PoNPCPort PRIVATE
    ${SDL2_INCLUDE_DIRS}
    ${LIBZIP_INCLUDE_DIRS}
    platform
    src/cpp
)

target_link_libraries(PoNPCPort PRIVATE
    SDL2::SDL2
    SDL2::SDL2main
    SDL2_mixer::SDL2_mixer
    SDL2_ttf::SDL2_ttf
    SDL2_image::SDL2_image
    ZLIB::ZLIB
    ${LIBZIP_LIBRARIES}
)

# Copy game data files to build directory after build
add_custom_command(TARGET PoNPCPort POST_BUILD
    COMMAND ${CMAKE_COMMAND} -E copy_if_different
        "${CMAKE_SOURCE_DIR}/PoN.jar"
        "${CMAKE_SOURCE_DIR}/PoN.sp"
        $<TARGET_FILE_DIR:PoNPCPort>
    COMMENT "Copying game data files"
)
