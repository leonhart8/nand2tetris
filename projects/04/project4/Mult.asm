// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Put your code here.

// Initialization
@R0
D=M
@n
M=D
@i
M=0
@R2
M=0

// Beginning of loop
// Process is the following : unroll R2 = R1*R0
// by adding R1 to R2 exactly R0 times
(LOOP)
@n
D=M 
@i
D=D-M 
@END 
D;JEQ // If i < n, continue with loop 
@R1
D=M
@R2
M=M+D // In each iteration add R1 to R2
@i
M=M+1 // Increment i
@LOOP 
0;JMP // Jump to beginning of loop

// Loop infinitely to avoid NOP SLIP
(END)
@END
0;JMP

