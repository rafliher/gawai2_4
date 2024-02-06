#!bin/bash
until $(curl --output /dev/null --silent --head --fail http://localhost:6080 ); do
echo "waiting for selenium hub being started"
sleep 1
done
