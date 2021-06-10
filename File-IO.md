#File I/O

File I/O refers to input and output from files. 

In the old days there was a Java library called java.io. java.io established channels between data destinations and sources. It was a little cumbersome to use. It's still there in the Java library set. If we were a little less pressed for time I would give you an example. Suffice to say that some 15 or so years after Java was developed, a new library was put in called "New I/O", or java.nio, and we will be using java.nio. 

java.nio is able to handle input and output to/from files on a computer filesystem. It's also able to handle networking, that is, the exchange of files between networked machines. Today we'll look a little at reading and writing from files. This will be the second way to persist data that we've learned, after JavaScript's localStorage system. In many ways, reading and writing to files is more robust for data storage and it's a very useful technique. Being able to interact with a computer's file system gives us a lot of power to handle information. Over the next few days you will gain practice with this technique by building a simple command-line contacts manager application.

To handle file input-output, henceforth file I/O, the nio library relies heavily on Classes that represent paths to files and the files themselves. Let's look first at the Path classes.

On a computer filesystem, every file has a path leading to it. On Unix-type systems, of which Mac OS X is a particular type, every file has a path beginning at a root, represented by the symbol /. 

```
% cd /
pwd
/
% ls
Applications	Volumes		etc		sbin
Library		bin		home		tmp
System		cores		opt		usr
Users		dev		private		var
```
Notice in the GUI Finder window, if I go up from my home directory (the one named after me as user) I see some of these directories. This is the root of the filesystem.

If I then go into Users I will see my own home directory. All *nix systems are inherently multi-user systems designed to allow multiple users to take advantage of one machine's resources. This is today mostly used on servers running Linux type OSes. 
```
cd Users 
javier@Javiers-MBP /Users 
 % pwd
/Users
% ls
Shared	javier
cd javier 
javier@Javiers-MBP ~ % 
javier@Javiers-MBP ~ % pwd
/Users/javier
javier@Javiers-MBP ~ % ls
Desktop		Downloads	Library		Music		Public
Documents	IdeaProjects	Movies		Pictures	Sites
```
Notice I am navigating the filesystem using the cd change directory command and then looking around with the ls list command. This is the same as going down into folders in the GUI. Notice also on the command line I can tab-complete any directory or file name.

```
cd IdeaProjects 
% pwd
/Users/javier/IdeaProjects
javier@Javiers-MBP IdeaProjects % ls
codeup-web-exercises		neptune-practice-assessment
neptune-java-exercises		neptune-second-js-assessment
neptune-java-exercises - a	neptune-web-exercises
javier@Javiers-MBP IdeaProjects % cd neptune-java-exercises
javier@Javiers-MBP neptune-java-exercises % pwd
/Users/javier/IdeaProjects/neptune-java-exercises
javier@Javiers-MBP neptune-java-exercises % ls
Inheritance-and-Polymorphism-Lecture.md	src
out
javier@Javiers-MBP neptune-java-exercises % cd src
javier@Javiers-MBP src % pwd
/Users/javier/IdeaProjects/neptune-java-exercises/src
javier@Javiers-MBP src % ls
ArraysLec.java
Bird.class
Bird.java
BirdLover.java
BirdShelter.java
BirdShelterTest.java
BirdShelterWithACrookedSecurityGuard.java
BirdTest.class
BirdTest.java
BirdVet.java
Bob.java
ConsoleExercises.java
ConsoleIOLecture.java
ControlFlow.class
ControlFlow.java
ControlFlowExercises.class
ControlFlowExercises.java
Duck.class
Duck.java
Finch.java
GalapagosPenguin.class
GalapagosPenguin.java
HelloWorld.java
HighLow.java
KitchenApp
MethodsExercises.java
MethodsLecture.java
OopLecture
Penguin.class
Penguin.java
Person.java
StringExercise.java
StringsLecture.java
SyntaxTypesVarsLecture.java
shapes
util
```

Now I am in the src subdirectory of our neptune-java-exercises directory. 

I can go upwards using the .. convention
```
cd ..
javier@Javiers-MBP neptune-java-exercises
```
And I can refer to this directory, the one I am in, with a .
```
ls .
Inheritance-and-Polymorphism-Lecture.md	src
out
```
When I am in a Java project created by IntelliJ, the root of the project is this directory, the one that the project is named after. Let's get into the nio Classes that represent these paths.

I can construct a Path object representing a path to a particular file using the Paths.get() method.

Working in a directory called new-java-practice, with an src directory within it:
```
import java.nio.file.*;

public class FileIOLecture {
    public static void main(String[] args) {
        Path path = Paths.get("src");
        System.out.println(path);
    }
}
```
Output
```
src
```
Going one step further, I can construct a path leading to a .java file within the src folder using two arguments in the Paths.get() method
```
        Path pathToThisFile = Paths.get("src", "FileIOLecture.java");
        System.out.println(pathToThisFile);
```
Output
```
src/FileIOLecture.java
```
Notice the Paths.get() method constructs a path by adding a slash between the arguments. But don't be deceived, it is not constructing a string, it's constructing a path object, which has information about the directories and files and their place in the overall system. We can see that this object knows about its place in the overall filesystem by applying the toAbsolutePath() method.

```
System.out.println(pathToThisFile.toAbsolutePath());
```
```
/Users/javier/Documents/Codeup/new-java-practice/src/src/FileIOLecture.java
```
Interestingly, when I use the native compiler rather than IntelliJ's we get a different and erroneous result
```
/Users/javier/Documents/Codeup/new-java-practice/src/src/FileIOLecture.java
```
Shouldn't be an issue but keep it in mind, you may have to experiment a little with how you construct the paths you will be using to read and write from files.

Keep in mind also that the Paths.get() method takes strings, not path objects. You cannot pass a Path object in here. You can get the string value of a Path object using String.valueOf
```
Path pathToSrc = Paths.get("src");
Path thisWontWork = Paths.get(pathToSrc, "FileIOLecture.java");
Path thisWillWork = Paths.get(String.valueOf(pathToSrc), "FileIOLecture.java");
```
In general since we are working within an IntelliJ project, our paths will be fairly short.

What's the point of these Path objects anyway?

Next up we meet the Files class and its methods. These methods often take a Path object as their argument, so that's why we need the Path object in order to read,write, or create files or directories. 

##Create a directory

Let's say we want to create a directory within src where we will want to put text files for data storage. First we define the path to that directory.
```
Path ourDataPlace = Paths.get("src/data");
Files.createDirectories(ourDataPlace);
```
We get a warning that there is an uncaught exception, IOException. In fact, just about any I/O operation is written to throw IO Exceptions. This is because you can never guarantee beforehand that the file or directory will be in the right place, that you will have permissions to read or write, or that the operating system will behave. So we have to write our code to catch exceptions.

```
try{
            Files.createDirectories(ourDataPlace);
        } catch (IOException ex){
            ex.printStackTrace();
        }
```
And you will see that when we run this code, a data directory will get created within our src directory. Note again that if we use the javac / java system, what actually gets created is a directory called src.data, so we need to keep that in mind. It looks like the built-in Java compiler works from where it is, whereas the IntelliJ compiler in its run method understands the IntelliJ project hierarchy. Something to keep in mind.

Now what happens if we run the command again? Absolutely nothing. I can put a test file in the directory and run the command and verify that the directory is not overwritten. Still, it's useless to run the command again and we may have code that needs to write the directory only if it doesn't exist, so we can write an if-else like this.

```
try{
            if (Files.notExists(ourDataPlace)){
                Files.createDirectories(ourDataPlace);
            } else {
                System.out.println("The " + ourDataPlace + " directory already exists.");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
```

##Create a File

Now let's create a file if it doesn't already exist.

```
try {
            if (Files.notExists(pathToList)){
                Files.createFile(pathToList);
            } else {
                System.out.println("The " + nameOfFile + " file already exists!");
            }
        } catch (IOException iox){
            System.out.println("There was a problem!");
            iox.printStackTrace();
        }
```
We should see that a new file has been created within the directory we just created. 

## Writing to a file

Now let's write to the file we created.

```
List<String> imperials = Arrays.asList("Augustus", "Livia", "Agrippina", "Claudius");
        try {
            Files.write(pathToList, imperials);
        } catch (IOException iox){
            iox.printStackTrace();
        }

        List<String> currentList = new ArrayList<>();

```

Notice we now have the list of imperials in our list.txt file

We can read it as follows

```

        try {
            currentList = Files.readAllLines(pathToList);
        } catch(IOException iox){
            iox.printStackTrace();
        }

        for (String item : currentList){
            System.out.println(item);
        }
```

We are going to be using this code -- read and output -- a lot so lets go ahead and write a method so we don't need to do this over and over

```
public void readFileAndOutput (Path pathToFile){
        List<String> linesInTheFile = new ArrayList<>();
        try {
            linesInTheFile = Files.readAllLines(pathToFile);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for (String line: linesInTheFile) {
            System.out.println(line);
        }
    }
```
```
        FileIOLecture io = new FileIOLecture();
        io.readFileAndOutput(pathToList);
```
And now we can read and output without all that code repetition.

##Add one line to the list

Let's append a single item to our list
```
try {
            Files.writeString(pathToList, "Messalina\n", StandardOpenOption.APPEND);
        } catch (IOException iox){
            iox.printStackTrace();
        }
        io.readFileAndOutput(pathToList);
```
We have now added Messalina to the list of imperials

Note the newline I put, otherwise the next time we add something it will run on the same line

##Add a list to the existing list

```
List<String> lateImperials = new ArrayList<>();
        lateImperials.add("Galla Placidia");
        lateImperials.add("Theodora");
        lateImperials.add("Licinia Eudoxia");

        try {
            Files.write(pathToList, lateImperials, StandardOpenOption.APPEND);
        } catch (IOException iox){
            iox.printStackTrace();
        }

        io.readFileAndOutput(pathToList);
```

##Removing items

Notice that when we pull the items from the text file, we are creating an ArrayList. We can append new items to the file, but we can also overwrite the entire file. In fact, in the Contacts Manager exercise that you will be doing next, you are specifically asked to overwrite. Which makes it so that your list manipulation will use ArrayList methods.

We've seen changes made to the ArrayList when the list is complete and known. But what about while we are iterating? ArrayLists have a specific iteration syntax that we are supposed to use.

[Java Iterator class](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Iterator.html)

```
       List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(pathToOurList);
        } catch(IOException iox){
            iox.printStackTrace();
        }
       Iterator<String> listIterator = currentGroceryList.iterator();
        while (listIterator.hasNext()){
            String item = listIterator.next();
            if (item.equals("filters")){
                listIterator.remove();
            }
        }
```

