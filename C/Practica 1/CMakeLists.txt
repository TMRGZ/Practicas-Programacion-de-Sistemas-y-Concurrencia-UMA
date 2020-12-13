cmake_minimum_required(VERSION 3.10)
project(Practica_1 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Practica_1
        gestion_memoria.h
        practica1.c)
