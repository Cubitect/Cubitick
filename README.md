# Cubitick
The Cubitick minecraft mod is an analysis tool for the technical minecraft community. It allows you to change the tickrate of the game, while still allowing you to move and interact with the world at a normal speed.

### Commands

`/tickrate [rate]`
Sets the tickrate of the world to `rate`.

`/ticksync [true/false]`
Controls if the player-tickrate should be bound to the world-tickrate (false by default). When ticksync is enabled, the mod uses more vanilla code where possible (which might be relevant for testing). 
Don't enable this at a world-tickrate of zero, or your game will freeze!

`/rerender [fromX fromY fromZ toX toY toZ]`
When no arguments are specified, `/rerender` will do the same as pressing F3+A. However, if a region of blocks is specified, then that region is marked in the code to be rendered again (without reloading). This command is still experimental and might change syntax in the future.

### Packet Analysis
Cubitick 1.4 to 1.5.1 comes bundled with a packet analysis tool which lets you view the content of some packets that are sent between the minecraft client and server.

## Source
The source code [here](https://github.com/Cubitect/Cubitick/tree/master) contains the modified classes in the decompiled minecraft code from [Mod Coder Pack](http://www.modcoderpack.com). The unmodified classes are not included.

Some versions of this mod are written by modifying minecraft's obfuscated code (for minecraft versions were MCP is unavailable). For those version I used the [CFR java decompiler](http://www.benf.org/other/cfr/) to get the source code. However, it turns out that it is not possible to modify the MinecraftServer class this way, as only classes in the default directory are accessible this way. To work around this issue I used [Krakatau Bytecode Tools](https://github.com/Storyyeller/Krakatau) to move the MinecraftServer class into the default directory.

