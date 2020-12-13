#include "Cola.h"
#include <stdio.h>
#include <stdlib.h>

void crear(Cola * cola)
{
	cola->primero = NULL;
	cola->ultimo = NULL;
}

void insertar(Cola * cola, unsigned * v)
{
	Puntero aux = malloc(sizeof(struct Nodo));
		aux->v[0] = v[0];
		aux->v[1] = v[1];
		aux->sig = NULL;

	if (cola->primero==NULL)
	{
		cola->primero = aux;
	}
	else
	{
		cola->ultimo->sig = aux;
	}
	cola->ultimo = aux;
}

int extraer(Cola * cola, unsigned * v)
{
	Puntero aux;
	
	if (!colaVacia(*cola))
	{
		return -1;
	}
	else
	{
		aux = cola->primero;
		cola->primero = cola->primero->sig;
		
		if (!colaVacia(*cola))
		{
			cola->ultimo = NULL;
		}
		
		v[0] = aux->v[0];
		v[1] = aux->v[1];
		free(aux);
	}
	return 0;
}

int colaVacia(Cola cola)
{
	return cola.primero == NULL && cola.ultimo == NULL;
}

void recorrer(Cola cola)
{
	Cola aux = cola;

	printf("[ ");
	while (aux.primero != NULL)
	{
		printf("{ %d , %d }", aux.primero->v[0], aux.primero->v[1]);
		aux.primero = aux.primero->sig;
	}
	printf(" ]");
}

void destruir(Cola *cola)
{
	Cola ptr = *cola;

	while (ptr.primero != NULL)
	{
		Cola aux = ptr;
		ptr.primero = ptr.primero->sig;
		free(aux.primero);
	}
	crear(cola);
}
