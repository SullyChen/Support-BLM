import webbrowser
import random
from youtube_search import YoutubeSearch
import time
import pafy

def main():
    while True:
        webbrowser.open("https://youtu.be/bCgLa25fDHM", new=1) #open main BLM-ad video in new window
        time.sleep(3386); #wait until main video finishes

        #generate new array of youtube links
        print("Querying new video links")
        results = YoutubeSearch('black lives matter -fox', max_results=32).to_dict() #query YouTube for videos, exclude Fox news
        links = ["https://youtube.com" + l["link"] for l in results]

        random_indices = random.choices(range(0, len(links)), k=len(links)) #sample without replacement

        idx = 0 #current index
        for _ in range(random.randint(3, 5)):
            #pick a YouTube video to open
            print("Searching for suitable new video...")
            while True:
                if idx >= len(links): #highly unlikely, but fail-safe
                    print("Ran out of links, will try again later...")
                    break
                video = pafy.new(links[idx]) #Creating pafy object
                if video.length < 600: #only pick videos under 10 minutes to save time
                    print("Opening new video: " + links[idx])
                    webbrowser.open_new_tab(links[idx]) #open a random blm video
                    print("Waiting " + str(video.length) + " seconds...")
                    time.sleep(video.length) #wait a minute to open the next one
                    idx += 1
                    break
                else:
                    idx += 1
        print("Reopening original video...")

if __name__ == '__main__':
    main()
