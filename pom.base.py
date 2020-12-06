import sys
import os

from xml.dom import minidom
from xml.etree import ElementTree

# Verifying if the filename exist
try:
    filename = sys.argv[1]
    if not os.path.exists(filename):
        raise ValueError(f'{filename} does not exists.')
except Exception as e:
    raise e
root = ElementTree.parse(filename).getroot()

# Generate properties for compiler
properties = ElementTree.Element("properties")
maven_compiler_source = ElementTree.SubElement(
    properties, 'maven.compiler.source')
maven_compiler_source.text = '1.8'
maven_compiler_target = ElementTree.SubElement(
    properties, 'maven.target.source')
maven_compiler_target.text = '1.8'

# Generate build elements
# build = ElementTree.Element("build")
# plugins = ElementTree.SubElement(build, 'plugins')
# plugin = ElementTree.SubElement(plugins, 'plugin')
# group_id = ElementTree.SubElement(plugin, 'groupId')
# group_id.text = 'org.apache.maven.plugins'
# artifact_id = ElementTree.SubElement(plugin, 'artifactId')
# artifact_id.text = 'maven-jar-plugin'
# version = ElementTree.SubElement(plugin, 'version')
# version.text = '3.1.0'
# configuration = ElementTree.SubElement(plugin, 'configuration')
# source = ElementTree.SubElement(configuration, 'source')
# source.text = '1.8'
# target = ElementTree.SubElement(configuration, 'target')
# target.text = '1.8'
# archive = ElementTree.SubElement(configuration, 'archive')
# manifest = ElementTree.SubElement(archive, 'manifest')
# add_class_path = ElementTree.SubElement(manifest, 'addClasspath')
# add_class_path.text = 'true'
# class_path_prefix = ElementTree.SubElement(manifest, 'classpathPrefix')
# class_path_prefix.text = 'lib'
# main_class = ElementTree.SubElement(manifest, 'mainClass')
# main_class.text = 'com.peqa.example_name.App'

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
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.3</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </pluginManagement>
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
