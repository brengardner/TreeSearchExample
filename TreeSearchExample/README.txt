README for TreeSearchExample
Author: Brenna Gardner

To compile and run  at the command line
---------------------------------------
(Before attempting to compile, please ensure your Java path is set correctly)

From the TreeSearchExample directory:

javac *.java
java TreeSearchExample.java 	

Explanation for design choices
------------------------------

In this example, we were somewhat limited by the structure of the Node class. 

Many algorithms for sorting and searching trees rely on a reference to the node's parent,
which was not included in the definition provided. This forced the alogorithm to focus on
looking at the current Node's children and encouraged using a recursive function that would
backtrack when reaching a Node without any children.

Another design choice included the use of a global ArrayList used to keep track of which
nodes were visited. While global variables are typically discouraged, in this example the
definition of the Node class did not include a value for whether or not it had already been visited.
Since I was using a recursive method to search the tree, I had to keep track of this information
outside of the method.

Design Advantages
-----------------

One advantage of the specified structure of the Node class is that it potentially allows for each Node
to contain more than two children. The recursive algorithm also takes this into consideration and will
look at any number of children for the search value. 

Possible Improvements
---------------------

A great way to improve the code I have included would be expanding the Node class to include a reference 
to each Node's parent. We could also alter the Node's structure to include references to a left and right
child as opposed to just children to allow us to easily sort the tree and allow access to efficient methods
like binary search.

At the moment, the use of a global variable to contain which Nodes have been visited is not a great design
choice as global variables become much more difficult to test and think about clearly as things grow. It would
be advantagous to include a 'visited' field for each Node that indicates whether or not it has already been 
searched. This would  eliminate the need for a global variable and create a logical connection between visited
Nodes without having to search a list.