#include<iostream>
#include <limits.h>

using namespace std;
#define len 7

// Function to find the vertex with the minimum distance value
int minDistance(int dist[], bool Tset[]) {
    int min = INT_MAX, min_index;

    for (int i = 0; i < len; i++)
        if (Tset[i] == false && dist[i] <= min)
            min = dist[i], min_index = i;


    return min_index;
}


// Function to print the output
void output(int dist[]) {
    cout << "Vertex \t Distance from the Source\n";
    for (int i = 0; i < len; i++){
        char ver = 65+i;
        cout << ver << " \t\t " << dist[i] << endl;
    }
}


void dijkstraAlgorithm(int graph[len][len], int src) {
    int dist[len]; // creating a list to store the shortest distances for each vertex
    bool Tset[len];

    for (int i = 0; i < len; i++)
        dist[i] = INT_MAX, Tset[i] = false;

    dist[src] = 0; // this is because the distance from source to source is zero

    // Finding shortest paths for each vertex
    for (int count = 0; count < len - 1; count++) {
        int u = minDistance(dist, Tset);
        // Mark the vertex as visited
        Tset[u] = true;


        for (int v = 0; v < len; v++)
            if (!Tset[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }

    // Print the output
    output(dist);
}




int main()
{
    /* Let us create the example graph discussed above */
    int graph[len][len] = { { 0, 0, 1, 2, 0, 0, 0},
                        { 0, 0, 2, 0, 0, 3, 0},
                        { 1, 2, 0, 1, 3, 0, 0},
                        { 2, 0, 1, 0, 0, 0, 1},
                        { 0, 0, 3, 0, 0, 2, 0},
                        { 0, 3, 0, 0, 2, 0, 1},
                        { 0, 0, 0, 1, 0, 1, 0}
    };

    dijkstraAlgorithm(graph, 0);

    return 0;
}