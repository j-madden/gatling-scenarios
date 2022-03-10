folder("Gatling-tests") {
    displayName("Gatling-test jobs")
}

pipelineJob('Gatling-tests/full') {
    displayName('Full')
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
            scriptPath('./Jenkinsfile.full-job')
        }
    }
}
