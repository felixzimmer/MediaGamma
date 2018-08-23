# MediaGamma
MediaGamma exercise, given an specific input we must provide a SparseVector output


From a given Json we have to provide an sparse vector output with the following format ( size, {index: value} ), I want to point out my thoughs:

1) The Json structure is well defined, I'm not expecting a variable Json schema
2) Given the raw Json input, our first task is to denormalize the Json into single fields (or features in this case). In our case, many features have a list of values for a feature, for simplicity I'm transforming the list into a concatenation of strings
3) I'm expecting to receive the file from a file path, in this moment I used a local directory and a Json line as an example
4) At the moment I'm producing a String that follows the format of the expected sparse vector
