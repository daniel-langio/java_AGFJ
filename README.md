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

It renders both the `ball-bounce` and `two-balls-collide` scenes (nothing needing real mouse input, unlike `paddle-control`, since there's no mouse on a CI runner) and publishes both ways:

- **Durable, always-current link:** the [`showoff-latest` release](../../releases/tag/showoff-latest) — overwritten on every run, so this link always has the newest videos, playable right in the browser.
- **Per-run artifact:** the triggering run's **Artifacts** section (`ball-bounce-showoff` / `two-balls-collide-showoff`), if you want that specific run's output — expires after 30 days:
  ```
  gh run download <run-id> --name ball-bounce-showoff
  ```

## Releases

`projectVersion` in `gradle.properties` and the repo's release tags follow semver, kept in sync automatically:

- **Every merge to `dev`** bumps and tags itself (`.github/workflows/auto-version.yml`): a `feat:` commit since the last tag bumps minor, anything else bumps patch. Major is never bumped automatically.
- **Major version bumps are manual** (`.github/workflows/major-version.yml`, `workflow_dispatch` only) — a deliberate action, not something inferred from a commit message:
  ```
  gh workflow run major-version.yml --ref dev
  ```

Both create a git tag (`vX.Y.Z`) and a GitHub Release with auto-generated notes.

## Scene/entity/action files

Edit or add JSON under `assets/data/actions`, `assets/data/entities`, `assets/data/scenes` to change what's in a scene — no Java changes needed.

## License

See [LICENSE](LICENSE) — attribution required, 1% royalty if commercialized.
