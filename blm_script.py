import webbrowser
import random
from youtube_search import YoutubeSearch
import time

#wait an exact time in seconds
def wait(wait_time):
    target_time = time.clock() + wait_time
    while time.clock() < target_time:
        pass

max_results = 30 #number of random BLM videos to query from YouTube
results = YoutubeSearch('black lives matter', max_results=max_results).to_dict() #query YouTube for videos

#generate array of youtube links
links = []
for l in results:
    links.append("https://youtube.com" + l["link"])

#main loop
while True:
    webbrowser.open("https://youtu.be/bCgLa25fDHM") #open BLM-ad video
    wait(3386) #wait until the video finishes
    for i in range(0, random.randint(3, 5)): #pick a random number of videos to open
        webbrowser.open(links[random.randrange(max_results)]) #open the video
        wait(60) #wait a minute to open the next one
