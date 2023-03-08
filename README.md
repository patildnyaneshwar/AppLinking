# AppLinking

In this example, you'll learn what android app links are and how to implement them to a specific screen in your app.

## What is Android App Links
_Android App Links_ allow an app to designate itself as the default handler of an application domain or URL that uses the HTTP and HTTPS protocols and has the ```autoVerify``` attribute. When a user clicks on an Android App Link, if your app is installed, it opens immediately—the disambiguation dialogue does not appear.

If the user does not want your app to be the default handler, they can change it in the app's settings. 

Unfortunately, App Links is only compatible with Android 6.0 (API level 23) and higher.

## Android 12 and Above
In Android 12 and above Google made changes to how the app will handle external links by the app.

> Starting with Android 12 (API level 31), a generic web intent will only resolve to an activity in your app only if your app is authorised for the particular domain it contains. In the absence of domain approval, the web intent resolves to the user's default browser application.

## Implimentation
I guess it's not necessary for me to explain everything because Google has already created a really good documentation. I've attached the links below for your convenience.

* [Handling Android App Links](https://developer.android.com/training/app-links)
* [Add Android App Links](https://developer.android.com/studio/write/app-link-indexing)
* [Verify Android App Links](https://developer.android.com/training/app-links/verify-android-applinks)

This example's primary focus is on how to publish the assetlinks.json file to a host/web server and github pages, as I'll explain below.
## Upload assetlinks.json file to the host/web-server
You must publish JSON verification file at the following location:
```https://domain.name/.well-known/assetlinks.json```
* The assetlinks.json file is served with ```content-type application/json```.
* The assetlinks.json file must be accessible over an HTTPS connection.
* The assetlinks.json file must be accessible without any redirects (no 301 or 302 redirects).
* The ```assetlinks.json```  file need to be added in root directory of host/project/webserver.

*Note:* The directory/package should be ```.well-known```, because google bot verifies the json file.

## How to use Github Pages repository as host
Now, we must create a repository and configure it to host our file (for free hosting). As an example, [this](https://github.com/patildnyaneshwar/AppLinking) is my repository.

Create a new public GitHub repository and clone it locally. I made two, one to host the web app and the other to add ```assetlinks.json``` file to host root directory.

#### _Host/Deploy web app_
To begin, navigate to the repository's settings tab and select the Pages menu from the left side. Now scroll down to the Branch section, where you can select the branch where the ```index.html``` file is located, as well as the root or docs directory and save. Your web app will be live in a matter of minutes. 

<p align="center">
  <img width="700" height="300" src="https://github.com/patildnyaneshwar/AppLinking/blob/main/image_files/github_pages_tab.png">
</p>

----------

<p align="center">
  <img width="700" height="300" src="https://github.com/patildnyaneshwar/AppLinking/blob/main/image_files/github_deployment_branch.png">
</p>

### _Upload assetlinks.json_
Remember when we deploy a web app, our domain name is always _github_username.github.io_. You can also create your own custom domain name in the github pages by configuring DNS in Google Domain, Cloudfare, GoDaddy, and other services.

_Note:_ GitHub also handles folders in Pages repositories differently. Essentially, you can't get to your asset linking file without first telling GitHub that the folder should be included.

As a result, when we host our web app the generated link will be something like _username.github.io/repo/_. So we have to create a new repo called _username.github.io_ ([Click here](https://github.com/patildnyaneshwar/patildnyaneshwar.github.io)) and put the ```assetlinks.json``` file inside the ```.well-known``` directory. Still, our job is not done here yet. We must follow the steps below to add ```assetlinks.json``` to the root directory of the github pages.

* Create the file ```_config.yml``` in the root of your project.
* Put include: [".well-known"] inside the ```_config.yml```.

Now, navigate to your asset links URL (https://yourdomain/.well-known/assetlinks.json) and you should see your ```assetlinks.json``` file!


## Finally, Verify the file assetLinks.json
You've created the file and uploaded it, but how do you know if it's correct?

Click the below link. 

https://digitalassetlinks.googleapis.com/v1/statements:list?source.web.site=https://domain-name&relation=delegate_permission/common.handle_all_urls

Replace _domain-name_ with the name of your domain. If your file looks like this at the bottom, it is correct.

<p align="center">
  <img width="700" height="300" src="https://github.com/patildnyaneshwar/AppLinking/blob/main/image_files/linking_sucess.png">
</p>

## Example
* If app is installed clicking on the [link](https://patildnyaneshwar.github.io/AppLinking/web-app/home?username=username&password=12345) opens the app and If we have both username and password values, this will auto-fill in edittext and execute auto sign-in, else the standard scenario will be used.
* In case app is not installed, the link by default opens the browser.

I hope you have learned something from this example. Please let me know if you have any questions. I will be delighted to assist you.

Happy Coding :)
