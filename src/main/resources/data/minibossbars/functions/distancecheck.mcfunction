#give any close enough players a score
execute as @a at @s if entity @e[type=evoker,distance=..50] run scoreboard players set @s evokerDistance 1
execute as @a at @s if entity @e[type=elder_guardian,distance=..50] run scoreboard players set @s elderGuardianDistance 1
execute as @a at @s if entity @e[type=warden,distance=..50] run scoreboard players set @s wardenDistance 1

#remove score from further players
execute as @a at @s unless entity @e[type=evoker,distance=..50] run scoreboard players set @s evokerDistance 0
execute as @a at @s unless entity @e[type=elder_guardian,distance=..50] run scoreboard players set @s elderGuardianDistance 0
execute as @a at @s unless entity @e[type=warden,distance=..50] run scoreboard players set @s wardenDistance 0