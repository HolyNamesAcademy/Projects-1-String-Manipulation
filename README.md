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

1. Open the assignment link your teacher posts in **Teams** or **OneNote**, and accept the assignment. GitHub will create a private project just for you.
2. On your new project page, click the green **Code** button, copy the link, and clone the project into IntelliJ (File → New → Project from Version Control, then paste the link).
3. When IntelliJ asks if you trust the project, say yes / trust it so it can finish setting things up.
4. If IntelliJ asks you to pick a Java version (JDK), choose **17** or newer.
5. Use the green play **dropdown** near the top-right of IntelliJ. You should see options like `Main`, `PhonemeDictionaryTest`, `RhymeGeneratorTest`, `WordRhymerTest`, `PhonemeDictionaryUtilitiesTest`, and `AllProvidedTests`. You can stay in the file you are editing — you do not need to open a different file first.
6. Start with **`PhonemeDictionaryUtilitiesTest`** and **`WordRhymerTest`** (they use the mini test dictionary). Run **`Main`** only after those pieces work — `Main` loads the full CMUDict file and is slower to debug against.

If anything looks confusing the first time you open the project, ask a teacher — IntelliJ asks a few one-time setup questions, and then day-to-day work is just writing code and using that green play button.


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

The program contains application classes and tests. The main classes are `PhonemeDictionary`,
`PhonemeDictionaryUtilities`, `WordRhymer`, `RhymeGenerator`, and `Main`. The tests are
`PhonemeDictionaryTest`, `PhonemeDictionaryUtilitiesTest`, `WordRhymerTest`, and `RhymeGeneratorTest`.

You will implement code in `PhonemeDictionaryUtilities`, `WordRhymer`, `RhymeGenerator`, and `Main`.
You will also fill in the student tests in `PhonemeDictionaryUtilitiesTest` and `WordRhymerTest`
(replace the `// TODO: replace with real assertTrue/assertFalse/assertEquals` placeholders with real checks). `PhonemeDictionaryTest` and
`RhymeGeneratorTest` are already written for you.

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
phoneme entry, the line needs to be parsed. We need to get the word from the line, and separate it from its phonemes. A
phoneme entry has the following format: the word, followed by **exactly two spaces**, and then a list of phonemes. Each phoneme is
separated by a single space. Here is the entry for "academy": `ACADEMY  AH0 K AE1 D AH0 M IY0` (notice the two spaces after `ACADEMY`).

In the resources folder you will find the dictionary file, _cmudict.0.7.a_. A second file has been included,
_miniCmuDict.txt_ that is a mini version of _cmudict.0.7.a_. When developing, you may find it easier to work with a
file with fewer words. You can switch between the files by changing the value of `DICTIONARY_FILE_PATH`, a constant in
the `PhonemeDictionary` class. Feel free to edit the _miniCmuDict.txt_ to include additional words to make your testing easier.

You'll need to implement the following methods in the **`PhonemeDictionaryUtilities`** class (called from `PhonemeDictionary`):

- `boolean isPhonemeEntry(String line)`: Return true for phoneme entries; return false for comment lines and empty lines. Comment lines in the dictionary start with `;;;` (you'll see forms like `;;;`, `;;; # …`, and `;;;  NOTES…`).

- `String getWordFromLine(String line)`: Return the word before the two-space delimiter. Example: `ACADEMY  AH0 K AE1 D AH0 M IY0` → `"ACADEMY"`. Watch out: splitting only on a single space `" "` will not treat the double space the way you expect.

- `List<String> getPhonemesFromLine(String line)`: Return the phonemes after the word (each phoneme separated by a single space). Example: `{ "AH0", "K", "AE1", "D", "AH0", "M", "IY0" }`.

`PhonemeDictionary` also has the following methods that will be helpful when developing your rhyming algorithm:

- `List<String> getEntries()`: This method returns all of the words that the `PhonemeDictionary` has phonemes for.

- `List<String> getPhonemes(String word)`: This method returns the list of phonemes for the specified word.

#### WordRhymer

The `WordRhymer` class is an intermediary between the `PhonemeDictionary` and `RhymeGenerator` classes. Its primary
function is to determine if two words rhyme. It also provides users of the class with the words that it can make rhyming
decisions about.

You'll need to implement the following method in the WordRhymer class:

- `boolean checkForRhyme(String word, String possibleRhyme)`: These parameters are **English words** (look up their phonemes with the dictionary). Two words rhyme when their final three phonemes match, including stress digits on those tokens (e.g. `EY2` is not the same as `EY1`). If either word has fewer than three phonemes, all phonemes of the shorter word must match the end of the longer word. A word does not rhyme with itself. Words that are not in the dictionary have no phonemes and should not count as rhymes.

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

At the end of every class period, commit and push your work from IntelliJ:

1. Click **Git > Commit…** (or use the Commit tool window).
2. Review the changed files. You can double-click a file to see the diff.
3. Enter a short commit message, then choose **Commit and Push…**.
4. Confirm the push to your project's `main` branch.
5. On GitHub, confirm your latest commits are visible.

Pushing to `main` is how you turn in work for this assignment. Autograding runs on those pushes. You can keep improving and pushing after the deadline if your teacher allows late work — ask about any late penalty.


## Grading

Your grade for each project will fall into one of four categories:

| Grade Level            | Explanation                                                                                                                                                                                  |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| _Exceeds Expectations_ | <ul><li>Quality is outstanding. Extra credit and/or independent improvements apparent.</li><li>All errors have been found.</li></ul>                                                         |
| _Excellent_            | <ul><li>Overall quality is high.</li><li>All errors have been found.</li></ul>                                                                                                               |
| _Satisfactory_         | <ul><li>Overall quality is good.</li><li>Most errors have been found.</li><li>Improvements can be made to bring the quality up to <i>Excellent</i>.</li></ul>                                |
| _Needs Improvement_    | <ul><li>Overall quality is not yet high enough and the submission will not be accepted.</li><li>Improvements must be made to bring the quality up to at least <i>Satisfactory</i>.</li></ul> |
