all:
	javac -d org.ioopm.calculator.ast/classes *.java

run:
	java -cp classes org.ioopm.calculator.Calculator

clean:
	rm -rf classes
