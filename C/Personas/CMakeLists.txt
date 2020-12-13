cmake_minimum_required(VERSION 3.10)
project(Personas C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(Personas
        Persona.h
        Personas.c)
