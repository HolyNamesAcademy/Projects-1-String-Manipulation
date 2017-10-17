# Project 4: String Manipulation

## Overview

In this project, you will use string manipulation techniques to find rhyming words in CMUDict, a phonetic dictionary
that provides the phonetic decomposition of, or the set of sounds that goes into words in North American English.

## About CMUDict

CMUDict is a phonetic dictionary created at Carnegie Mellon University.  A lot of programs that support speech
recognition for North American English use CMUDict to match the sequences of phonemes that the user utters to the words
that the user might be saying.

Each line of the dictionary contains a word followed by its phonemes. For example, the word "academy" has the  following
entry: `ACADEMY  AH0 K AE1 D AH0 M IY0`

Below is the list of phonetic symbols you will see in the dictionary and how they should be read. The Phoneme column
contains the phonetic symbols. The Example column contains an example word in English that contains that is pronounced
with that phoneme. The Translation column contains the phonetic translations of the words in the English column.

```
        Phoneme Example Translation
        ------- ------- -----------
        AA	odd     AA D
        AE	at	AE T
        AH	hut	HH AH T
        AO	ought	AO T
        AW	cow	K AW
        AY	hide	HH AY D
        B 	be	B IY
        CH	cheese	CH IY Z
        D 	dee	D IY
        DH	thee	DH IY
        EH	Ed	EH D
        ER	hurt	HH ER T
        EY	ate	EY T
        F 	fee	F IY
        G 	green	G R IY N
        HH	he	HH IY
        IH	it	IH T
        IY	eat	IY T
        JH	gee	JH IY
        K 	key	K IY
        L 	lee	L IY
        M 	me	M IY
        N 	knee	N IY
        NG	ping	P IH NG
        OW	oat	OW T
        OY	toy	T OY
        P 	pee	P IY
        R 	read	R IY D
        S 	sea	S IY
        SH	she	SH IY
        T 	tea	T IY
        TH	theta	TH EY T AH
        UH	hood	HH UH D
        UW	two	T UW
        V 	vee	V IY
        W 	we	W IY
        Y 	yield	Y IY L D
        Z 	zee	Z IY
        ZH	seizure	S IY ZH ER
```

You may notice that some phonetic symbols for vowels in the dictionary have 0, 1, or 2 at the end of them. Take again,
for example, "academy": `AH0 K AE1 D AH0 M IY0`. The numbers indicate whether the phoneme is stressed when spoken; 0
means the phoneme has no vocal stress, 1 means that the phoneme has the primary vocal stress, and 2 means that the
phoneme has secondary vocal stress. All you need to remember about these numbers is that if two phonemes match *except*
for the number, **they don't rhyme with each other**.

For more information about CMUDict, check out http://www.speech.cs.cmu.edu/cgi-bin/cmudict.

## Program Contents

The program contains three application classes, `CmuDict`, `WordRhymer`, and `Main`, as well as two test classes,
`CmuDictTest` and `WordRhymerTest`. Students will make changes to `CmuDict`, `WordRhymer`, `CmuDictTest`, and
`WordRhymerTest`.

### Application Classes

#### CmuDict

The `CmuDict` class provides access to and utility functions for *cmudict.0.7.a*, the text file containing CMUDict.
The dictionary entries are read into an `ArrayList<String>` in the constructor. Each item in the list should correspond
to a line in the dictionary containing a word and its phonemes. For example, the word "academy"
has the following entry: `ACADEMY  AH0 K AE1 D AH0 M IY0`

#### WordRhymer

The `WordRhymer` class is an intermediary between the `CmuDict` and `Main` classes, its primary function being to take
the word that the user wants to rhyme and find words in CmuDict that rhyme with it.

#### Main

The `Main` class serves as the user interface, where the user can specify which words they want to rhyme and how many
rhyming words they want to find.

### Test Classes

#### CmuDictTest

You'll write your tests for the `CmuDict` class here.

#### WordRhymerTest

You'll write your tests for the `WordRhymer` class here.

