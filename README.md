# Project 4: String Manipulation

## Table of Contents
- [Good work pledge](#good-work-pledge)
- [Getting started](#getting-started)
- [Project overview](#project-overview)
- [Program contents](#program-contents)
   - [Application classes](#application-classes)
      - [Main](#main)
      - [CmuDict](#cmudict)
      - [WordRhymer](#wordrhymer)
   - [Test classes](#test-classes)
      - [CmuDictTest](#cmudicttest)
      - [WordRhymerTest](#wordrhymertest)
- [Extra credit](#extra-credit)
   - [Make the CmuDict methods robust to bogus input](#make-the-cmudict-methods-robust-to-bogus-input)
   - [Make CmuDict more efficient](#make-cmudict-more-efficient)
   - [Improve the rhyming algorithm](#improve-the-rhyming-algorithm)
   - [Rhyme words that aren't in the dictionary](#rhyme-words-that-arent-in-the-dictionary)
- [Turning in the project](#turning-in-the-project)
- [Grading rubric](#grading-rubric)

## Good work pledge

We are here to broaden your exposure to Computer Science. We can only achieve that purpose when you work hard and
honestly. It may be tempting to copy-paste code from a classmate, or let a classmate do all your work for you don't!
You will be cheating yourself from the most valuable thing course has to offer overcoming challenges.

We know that hard, and honest work doesn't come easily. If you feel like you are falling behind

   1. Don't copy-paste code, or let someone do your work for you
   2. Ask for help!
   3. Tell the teaching-team you need more time

## Getting started

1. Go to the provided assignment link, and click accept. It should take you to your project page. (If it doesn't, click
   on the link above again, and click on the link to the project page).
2. On the GitHub project page, click on the green "Clone or Download" button and copy the link.
3. Open Intellij, click on the "Checkout from Version Control" drop down and select "GitHub"
4. On the next page paste the link you copied into the "Git Repository URL" box.
5. Click Clone. You may have to enter your GitHub username and password.
6. If it asks you whether you want to open the project or not, select yes.
7. You should see your project open. If you need to reopen the project, you should see it under "File > Open Recent"
8. If you click on the drop-down menu of run configurations, you should see "Main", "CmuDictTest", and "WordRhymerTest"
   as options. You should be able to run all of them. If any of the configurations are missing, call an instructor over.

## Project overview

In this project, you will use string manipulation techniques to find rhyming words in CMUDict, a dictionary that
contains information about the pronunciation of words in North American English.

CMUDict is a pronunciation dictionary created at Carnegie Mellon University.  A lot of programs that support speech
recognition for North American English use CMUDict to match the sequences of phonemes ("word sounds", like vowels and
consonants) that we make to the words that we're actually saying. So when you say "Holy Names Academy," the computer
will hear it as something like "H OH L EE N AY M Z AH K A D EH M EE". Using this pronunciation dictionary, it can take
these phonemes that it hears and figure out what you might have said.

Each line of the dictionary contains a word followed by its phonemes. For example, the word "academy" has the following
entry: `ACADEMY  AH0 K AE1 D AH0 M IY0`. Below is the list of phonemes you will see in the dictionary and how they
should be read. The "Phoneme" column contains the phonemes themselves. The "Example" column contains an example word in
English that uses that phoneme. The "Translation" column contains the full pronunciation of the word in the "Example"
column using the phonemes in the dictionary.

Phoneme | Example | Translation
--- | --- | ---
AA | odd | AA D
AE | at | AE T
AH | hut | HH AH T
AO | ought | AO T
AW | cow | K AW
AY | hide | HH AY D
B  | be | B IY
CH | cheese | CH IY Z
D  | dee | D IY
DH | thee | DH IY
EH | Ed | EH D
ER | hurt | HH ER T
EY | ate | EY T
F  | fee | F IY
G  | green | G R IY N
HH | he | HH IY
IH | it | IH T
IY | eat | IY T
JH | gee | JH IY
K  | key | K IY
L  | lee | L IY
M  | me | M IY
N  | knee | N IY
NG | ping | P IH NG
OW | oat | OW T
OY | toy | T OY
P  | pee | P IY
R  | read | R IY D
S  | sea | S IY
SH | she | SH IY
T  | tea | T IY
TH | theta | TH EY T AH
UH | hood | HH UH D
UW | two | T UW
V  | vee | V IY
W  | we | W IY
Y  | yield | Y IY L D
Z  | zee | Z IY
ZH | seizure | S IY ZH ER

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

Therefore, **for this project**, we can conclude that words definitely rhyme when the following are true:
* The words themselves are different from each other
* The words have the same final phonemes in the same order
* The phonemes that match also have the same stress markers

For more information about CMUDict, check out http://www.speech.cs.cmu.edu/cgi-bin/cmudict.

## Program contents

The program contains two packages: *main* and *test*. The *main* package contains three application
classes: `CmuDict`, `WordRhymer`, and `Main`. The *test* package contains two test classes: `CmuDictTest` and
`WordRhymerTest`. You will make changes to `CmuDict`, `WordRhymer`, `CmuDictTest`, and `WordRhymerTest`.

### Application classes

These classes contain the code for the word rhyming application you'll be writing. To run the program, select the "Main"
run configuration at the top right corner of the screen and click the green triangle (the "run" button) to the right.

#### Main

The `Main` class serves as the user interface. In the `main()` method, it asks the user if they want to either find a
rhyming word or quit the program. If the user types "rhyme", they will be prompted first for a word they want to rhyme,
and then the number of rhyming words they want the program to find. Once the program has that information from the user,
it calls the `findRhymingWords()` method from the `WordRhymer` class to get the rhyming words and print them out. Then
it will repeat everything in a loop until the user decides to quit the program by typing "quit".

#### CmuDict

The `CmuDict` class provides access to and helper methods for *cmudict.0.7.a*, the text file containing version 0.7a
(from 2008) of CMUDict. The dictionary entries are read into an `ArrayList<String>` in the constructor. Each item in the
list should correspond to a valid entry in the dictionary containing a word and its phonemes. A valid entry is a line
containing the word, followed by two spaces, then the phonemes, each separated by a single space. See again the entry
for "academy": `ACADEMY  AH0 K AE1 D AH0 M IY0`

You'll need to implement the following methods in the CmuDict class:
* `boolean isWordEntry(String line)`: This is the method we use when reading in the lines of the text file containing
   the dictionary. The method should return true if the string it's looking at is a valid word entry as described above.
   If you open up the `cmudict.0.7a.txt` file, you'll see that the first 50-ish lines don't contain actual entries;
   they're just notes telling you about the dictionary. We want to make sure we don't include those lines as entries.
* `String getWord(String line)`: This method should return the word component of a dictionary line. So if the line is
  "ACADEMY  AH0 K AE1 D AH0 M IY0", then you'll want to return "ACADEMY".
* `String[] getPhonemes(String line)`: This method should return an array containing the phonemes of a dictionary line
  as separate entries. So if the line is "ACADEMY  AH0 K AE1 D AH0 M IY0", then you'll want to return
  { "AH0", "K", "AE1", "D", "AH0", "M", "IY0" }.
* `String getDictLineForWord(String word)`: This method should return the line in the dictionary that corresponds to the
  word that's been given. So if you call `getDictLineForWord("academy")` you'll want to return
  "ACADEMY  AH0 K AE1 D AH0 M IY0". In the case that the entry cannot be found in the dictionary, return the empty
  string, "".

#### WordRhymer

The `WordRhymer` class is an intermediary between the `CmuDict` and `Main` classes. Its primary function is to take the
word that the user wants to rhyme and find words in CmuDict that rhyme with it.

You'll need to implement the following methods in the WordRhymer class:
* `boolean finalPhonemesMatch(String[] word1Phonemes, String[] word2Phonemes)`: This method should check whether two
  arrays of phonemes match at the end, essentially determining whether they represent words that rhyme. Checking the
  final 3 phonemes should be sufficient to conclude that they do rhyme. Some words have fewer than 3 phonemes, though,
  so in that case, match as many final phonemes as you can, up to 3.
* `ArrayList<String> findRhymingWords(String wordToRhyme, int numRhymingWords)`: This is the method that does all the
  work of finding the rhyming words. It's called in the `main()` method in the Main class once the user gives the word
  that they want to rhyme and the number of rhyming words they want to find. You'll return an ArrayList with up to
  `numRhymingWords` words in it that rhyme with `wordToRhyme`. The only reason to return an ArrayList shorter than
  `numRhymingWords` in length is if there aren't that many rhyming words in the dictionary. For example, if you called
  `findRhymingWords("academy", 3)`, you could return ["ALCHEMY", "ANATOMY", "ANOMIE"]. NOTE: make sure that you do not
   include the word itself as a rhyming word in the list you return.

### Test classes

These classes contain the test code for classes defined in the *rhymingwords* package. Each of the two classes has its
own run configuration. To run the tests for a given test class, select the corresponding configuration at the top right
corner of the screen and click the run button to the right.

#### CmuDictTest

You'll write your tests for the `CmuDict` class here. You'll need to implement the following test cases:
* `isWordEntry(String line)`

   * Check that the method returns true when `line` is a valid dictionary line
   * Check that the method returns false when `line` is not a valid dictionary line

* `getWord(String dictLine)`

   * Check that we correctly extract the word when `dictLine` is a valid dictionary line
   * Check that we correctly extract the word when `dictLine` is a valid dictionary line containing an alternate
     pronunciation, so that we strip off the final parentheses

* `getPhonemes(String dictLine)`

   * Check that we correctly extract the phonemes when `dictLine` is a valid dictionary line

* `getDictLineForWord(String word)`

   * Check that we return the dictionary line for `word` when `word` is present in the dictionary
   * Check that we return the empty string when `word` is not in the dictionary

#### WordRhymerTest

You'll write your tests for the `WordRhymer` class here. You'll need to implement the following test cases:
* `finalPhonemesMatch(String[] phonemes1, String[] phonemes2)`

   * Check that the method returns true when `phonemes1` and `phonemes2` have at least 3 phonemes each and the final 3
     match
   * Check that the method returns false when `phonemes1` and `phonemes2` have at least 3 phonemes each and the final 3
     don't match
   * Check that the method returns true when at least one of `phonemes1` and `phonemes2` has fewer than 3 phonemes and
     the final phonemes present in the shorter array do match
   * Check that the method returns false when at least one of `phonemes1` and `phonemes2` has fewer than 3 phonemes and
     the final phonemes present in the shorter array do not match

## Extra credit

### Make the CmuDict methods robust to bogus input

When constructing `CmuDict`, we made sure not to read any invalid dictionary entries into our list, so `getWord()` and
`getPhonemes()` will always be called on valid dictionary lines and so should always be able to extract the word or
the phonemes on the input you give it. What should happen if you call `getWord()` or `getPhonemes()` with bogus input,
like the empty string or "hello, world"? Decide how you want to handle those cases, and then add the logic to your code,
as well as unit tests that show the new logic being used. Make sure to add comments to document how you're handling the
error cases.

### Make CmuDict more efficient

As far as classes go, CmuDict is on the hefty side. The text file it reads from is over 3.5MB, which we store in RAM
(the memory that your computer has to store running programs and data for those programs). We've made the `dictLines`
member variable, which contains the 3.5MB of dictionary, as `static`, so that there's only one list in memory even if
there are multiple instances of the CmuDict class.

That said, every time we instantiate a new CmuDict object, the constructor recreates the dictionary by reassigning
`dictLines` to an empty ArrayList, opening the text file, and reading in all 3.5MB over gain. That's a lot of memory
churn, and it really seems unnecessary since the contents of the dictionary aren't changing from instance to instance.

You can make the class more efficient by updating it to be completely static. Instead of populating `dictLines` in the
constructor, you can move that logic to a separate method and populate the list right where you declare it.
Once you do that, then there's no need to actually create any instances of the class, since your only instance variable
is static, and your instance methods only touch static data.

### Improve the rhyming algorithm

Our rhyming algorithm isn't perfect. For example, when you try to rhyme "orange" or "silver", some of the words we get
don't actually rhyme. Can you do better?

### Rhyme words that aren't in the dictionary

CMUDict has a lot of words in it, but it's certainly not a complete representation of the English language. As such,
if you try to rhyme words that aren't in there, like "pokemon" or "spongebob", you'll come up empty-handed. If you can't
find any words for the original word you supplied, try to improve your search by finding a word that is similar to that
word and finding rhyming words for the similar word.

## Turning in the project

Follow the guidelines in the IntelliJ Setup page to turn in your assignment.

## Grading rubric

| <h3>CmuDict</h3> | <h3>20 pts</h3> |
| :------------- | -----: |
| isWordEntry() | 5 pts |
| getWord() | 5 pts |
| getPhonemes() | 5 pts |
| getDictLineForWord() | 5 pts |
| <h3>WordRhymer</h3> | <h3>20 pts</h3> |
| finalPhonemesMatch() | 5 pts |
| findRhymingWords() | 15 pts |
| <h3>CmuDictTest (5 points per test)</h3> | <h3>35 pts</h3> |
| <h3>WordRhymerTest (5 points per test)</h3> | <h3>20 pts</h3> |
| <h3>Code Quality</h3> | <h3>20 pts</h3> |
| No compile errors | 10 pts |
| [Code spaced and indented properly](https://stackoverflow.com/questions/17879475/how-enable-auto-format-code-for-intellij-idea) | 10 pts |
| [Descriptive variable names](http://www.makinggoodsoftware.com/2009/05/04/71-tips-for-naming-variables) | 5 pts |
| <h3>Administrative</h3> | <h3>20 pts</h3> |
| Correctly pushed to GitHub | 5 pts |
| Turned in on time | 15 pts |
| <h3>Extra Credit</h3> | <h3>20 pts</h3> |
| Handling bogus input in CmuDict methods | 5 pts |
| Making CmuDict more efficient | 5 pts |
| Improving the rhyming algorithm | 5 pts |
| Rhyme words that aren't in the dictionary | 5 pts |
| <h3>Total</h3> (not including extra credit) | <h3>135 pts</h3> |
