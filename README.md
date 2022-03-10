### Jenkins + Gatling + MQTT

Setup Jenkins locally:
- Install the docker plugin
- Install the Gatling plugin
- Create a SCM pipeline pointing at this repo

Start up mosquitto with the no-auth configuration exposing the default ports
`docker run -p 1883:1883 -p 9001:9001 eclipse-mosquitto mosquitto -c /mosquitto-no-auth.conf`

Note: Gatling Plugin will look for files under your Job Root Directory (defaults to $JENKINS_HOME/yourjobname), so you may need to copy the results file if you're doing a containerized job.
