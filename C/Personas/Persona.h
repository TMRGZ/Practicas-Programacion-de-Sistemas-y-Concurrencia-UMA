#include<string.h>
#include <stdio.h>
/*
 * Persona.h
 *
 *  Created on: 7 mar. 2018
 *      Author: MIguel Angel Ruiz Gomez
 */

#ifndef PERSONA_H_
#define PERSONA_H_
struct Persona{
	char nombre[30];
	int edad;
};

int inicializarP(struct Persona *p)
{
	int v;
	printf("Introduce un nombre y una edad \n");
	v = scanf("%s %d", &(p->nombre), &(p->edad));
	return v;
}

void escribirP(struct Persona p) 
{	
	printf("Nombre: %s, edad: %d) \n", p.nombre, p.edad);
}

int inicializarListaP(struct Persona *p[], int tam)
{
	int i = 0;
	int fin = 0;
	int v;

	while (i<tam && !fin)
	{
		v = inicializarP(p + i);
		if (v != 2)
		{
			fin = 1;
		}
		else 
		{
			i++;
		}
	}
}

void escribirListaP(struct Persona *p[], int tam)
{
	for (int i = 0; i < tam; i++)
	{
		escribirP(*p[i]);
	}
}

#endif /* PERSONA_H_ */
