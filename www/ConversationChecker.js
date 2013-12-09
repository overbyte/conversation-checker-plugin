/**
 * ConversationChecker Phonegap plugin
 */
var ConversationChecker = function () { 
	console.log('Conversation Checker is here'); 

	window.echo = function(str, callback) {
        cordova.exec(callback, function(err) {
            callback('Nothing to echo.');
        }, "Echo", "echo", [str]);
    };
};



//-------------------------------------------------------------------

module.exports = new ConversationChecker();