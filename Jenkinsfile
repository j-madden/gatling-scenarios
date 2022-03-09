node {
    def app

    stage('Clone repository') {
        checkout scm
    }

    stage('Build image') {
        app = docker.build("gatling-tests:latest")
    }

    stage('MqttRoundtripMeasurementExample') {
        app.run('-v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)"/results/:/opt/gatling/results/', '-s MqttRoundtripMeasurementExample')
        .inside() {
            gatlingArchive()
        }
    }

    stage('MqttScenarioExample') {
        app.run('-v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)"/results/:/opt/gatling/results/', '-s MqttScenarioExample')
        .inside() {
            gatlingArchive()
        }
    }
}
