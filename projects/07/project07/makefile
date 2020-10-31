.PHONY = clean all test

all:
	javac *.java

clean:
	rm *.class VMTranslator

test:
	make VMTranslator.class
	java VMTranslator ../MemoryAccess/BasicTest/BasicTest.vm

Parser.class: Parser.java
	javac Parser.java

CommandTypes.class: CommandTypes.java
	javac CommandTypes.java

CodeWriter.class: CodeWriter.java
	javac CodeWriter.java

VMTranslator.class: VMTranslator.java Parser.java CommandTypes.java
	javac VMTranslator.java Parser.java CommandTypes.java CodeWriter.java
