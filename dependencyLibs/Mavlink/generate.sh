#!/bin/sh
# script to re-generate mavlink C code for APM

mavdir="$(dirname $0)"
echo Building in directory ${mavdir}

#if ! python -m pymavlink.tools.mavgen > /dev/null; then
#    echo "mavgen.py must be in your PATH. Get it from http://github.com/mavlink/mavlink in the pymavlink/generator directory"
#    exit 1
#fi

echo "Generating Java code"
#mavgen.py --lang=Java --wire-protocol=1.0 --output=$mavdir/src/com/MAVLink $mavdir/message_definitions/ardupilotmega.xml
python -m pymavlink.tools.mavgen --lang Java --wire-protocol 1.0 --output=$mavdir/src/com/MAVLink $mavdir/message_definitions/v1.0/ardupilotmega.xml
