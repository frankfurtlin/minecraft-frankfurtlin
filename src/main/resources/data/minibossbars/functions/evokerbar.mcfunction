execute as @a[scores={evokerDistance=1},limit=1,sort=random] at @s unless entity @e[type=evoker,tag=bossbar] run tag @e[type=evoker,limit=1,sort=nearest] add bossbar
execute store result bossbar 1 value run data get entity @e[type=evoker,tag=bossbar,limit=1,sort=nearest] Health 1
execute at @e[type=evoker,tag=bossbar] run bossbar set 1 players @a[distance=..50]
bossbar set 1 name {"selector":"@e[type=evoker,limit=1,tag=bossbar]"}
execute unless entity @e[type=evoker,tag=bossbar] run bossbar set 1 players @a[distance=0]