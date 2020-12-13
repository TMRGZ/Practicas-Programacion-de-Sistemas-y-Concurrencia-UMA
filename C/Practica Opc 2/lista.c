#include <stdio.h>
#include <stdlib.h>
#include "lista.h"
#include <string.h>

void crear(Lista *l) {
    *l = NULL;
}

int lista_vacia(Lista l) {
    return l == NULL;
}

void escribir(Lista l) {

    printf("[ ");
    Lista aux = l;

    while (aux != NULL) {
        printf("%s ", aux->palabra);
        aux = aux->sig;
    }
    printf(" ]\n");

    /*
	if (l != NULL)
	{
		printf("%s ", l->palabra);
		escribir(l->sig);
	}
	printf("\n");*/
}

void escribir_fichero(FILE *fp, Lista l) {
    if (fp == NULL) {
        perror("error");
    } else {
        Lista aux = l;
        while (aux != NULL) {
            fprintf(fp, "%s ", aux->palabra);
            aux = aux->sig;
        }
        fclose(fp);
    }
}

void insertar(char *palabra, Lista *l) {
    if (!buscar_palabra(palabra, *l)) {
        Lista aux = (Lista) malloc(sizeof(struct item));
        strcpy(aux->palabra, palabra);
        aux->sig = NULL;
        Lista act = *l, ant = NULL;

        if (*l == NULL) {
            *l = aux;
        } else {
            while (act != NULL) {
                ant = act;
                act = act->sig;
            }
            aux->sig = act;
            ant->sig = aux;
        }
    }
}

void destruir(Lista *l) {
    /*
    Lista ptr = *l;

    while (ptr != NULL)
    {
        Lista aux = ptr;
        ptr = ptr->sig;
        printf("%s ", aux->palabra);
        free(aux);
    }
    *l = NULL;
    */
    if ((*l) != NULL) {
        printf("%s ", (*l)->palabra);
        destruir(&((*l)->sig));
        free(*l);
        *l = NULL;
    }
}

int buscar_palabra(char *palabra, Lista l) {
    /*
    Lista aux = l;

    while (aux != NULL)
    {
        if (strcmp(aux->palabra, palabra) == 0)
        {
            return 1;
        }
        aux = aux->sig;
    }
    */
    if (l != NULL) {
        return buscar_palabra(palabra, l->sig) || strcmp(l->palabra, palabra) == 0;
    }
    return 0;
}
