cmake_minimum_required(VERSION 3.9)
project(Practica_2 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Practica_2
        arbolbb.h
        ArbolC.c
        main.c
        Practica2B.c)
