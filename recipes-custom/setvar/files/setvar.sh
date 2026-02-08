#!/bin/sh
# Set U-Boot ipaddr and serverip on first boot if they differ from expected values

EXPECTED_IPADDR="192.168.1.100"
EXPECTED_SERVERIP="192.168.1.101"

# Read current values (fw_printenv outputs "name=value", extract value)
IPADDR=$(fw_printenv ipaddr 2>/dev/null | sed 's/^[^=]*=//')
SERVERIP=$(fw_printenv serverip 2>/dev/null | sed 's/^[^=]*=//')

# If either differs, set both
if [ "$IPADDR" != "$EXPECTED_IPADDR" ] || [ "$SERVERIP" != "$EXPECTED_SERVERIP" ]; then
    echo "setvar: First boot detected, setting U-Boot variables" >/dev/kmsg
    fw_setenv ipaddr "$EXPECTED_IPADDR"
    fw_setenv serverip "$EXPECTED_SERVERIP"
    echo "setvar: Set ipaddr=$EXPECTED_IPADDR serverip=$EXPECTED_SERVERIP" >/dev/kmsg
fi
