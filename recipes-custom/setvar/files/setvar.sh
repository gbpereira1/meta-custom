#!/bin/sh
# Set U-Boot ipaddr if different from the expected

EXPECTED_IPADDR="192.168.1.100"

IPADDR=$(fw_printenv ipaddr 2>/dev/null | sed 's/^[^=]*=//')

if [ "$IPADDR" != "$EXPECTED_IPADDR" ] ; then
    echo "setvar: IPADDR is different, setting U-Boot" >/dev/kmsg
    fw_setenv ipaddr "$EXPECTED_IPADDR"
    echo "setvar: Set ipaddr=$EXPECTED_IPADDR" >/dev/kmsg
fi
