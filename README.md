# Nofy

A libGDX prototype for interactive animated scenes: entities and their actions (walk, jump, bounce, ...) are described in JSON files, not hardcoded in Java.

**Docs: [docs/README.md](docs/README.md)** — authoring scenes, triggers/actions, demos, video export, CI workflows.

## Modules

- `core`: engine — entities, animations, actions, scene loading, triggers (`assets/data/`).
- `lwjgl3`: desktop launcher, demos, headless video-export tool.
- `html`: web platform (GWT/WebGL).

## Quick start

```
./gradlew lwjgl3:run                    # interactive demo
./gradlew lwjgl3:runBallBounce           # a scenario preview (see docs/demos.md)
./gradlew lwjgl3:videoExportJar          # build the headless video-export jar (see docs/video-export.md)
```

## License

See [LICENSE](LICENSE) — attribution required, 1% royalty if commercialized.
