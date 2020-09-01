#!groovy
properties([disableConcurrentBuilds()])

pipeline {
	agent {
		label 'master'
	}
	options {
		timestamps()
	}
	stages {
	   	stage('Preparation') {
			steps {
				sh "echo 'Preparing to Jenkins pipeline invokation.'"
				sh 'hostname'
				sh 'java -version'
				sh 'sudo yum upgrade'
			}
		}
	}

}