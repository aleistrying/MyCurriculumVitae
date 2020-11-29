# Delete the current "project" and creates a new one.
sudo rm -rf project
docker run --rm --name peqa.dev-maven \
           -v "$PWD/project:/usr/src" \
           -it peqa.dev/tutorials/maven:latest sh -c "mvn archetype:generate \
                    -DgroupId=peqa \
                    -DartifactId=example_project_name \
                    -DarchetypeArtifactId=maven-archetype-quickstart \
                    -DinteractiveMode=false"
sudo chown -R $USER:$USER ./project