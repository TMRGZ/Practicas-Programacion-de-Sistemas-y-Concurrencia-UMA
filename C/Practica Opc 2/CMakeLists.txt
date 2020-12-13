cmake_minimum_required(VERSION 3.9)
project(Practica_Opc_2 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Practica_Opc_2
        lista.c
        lista.h
        prPalabras3_13.c
        test_lista.c)
