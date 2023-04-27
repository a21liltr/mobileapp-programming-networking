
# Rapport

**Project to fetch and use data from JSON.**

For this assignment, JSON data is provided as a local file as well as via a URL.
The goal is to deserialize the JSON data and display the information in an app with the help of a recycler view.

Looking at the JSON data, it appears that a JSONarray was provided containing a couple of JSONobjects.
From this, a class Mountain is created with the same properties that are in the JSONobjects,
with an exception of the field "size" in the JSONobject that is deserialized but is changed to "height" in the Mountian class.

Only some data is of interest and wil be used, therefor only some properties are chosen to be deserialized, these are:
- name
- location
- size ("height")

To deserialize JSON data, it is first converted to a string. Then, GSON is used to do the actual deserialization of JSON.
As the contents is that of a JSONarray which is to be deserialized into a list of objects, this needs to happen in two steps, first by using Type and TypeToken.

TypeToken is used to specify to GSON what object to convert the JSON to.
What is desired is specifically _an array of objects of the class Mountain_ but it is not possible to just type in ArrayList<Mountain>,
therefor this middle-step is needed to specify it as an arraylist of mountain objects.

```
private ArrayList<Mountain> mountains;
...

@Override
    public void onPostExecute(String json) {
    Gson gson = new Gson();

    Type mountainListType = new TypeToken<ArrayList<Mountain>>(){}.getType();
    mountains = gson.fromJson(json, mountainListType);   
    ...
```


![](android.png)
