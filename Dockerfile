FROM prakashul/knowledgemeet:km
MAINTAINER "prakashul@tothenew.com"
COPY target/KSS-Jenkins-1.0-SNAPSHOT.jar /root/KSS-Jenkins.jar
COPY entrypoint.sh /entrypoint.sh
RUN chmod 755 /entrypoint.sh 
CMD ["/entrypoint.sh"]
