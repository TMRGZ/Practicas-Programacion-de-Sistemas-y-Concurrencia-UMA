/*
 * Personas.c
 *
 *  Created on: 7 mar. 2018
 *      Author: mmar
 */
#include "Persona.h"
#include <stdio.h>



int main()
{
	struct Persona p1;
	inicializarP(&p1);
	escribirP(p1);

	struct Persona Personas[5];
	inicializarListaP(&Personas, 5);
	escribirListaP(&Personas, 5);

	return 0;
}
