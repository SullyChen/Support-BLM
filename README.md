# Support-BLM
An app to generate ad money for the Black Lives Matter (BLM) movement

# What is this?
Recently a [video](https://youtu.be/bCgLa25fDHM) was released intending to raise money for BLM. Unfortunately, YouTube's algorithm will often mark video views as spam if the video is simply replayed over and over, or opened many times at once.

This script implements the "5/+/r/3/a/m" method of YouTube randomization to maximize ad revenue.

# Requirements
For Windows, the only requirement is Google Chrome v83. For Mac/Linux, see below.

# Where to find the release
If you're not interested in the code and just want to download the app, follow this [link](https://github.com/SullyChen/Support-BLM/releases) and download the latest release!

# Python
Requirements: `pip install youtube-search pafy youtube_dl selenium`. You will also need Google Chrome v83, as well as the associated [ChromeDriver](https://chromedriver.chromium.org/) for your OS. Finally, you can run the `blm_script.py` which is included in this repository.

# Java
To install the Java version on any platform, open a terminal, set the working directory to Support-BLM/Java, and run the following command: `./gradlew :shadowJar`. To run the compiled application, use the following command: `java -jar build/libs/Support-BLM-all.jar`. Big thanks to David Hacker for porting the Python code to Java and writing all of the Gradle code!
