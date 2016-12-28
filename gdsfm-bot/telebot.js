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

const apiRoot = 'http://localhost:8080'

bot.on('/current', msg => {
  let [cmdName, nrOfItems] = msg.text.split(' ')
  let chatId = msg.from.id
  let reply = msg.message_id
  return request.get({url: apiRoot + "/current"}, (err, res, body)=>{
    return body
  })
})

bot.connect()
