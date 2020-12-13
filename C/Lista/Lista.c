#include "Lista.h"
#include <stdlib.h>
#include <stdio.h>

void crearLista(Lista *l)
{
	*l = NULL;
}

int crearListaDesdeFichero(char *nombre, Lista *l)
{
	crearLista(l);
	FILE *f = fopen(nombre, "r");
	int n;

	if (f==NULL)
	{
		perror("error");
		return -1;
	}
	else
	{
		while (fscanf(f,"%d", &n)==1)
		{
			insertarLista(l, n);
		}
		
		fclose(f);
		return 0;
	}
}

int crearListaDesdeFicheroBinario(char *nombre, Lista *l)
{
	FILE *f = fopen(nombre, "rb");
	int i;

	if (f == NULL)
	{
		perror("No existe");
		return -1;
	}
	else
	{
		while (fread(&i, sizeof(int), 1,f)==1)
		{
			insertarLista(&l, i);
		}
		fclose(f);
		return 0;
	}
}

void recorrerLista(Lista l)
{
	printf("[ ");

	while (l!=NULL)
	{
		printf("%d ", l->elem);
		l = l->sig;
	}
	printf("]\n");
}

int listaVacia(Lista l)
{
	return l == NULL;
}

void insertarLista(Lista *l, int elem)
{
	Lista act = *l, ant = NULL;
	Lista aux = (Lista)malloc(sizeof(struct NodoLista));
		aux->elem = elem;
		aux->sig = NULL;

	if (*l==NULL)
	{
		*l = aux;
	}

	else
	{
		while (act != NULL && act->elem < elem)
		{
			ant = act;
			act = act->sig;
		}
		if (ant == NULL)
		{
			aux->sig = *l;
			*l = aux;
		}
		else
		{
			aux->sig = act;
			ant->sig = aux;
		}
	}
}

int extraer(Lista *l, int elem)
{
	Lista ant = NULL, act = *l;

	while (act!=NULL && act->elem < elem)
	{
		ant = act;
		act = act->sig;
	}

	if (act == NULL || act->elem != elem)
	{
		return -1;
	}
	else if (ant == NULL)
	{
		*l = act->sig;
	}
	else
	{
		ant->sig = act->sig;
	}
	free(act);
	return 0;
}