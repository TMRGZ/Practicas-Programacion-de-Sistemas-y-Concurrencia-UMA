#include "Lista.h"
#include <stdlib.h>
#include <stdio.h>

void crear(T_Lista *lista)
{
	lista->cabeza = NULL;
	lista->cola = NULL;
}

void destruir(T_Lista * lista)
{
	struct TNodo* aux;
	
	while ((*lista).cabeza != NULL)
	{
		aux = (*lista).cabeza->sig;
		free((*lista).cabeza);
		(*lista).cabeza = aux;
	}
	crear(lista);
}

void insertar(T_Lista *lista, int valor)
{
	struct TNodo* aux = malloc(sizeof(struct TNodo));
		aux->valor = valor;
		aux->sig = NULL;
		aux->ant = NULL;
	T_Lista ptr = *lista;
	

	if (ptr.cabeza == NULL && ptr.cola == NULL)
	{
		ptr.cabeza = aux;
		ptr.cola = aux;
	}
	else
	{
		struct TNodo* auxCab = ptr.cabeza;
		struct TNodo* auxCol = ptr.cola;
		int insert = 0;

		while (!insert)
		{
			if (auxCab != NULL)
			{
				if (auxCab->valor < valor)
				{
					auxCab = auxCab->sig;
				}
				else
				{
					aux->sig = auxCab;
					
					if (auxCab->ant == NULL)
					{
						auxCab = aux;
						ptr.cabeza = aux;
					}
					else
					{
						aux->ant = auxCab->ant;
						auxCab->ant->sig = aux;
						auxCab->ant = aux;
					}
					insert = 1;
				}
			}
			if (auxCol != NULL && !insert)
			{
				if (auxCol->valor > valor) 
				{
					auxCol = auxCol->ant;
				}
				else
				{
					if (auxCol->sig == NULL)
					{
						auxCol->sig = aux;
						aux->ant = auxCol;
						ptr.cola = aux;
					}
					else
					{
						aux->sig = auxCol->sig;
						auxCol->sig->ant = aux;
						aux->ant = auxCol;
						auxCol->sig = aux;
					}
				}
				insert = 1;
			}
		}
	}
	*lista = ptr;
}

int eliminar(T_Lista * lista, int valor)
{
	struct TNodo* auxCab = (*lista).cabeza;
	struct TNodo* auxCol = (*lista).cola;
	struct TNodo* aux;
	
	while (auxCab != NULL || auxCol != NULL)
	{
		if (auxCab != NULL && auxCab->valor == valor) 
		{
			if (auxCab->ant == NULL)
			{
				aux = (*lista).cabeza->sig;
				free((*lista).cabeza);
				(*lista).cabeza = aux;
				(*lista).cabeza->ant = NULL;

				if (aux == NULL)
				{
					(*lista).cola = NULL;
				}
			}
			else
			{
				auxCab->ant->sig = auxCab->sig;
				auxCab->sig->ant = auxCab->ant;
				free(auxCab);
			}
			return 1;
		}
		else if (auxCol != NULL && auxCol->valor == valor)
		{
			if (auxCol->sig == NULL)
			{
				aux = (*lista).cola->ant;
				free((*lista).cola);
				(*lista).cola = aux;
				(*lista).cola->sig = NULL;
			}
			else
			{
				auxCol->ant->sig = auxCol->sig;
				auxCol->sig->ant = auxCol->ant;
				free(auxCol);
			}
			return 1;
		}
		else
		{
			if (auxCol != NULL)
			{
				auxCol = auxCol->ant;
			}
			if (auxCab != NULL)
			{
				auxCab = auxCab->sig;
			}
		}
	}
	return 0;
}

void imprimir(T_Lista lista, int direccion)
{
	struct TNodo* aux;

	if (direccion == 0)
	{
		aux = lista.cabeza;

		printf("[ ");
		while (aux != NULL)
		{
			printf("%d, ", aux->valor);
			aux = aux->sig;
		}
		printf(" ] \n");
	}
	else
	{
		aux = lista.cola;

		printf("[ ");
		while (aux != NULL)
		{
			printf("%d, ", aux->valor);
			aux = aux->ant;
		}
		printf(" ] \n");
	}
}
