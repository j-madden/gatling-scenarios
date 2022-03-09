pipeline {
    agent {
        dockerfile {
            filename 'Dockerfile'
            dir 'build'
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
