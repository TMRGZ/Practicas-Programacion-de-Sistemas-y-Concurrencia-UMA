/*
 * Pila.h
 *
 *  Created on: 9 mar. 2018
 *      Author: mmar
 */

#ifndef PILA_H_
#define PILA_H_

typedef struct Nodo* Pila;
struct Nodo{
	int elem;
	Pila sig;
};

//inicializa p a NULL
void crear(Pila* p);

void mostrar(Pila p);

void insertar(Pila* p,int elem);

int pilaVacia(Pila p);

int extraer(Pila *p,int *elem);

void borrar(Pila *p);

#endif /* PILA_H_ */
