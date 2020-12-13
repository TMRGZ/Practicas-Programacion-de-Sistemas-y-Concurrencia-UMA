cmake_minimum_required(VERSION 3.9)
project(Practica_Opc_1 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Practica_Opc_1
        ListaCircular.c
        ListaCircular.h
        Principal.c)
