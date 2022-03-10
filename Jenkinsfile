node {
    def app

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("gatling-tests:latest")
    }

    stage('MqttScenarioExample') {
        app.withRun('--net=host -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s MqttScenarioExample') { c -> 
            sh "docker wait ${c.id}"
            gatlingArchive()
        }
    }

    stage('AnotherMqttScenarioExample') {
        app.withRun('--net=host -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s AnotherMqttScenarioExample') { c -> 
            sh "docker wait ${c.id}"
            gatlingArchive()
        }
    }
}
