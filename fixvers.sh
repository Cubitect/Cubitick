#!/bin/bash

# To use, place this file inside the minecraft version directory, and run:
# ./fixvers.sh [VERSION_DIR]
# Where the actual minecraft jar file should be located at "./VERSION_DIR/VERSION_DIR.jar"

# This script disassembles and fixes the internal name of net/minecraft/server/MinecraftServer 
# such that it becomes accessable to the modded classes. The 'fixed' classes are placed in '$out'.
# The disassembler used here is the "Krakatau Bytecode Tools" by Robert Grosse.

tmp="./tmp_deasm"
out="./$1/fixclasses"
krakatauDir="./Krakatau-master"

unzip -q ./$1/$1.jar -d $out
python $krakatauDir/disassemble.py -r $out -out $tmp 1>/dev/null
rm -r $out/*
rm $(grep -rL 'MinecraftServer' $tmp/* 2>/dev/null) 2>/dev/null
mv $tmp/net/minecraft/server/MinecraftServer* $tmp
find $tmp -type f -print0 | xargs -0 sed -i 's#net/minecraft/server/MinecraftServer#MinecraftServer#g'
python $krakatauDir/assemble.py -q -r $tmp -out $out
rm -r $tmp
if [ ! -e ./$1/$1_ori.jar ]
then
  cp ./$1/$1.jar ./$1/$1_ori.jar
fi
wdir=$(pwd)
cd $out
jar uf $wdir/$1/$1.jar ./*.class
cd $wdir
