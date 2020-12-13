cmake_minimum_required(VERSION 3.10)
project(Lista C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Lista
        Lista.c
        Lista.h
        ListaPersona.c
        ListaPersonas.h
        main.c
        Pila.c
        Pila.h
        Principal.c)
