// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.

// Initialization of number of pixel blocks (blocks of 16 bits)
@8192 // 512*256
D=A
@nbBlocks
M=D

// Loop which listens for keyboard input
(KBDLOOP)
@KBD
D=M
@KBDLOOP
D;JEQ

// Key was pressed, color everything in black
// Initialization 
@i
M=0

// Loop to color screen black 
(SCREENBLACK)
@nbBlocks
D=M
@i
D=D-M
@KBDLOOP2
D;JEQ
@i
D=M
@SCREEN
A=A+D
M=-1
@i
M=M+1
@SCREENBLACK
0;JMP


// Loop which listens for keyboard input
(KBDLOOP2)
@KBD
D=M
@KBDLOOP2
D;JNE

// Key was released, color everything back to white
// Initialization 
@i
M=0

// Loop to color screen white
(SCREENWHITE)
@nbBlocks
D=M
@i
D=D-M
@KBDLOOP
D;JEQ
@i
D=M
@SCREEN
A=A+D
M=0
@i
M=M+1
@SCREENWHITE
0;JMP





