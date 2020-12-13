#include "Planificador.h"
#include <string.h>

void crear(T_Planificador *planif)
{
	*planif = NULL;
}

void insertar_tarea(T_Planificador *planif, int pri, char * id)
{
	T_Planificador aux = malloc(sizeof(struct TNodo));
		aux->id = id;
		aux->pri = pri;
		aux->sig = NULL;
	T_Planificador ptr = *planif, ant = NULL;
	int ok = 0;

	if (*planif == NULL)
	{
		*planif = aux;
	}
	else
	{
		while (ptr != NULL && !ok)
		{
			if (ptr->pri > aux->pri)
			{
				ant = ptr;
				ptr = ptr->sig;
			}
			else if (ptr->pri < aux->pri)
			{
				if (ant != NULL)
				{
					ant->sig = aux;
					aux->sig = ptr;
				}
				else
				{
					aux->sig = ptr;
					*planif = aux;
				}
				ok = 1;
			}
			else
			{
				aux->sig = ptr->sig;
				ptr->sig = aux;
				ok = 1;
			}
		}
		if (!ok)
		{
			aux->sig = NULL;
			ant->sig = aux;
		}
	}
}

void mostrar(T_Planificador planificador)
{
	T_Planificador aux = planificador;

	while (aux != NULL)
	{
		printf("ID: %s, Prior: %d \n", aux->id, aux->pri);
		aux = aux->sig;
	}
	printf("- \n");
}

void eliminar_tarea(T_Planificador *planif, char * id, unsigned * ok)
{
	T_Planificador aux = *planif, ant = NULL;

	while (aux != NULL && (*ok)==0)
	{
		if (strcmp(id, aux->id) != 0)
		{
			ant = aux;
			aux = aux->sig;
		}
		else
		{
			if (ant != NULL)
			{
				ant->sig = aux->sig;
			}
			else
			{
				*planif = aux->sig;
			}
			free(aux);
			*ok = 1;
		}
	}
}

void planificar(T_Planificador *planif)
{
	T_Planificador aux = *planif;
	aux = aux->sig;
	*planif = aux;
}

void destruir(T_Planificador *planif)
{
	T_Planificador ptr = *planif;

	while (ptr != NULL)
	{
		T_Planificador aux = ptr;
		ptr = ptr->sig;
		free(aux);
	}
	crear(planif);
}
