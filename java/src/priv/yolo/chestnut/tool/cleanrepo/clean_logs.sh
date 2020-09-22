#!/usr/bin/env bash

logDirs[0]=""

cleanDate=+1

cleanLogDir=""

logFile="${cleanLogDir}/cleanLog_`date +%Y-%m-%d`.log"

if [ ! -d ${cleanLogDir} ]; then
  mkdir ${cleanLogDir}
fi

for logDir in ${logDirs[@]}; do
  echo "清理日志文件，当前时间为：[`date +%F\ %T`]" >> ${logFile}
  find ${logDir} -type f \( -name \*.log -o -name \*.txt \) -mmin ${cleanDate} -print0 | xargs -0 -I file sh -c "echo 删除 file >> ${logFile}; rm file;"
  echo " " >> ${logFile}
done
