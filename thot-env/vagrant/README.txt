These files can help you to bootstrap a devenv ubuntu 12.04 LTS system for the thot application. 

The current state is far away from perfect but a start. At a conference the resulted VM can be shared via usb stick. Quite important is, that after the devenv image works, the developer sets his git user configuration before he commits anything further, to be able to identify later commits:

 git config --add user.name "the-developers-user-name"
 git config --add user.email "the-developers-email@his-provider.org"

Optionally the workflow can be improved by configuring ssh access to github.

"Server Approach": Advantage is: it is already more automated, but acceptance testing does not yet work. Install vagrant, (on windows also Xming, Putty) and VirtualBox on your (tested with win)  host system. And give this directory vagrant to "vagrant up" your vm. As this solution uses a headless/server ubuntu. So you have to SSH -X localhost:2222 into your vm and then start the STS-Eclipse under /usr/local/springsource/.../STS. It is configured so that port 8080 is passed through to the host system, so that you can start the appserver in eclipse and access the webapp through typing "localhost:8080" into your host system 's browser. 

"Desktop Approach": A second approach is to install a 32-bit Ubuntu 12.04 LTS in virtualbox and use only the puppet file manifest/default.pp to bootstrap the system. You have to install the puppet package before you start. This approach has the advantage, that also the browser/acceptance testing works, but currently only with the firefox 11.0+build1-0ubuntu4. So probably you will have to downgrade your FF. A first try with newer selenium version and FF 24 broke, but should be done in the future. 

In any case you probably will have to start the puppet script two times and between them have to start STS to create the default workspace suggested from STS. After that in STS you will have to do some additional manual steps like importing the eclipse projects, configure a tomcat server referencing the tomcat under /usr/local/apache-tomcat..., adding the webapp to the server and probably some steps I have forgotten. Perhaps someone can further automate these steps by copying eclipse metadata files.
