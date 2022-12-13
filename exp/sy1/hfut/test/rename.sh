#!/bin/bash
for file in `ls *_*`
do
	name=${file%_*}
	num=${file#*_}
	newname="hfut1_"${num}
	mv $file $newname
done
