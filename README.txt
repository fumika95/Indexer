
This is a simple distributed file indexer.

* Files
  - IndexerTester: executable files that can run simple tests or any file user passed as argument
  - Indexer.java : main file which reads a plain text file and print out the 
    result of top 10 words that appeared in the text file
    
  - IndexerTree.java : tree object file that stores the words by charachter
  - NodeArray.java : array list of nodes
  - TreeNode.java : nodes of tree that store NodeArray of children
  - test.txt : plain text file that contains sample text
  

* to run the program
 - use   javac IndexerTester.java  to compile
 - use   java IndexerTester [name of text file]   to run the grogram with the file or
 - use   java IndexerTester test     to run the simple tests
  
