#evoker setup
bossbar add 1 "Evoker"
bossbar set 1 color yellow
bossbar set 1 max 24
bossbar set 1 style progress

#elder guardian setup
bossbar add 2 "Elder Guardian"
bossbar set 2 color white
bossbar set 2 max 80
bossbar set 2 style progress

#warden setup
bossbar add 3 "Warden"
bossbar set 3 color blue
bossbar set 3 max 500
bossbar set 3 style progress

#setup distance scoreboards
scoreboard objectives add evokerDistance dummy "Evoker Distance"
scoreboard objectives add elderGuardianDistance dummy "Elder Guardian Distance"
scoreboard objectives add wardenDistance dummy "Warden Distance"