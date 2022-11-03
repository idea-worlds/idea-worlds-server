#!/bin/bash
cd `dirname $0`
archetype_group="-DarchetypeGroupId=dev.simpleframework"
archetype_artifact="-DarchetypeArtifactId=simple-archetype-module"
archetype_version="-DarchetypeVersion=0.1-SNAPSHOT"

moduleName=$1
if [ -z $moduleName ]; then
  read -p "please input module name: " moduleName
fi
if [ -z $moduleName ]; then
  echo "module name can not be empty"
  exit 1;
fi

packageName=$moduleName
packageName=${packageName##*-}
packageName=${packageName##*_}
packageName=${packageName,,}
sampleName=${packageName^}

module_group="-DgroupId=info.ideaworlds.server"
module_artifact="-DartifactId=$moduleName"
module_version="-Dversion=1.0-SNAPSHOT"
module_package="-Dpackage=info.ideaworlds.server.$packageName"
module_sample="-Dsample=$sampleName"
module_project="-Dproject=idea-worlds-server"
module_db="-Ddb=postgresql"

mvn archetype:generate $archetype_group $archetype_artifact $archetype_version $module_group $module_artifact $module_version $module_package $module_sample $module_project $module_db