#include<stdio.h>
#include<string.h>
/*int main() {
    int i;
    char c;
    float f;
    double d;
    char cadena[10] = "Hola Mundo";
    i=44;
    c = 'A';
    f = 45.3545252414134314;
    d = 45.3545252414134314;

    //printf("Entero: %d, caracter %c, float %.9f ", i, c, f);
    //printf("Double %.9lf \n", d);
    //printf("cadena: %s", cadena);
    printf("Entero: %d, caracter %d", i, c);
    return 0;
}*/

int factorial(int n){
    int fact = 1;

    for(int i=1; i<=n; i++){
        fact = fact * i;
    }
    return fact;
}

/*void leerEntero(struct Entero e) {

}*/

void eliminar(char cadena[], char c)  { // hacer
	int i = 0;

	while (cadena[i] != '\0') 
	{
		if (cadena[i] == c)
		{
			for (int j = i; cadena[j] != 0; j++) 
			{
				cadena[j] = cadena[j + 1];
			}
		}
		else
		{
			i++;
		}
	}
}

void intercambiar(int* ap, int* bp) 
{
	int aux = *ap;
	*ap = *bp;
	*bp = aux;
}

struct Complejo 
{
	double preal, pimag;
};

void inicializar(struct Complejo *c) 
{
	/*
	(*c).preal = 1.0; // c->preal = 1.0
	(*c).pimag = 1.0; // c->pimag = 1.0
	*/

	printf("Introduce un numero complejo \n");
	scanf("%lf %lf", &(c->preal), &(c->pimag));
}

void inicializar2(double comp[])
{
	//comp[0] = 2.2;
	//comp[1] = 3.3;
	printf("Introduce un numero complejo: \n");
	scanf("%lf %lf", &comp[0], &comp[1]);
}

int inicListaComplejos(struct Complejo *lista[], int tam)
{
	int i = 0; 
	int fin = 0;
	int v;

	while (i<tam && !fin)
	{
		v = inicializar(lista+i);
		if (v != 2) fin = 1;
		else i++;
	}
}

void escListaComplejos(struct Complejo lista[], int tam)
{
	for (int i = 0; i < tam; i++) 
	{
		printf("()");
	}
}


int main() 
{
	/*int n;
	printf("Introduce un numero: ");

	scanf("%d", &n);
	printf("El factorial de %d es %d", n, factorial(n));
	*/
	/*
	int a[2] = { 0,2 };
	int b[2];
	//b[8888] = 00;

	printf("%d %d %d %d \n", a, &a[1], b, &b[1]);
	*/
	/*
	struct Entero
	{
		unsigned num;
		unsigned den;
	};

	struct Persona
	{
		char nombre[20];
		int edad;
		char direccion[50];
	};

	struct Entero e1, e2;
	struct Persona p1, p2;
	struct Persona lista[20];

	e1.num = 1;
	e2.den = 1;
	e2 = e1;

	//
	char n[20];
	strcpy(n, "Hola Mundo");
	char m[20] = "Adios Mundo";
	
	strcmp(n, m);
	strcat(n, m);
	printf("%s", n);
	*/
	/*
	char c = 'a';
	int n = 5;
	float f = 5.5;
	double d = 3.3;

	char *cp2;
	int *np;
	float *fp;
	double *dp;

	cp2 = &c;
	np = &n;
	fp = &f;
	dp = &d;

	printf("5c \n", c);
	*cp = 'b';
	*/
	/*
	char cadena[20] = "jaj";
	eliminar(cadena, 'a');
	printf(cadena);
	*/
	/*
	int x = 8, y = 25;
	intercambiar(&x, &y);
	printf("x = %d, y = %d", x, y);
	*/
    /*
	struct Complejo c;
	inicializar(&c);
	printf("(%.2lf, %.2lf)", c.preal, c.pimag);
	*/
	/*
	double comp[2];
	inicializar2(comp);
	printf("(%.)");


	struct Complejo lista[20];
	int l;

	l = inicListaComplejos(lista, 20);
	escListaComplejos(lista, l);
	*/

	return 0;
}