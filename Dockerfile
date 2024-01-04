FROM ubuntu:latest
LABEL authors="stvnreis"

ENTRYPOINT ["top", "-b"]