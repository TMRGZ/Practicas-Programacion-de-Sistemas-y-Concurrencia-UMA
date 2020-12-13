#ifndef LISTAPERSONAS_H_
#define LISTAPERSONAS_H_


typedef struct Nodo * ListaPersona;

struct Persona
{
	char nombre[30];
	int edad;
};

struct Nodo
{
	struct Persona pers;
	ListaPersona sig;
};

void crearListaPersona(ListaPersona *l);
void recorrerListaPersona(ListaPersona l);
void insertarListaPersonas(ListaPersona *l, struct Persona p);




#endif // !1

