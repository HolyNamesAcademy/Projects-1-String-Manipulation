# Project: String Manipulation

## Table of Contents

- [Project: String Manipulation](#project-string-manipulation)
  - [Table of Contents](#table-of-contents)
  - [Good work pledge](#good-work-pledge)
  - [Getting started](#getting-started)
  - [Project overview](#project-overview)
  - [Program contents](#program-contents)
    - [Application classes](#application-classes)
      - [Main](#main)
      - [PhonemeDictionary](#phonemedictionary)
      - [WordRhymer](#wordrhymer)
      - [RhymeGenerator](#rhymegenerator)
    - [Test classes](#test-classes)
      - [WordRhymerTest](#wordrhymertest)
  - [Extra credit](#extra-credit)
    - [Improve the rhyming algorithm](#improve-the-rhyming-algorithm)
    - [Dictionary words with '\_' in them](#dictionary-words-with-_-in-them)
    - [Rhyme words that aren't in the dictionary](#rhyme-words-that-arent-in-the-dictionary)
  - [Committing your Changes and Turning In The Project](#committing-your-changes-and-turning-in-the-project)
  - [Grading](#grading)

## Good work pledge

We are here to broaden your exposure to Computer Science. We can only achieve that purpose when you work hard and
honestly. It may be tempting to copy-paste code from a classmate, or let a classmate do all your work for you don't!
You will be cheating yourself from the most valuable thing course has to offer overcoming challenges.

We know that hard, and honest work doesn't come easily. If you feel like you are falling behind

1. Don't copy-paste code, or let someone do your work for you
2. Ask for help!
3. Tell the teaching-team you need more time

## Getting started

1. Go to the provided assignment link, and click accept. It should take you to your project page.
   (If it doesn't, click on the link above again, and click on the link to the project page).
1. On the GitHub project page, click on the green "Clone or Download" button and copy the link.
1. Open Intellij, click on the "Checkout from Version Control" drop down and select "GitHub"
1. On the next page paste the link you copied into the "Git Repository URL" box.
1. Click Clone. You may have to enter your GitHub username and password.
1. If it asks you whether you want to open the project or not, select yes.
1. You should see your project open. If you need to reopen the project, you should see it under "File > Open Recent"
1. If you click on the drop-down menu of run configurations, you should see "Main", "RhymeGeneratorTest",
   "WordRhymerTest", and "PhonemeDictionaryTest" as options. You should be able to run all of them. If any of the
   configurations are missing, call an instructor over.

## Project overview

In this project, you will use string manipulation techniques to find rhyming words with the help of CMUDict, a
dictionary that contains information about the pronunciation of words in North American English.

CMUDict is a pronunciation dictionary created at Carnegie Mellon University. A lot of programs that support speech
recognition (computers understanding language) for North American English use CMUDict to match the sequences of phonemes
("word sounds") that we make to the words that we're actually saying. So when you say "Holy Names Academy," the computer
will hear it as something like "H OH L EE N AY M Z AH K A D EH M EE". Using this pronunciation dictionary, it can lookup
the phonemes that it hears and figure out what you might have said.

Each line in the dictionary contains a word followed by its phonemes. For example, the word "academy" has the following
entry: `ACADEMY  AH0 K AE1 D AH0 M IY0`. Below is the list of phonemes you will see in the dictionary and how they
should be read. The "Phoneme" column contains the phonemes themselves. The "Example" column contains an example word in
English that uses the word sound. The "Translation" column contains the full pronunciation of the word in the "Example"
column using the phonemes in the dictionary.

| Phoneme | Example | Translation |
| ------- | ------- | ----------- |
| AA      | odd     | AA D        |
| AE      | at      | AE T        |
| AH      | hut     | HH AH T     |
| AO      | ought   | AO T        |
| AW      | cow     | K AW        |
| AY      | hide    | HH AY D     |
| B       | be      | B IY        |
| CH      | cheese  | CH IY Z     |
| D       | dee     | D IY        |
| DH      | thee    | DH IY       |
| EH      | Ed      | EH D        |
| ER      | hurt    | HH ER T     |
| EY      | ate     | EY T        |
| F       | fee     | F IY        |
| G       | green   | G R IY N    |
| HH      | he      | HH IY       |
| IH      | it      | IH T        |
| IY      | eat     | IY T        |
| JH      | gee     | JH IY       |
| K       | key     | K IY        |
| L       | lee     | L IY        |
| M       | me      | M IY        |
| N       | knee    | N IY        |
| NG      | ping    | P IH NG     |
| OW      | oat     | OW T        |
| OY      | toy     | T OY        |
| P       | pee     | P IY        |
| R       | read    | R IY D      |
| S       | sea     | S IY        |
| SH      | she     | SH IY       |
| T       | tea     | T IY        |
| TH      | theta   | TH EY T AH  |
| UH      | hood    | HH UH D     |
| UW      | two     | T UW        |
| V       | vee     | V IY        |
| W       | we      | W IY        |
| Y       | yield   | Y IY L D    |
| Z       | zee     | Z IY        |
| ZH      | seizure | S IY ZH ER  |

Looking at this chart, we can see that words that rhyme with each other have the same final phonemes. For instance, the
pronunciations for "knee", "tea", "we", and "fee" all end with the "IY" phoneme.

In the dictionary entries, you'll notice that some of the vowel phonemes in the dictionary have 0, 1, or 2 at the end of
them. The numbers indicate whether the phoneme is stressed, or emphasized, when spoken; 0 means the phoneme is not
stressed, 1 means that the phoneme is the most stressed, and 2 means that the phoneme is less stressed than 1 but more
than 0.

For example, consider the entries for "academy", "empty", and "tea":

```
ACADEMY  AH0 K AE1 D AH0 M IY0
EMPTY  EH1 M P T IY0
TEA  T IY1
```

The final "IY" sound in "academy" and "empty" is unstressed, whereas the "IY" sound in "tea" is the mainly emphasized
sound. Say it to yourself and feel the difference in how you pronounce each word. This difference in stress shows us
that even though all three words end with the same overall sound, "academy" and "empty" rhyme with each other more
strongly than they do with "tea".

Additionally, you may notice that some words have multiple entries. For example, consider the entries for "jewelry":

```
JEWELRY  JH UW1 AH0 L R IY0
JEWELRY(1)  JH UW1 L R IY0
JEWELRY(2)  JH UW1 L ER0 IY0
```

This means that there are three different ways someone might pronounce the word "jewelry". But they're all still
the same word. So even though the first two pronunciations of "jewelry" have the same final phonemes, it would be on the
pedantic side to say that "jewlery" and "jewelry" are rhyming words.

Therefore, **for this project**, we can conclude that words rhyme when the following are true:

- The words themselves are different from each other
- The words have the same final phonemes in the same order
- The phonemes that match also have the same stress markers

For more information about CMUDict, check out <http://www.speech.cs.cmu.edu/cgi-bin/cmudict>.

## Program contents

The program contains two packages: _main_ and _test_. The _main_ package contains four application
classes: `PhonemeDictionary`, `WordRhymer`, `RhymeGenerator`, and `Main`. The _test_ package contains three test
classes: `PhonemeDictionaryTest`, `WordRhymerTest`, `RhymeGeneratorTest`. You will make changes to `PhonemeDictionary`,
`WordRhymer`, `RhymeGenerator`, `Main`, and `WordRhymerTest`.

### Application classes

These classes contain the code for the word rhyming application you'll be writing. To run the program, select the "Main"
run configuration at the top right corner of the screen and click the green triangle (the "run" button) to the right.

#### Main

The `Main` class serves as the user interface. In the `main()` method, the user is asked if they want to find rhyming
words or quit the program. If the user types "rhyme", they will be prompted first for a word they want to rhyme
with, and then the number of rhyming words they want the program to find. Once the program has collected that
information from the user, it calls the `findRhymingWords()` method from the `RhymeGenerator` class to get the rhyming
words. Finally, it prints the rhymes out to the console for the user to see. The user can continue to request rhymes, or
quit the program by typing "quit" when asked if they want to quit or rhyme.

You will implement one method in this class:

- `void printRhymes(List<String> rhymingWords, String originalWord)`: This method should print out a report of how many
  words were found that rhyme, and the rhymes. An example of what the output should look like:

  Found 3 words that rhyme with: educate
  Domesticate
  Pontificate
  Communicate

  Notice that the rhymes are printed starting with a capital letter and followed by all lower case.

#### PhonemeDictionary

The `PhonemeDictionary` class provides access to helper methods for _cmudict.0.7.a_, the text file containing version
0.7a (from 2008) of CMUDict. The dictionary file is read in the constructor. For each line in the dictionary, we need to
determine if the line contains a word and its phonemes, or just comments explaining the dictionary. If the line is a
phoneme entry, the line needs to be parsed. We need to get the word from the line, and separate it from it's phonemes. A
phoneme entry has the following format: the word, followed by two spaces, and then a list of phonemes. Each phoneme is
separated by a single space. Here is the entry for "academy": `ACADEMY  AH0 K AE1 D AH0 M IY0`.

In the resources folder you will find the dictionary file, _cmudict.0.7.a_. A second file has been included,
_miniCmuDict.txt_ that is a mini version of _cmudict.0.7.a_. When developing, you may find it easier to work with a
file with fewer words. You can switch between the files by changing the value of `DICTIONARY_FILE_PATH`, a constant in
the `PhonemeDictionary` class. Feel free to edit the _miniCmuDict.txt_ to include additional words to make your testing easier.

You'll need to implement the following methods in the `PhonemeDictionary` class:

- `boolean isPhonemeEntry(String line)`: This is the method we use when reading in the lines of the text file containing
  the dictionary. The method should return true if the String it's looking at is a valid phoneme entry as described
  above. If you open up the `cmudict.0.7a.txt` file, you'll see that the first 50-ish lines don't contain actual
  entries; they're just comments telling you about the dictionary. We want to make sure we don't include those lines as
  dictionary entries.

- `String getWordFromLine(String line)`: This method should return the word component of a dictionary line. So if the
  line is "ACADEMY AH0 K AE1 D AH0 M IY0", then you'll want to return "ACADEMY".

- `List<String> getPhonemesFromLine(String line)`: This method should return a list containing the phonemes of a
  dictionary line as separate entries. So if the line is "ACADEMY AH0 K AE1 D AH0 M IY0", then you'll want to return
  { "AH0", "K", "AE1", "D", "AH0", "M", "IY0" }.

`PhonemeDictionary` also has the following methods that will be helpful when developing your rhyming algorithm:

- `List<String> getEntries()`: This method returns all of the words that the `PhonemeDictionary` has phonemes for.

- `List<String> getPhonemes(String word)`: This method returns the list of phonemes for the specified word.

#### WordRhymer

The `WordRhymer` class is an intermediary between the `PhonemeDictionary` and `RhymeGenerator` classes. Its primary
function is to determine if two words rhyme. It also provides users of the class with the words that it can make rhyming
decisions about.

You'll need to implement the following method in the WordRhymer class:

- `boolean checkForRhyme(String word, String possibleRhyme)`: This method determines if two words rhyme. It checks if
  the final three phonemes of each word match. If so, it returns true, and false otherwise. Some words have fewer than
  three phonemes. In that case, the word with fewer phonemes mutch have a match on all phonemes. For example, if we are
  trying to rhyme with _at_ (AT AE1 T), then both `AE1` and `T` would need to match the final two phonemes of the
  other word.

#### RhymeGenerator

- `List<String> findRhymingWords(String wordToRhyme, int numRhymingWords)`: This is the method that is called in the
  `main()` method in the Main class once the user gives the word that they want to rhyme and the number of rhyming
  words they want to find. You'll return a List with up to `numRhymingWords` words in it that rhyme with `wordToRhyme`.
  The only reason to return a List shorter than `numRhymingWords` in length is if there aren't that many rhyming words
  in the dictionary that rhyme. For example, if you called `findRhymingWords("Educate", 3)`, you could return
  ["DOMESTICATE", "COMMUNICATE", "PONTIFICATE"]. NOTE: make sure that you do not include the word itself as a rhyming
  word in the list you return.

### Test classes

These classes contain the test code for the application classes. Each of the test classes has its own run configuration.
To run the tests for a given test class, select the corresponding configuration at the top right corner of the screen
and click the run button to the right.

#### WordRhymerTest

You'll write your tests for the `WordRhymer` class here. You'll need to implement the following test cases:

- `boolean checkForRhyme(String word, String possibleRhyme)`

  - `checkForRhyme_wordDoesNotRhymeWithSelf`:
    checkForRhyme returns false when both words are the same
    Ex: anatomy & anatomy
  - `checkForRhyme_rhymes_bothWordsThreeOrMorePhonemes`:
    checkForRhyme returns true when both words have three or more phonemes
    Ex: complicate & dedicate
  - `checkForRhyme_notRhymes_bothWordsThreeOrMorePhonemes`:
    checkForRhyme returns false when both words have three or more phonemes
    Ex: littering & living
  - `checkForRhyme_rhymes_wordLessThanThreePhonemes`:
    checkForRhyme returns true when the word argument has less than three phonemes, and the possibleRhyme argument has
    three or more phonemes
    Ex: at & cat
  - `checkForRhyme_notRhymes_wordLessThanThreePhonemes`:
    checkForRhyme returns false when the word argument has less than three phonemes, and the possibleRhyme argument
    has three or more phonemes
    Ex: at & banana
  - `checkForRhyme_rhymes_possibleRhymeLessThanThreePhonemes`:
    checkForRhyme returns true when the word argument has three or more phonemes, and the possibleRhyme argument has
    less than three phonemes
    Ex: knit & it
  - `checkForRhyme_notRhymes_possibleRhymeLessThanThreePhonemes`:
    checkForRhyme returns false when the word argument has three or more phonemes, and the possibleRhyme argument has
    less than three phonemes
    Ex: crab & it

## Extra credit

### Improve the rhyming algorithm

Our rhyming algorithm isn't perfect. For example, when you try to rhyme "orange" or "silver", some of the words we get
don't actually rhyme. Another place we our algorithm could be improved is when we have words with less than three
phonemes. To rhyme with the word "fish", a word has to have "fish" at the end. Can you do better?

### Dictionary words with '\_' in them

The dictionary has words that contain an underscore. The underscore represents a space. Can you enhance your rhyming
algorithm so that if a user asks for rhymes of "recourse" you return "Air force"? Can you enhance it so a user can enter
"air force" and you generate "recourse" as a rhyme?

### Rhyme words that aren't in the dictionary

CMUDict has a lot of words in it, but it's certainly not a complete representation of the English language. As such,
if you try to rhyme words that aren't in there, like "pokemon" or "spongebob", you'll come up empty-handed. If you can't
find any words for the original word you supplied, try to improve your search by finding a word that is similar to that
word and finding rhyming words for the similar word.

## Committing your Changes and Turning In The Project

The same instructions with screenshots are in the OneNote [here](https://holynamesseattle-my.sharepoint.com/personal/ecudaback_holynames-sea_org/_layouts/OneNote.aspx?id=%2Fpersonal%2Fecudaback_holynames-sea_org%2FDocuments%2FClass%20Notebooks%2FProjects%20in%20CS%20MW%20P7%2017-18&wd=target%28_Content%20Library%2FUsing%20the%20Content%20Library.one%7CAF912239-6A74-48A4-BA23-3D819CB96383%2FIntelliJ%20Setup%7CEA8F2C82-E1EE-459F-8521-D24F0460F650%2F%29).

At the end of every class period, you should commit your changes. "Committing your changes" is basically a fancy way of saving the changes you made. It is very important and useful for two reasons:

1. You save your changes online, so you can never lose them. Even if your computer breaks, your changes will still be saved somewhere.
2. You can go back to any previous version that you committed. So if you accidentally make a wrong change that breaks your program, you can always go back to a state where the program was working.

You can commit and push ("push" means send it to GitHub.com to save it there) by doing the steps below:

1. Once you are ready to save your changes, click on VCS > Commit Changes… in the taskbar.
2. It will show you a list of files that you have made changes to. (It might also show changes to a file called workspace.xml, which you didn’t touch. That's ok, IntelliJ modifies that file behind the scenes). You can double click on any file and see the changes you've made to the file.
3. Hover over the commit button and select "Commit and Push". It will prompt you, asking if you are sure. Select "Commit", and then on the next page, select "Push".
4. Go to your project page on GitHub, and make sure that your changes are there.
5. That's it. The last change you submit before the deadline will be considered your turned in assignment. You can turn in additional submissions after the deadline, but remember that there is a 10% penalty added each week after the deadline you turn in the assignment.

## Grading

Your grade for each project will fall into one of four categories:

| Grade Level            | Explanation                                                                                                                                                                                  |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| _Exceeds Expectations_ | <ul><li>Quality is outstanding. Extra credit and/or independent improvements apparent.</li><li>All errors have been found.</li></ul>                                                         |
| _Excellent_            | <ul><li>Overall quality is high.</li><li>All errors have been found.</li></ul>                                                                                                               |
| _Satisfactory_         | <ul><li>Overall quality is good.</li><li>Most errors have been found.</li><li>Improvements can be made to bring the quality up to <i>Excellent</i>.</li></ul>                                |
| _Needs Improvement_    | <ul><li>Overall quality is not yet high enough and the submission will not be accepted.</li><li>Improvements must be made to bring the quality up to at least <i>Satisfactory</i>.</li></ul> |
