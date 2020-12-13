#include "LinkedList.h"

/* Creates an empty List */
void create(TList *l)
{
    *l = NULL;
}

/* Insert in the list in an ordered way */
void Add(TList *plist, int data){
	TNode *aux = (TNode*)malloc(sizeof(TNode));
		aux->data = data;
		aux->next = NULL;
		aux->prev = NULL;
	
    if(*plist == NULL)
	{
        (*plist) = aux;
    }
	else if ((*plist)->data >= aux->data)
	{
		aux->next = *plist;
		aux->next->prev = aux;
		*plist = aux;
	}
	else 
	{
		TNode *ptr = *plist;
		
		while ((ptr->next != NULL) && (ptr->next->data <= aux->data)) 
		{
			ptr = ptr->next;
		}
            
		aux->next = ptr->next;

        if(ptr->next != NULL)
		{
			aux->next->prev = aux;
        }
		ptr->next = aux;
		aux->prev = ptr;
    }
}

/* Displays the content of the list */
void show(TList plist)
{
    while (plist != NULL)
	{
        printf("%d ", (plist)->data);
        (plist) = (plist)->next;
    }
    printf("\n");
}


/* Destroys the list and sets it to NULL */
void destroy(TList * plist)
{
    TList ptr = (*plist);
    TList aux;
    while (ptr != NULL)
	{
        aux = ptr;
        ptr = ptr->next;
        free(aux);
    }
    *plist = NULL;
	/*
	if ((*plist) != NULL)
	{
		destroy(&((*plist)->next));
		free(*plist);
		*plist = NULL;
	}*/
}

