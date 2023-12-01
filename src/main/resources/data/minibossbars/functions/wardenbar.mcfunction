execute as @a[scores={wardenDistance=1},limit=1,sort=random] at @s unless entity @e[type=warden,tag=bossbar] run tag @e[type=warden,limit=1,sort=nearest] add bossbar
execute store result bossbar 3 value run data get entity @e[type=warden,tag=bossbar,limit=1,sort=nearest] Health 1
execute at @e[type=warden,tag=bossbar] run bossbar set 3 players @a[distance=..50]
bossbar set 3 name {"selector":"@e[type=warden,limit=1,tag=bossbar]"}
execute unless entity @e[type=warden,tag=bossbar] run bossbar set 3 players @a[distance=0]