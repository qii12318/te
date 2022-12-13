#!/bin/bash
read -p "path startline endline:$ " order
IFS=" "
array=($order)
filepath=${array[0]}
startloc=${array[1]}
endloc=${array[2]}
cat $filepath -n | head -n $endloc | tail -n +$startloc
