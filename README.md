# MediaGamma
MediaGamma exercise, given an specific input we must provide a SparseVector output


From a given Json we have to provide an sparse vector output with the following format ( size, {index: value} ), I want to point out my thoughs:

1) The Json structure is well defined, I'm not expecting a variable Json schema, for this part I'm using the Jackson library
2) Given the raw Json input, our first task is to denormalize the Json into single fields (or features in this case). In my case, many features have a list of values for a feature, for simplicity I'm transforming the list into a concatenation of strings
3) I'm expecting to receive the file from a file path, in this moment I used a local directory/Json line as an example
4) At the moment I'm producing a String that follows the format of the expected sparse vector
5) The current feature list is the following bid_time;bundle;cat;coppa;userrating;language;domain;id;segment;country;region;metro;city;inventory_source;time_of_week;augomented_os;augmented_model;augmented_browser;augmented_browser_version;augomented_osv;augmented_make;augmented_device_screen_size;carrier;devicetype;connectiontype;js;video;placement;placement_type;environment_type;h;battr;w;instl
