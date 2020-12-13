#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "arbolbb.h"

// Crea la estructura utilizada para gestionar la memoria disponible.
void Crear(T_Arbol* arbol)
{
	*arbol = NULL;
}

// Destruye la estructura utilizada.
void Destruir(T_Arbol* arbol)
{
	if((*arbol)!=NULL)
	{
		Destruir(&(*arbol)->der);
		Destruir(&(*arbol)->izq);
		free(*arbol);
		*arbol = NULL;
	}
}

// Inserta num en el arbol
void InsertarRecursivo(T_Arbol *arbol, unsigned num)
{
	if (*arbol == NULL)
	{
		*arbol = (T_Arbol)malloc(sizeof(struct T_Nodo));
			(*arbol)->dato = num;
			(*arbol)->izq = NULL;
			(*arbol)->der = NULL;
	}
	else if ((*arbol)->dato > num)
	{
		InsertarRecursivo(&(*arbol)->izq, num);
	}
	else if ((*arbol)->dato < num)
	{
		InsertarRecursivo(&(*arbol)->der, num);
	}
}

void InsertarIterativo(T_Arbol *arbol, unsigned num)
{
	T_Arbol act = *arbol, ant = NULL;
	T_Arbol aux = (T_Arbol)malloc(sizeof(struct T_Nodo));
		aux->dato = num;
		aux->der = NULL;
		aux->izq = NULL;

	unsigned enc = 0;

	while (act != NULL && !enc)
	{
		ant = act;

		if (ant->dato > num)
		{
			act = act->izq;
		}
		else if (ant->dato < num)
		{
			act = act->der;
		}
		else
		{
			enc = 1;
		}
	}
	if (!enc)
	{
		if (ant == NULL)
		{
			*arbol = aux;
		}
		else
		{
			if (ant->dato > num)
			{
				ant->izq = aux;
			}
			else
			{
				ant->der = aux;
			}
		}
	}
}

void Insertar(T_Arbol* arbol,unsigned num)
{
	InsertarRecursivo(arbol, num);
}



// Muestra el contenido del árbol en InOrden
void imprimir(T_Arbol arbol)
{
	if (arbol != NULL)
	{
		imprimir(arbol->izq);
		printf("%d ", arbol->dato);
		imprimir(arbol->der);
	}
}

void Mostrar(T_Arbol arbol)
{
	printf("[ ");
	imprimir(arbol);
	printf(" ] \n");
}


// Guarda en disco el contenido del arbol
void Salvar(T_Arbol arbol, FILE* fichero)
{
	if(arbol != NULL)
	{
		if (arbol->izq != NULL)
		{
			Salvar(arbol->izq, fichero);
		}
		//fprintf(fichero, "%d ", arbol->dato);
		fwrite(&(arbol->dato), sizeof(unsigned), 1, fichero);
		
		if (arbol->der != NULL)
		{
			Salvar(arbol->der, fichero);
		}
	}
}
