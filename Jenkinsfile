node {
    stage('Checkout') {
            /*git url: 'https://github.com/soumendhar1310/sampleDBUtil.git', credentialsId: '1196f52e-7a91-4507-9fc5-840598e1f9ba', branch: 'master'*/
        checkout scm
        }
        
   stage('Build') {
            sh 'mvn clean install'
   }
}
