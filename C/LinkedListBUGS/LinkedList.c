#include "LinkedList.h"
#include <stdlib.h>
#include <stdio.h>

/* Creates an empty List */
void create(TList *l) {
    *l = NULL;
}

/* Insert in the head of the list */
// This function has 1 bug.
void insert(TList *plist, const int data) {
    TNode *aux = (TNode *) malloc(sizeof(TNode));
    aux->data = data;
    aux->next = *plist;

    *plist = aux;
}

/* Displays the content of the list */
// This function has 1 bug
void show(TList plist) {
    printf("[ ");

    while (plist != NULL) {
        printf("%d ", plist->data);
        plist = plist->next;
    }
    printf(" ] \n");
}

/* Deletes the head of the list */
// This function has several bugs
void delete(TList *plist) {
    TList aux = *plist;
    *plist = aux->next;
    free(aux);
}

/* Destroys the list and sets it to NULL */
// This function has 1 missing operation
void destroy(TList *plist) {
    /*TList ptr = *plist;
    while (ptr != NULL)
    {
        TList aux = ptr;
        ptr = ptr->next;
        free(aux);
    }
    *plist = NULL;*/

    if (*plist != NULL) {
        destroy(&((*plist)->next));
        free(*plist);
        *plist = NULL;
    }
}
