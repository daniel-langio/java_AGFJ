# AGFJ

A libGDX prototype for interactive animated scenes: entities and their actions (walk, jump, bounce, ...) are described in JSON files, not hardcoded in Java.

## Modules

- `core`: engine — entities, animations, actions, scene loading (`assets/data/`).
- `lwjgl3`: desktop launcher, plus a headless video-export tool.
- `html`: web platform (GWT/WebGL).

## Run the interactive demo

```
./gradlew lwjgl3:run
```

## Export a scene to video

```
./gradlew lwjgl3:videoExportJar
java -jar lwjgl3/build/libs/AGFJ-video-export-1.0.0.jar assets/data/video/ball-bounce.json
```

Renders headlessly to an MP4 (no ffmpeg needed). Still needs a real display to render frames (e.g. Xvfb on a headless server).

## Scene/entity/action files

Edit or add JSON under `assets/data/actions`, `assets/data/entities`, `assets/data/scenes` to change what's in a scene — no Java changes needed.

## License

See [LICENSE](LICENSE) — attribution required, 1% royalty if commercialized.
