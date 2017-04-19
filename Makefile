checkstyle:
	cd plugins; ./gradlew checkstyle

test-android:
	cd plugins; ./gradlew :traffic:test

build-release-android:
	cd plugins; ./gradlew :traffic:assembleRelease

javadoc:
	# Android modules
	# Output is ./mapbox/*/build/docs/javadoc/release
	cd plugins; ./gradlew :traffic:javadocrelease

publish-android:
	cd plugins; export IS_LOCAL_DEVELOPMENT=false; ./gradlew :traffic:uploadArchives

publish-local:
	# This publishes to ~/.m2/repository/com/mapbox/mapboxsdk
	cd plugins; export IS_LOCAL_DEVELOPMENT=true; ./gradlew :traffic:uploadArchives
