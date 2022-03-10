node {
    def app

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("gatling-tests:latest")
    }

    stage('MqttRoundtripMeasurementExample') {
        app.withRun('--net=host -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s MqttRoundtripMeasurementExample') { c -> 
            sh "docker ps"
            sh "curl -d 75 mqtt://localhost/number"
            sh "docker wait ${c.id}"
            gatlingArchive()
        }
    }

    stage('MqttScenarioExample') {
        app.withRun('--net=host -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s MqttScenarioExample') { c -> 
            sh "docker ps"
            sh "curl -d 75 mqtt://localhost/number"
            sh "docker wait ${c.id}"
            gatlingArchive()
        }
    }
}
