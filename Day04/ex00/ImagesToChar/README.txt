#Delete a folder
rm -rf target

#Create a folder
mkdir target

#Сompilation
javac src/java/edu/school21/printer/*/*.java -d target

#Start
java -classpath target edu.school21.printer.app.Program "." o /Users/lfornio/Desktop/it.bmp

