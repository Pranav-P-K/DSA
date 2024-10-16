#include <stdio.h>
#include <stdlib.h>

// defining a node
typedef struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
} Node;

// Function to create a new node with given value as data
Node* createNode(int data)
{
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = newNode;
    newNode->prev = newNode;
    return newNode;
}

// Function to insert a node at the beginning
void insertAtBeginning(Node** head, int data)
{
    Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    Node* last = (*head)->prev;  // Get the last node

    newNode->next = *head;
    newNode->prev = last;
    last->next = newNode;
    (*head)->prev = newNode;

    *head = newNode;
}

// Function to insert a node at the end
void insertAtEnd(Node** head, int data)
{
    Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    Node* last = (*head)->prev;  // Get the last node

    newNode->next = *head;
    newNode->prev = last;
    last->next = newNode;
    (*head)->prev = newNode;
}

// Function to insert a node at a specified position
void insertAtPosition(Node** head, int data, int position)
{
    if (position < 1) {
        printf("Position should be >= 1.\n");
        return;
    }

    if (position == 1) {
        insertAtBeginning(head, data);
        return;
    }

    Node* newNode = createNode(data);
    Node* temp = *head;
    for (int i = 1; temp->next != *head && i < position - 1; i++) {
        temp = temp->next;
    }

    if (temp == *head && temp->next == *head) {  // Single node case
        printf("Position greater than the number of nodes.\n");
        return;
    }

    newNode->next = temp->next;
    newNode->prev = temp;
    temp->next->prev = newNode;
    temp->next = newNode;
}

// Function to delete a node from the beginning
void deleteAtBeginning(Node** head)
{
    if (*head == NULL) {
        printf("The list is already empty.\n");
        return;
    }

    Node* last = (*head)->prev;
    Node* temp = *head;

    if (*head == last) {  // Only one node in the list
        *head = NULL;
        free(temp);
        return;
    }

    last->next = (*head)->next;
    (*head)->next->prev = last;
    *head = (*head)->next;
    free(temp);
}

// Function to delete a node from the end
void deleteAtEnd(Node** head)
{
    if (*head == NULL) {
        printf("The list is already empty.\n");
        return;
    }

    Node* last = (*head)->prev;

    if (*head == last) {  // Only one node in the list
        *head = NULL;
        free(last);
        return;
    }

    last->prev->next = *head;
    (*head)->prev = last->prev;
    free(last);
}

// Function to delete a node from a specified position
void deleteAtPosition(Node** head, int position)
{
    if (*head == NULL) {
        printf("The list is already empty.\n");
        return;
    }

    if (position == 1) {
        deleteAtBeginning(head);
        return;
    }

    Node* temp = *head;
    for (int i = 1; temp->next != *head && i < position; i++) {
        temp = temp->next;
    }

    if (temp->next == *head && temp == *head) {
        printf("Position is greater than the number of nodes.\n");
        return;
    }

    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    free(temp);
}

// Function to print the list in forward direction
void printListForward(Node* head)
{
    if (head == NULL) {
        printf("The list is empty.\n");
        return;
    }

    Node* temp = head;
    printf("Forward List: ");
    do {
        printf("%d ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("\n");
}

// Function to print the list in reverse direction
void printListReverse(Node* head)
{
    if (head == NULL) {
        printf("The list is empty.\n");
        return;
    }

    Node* last = head->prev;
    Node* temp = last;

    printf("Reverse List: ");
    do {
        printf("%d ", temp->data);
        temp = temp->prev;
    } while (temp != last);
    printf("\n");
}

int main()
{
    Node* head = NULL;

    // Demonstrating various operations
    insertAtEnd(&head, 10);
    insertAtEnd(&head, 20);
    insertAtBeginning(&head, 5);
    insertAtPosition(&head, 15, 2); // List: 5 15 10 20

    printf("After Insertions:\n");
    printListForward(head);
    printListReverse(head);

    deleteAtBeginning(&head); // List: 15 10 20
    deleteAtEnd(&head); // List: 15 10
    deleteAtPosition(&head, 2); // List: 15

    printf("After Deletions:\n");
    printListForward(head);

    return 0;
}
