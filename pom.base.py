import sys
import os

from xml.etree import ElementTree

# Verifying if the filename exist
try:
    filename = sys.argv[1]
    if not os.path.exists(filename):
        raise ValueError(f'{filename} does not exists.')
except Exception as e:
    raise e
root = ElementTree.parse(filename).getroot()

# Generate new elements
properties_str = """
<properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.target.source>8</maven.target.source>
</properties>
"""
properties = ElementTree.fromstring(properties_str)
build_str = """
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.0</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>2.4.3</version>
            <configuration>
                <filters>
                    <filter>
                        <artifact>*:*</artifact>
                        <excludes>
                            <exclude>META-INF/*.SF</exclude>
                            <exclude>META-INF/*.DSA</exclude>
                            <exclude>META-INF/*.RSA</exclude>
                        </excludes>
                    </filter>
                </filters>
            </configuration>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <transformers>
                            <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                <mainClass>com.peqa.example_name.App</mainClass>
                            </transformer>
                        </transformers>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
"""
build = ElementTree.fromstring(build_str)

# Appending element trees the root
root.append(properties)
root.append(build)

# Ensuring we apply a valid namespace
ElementTree.register_namespace("", "http://maven.apache.org/POM/4.0.0")
ElementTree.dump(root)

# Writting the new version of the file
xmlstr = ElementTree.tostring(
    root, xml_declaration=False)
with open(filename, "w") as f:
    f.write(xmlstr.decode('utf-8'))
