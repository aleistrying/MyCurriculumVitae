docker run --rm --name peqa.dev-maven \
           -v "$PWD/project:/usr/src" \
           -it peqa.dev/tutorials/maven:latest $@