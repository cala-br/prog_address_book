build:
	javac -d bin/ address_book/Program.java

run: build
	java -cp bin/ address_book.Program