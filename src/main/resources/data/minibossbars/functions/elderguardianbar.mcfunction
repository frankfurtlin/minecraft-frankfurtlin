execute as @a[scores={elderGuardianDistance=1},limit=1,sort=random] at @s unless entity @e[type=elder_guardian,tag=bossbar] run tag @e[type=elder_guardian,limit=1,sort=nearest] add bossbar
execute store result bossbar 2 value run data get entity @e[type=elder_guardian,tag=bossbar,limit=1,sort=nearest] Health 1
execute at @e[type=elder_guardian,tag=bossbar] run bossbar set 2 players @a[distance=..50]
bossbar set 2 name {"selector":"@e[type=elder_guardian,limit=1,tag=bossbar]"}
execute unless entity @e[type=elder_guardian,tag=bossbar] run bossbar set 2 players @a[distance=0]