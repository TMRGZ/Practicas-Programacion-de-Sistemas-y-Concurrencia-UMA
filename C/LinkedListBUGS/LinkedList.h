/* 
 * File:   LinkedList.h
 * Author: galvez
 *
 * Created on 21 de marzo de 2017, 13:54
 */

#ifndef LINKEDLIST_H
#define	LINKEDLIST_H

// These definitions have 1 bug.
typedef struct Node* TList;

typedef struct Node
{
	int data;
	TList next;
} TNode;

/* Creates an empty List */
void create(TList* l);

/* Insert in the head of the list */
void insert(TList* plist, int data);

/* Displays the content of the list */
void show(TList plist);

/* Deletes the head of the list */
void delete(TList* plist);

/* Destroys the list and sets it to NULL */
void destroy(TList* plist);


#endif	/* LINKEDLIST_H */
