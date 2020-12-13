#include"Lista.h"
#include<stdio.h>
#include<time.h>
#include "ListaPersonas.h"
#include <string.h>

int crearFicheroTextoNumeros(char *nombre)
{
	FILE *f = fopen(nombre, "w");

	if (f == NULL)
	{
		perror("No se puede abrir el archivo");
		return -1;
	}
	else
	{
		for (int i = 0; i < 100; i++)
		{
			fprintf(f, "%d ", i);
		}

		fclose(f);
		return 0;
	}
}

int crearFicheroBinarioNumeros(char *nombre)
{
	FILE *f = fopen("Numeros.bin", "wb");
	int i;

	if (f==NULL)
	{
		perror("error");
		return -1;
	}
	else
	{
		for (int i = 0; i < 100; i++)
		{
			fwrite(&i, sizeof(int), 1, f);
		}
		fclose(f);
		return 0;
	}
}



int main1()
{
	srand(time(NULL));

	int n;
	Lista l;

	crearLista(&l);
	
	for (int i = 0; i < 10; i++)
	{
		n = rand() % 100;
		printf("%d ", n);
		insertarLista(&l, n);
	}
	printf("\n");
	recorrerLista(l);
}

int main()
{
	Lista li;
	//crearFicheroTextoNumeros("Numeros.txt");
	//crearListaDesdeFichero("Numeros.txt", &l);
	//recorrerLista(l);
	//crearFicheroBinarioNumeros("Numeros.txt");
	//crearListaDesdeFicheroBinario("Numeros.txt", &l);

	ListaPersona l;
	crearListaPersona(&l);

	
	struct Persona p2;
	strcpy(p2.nombre, "HappyPepa");
	p2.edad = 2;
	insertarListaPersonas(&l, p2);

	struct Persona p;
	strcpy(p.nombre, "HappyDogo");
	p.edad = 5;
	insertarListaPersonas(&l, p);
	
	recorrerListaPersona(l);

}