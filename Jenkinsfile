pipeline {
	agent {
		label 'dgordeev-vm-2-slave'
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