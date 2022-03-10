folder("Gatling-tests") {
    displayName("Gatling-test jobs")
}

pipelineJob('Gatling-tests/example') {
    displayName('Example')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('ssh://https://github.com/j-madden/gatling-simulations.git')
                        branch('seed-jobs')
                    }
                }
            }
            scriptPath('./jobs/MqttScenarioExample/Jenkinsfile')
        }
    }
}

pipelineJob('Gatling-tests/another') {
    displayName('Another')
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('ssh://https://github.com/j-madden/gatling-simulations.git')
                        branch('seed-jobs')
                    }
                }
            }
            scriptPath('./jobs/AnotherMqttScenarioExample/Jenkinsfile')
        }
    }
}
