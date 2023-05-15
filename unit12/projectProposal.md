## Project Proposal: musical 'lick' generator

In imporivsational music (i.e. jazz), musiciains often 'borrow' short musical phrases (licks) from their favorite recordings and insert them into their own solos. A good component of practice is to learn licks and transpose them into all 12 keys. However, it can sometimes be hard to find the motivation and time to listen, transcribe, and practice a new lick every practice session. To solve this problem, I want to code a program to generate musical licks, which can then be learned much quicker and practiced as a warmup. In addition, the program will be able generate licks in specific keys and modes, that way it is easy to narrow down your practice to the specific scale you're working on.

The goal with this program is to encourage me (or other musicians) to learn a larger quantity of licks in order to improve their musical vocabulary, technique, knowledge of scales, and ability to play in all 12 keys with equal skill. Because these goals focus on improving musicianship, rather than actually learning good licks, it's not necessary for this program to output great-sounding licks; they just have to be vaguely musical.

## Decomposition

Steps:
1. Build a class to store private instance variables and licks
2. Input common scales/modes as private instance variables
4. Write methods that determine the next note using different methods (like chromatic, scale tone, interval, etc.)
5. Write method that 'weights' a set of reasonable notes based on their relationship to the scale and the previous notes, then randomly chooses the next note based on this weighting 
6. Write a method that outputs the generated lick in a simple, usable format for the user to read

## Things this project will teach me

- using randomization in a controlled way
