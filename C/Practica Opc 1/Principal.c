/*
 * Principal.c
 *
 *  Created on: 12/4/2016
 *      Author: mmar
 */

#include "ListaCircular.h"
#include <stdio.h>
#include <string.h>


// Lee el fichero y lo introduce en la lista
void cargarFichero (const char *nombreFich, TListaCircular *lc){
	FILE *f = fopen(nombreFich, "r");
	char n[30];

	if (f == NULL)
	{
		perror("error");
	}
	else
	{
		while (fgets(n, sizeof(n), f) != NULL)
		{
			insertar(lc, n);
		}
		fclose(f);
	}
}


int main(){

	TListaCircular lc;
	crear(&lc);

	char nombre[30];

	int n;
/*
	cargarFichero ("listaNombres.txt", &lc);
	recorrer(lc);
	printf("Introduce un n�mero entre 0 y 60: ");
	fflush(stdout);
	scanf("%d", &n);
	while (longitud(lc)>1){
		mover(&lc, n);
		extraer(&lc, nombre);
		printf("%s ha salido del c�rculo \n", nombre);
	}

	extraer(&lc, nombre);
	printf("--------------------------------------\n");
	printf("%s ha sido seleccionado !!!!! \n", nombre);
	fflush(stdout);*/


	strcpy(nombre, "prueba1");
	insertar(&lc, &nombre);
	recorrer(lc);
	strcpy(nombre, "prueba2");
	insertar(&lc, &nombre);
	recorrer(lc);
	strcpy(nombre, "prueba3");
	insertar(&lc, &nombre);
	recorrer(lc);
	extraer(&lc, &nombre);
	recorrer(lc);

	return 0;
}
