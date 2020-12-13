#ifndef LISTA_H_ 
#define LISTA_H_

#include <stdlib.h>
#include <stdio.h>

typedef struct Lista T_Lista;

struct Lista {
	struct TNodo * cabeza;
	struct TNodo * cola;
};

struct TNodo {
	int valor;
	struct TNodo* sig;
	struct TNodo* ant;
};

void crear(T_Lista *lista);//Crea una lista doblemente enlazada vacía.
void destruir(T_Lista *lista); //Destruye completamente la estructura de la lista.
void insertar(T_Lista *lista, int valor);
int eliminar(T_Lista *lista, int valor);
void imprimir(T_Lista lista, int direccion);

#endif /* LISTA_H_ */
