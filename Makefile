all:
	javac -d org.ioopm.calculator.ast/classes org.ioopm.calculator.ast/*.java

run:
	java -cp classes org.ioopm.calculator.Calculator

clean:
	rm -rf org.ioopm.calculator.ast/classes
