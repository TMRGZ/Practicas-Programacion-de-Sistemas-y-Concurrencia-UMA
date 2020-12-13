/*
 * Lista.h
 *
 *  Created on: 9 mar. 2018
 *      Author: mmar
 */

#ifndef LISTA_H_
#define LISTA_H_

typedef struct NodoLista* Lista;
struct NodoLista{
	int elem;
	Lista sig;
};


void crearLista(Lista *l);
void recorrerLista(Lista l);
int listaVacia(Lista l);
void insertarLista(Lista *l,int elem);
//inserta de forma ordenada elem en l
int extraer(Lista *l,int elem);
// extrae elem de l, si está, sino devuelve -1
int crearListaDesdeFichero(char *nombre, Lista *l);
int crearListaDesdeFicheroBinario(char *nombre, Lista *l);

#endif /* LISTA_H_ */
