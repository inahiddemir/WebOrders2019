node {

// Select SCM

        stage("Pulling code from github") {
           git 'https://github.com/inahiddemir/WebOrders2019.git'
       }

 // build
        stage("Running tests") {
            if (isUnix()) {
              parallel chrome: {
              				    sh label: '', script: 'mvn clean test -Dbrowser="chrome"'
              				}, firefox: {
              				    sh label: '', script: 'mvn clean test -Dbrowser="chrome_headless"'
              				}

            } else {
               parallel chrome: {
               				        bat label: '', script: 'mvn clean test -Dbrowser="chrome"'
               				    }, firefox: {
               				        bat label: '', script: 'mvn clean test -Dbrowser="chrome_headless"'
               				    }

            }
        }

// generate report
        stage("Generate cucumber report"){
            cucumber fileIncludePattern: '**/*.json', sortingMethod: 'ALPHABETICAL'
        }

//send email
        stage("Send email"){
            emailext body:
            '''${JELLY_SCRIPT, template="html"}
            $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS
            <br>
            <strong>Check Cucumber HTML report: $PROJECT_URL/$BUILD_NUMBER/cucumber-html-reports/overview-features.html</strong>''',
            subject: 'Smoke test status: $BUILD_STATUS',
            to: 'i.nahid.demir@gmail.com'
        }
}