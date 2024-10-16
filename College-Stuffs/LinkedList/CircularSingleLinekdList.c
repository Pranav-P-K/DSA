#include <stdio.h>
#include <stdlib.h>

// Define the Node structure
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node 
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = newNode;  // For circular, initially points to itself
    return newNode;
}

// Function to insert a new element at the beginning of the circular singly linked list
void insertAtFirst(struct Node** head, int data) {
    struct Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != *head) {  // Find the last node
        temp = temp->next;
    }

    newNode->next = *head;
    temp->next = newNode;
    *head = newNode;
}

// Function to insert a new element at the end of the circular singly linked list
void insertAtEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != *head) {  // Find the last node
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->next = *head;  // Make it circular
}

// Function to insert a new element at a specific position in the circular singly linked list
void insertAtPosition(struct Node** head, int data, int position) {
    if (position == 0) {
        insertAtFirst(head, data);
        return;
    }

    struct Node* newNode = createNode(data);
    struct Node* temp = *head;
    for (int i = 0; temp->next != *head && i < position - 1; i++) {
        temp = temp->next;
    }

    newNode->next = temp->next;
    temp->next = newNode;
}

// Function to delete the first node of the circular singly linked list
void deleteFromFirst(struct Node** head) {
    if (*head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = *head;
    struct Node* last = *head;

    // Find the last node
    while (last->next != *head) {
        last = last->next;
    }

    if (*head == (*head)->next) {  // If there's only one node
        free(*head);
        *head = NULL;
    } else {
        last->next = (*head)->next;
        *head = (*head)->next;
        free(temp);
    }
}

// Function to delete the last node of the circular singly linked list
void deleteFromEnd(struct Node** head) {
    if (*head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = *head;
    if (temp->next == *head) {  // If there's only one node
        free(*head);
        *head = NULL;
        return;
    }

    struct Node* prev = NULL;
    while (temp->next != *head) {
        prev = temp;
        temp = temp->next;
    }

    prev->next = *head;
    free(temp);
}

// Function to delete a node at a specific position in the circular singly linked list
void deleteAtPosition(struct Node** head, int position) {
    if (*head == NULL) {
        printf("List is empty\n");
        return;
    }

    if (position == 0) {
        deleteFromFirst(head);
        return;
    }

    struct Node* temp = *head;
    struct Node* prev = NULL;

    for (int i = 0; temp->next != *head && i < position; i++) {
        prev = temp;
        temp = temp->next;
    }

    if (temp->next == *head && prev != NULL) {  // Position out of range
        printf("Position out of range\n");
        return;
    }

    prev->next = temp->next;
    free(temp);
}

// Function to print the circular singly linked list
void print(struct Node* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct Node* temp = head;
    do {
        printf("%d -> ", temp->data);
        temp = temp->next;
    } while (temp != head);
    printf("HEAD\n");
}

// Driver Code
int main() {
    struct Node* head = NULL;
    
    insertAtFirst(&head, 10);
    printf("Circular linked list after inserting the node:10 at the beginning \n");
    print(head); 
    
    printf("Circular linked list after inserting the node:20 at the end \n");
    insertAtEnd(&head, 20);
    print(head); 
    
    printf("Circular linked list after inserting the node:5 at the end \n");
    insertAtEnd(&head, 5);
    print(head); 
    
    printf("Circular linked list after inserting the node:30 at the end \n");
    insertAtEnd(&head, 30);
    print(head); 
    
    printf("Circular linked list after inserting the node:15 at position 2 \n");
    insertAtPosition(&head, 15, 2);
    print(head);
    
    printf("Circular linked list after deleting the first node: \n");
    deleteFromFirst(&head);
    print(head); 
    
    printf("Circular linked list after deleting the last node: \n");
    deleteFromEnd(&head);
    print(head); 
    
    printf("Circular linked list after deleting the node at position 1: \n");
    deleteAtPosition(&head, 1);
    print(head); 

    return 0;
}
