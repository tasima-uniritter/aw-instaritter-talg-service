#!/bin/bash

touch /var/log/cloud-reverser.log
nohup java -jar -Dspring.profiles.active=production /tmp/*.jar > /var/log/aw-instaritter-talg-service.log 2>&1 &