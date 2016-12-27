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
});

bot.on('text', msg => {
  let fromId = msg.from.id;
  let firstName = msg.from.first_name;
  let reply = msg.message_id;
  //return bot.sendMessage(fromId, `Welcome, ${ firstName }!`, { reply });
  return request.get({url:'http://gdsfm.airtime.pro/api/item-history-feed'}, (err, res, body)=>{
    let json = JSON.parse(body);
    json.sort((a, b) => {
        return new Date(a.starts).getTime() - new Date(b.ends).getTime();
    });
    console.log(json);
    return bot.sendMessage(fromId, body.toString().substring(0, 10));    
  });
  
});

bot.connect();