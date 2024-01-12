"""
    decodes the content scraped by Scraper.java module
"""
from bs4 import BeautifulSoup

with open(file="content.txt", mode="r", encoding="utf-8") as file:
    message = file.read()

soup = BeautifulSoup(message, "html.parser")


def decode_message(tag, indent=0):
    """decode funtion which analyzed the html tag hierarchy and prints the content"""

    if tag.children:
        for child in tag.children:
            if tag.name == "div":
                print(tag.text)
            decode_message(child, indent + 1)


decode_message(soup)
