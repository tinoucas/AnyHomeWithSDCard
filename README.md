
/!\ THIS FORK HAS A HARD-CODED REQUIREMENT FOR AN SD-CARD /!\

## Problem
  On a AYN Odin 2, if you choose ES-DE as your launcher (currently being version 3.0.3-26), and have ROMs or ES-DE data on the SD-CARD, you get the ES-DE setup wizard after rebooting the device. The launcher, ES-DE, gets started by the system before the SD-CARD is mounted and ready.

## Usage
- Launch AnyHome, and choose ES-DE (it will on ask once, if you mess this up, uninstall/reinstall AnyHome).
- Set AnyHome as your default home app (from Apps > Default Apps in Android settings).

## With this fork:
  Now, after reboot, ES-DE won't be started until the sd-card is mounted and ready. There will be a small delay, but you shouldn't get the setup wizard again.

  IF YOU DON'T HAVE AN SD-CARD NOTHING WILL HAPPEN AND THE SCREEN WILL REMAIN BLANK (use the original AnyHome instead: https://github.com/tytydraco/AnyHome)


## Side note
  In the android app switcher, you can "swipe down" ES-DE to "lock" it. This way it won't get closed when you tap "Clear All".

Original README:
# AnyHome
Use any app as a homescreen launcher

# How to use
Select an app on the initial screen and set AnyHome as your default launcher. Reset the app data to set a new home app.
