#!/bin/bash

source plugins/$TARGET_PLUGIN
git clone https://github.com/kounoike/gitbucket-plugin-registry.git
pushd gitbucket-plugin-registry
git config credential.helper "store --file=.git/credentials"
echo "https://${GH_TOKEN}:@github.com" > .git/credentials

mkdir -p registry/plugins/$GITBUCKET_VERSION
echo "{\"name\": \"$PLUGIN_NAME\", \"version\": \"$PLUGIN_VERSION\", \"url\": \"$PLUGIN_URL\"}" > registry/plugins/$GITBUCKET_VERSION/$TARGET_PLUGIN.json
git add .
git commit . -m "CI Check passed for $PLUGIN_NAME:$PLUGIN_VERSION with GitBucket-$GITBUCKET_VERSION"
git push origin HEAD:master
popd