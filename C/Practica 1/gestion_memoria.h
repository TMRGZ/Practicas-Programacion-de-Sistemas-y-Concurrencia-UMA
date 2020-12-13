/*
 * gestion_memoria.h
 *
 *  Created on: dd/mm/aaaa
 *  Author: Miguel Angel Ruiz Gomez
 */

#ifndef _GESTION_MEMORIA_
#define _GESTION_MEMORIA_

typedef struct T_Nodo* T_Manejador;

struct T_Nodo {
	unsigned inicio;
	unsigned fin;
	T_Manejador sig;
};

const unsigned MAX = 1000;

/* Crea la estructura utilizada para gestionar la memoria disponible. Inicialmente, sólo un nodo desde 0 a MAX */
void crear(T_Manejador* manejador)
{
	*manejador = (T_Manejador)malloc(sizeof(struct T_Nodo));
	(*manejador)->inicio = 0;
	(*manejador)->fin = MAX - 1;
	(*manejador)->sig = NULL;
}

/* Destruye la estructura utilizada (libera todos los nodos de la lista. El parámetro manejador debe terminar apuntando a NULL */
void destruir(T_Manejador* manejador)
{
	T_Manejador aux;

	while (*manejador!=NULL)
	{
		aux = *manejador;
		*manejador = aux->sig;
		free(aux);
	}
}

/* Devuelve en “dir” la dirección de memoria “simulada” (unsigned) donde comienza el trozo de memoria continua de tamaño “tam” solicitada.
Si la operación se pudo llevar a cabo, es decir, existe un trozo con capacidad suficiente, devolvera TRUE (1) en “ok”; FALSE (0) en otro caso.
 */
void obtener(T_Manejador *manejador, unsigned tam, unsigned* dir, unsigned* ok)
{
	T_Manejador ant = NULL, act = *manejador;
	*ok = 0;

	while (act!=NULL && !(*ok))
	{
		if (tamBloque(act)>=tam)
		{
			*ok = 1;
		}
		else
		{
			ant = act;
			act = act->sig;
		}
	}

	if (*ok)
	{
		*dir = act->inicio;
		act->inicio = act->inicio + tam;

		if (act->fin<act->inicio) // Hay que eliminar el nodo act
		{
			if (ant==NULL) // Es el primer nodo
			{
				*manejador = act->sig;
			}
			
			else // No es el primer nodo
			{
				ant->sig = act->sig;
			}
			free(act);
		}
	}
}

int tamBloque(struct T_Nodo *nodo)
{
	return nodo->fin - nodo->inicio + 1;
}

/* Muestra el estado actual de la memoria, bloques de memoria libre */
void mostrar(T_Manejador manejador)
{
	printf("[");

	while (manejador!=NULL)
	{
		printf("(%d, %d)", manejador->inicio, manejador->fin);
		manejador = manejador->sig;
	}

	printf("] \n");
}

/* Devuelve el trozo de memoria continua de tamaño “tam” y que
 * comienza en “dir”.
 * Se puede suponer que se trata de un trozo obtenido previamente.
 */
void devolver(T_Manejador *manejador, unsigned tam, unsigned dir)
{
	T_Manejador act = *manejador, ant = NULL, aux;

	while (act!=NULL && act->inicio<dir)
	{
		ant = act;
		act = act->sig;
	}

	if (ant==NULL && act==NULL)
	{
		*manejador = (T_Manejador)malloc(sizeof(struct T_Nodo));
		(*manejador)->inicio = dir;
		(*manejador)->fin = dir + tam - 1;
		(*manejador)->sig = NULL;
	}
	else if (ant==NULL) // El bloque va delante del primero
	{
		if (dir+tam == act->inicio)
		{
			act->inicio = dir;
		}
		else
		{
			aux = (T_Manejador)malloc(sizeof(struct T_Nodo));
			aux->inicio = dir;
			aux->fin = dir + tam - 1;
			aux->sig = *manejador;
			*manejador = aux;
		}
	}
}

#endif
