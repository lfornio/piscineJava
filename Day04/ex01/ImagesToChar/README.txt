#Delete a folder
rm -rf target

#Create a folder
mkdir target

#Сompilation
javac src/java/edu/school21/printer/*/*.java -d target

#Copy resources
mkdir target/resources
cp src/resources/* target/resources

#Create .jar
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

#Start .jar
java -jar target/images-to-chars-printer.jar "." o