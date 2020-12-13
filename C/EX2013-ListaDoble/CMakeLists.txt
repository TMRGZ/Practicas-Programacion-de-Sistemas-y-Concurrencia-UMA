cmake_minimum_required(VERSION 3.10)
project(EX2013_ListaDoble C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(EX2013_ListaDoble
        Lista.c
        Lista.h
        main.c)
