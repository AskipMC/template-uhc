# Description

This plugin is a simple plugin that allow you to do an UHC. 
The idea is not really to do simple UHC, you can fork this and add roles ... 

# Commands

- /uhc create : create the UHC
- /uhc delete : delete the UHC (need to be in END state)
- /uhc start : start the UHC
- /uhc stop : stop the UHC (and put it in END state)
- /uhc player add [name] : add a player to the game
- /uhc player remove [name] : remove a player to the game
- /uhc player list : see the player in the game

For every command, the permission is uhc.[first arg].use, for instance uhc.create.use for /uhc create

# For developpers

SettingsUHC is a default config that you can set in settings.yml 
ConfigUHC is the current config of the UHC, currently impossible to change but maybe in the future with a GUI :-)
