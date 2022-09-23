 :seedling: :seedling: This is just a basic framework under development for automating of Web applications.  `Java` `Selenium` `TestNG` `ExtentReports` `Docker`

 Designed specifically for `clipboard` project. :clipboard::black_nib: :paperclip:   
 
 #
 
**How to run test locally** :desktop_computer:    

1. Go to the project folder `clipboard-automation` where `pom.xml` file is present.
2. Open terminal/CMD in this folder.   
3. Run command **mvn clean install**   

the test suite execution will start and you can see the execution report under **test-result** folder (it will be generated automatically).
#

**How to run test on BrowserStack**   :cloud_with_lightning_and_rain:   :rocket:  

I have created a github workflow for this project that will execute the script on BrowserStack  

On this repository   

1. Go to Actions tab in this repository
2. Click on workflow `Clipboard UI Automation`
3. Click on `Run workflow` dropdown 
4. Click on green `Run workflow` button   

Login to browserstack to see results, follow below steps   
Sign in: [BrowserStack](https://www.browserstack.com/users/sign_in )  
[Username]: gawolo8548@satedly.com   
[Password]: Fork@123   
Now go to [dashboard](https://automate.browserstack.com/dashboard/v2/builds)  to check your run. You can see here video of your execution and all the logs.

[Here is the end to end video for the scenario automated](https://automate.browserstack.com/dashboard/v2/builds/71c5d234ce3596b44d0bbbb56f273b1ef5d40b64/sessions/53ce06ef7d2a670dd8951b9673e6becb164e99ce)

You can also download the `test-result` folder present inside `Artifact` block in last github workflow run and see the extent HTML report.  
#

**How to run using docker image** :whale:   :rocket:  

I have added a github workflow that will publish a new image evertime there is a merge into master branch, so that we have the latest docker image always.
This image is public and can be accessed by anyone at the moment.Stored in github registry.


1. Seach for the Packages section in this repository 
2. Click on package `clipboard-automation/clipboard-tests`
3. Copy the latest docker pull command from there (like `docker pull ghcr.io/dangi13/clipboard-automation/clipboard-tests:XXXXXXX`)
4. Run this command on your computer in a terminal (you should have docker installed)
5. After running the above command you should get an image downloaded in your machine (like `ghcr.io/dangi13/clipboard-automation/clipboard-tests:XXXXXXX`)
6. Now run `docker run ghcr.io/dangi13/clipboard-automation/clipboard-tests:XXXXXXX mvn -f /home/clipboard-automation/pom.xml clean install
`
7. Test cases will start running now in your machine.   
// TODO (Still configuration to pass browser in docker command is in progress)
#

Cheers :shipit: :tada:



