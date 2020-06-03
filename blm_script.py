import webbrowser
import random
from youtube_search import YoutubeSearch
import time

max_results = 30 #number of random BLM videos to query from YouTube
results = YoutubeSearch('black lives matter -fox', max_results=max_results).to_dict() #query YouTube for videos, exclude Fox news

# print(results)

#generate array of youtube links
links = ["https://youtube.com" + l["link"] for l in results]
# print(links)

#main loop
while True:
    print("starting BLM video...")

    webbrowser.open("https://youtu.be/bCgLa25fDHM", new=1) #open BLM-ad video in new window
    time.sleep(3386); #wait until the video finishes


    for i in range(0, random.randint(3, 5)): #pick a random number of videos to open
        webbrowser.open(links[random.randrange(max_results)]) #open a random blm video
        time.sleep(60) #wait a minute to open the next one
