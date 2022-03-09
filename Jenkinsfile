pipeline {
    agent {
        docker {
            image 'jmlunatech/gatling-tests'
            alwaysPull true
            args '-v "$(pwd)"/gatling/simulations:/opt/gatling/user-files/simulations -v "$(pwd)"/results/:/opt/gatling/results/'
        }
    }
    stages {
        stage('MqttScenarioExample') {
            steps {
                sh "-s MqttScenarioExample"
            }
        }
        stage('MqttRoundtripMeasurementExample') {
            steps {
                sh "-s MqttRoundtripMeasurementExample"
            }
        }
        stage('Gatling Archive') {
            steps {
                gatlingArchive()
            }
        }
    }
}
