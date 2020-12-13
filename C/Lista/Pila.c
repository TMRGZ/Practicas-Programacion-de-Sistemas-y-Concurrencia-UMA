/*
 * Pila.c
 *
 *  Created on: 9 mar. 2018
 *      Author: mmar
 */


#include "Pila.h"
#include <stdlib.h>

void crear(Pila* p){
	*p=NULL;
}

void mostrar(Pila p){
	//Pila aux = p;
	while (p!=NULL){
		printf("%d ",p->elem);
		p = p->sig;
	}
}

void insertar(Pila* p,int elem){
	Pila aux = (Pila)malloc(sizeof(struct Nodo ));
	aux->elem = elem;
	aux->sig = *p;
	*p = aux;
}

int pilaVacia(Pila p){

	return p == NULL;
}

int extraer(Pila *p,int *elem){
	Pila aux = *p;
	if (pilaVacia(*p)) return -1;
	*p = aux->sig;
	*elem = aux->elem;
	free(aux);
	return 0;
}

void borrar(Pila *p){
	Pila aux;
	while (*p!=NULL){
		aux = *p;
		*p = aux->sig;
		free(aux);
	}
}
