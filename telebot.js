const TeleBot = require('telebot');
const request = require('request');

const bot = new TeleBot({
  token: '302195705:AAHKHRsw0Si_hrnkmaHhVhA2kVpFNpA4mRE', // Required. Telegram Bot API token.
  polling: { // Optional. Use polling.
    interval: 1000, // Optional. How often check updates (in ms).
    timeout: 0, // Optional. Update polling timeout (0 - short polling).
    limit: 100, // Optional. Limits the number of updates to be retrieved.
    retryTimeout: 5000 // Optional. Reconnecting timeout (in ms).
  }
})

const apiRoot = 'http://gdsfm.airtime.pro/api/item-history-feed'

bot.on('/history', msg => {
  let [cmdName, nrOfItems] = msg.text.split(' ')
  let chatId = msg.from.id
  let reply = msg.message_id
  console.log(cmdName, nrOfItems)
  return request.get({url: apiRoot}, (err, res, body)=>{
    let json = JSON.parse(body)
    return bot.sendMessage(chatId, json.toString().substring(0, 10), {reply})    
  })
})

bot.connect()