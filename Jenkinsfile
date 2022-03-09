node {
    def app

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("gatling-tests")
    }

    stage('MqttRoundtripMeasurementExample') {
        app.inside {
            sh 'docker run -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)"/results/:/opt/gatling/results/ docker.io/library/gatling-tests -s MqttRoundtripMeasurementExample'
        }
    }

    stage('MqttScenarioExample') {
        app.inside {
            sh 'docker run -v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)"/results/:/opt/gatling/results/ docker.io/library/gatling-tests -s MqttScenarioExample'
        }
    }
}