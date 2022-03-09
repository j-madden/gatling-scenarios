node {
    def app

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("gatling-tests:latest")
    }

    stage('MqttRoundtripMeasurementExample') {
        app.run('-v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s MqttRoundtripMeasurementExample')
    }

    stage('MqttScenarioExample') {
        app.run('-v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)":/opt/gatling/results/', '-s MqttScenarioExample')
    }

    stage('Gatling Archive') {
        gatlingArchive()
    }
}
