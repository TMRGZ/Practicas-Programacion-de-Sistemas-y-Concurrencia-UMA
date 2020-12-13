#include "ListaPersonas.h"
#include <stdlib.h>
#include <stdio.h>

void crearListaPersona(ListaPersona *l)
{
	*l = NULL;
}

void recorrerListaPersona(ListaPersona l)
{
	ListaPersona act;
	printf("[");

	if (l != NULL)
	{
		act = l;

		do
		{
			act = act->sig;
			printf("(%s, %d)", l->pers.nombre, l->pers.edad);
		} while (act != l);
	}

	printf("]\n");
}

void insertarListaPersonas(ListaPersona *l, struct Persona p)
{
	//Insertamos de forma ordenada
	ListaPersona act = *l, aux;

	aux = (ListaPersona)malloc(sizeof(struct Nodo));
		aux->pers = p;
		aux->sig = NULL;

	if (*l == NULL)
	{
		*l = aux;
		aux->sig = aux;
	}
	else
	{
		if (act->pers.edad < p.edad)
		{
			act->sig = (*l)->sig;
			(*l)->sig = aux;
			*l = (*l)->sig;
		}
		else if (act->sig->pers.edad > p.edad)
		{
			aux->sig = act->sig;
			act->sig = aux;
		}
		else
		{
			act = act->sig;
			
			while (act->sig->pers.edad < p.edad)
			{
				act = act->sig;
			}
		}
	}
}