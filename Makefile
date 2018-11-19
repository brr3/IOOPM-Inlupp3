all:
	javac -d classes org.ioopm.calculator.ast/*.java
	javac -d classes *.java

run:
	java -cp classes org.ioopm.calculator.Calculator

test:
	java -cp classes Test

clean:
	rm -rf classes
