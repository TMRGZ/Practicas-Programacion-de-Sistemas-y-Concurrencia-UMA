cmake_minimum_required(VERSION 3.10)
project(DoubleLinkedListBUGS C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(DoubleLinkedListBUGS
        FindTheBugs.c
        LinkedList.c
        LinkedList.h)
