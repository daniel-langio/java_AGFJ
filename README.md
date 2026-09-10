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

## Generate a show-off video via CI

A manual-only GitHub Actions workflow (`.github/workflows/showoff-video.yml`) does the same export as above, but on a runner instead of your machine:

```
gh workflow run showoff-video.yml --ref dev
```

Once it finishes, download the video from that run's **Artifacts** section (`ball-bounce-showoff`, contains the `.mp4`) — either in the Actions tab on GitHub, or:

```
gh run download <run-id> --name ball-bounce-showoff
```

Artifacts expire after 30 days. This only runs the `ball-bounce` scene — it needs no real mouse, unlike the `paddle-control` demo.

## Scene/entity/action files

Edit or add JSON under `assets/data/actions`, `assets/data/entities`, `assets/data/scenes` to change what's in a scene — no Java changes needed.

## License

See [LICENSE](LICENSE) — attribution required, 1% royalty if commercialized.
