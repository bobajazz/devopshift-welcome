pipelineJob('קובץ dsa') { // Job NAME
   definition {
       cpsScm {
           scm {
               git('https://github.com/yanivomc/devopshift-welcome.git') { // Your repository
                   branches('*/main') // Branch to build, replace with your branch if needed
                   extensions {
                       relativeTargetDirectory('docker-demo') // Optional: Check out to a sub-directory
                       cleanBeforeCheckout() // Optional: Clean the workspace before checkout
                   }
                   userRemoteConfigs {
                       userRemoteConfig {
                           name('DSL User')
                           email('jenkins-dsl@domain.com')
                       }
                   }
               }
           }
           scriptPath('/sudent/matan/jenkinsfile') // Path to the Jenkinsfile in the repository
       }
   }
   triggers { // Configure when to check for changes
       scm('H/5 * * * *')
   }
}