These files can help you to bootstrap a devenv ubuntu 12.04 LTS system. 

It is far away from perfect but a start. At a conference the resulted VM can be shared via usb stick. Install vagrant, (on windows also Xming, Putty) and VirtualBox on your (tested with win)  host system. And give this directory vagrant to "vagrant up" your vm. As this solution uses a headless/server ubuntu. So you have to SSH -X localhost:2222 into your vm and then start the STS-Eclipse under /usr/local/springsource/.../STS. It is configured so that port 8080 is passed through to the host system, so that you can start the appserver in eclipse and access the webapp through typing "localhost:8080" into your host system 's browser. 

A second approach is to install a 32-bit Ubuntu 12.04 LTS in virtualbox and use only the puppet file default.pp to bootstrap the system. This has the advantage, that also the browser/acceptance testing works.

In any case you probably will have to start the puppet script two times and between them have to start STS to create the default workspace suggested from STS.
