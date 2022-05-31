#Delete a folder
rm -rf target

#Create a folder
mkdir target

#Copy resources
mkdir target/resources
cp src/resources/* target/resources

#Copy .class for jcommander
jar -xf lib/jcommander-*.jar; mv com target; rm -rf META-INF

#Copy .class for JCDP
jar -xf lib/JCDP-*.jar; cp -R com target; rm -rf META-INF com

#Сompilation
javac -cp lib/*:./lib/* src/java/edu/school21/printer/*/*.java -d target

#Create .jar
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

#Start .jar
java -jar target/images-to-chars-printer.jar  --white=RED --black=GREEN
