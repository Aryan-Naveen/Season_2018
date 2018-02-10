## Build Status
[![Build Status](https://travis-ci.org/Greenvillians281/Entech281_2018.svg?branch=master)](https://travis-ci.org/Greenvillians281/Entech281_2018)

## Team281 Java Conventions
Eclipse Preferences > Java > Code Style > Formatter > New > Name the profile to Team281 Conventions > Initialize settings with "Java Conventions" > OK > Change Tab policy to "Spaces only" > Set Indentation size to 4 > Set Tab size to 4 > OK

## FAQ for UNIX lang in bash/terminal

_Instructions imply you're already in the `Team281_2018` directory_

### To push your changes to a branch
1. git checkout _branchname_
2. git add --all
3. git commit -m '_Enter commit message here_'
4. git push

### To make a merge (pull) request
1. Go to Pull Requests in GitHub
2. Click on New Pull Request
3. Select "base: master" and "compare: _Your Branch Goes Here_"
4. Make a good title and description so reviewers understand your code
5. Add people to review your code

### To deploy to robot
1. Connect to robot's WiFi hotspot 
2. ./gradlew deploy
3. Restart Robot Code in the Driver's Station

## Eclipse help

>Eclipse has lost its mind! - Dave Cowden

### Fix Eclipse 101 
* cd (directory you want to be in)
* ./gradlew clean
* ls -la
* rm -rf .classpath .project .settings 
* ./gradlew eclipse
* Open eclipse
* Browse to directory
* Enjoy your happy eclipse!

### To format your document
1. Click anywhere in a document or Package Explorer
2. Click Source
3. Click Format or Organize Imports

### To run a test
* ./gradlew build to test for bugfixes
* Right click what you want to be tested in the File Explorer > Run as > JUnit Test

## Helpful information

### Helpful commands 
* pwd (to find current directory)
* ls (to see the names of all files inside current directory)
* git reset --hard _CommitIdentifierCode_ (to rollback to a previous commit)
* git reset --hard (to reset to the last _git pull_'ed version of a branch)
* git reset -f (to unto a branch checkout)
* git branch _BranchName_ (to create a branch)

### Dave’s “foot/car race” analogy for understanding PIDF and gains
Say you’re a runner and you want to run a mile. You have a goal of running 100 yards in 5 seconds.

You start the race, and run 100 yards in 7 seconds - you’re not going fast enough and as time passes. Those 2 seconds will add up for every 100 yards you run at that pace, leaving you further and further behind the other runners. 

F is how fast you want to go before you even start the race. It’s the pace you’re aiming for, in this case 100 yards in 5 seconds.

The I term represents the total amount of time you’re off the mark, adding up as you go. At 200 yards, you will be 4 seconds behind. At 300, 6 seconds behind.

P is the difference you’re off between two intervals. For example, you’re off by 2 seconds in between 0 and 100 yards.

Say you speed up to 100 yards in 6 seconds between 300 and 400 yards. D is the difference between the current error and the previous error. In this case, you were off 2 seconds between 200 and 300 yards, but only 1 second off between 300 and 400 yards.

Now say you’re driving a car, so you’re measuring feet/seconds. When you accelerate to go faster, you go from 0 to 100% throttle. However, the motor measures speed in feet per seconds, not 0 to 1 (the throttle). Gains are the number that you multiply feet/second to get a vase between 0 and 1.

If you’re going to slow, you need to floor the accelerator, so the value is closer to 0, because you’re getting closer to the finish line.

Say the motor has a voltage input of 12V, and you measure it in 500 encoder counts per second. You’re currently at 200 encoder counts, so 300 short. You multiply 200 by a gain to figure out how far behind you are compared to 1V.

##### Last updated 2/8/18 by Santiago #####
