/*
 ============================================================================
 Name        : prPalabras3_13.c
 Author      : PONGA SU NOMBRE AQUI <<<<<<<<<<<<<<<<<<<<<
 Version     : 1
 Copyright   : Examen parcial abril 2017
 Description : Programa principal, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"
#define MIN_LETRA (3)
#define MAX_LETRA (13)
#define NUM_TAMANO (MAX_LETRA - MIN_LETRA +1)


void escribir_salida(FILE *fp, Lista *lp)
{
	if (fp == NULL)
	{
		perror("error");
	}
	else
	{
		for (int i = 0; i < NUM_TAMANO; i++)
		{
			fprintf(fp, "--------- \n Palabras de %d letras: \n [ ", i+3);

			while (lp[i] != NULL)
			{
				fprintf(fp, "%s, ", lp[i]->palabra);
				lp[i] = lp[i]->sig;
			}
			fprintf(fp, " ] \n");
		}
	}
}


int main(void) {

	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
	char *inputFileName = "Lorem_Ipsum.txt";
	char *outputFileName = "Palabras3_13.txt";


	/* Crear Array de Palabras de tamaño NUM_TAMANO */
	Lista lista[NUM_TAMANO];

	/* Incializar lista palabras */
	for (int i = 0; i < NUM_TAMANO; i++)
	{
		crear(&lista[i]);
	}

	/* Abrir Fichero de Entrada */
	FILE *f = fopen(inputFileName, "r");

	/* Leer palabras del fichero de entrada */
	char n[30];

	if (f ==  NULL)
	{
		perror("error");
	}
	else
	{
		while (fscanf(f, "%s", n) == 1)
		{
			if (strlen(&n)>=MIN_LETRA)
			{
				insertar(&n, &lista[strlen(&n) - MIN_LETRA]);
			}
		}
	}

	/* Escribir en consola */
	for (int i = 0; i < NUM_TAMANO; i++)
	{
		printf(" ---------------------- \n Palabras de %d letras: \n", i + 3);
		escribir(lista[i]);
	}

	/* Escribir archivo (para el apartado B) */
	FILE *fp = fopen(outputFileName, "w");
	
	escribir_salida(fp, &lista);
	
	fclose(fp);
	
	/* Destruir las listas creadas */
	for (int i = 0; i < NUM_TAMANO; i++)
	{
		destruir(&lista[i]);
	}


	return EXIT_SUCCESS;
}


