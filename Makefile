all:
	javac -d classes *.java

run:
	java -cp classes org.ioopm.calculator.Calculator
	
run_parser:
	java -cp classes org.ioopm.calculator.parser.ParserDriver

test:
	java -cp classes org.ioopm.calculator.ast.Test

gitadd:
	git add *.java Makefile 

clean:
	rm -rf classes
