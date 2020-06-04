# Support-BLM
A python script to generate ad money for the Black Lives Matter (BLM) movement

# What is this?
Recently a [video](https://youtu.be/bCgLa25fDHM) was released intending to raise money for BLM. Unfortunately, YouTube's algorithm will often mark video views as spam if the video is simply replayed over and over, or opened many times at once.

This script implements the "5/+/r/3/a/m" method of YouTube randomization to maximize ad revenue.

# Requirements
For Windows, the only requirement is Google Chrome v83. For Mac/Linux, see below.

# How to use on Windows
For Windows users, download and unzip the blm_windows_exe.zip file, then run "blm_script.exe" and that's it! HUGE shoutout to [Brent Vollebregt](https://github.com/brentvollebregt/auto-py-to-exe), who made the code to turn any .py file into a Windows executable. Incredible work which allowed this project to be easier to use on Windows! Please turn off YouTube autoplay, and ensure that your machine is not set to go to sleep after a certain period of time (this will stop the videos from playing).

# For Mac/Linux
Unfortunately, I haven't yet been able to make a Mac or Linux executable file. To run this, [download Python](https://www.python.org/downloads/), then in a [terminal](https://www.youtube.com/watch?v=QROX039ckO8), type `pip install youtube-search pafy youtube_dl selenium`. You will also need Google Chrome v83, as well as the associated [ChromeDriver](https://chromedriver.chromium.org/) for your OS. Finally, you can run the `blm_script.py` which is included in this repository. Please turn off YouTube autoplay, and ensure that your machine is not set to go to sleep after a certain period of time (this will stop the videos from playing).
