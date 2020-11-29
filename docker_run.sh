docker run --rm -it \
           -v "$PWD/project:/usr/src" \
           -u 1000 \
           peqa.dev/tutorials/maven:latest $@