#include "ListaCircular.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void crear(TListaCircular * lc)
{
	*lc = NULL;
}

void insertar(TListaCircular *lc, char *nombre)
{
	TListaCircular aux, act;
	aux = (TListaCircular)malloc(sizeof(struct TNodo));
		strcpy(aux->nombre, nombre);
		aux->sig = aux;
	
	if (*lc != NULL)
	{
		act = *lc;
		aux->sig = act->sig;
		act->sig = aux;
	}
	*lc = aux;
}

void recorrer(TListaCircular lc)
{
	printf("[ ");
	int i = 0;
	TListaCircular aux = lc->sig;

	while (i < longitud(aux))
	{
		printf("%s ", aux->nombre);
		aux = aux->sig;
		i++;
	}
	printf("]\n");
}

int longitud(TListaCircular lc)
{
	int lon = 1;
	TListaCircular aux = lc->sig;

	while (aux != NULL && lc != aux)
	{
		lon++;
		aux = aux->sig;
	}
	
	return lon;
}

void mover(TListaCircular * lc, int n)
{
	for (int i = 0; i < n; i++)
	{
		(*lc) = (*lc)->sig;
	}
}

void extraer(TListaCircular * lc, char * nombre)
{
	if(lc != NULL)
	{
		TListaCircular act = *lc, aux = NULL;

		if(longitud(act)==1)
		{
			free(act);
			*lc = NULL;
		}
		else
		{
			aux = act->sig;
			printf(aux->nombre);
			act->sig = aux->sig;

			strcpy(nombre, aux->nombre);
			free(aux);
		}
	}
}
