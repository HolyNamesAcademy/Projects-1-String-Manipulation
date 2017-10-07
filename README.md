# Project 4: String Manipulation

## Overview

In this project, students will use string manipulation techniques to find rhyming words in a phonetic dictionary.

## Program Contents

The program contains three application classes, `CmuDict`, `WordRhymer`, and `Main`, as well as two test classes,
`CmuDictTest` and `WordRhymerTest`. Students will make changes to `CmuDict`, `WordRhymer`, `CmuDictTest`, and
`WordRhymerTest`.

### Application Classes

#### CmuDict

The `CmuDict` class provides access to and utility functions for *cmudict.0.7.a*, the phonetic dictionary created by
Carnegie Mellon University. The dictionary entries are read into an `ArrayList<String>` in the constructor. Each item in
the list corresponds to a line in the dictionary containing the word and its phonemes. For example, the word "academy"
has the  following entry: `ACADEMY  AH0 K AE1 D AH0 M IY0`

#### WordRhymer

The `WordRhymer` class is an intermediary between the `CmuDict` and `Main` classes, its primary function being to take
the word that the user wants to rhyme and find words in CmuDict that rhyme with it.

#### Main

The `Main` class serves as the user interface, where the user can specify which words they want to rhyme and how many
rhyming words they want to find.

### Test Classes

#### CmuDictTest

#### WordRhymerTest

## More about the CMU Pronunciation Dictionary

