//'use strict';

var ConversationChecker = function (str, callback) {
	console.log('Conversation Checker is here');

	console.log('echoing: ' + str);
    cordova.exec(callback, function(err) {
        callback('Nothing to echo.');
    }, "ConversationChecker", "echo", [str]);
};


module.exports = ConversationChecker;