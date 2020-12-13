cmake_minimum_required(VERSION 3.9)
project(LinkedListBUGS C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(LinkedListBUGS
        FindTheBugs.c
        LinkedList.c
        LinkedList.h)
