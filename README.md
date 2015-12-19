# Cubitick
The Cubitick minecraft mod is an analysis tool for the technical minecraft community. It allows you to change the tickrate of the game, while still allowing you to move and interact with the world at a normal speed.

### Commands

`/tickrate [rate]`
Sets the tickrate of the world to `rate`.

`/ticksync [on/off]`
Controls if the player-tickrate should be independent of the world-tickrate. It is off (or false) by default. Enabling ticksync will use more vanilla code where possible (which might influence test results). Don't enable this at a world-tickrate of zero, or your game will freeze!

### Packet Analysis
Cubitick 1.4.X comes bundled with a packet analysis tool which lets you view the content of some packets that are sent between the minecraft client and server.

`/showpacket [PACKET_TYPE] [true/false]`
You can get a list of supported packet-types by running `/showpacket` without arguments. If you need to analyse packets of a particular type that are not yet supported, then you can try to contact me by email (probably slower) or on my [youtube channel](https://www.youtube.com/user/Cubitect) (probably faster) and I will try implement support in the next release.

`/rerender [fromX fromY fromZ toX toY toZ]`
When no arguments are specified, `/rerender` will do the same as pressing F3+A. However, if a region of block coordinates is defined by the argument, then the blocks in that region are marked to be rendered again (without reloading). This command is still experimental and might change syntax in future.

## Source
The source code [here](https://github.com/Cubitect/Cubitick/tree/Cubitick-1.8) contains the modified classes in the decompiled minecraft code from [Mod Coder Pack](http://www.modcoderpack.com). The unmodified classes are not included.
