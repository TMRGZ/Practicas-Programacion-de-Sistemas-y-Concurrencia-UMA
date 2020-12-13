cmake_minimum_required(VERSION 3.10)
project(EX2012_Planificador C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(EX2012_Planificador
        main.c
        Planificador.c
        Planificador.h)
