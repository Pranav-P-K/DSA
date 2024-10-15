// C program to implement a stack using singly linked list
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

// Struct representing a node in the linked list
typedef struct Node {
    int data;
    struct Node* next;
} Node;

Node* createNode(int new_data) {
    Node* new_node = (Node*)malloc(sizeof(Node));
    new_node->data = new_data;
    new_node->next = NULL;
    return new_node;
}

// Struct to implement stack using a singly linked list
typedef struct Stack {
    Node* head;
} Stack;

// Constructor to initialize the stack
void initializeStack(Stack* stack) { stack->head = NULL; }

// Function to check if the stack is empty
int isEmpty(Stack* stack) {
    return stack->head == NULL;
}

// Function to push an element onto the stack
void push(Stack* stack, int new_data) {
    Node* new_node = createNode(new_data);

    if (!new_node) {
        printf("\nStack Overflow");
        return;
    }

    new_node->next = stack->head;
    stack->head = new_node;
}

// Function to remove the top element from the stack
void pop(Stack* stack) {
    if (isEmpty(stack)) {
        printf("\nStack Underflow\n");
        return;
    } else {
        Node* temp = stack->head;
        stack->head = stack->head->next;
        free(temp);
    }
}

// Function to return the top element of the stack
int peek(Stack* stack) {
    if (!isEmpty(stack))
        return stack->head->data;
    else {
        printf("\nStack is empty");
        return INT_MIN;
    }
}

// Function to print the elements of the stack
void printStack(Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        return;
    }

    Node* temp = stack->head;
    printf("Stack elements: ");
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Driver program to test the stack implementation
int main() {
    Stack stack;
    initializeStack(&stack);

    // Push elements onto the stack
    push(&stack, 11);
    push(&stack, 22);
    push(&stack, 33);
    push(&stack, 44);

    // Print all elements of the stack
    printStack(&stack);

    // Print top element of the stack
    printf("Top element is %d\n", peek(&stack));

    // Remove two elements from the top
    printf("Removing two elements...\n");
    pop(&stack);
    pop(&stack);

    // Print all elements of the stack
    printStack(&stack);

    // Print top element of the stack
    printf("Top element is %d\n", peek(&stack));

    return 0;
}
