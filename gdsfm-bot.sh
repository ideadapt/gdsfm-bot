#!/bin/bash

java -jar gdsfm-bot-master/gdsfm-server/target/telegram-bot-0.0.1-SNAPSHOT.jar 2&>1 

node gdsfm-bot-master/gdsfm-bot/telebot.js



