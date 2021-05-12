#!/bin/bash

sname=tomcat-8087

PID=$(ps -ef | grep ${sname} | grep -v grep | awk '{print $2}')

if [ ! $PID ]; then
    echo "process ${sname} not exit"
    exit
else
    echo "process id: $PID"
fi

kill -9 ${PID}

if [ $? -eq 0 ]; then
    echo "kill ${sname} success"
else
    echo "kill ${sname} fail"
fi
