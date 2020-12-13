#pragma once
#ifndef PLANIFICADOR_H
#define	PLANIFICADOR_H

#include <stdio.h>
#include <stdlib.h>

typedef struct TNodo * T_Planificador;
struct TNodo {
	char *id;
	int pri;
	T_Planificador sig;
};

/*Inicializa el planificador creando un planificador vacío*/
void crear(T_Planificador *planif);

/*Inserta una nueva tarea id de prioridad pri en el planificador planif.
La lista está ordenada por prioridad y en el caso de que exista una tarea 
con la misma prioridad se almacenará por orden de llegada.El identificador de tarea es único*/
void insertar_tarea(T_Planificador *planif, int pri, char *id);

/*Muestra el estado del planificador*/
void mostrar(T_Planificador planificador);

/*Dado un planificador, elimina una tarea id que está preparada para ejecución. 
En el caso de que no exista dicha tarea, se devolverá 0 en el parámetro ok. 
OK valdrá 1 en el caso de que se haya realizado el borrado.*/
void eliminar_tarea(T_Planificador *planif, char *id, unsigned *ok);

/*Extrae de la estructura la tarea que le corresponde ejecutarse*/
void planificar(T_Planificador *planif);

/*Destruye toda la estructura eliminando y liberando la memoria de todos los nodos*/
void destruir(T_Planificador *planif);

#endif	/* PLANIFICADOR_H */