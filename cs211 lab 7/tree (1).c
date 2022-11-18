#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "tree.h"

/*Task 1 - Complete the function below,
  newNode() will return a tree node*/
node* newNode(int key){
	node* ptr = (node*)malloc(sizeof(node)); 
	ptr->val = key ; 
	ptr->left = NULL; 
	ptr->right = NULL; 
	return ptr;
}

/*Task 2 - Complete the function below to return
the size (number of elements stored) of a binary 
tree*/
int size(node* root){
  if (root == NULL) {
    return 0;
  }
  return size(root->right) + size(root->left) + 1;
}

// ABCD EFGH
/*Task 3 - Complete the function below to print 
a binary tree while performing an Preorder traversal.
Recall preorder traversal: 
	visit parent
	visit left subtree
	visit right subtree
you MUST use recursion	*/

void printPreorder(node* r){
	if(r == NULL){
    return;
  }
	printPreorder(r->right);
	printf("%d,  ", r->val);
	printPreorder(r->left); 
	
}


/*Task 4 - Complete the function below to print 
a binary tree while performing an Inorder traversal.
Recall inorder traversal: 
	visit left subtree
	visit parent
	visit right subtree
you MUST use recursion	*/

void printInorder(node* r){
	if(r == NULL) {
    return;
  }
	printInorder(r->left); 
	printInorder(r->right);
	printf("%d,  ", r->val);
	
	
}



/*
  Task 5 - Complete the function below to clear a 
  binary tree. Perform a recursive traversal of a
  tree destroying all nodes.
*/

void clearTree(node* root){
  if (root == NULL) {
    return;
  }
  if (root->right != NULL) {
    clearTree(root->right);
  }
  if (root->left != NULL) {
    clearTree(root->left);
  }
  free(root);
}

/*
  Task 6 - Complete the function below to find and
  return the max depth of a binary tree. 
  Recall that max depth of a tree is the number of 
  nodes along the longest path from the root node 
  down to the farthest leaf node.
*/
int maxDepth (node* root){
  int counterLeft = 0;
  int counterRight = 0;
  if (root == NULL) {
    return 0;
  }
  counterRight = maxDepth(root->right);
  counterLeft = maxDepth(root->left);

  if (counterRight > counterLeft) {
    return counterRight+1;
  } else {
    return counterLeft+1;
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

node* insertBST(node* root, int key){ 
   if (root == NULL){
     return newNode(key);
   }
   if (key > root->val){
     insertBST(root->right, key);
   } else {
     insertBST(root->left, key);
   }
}