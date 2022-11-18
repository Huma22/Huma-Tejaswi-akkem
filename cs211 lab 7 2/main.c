//
//  main.c
//  cs211 lab 7
//
//  Created by Akkem Humatejaswi on 10/14/20.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct TreeNode

{
int val;
struct TreeNode *left;
struct TreeNode *right;
}node;

/*Task 1 - Complete the function below,
newNode() will return a tree node*/
node* newNode(int key)

{
node * n = malloc(sizeof(node));
   n->val = key;
   n->left = NULL;
   n->right = NULL;
   return n;
}

/*Task 2 - Complete the function below to return
the size (number of elements stored) of a binary
tree*/
int size(node* root)

{
if (root==NULL)
return 0;
else
return(size(root->left) + 1 + size(root->right));

}


/*Task 3 - Complete the function below to print
a binary tree while performing an Preorder traversal.
Recall preorder traversal:
visit parent
visit left subtree
visit right subtree
you MUST use recursion */

void printPreorder(node* r)

{
printf("%d ", r->val);
   if(r->left)
   printPreorder(r->left);
   if(r->right)
   printPreorder(r->right);
}


/*Task 4 - Complete the function below to print
a binary tree while performing an Inorder traversal.
Recall inorder traversal:
visit left subtree
visit parent
visit right subtree
you MUST use recursion */

void printInorder(node* r) {
if(r->left)
printInorder(r->left);
   printf("%d ", r->val);
   if(r->right)
   printInorder(r->right);
  
}

/*
Task 5 - Complete the function below to clear a
binary tree. Perform a recursive traversal of a
tree destroying all nodes.
*/

void clearTree(node* root){
if( root != NULL )
{
clearTree(root->left);
clearTree(root->right);
free(root);
}

}

/*
Task 6 - Complete the function below to find and
return the max depth of a binary tree.
Recall that max depth of a tree is the number of
nodes along the longest path from the root node
down to the farthest leaf node.
*/
int maxDepth (node* root)

{
if (root==NULL)
return 0;
else
{
/* calculate the depth of each subtree */
int leftDepth = maxDepth(root->left);
int rightDepth = maxDepth(root->right);
  
if (leftDepth > rightDepth)
return(leftDepth+1);
else
return(rightDepth+1);
}

}

/*
Task 7 - Complete the function below to create
an ordered binary tree (bst). In a binary search
tree, for every node, all nodes in the left subtree
are smaller while all nodes in the right subtree are
larger. (You should compare the key with current value
then decide whether to move to the left or right subtree)
*/

node* insertBST(node* root, int key)
{
// check root is empty
if (root == NULL)
return newNode(key);
if (key < root->val)
root->left = insertBST(root->left, key);
else if (key > root->val)
root->right = insertBST(root->right, key);
return root;
}
int main(int argc, char const *argv[])
{
node *root = newNode(5);
root->left = newNode(4);
root->right = newNode(12);
root->right->left = newNode(13);
root->right->right = newNode(2);
root->left->left = newNode(8);

printf("Size of the tree is %d\n",size(root));
printf("Maximum depth of the tree is %d\n", maxDepth(root) );
printPreorder(root);
printf("\n");
printInorder(root);
printf("\n");

node* bst;
int input ;
scanf("%d", &input);
while(input != -999){
bst = insertBST (bst,input);
scanf("%d", &input);
}
printInorder(bst);
return 0;
}
