# CI workflows

## `showoff-video.yml` — manual, render + publish demo videos

```
gh workflow run showoff-video.yml --ref dev
```

Builds the video-export jar, renders `ball-bounce` and `two-balls-collide` under Xvfb, publishes both ways:

- **Durable link**: [`showoff-latest` release](../../releases/tag/showoff-latest) — overwritten every run, playable inline in the browser.
- **Per-run artifact**: that run's Artifacts section (30-day expiry) — `gh run download <run-id> --name ball-bounce-showoff`.

`workflow_dispatch` only — not on every push (would be slow/noisy for something you trigger occasionally).

## `auto-version.yml` — automatic, on every push to `dev`

Bumps and tags `projectVersion` (`gradle.properties`) automatically:
- any `feat:` commit since the last tag → **minor** bump
- anything else (`fix:`, `docs:`, `ci:`, ...) → **patch** bump
- **major is never auto-bumped**, even for a breaking-change commit

Creates the git tag (`vX.Y.Z`) and a GitHub Release with `--generate-notes`. First run (no prior semver tag) considers full history; later runs only consider commits since the last tag.

## `major-version.yml` — manual major bump

```
gh workflow run major-version.yml --ref dev
```

`workflow_dispatch` only — a major bump is a deliberate decision, never inferred from a commit message. Bumps to `X+1.0.0`, same tag/release mechanics as above.

## Conventions these rely on

- **PR titles** must use Conventional Commits (`feat:`, `fix:`, `docs:`, `ci:`, ...) — `auto-version.yml`'s bump decision reads commit messages, and PR titles become the squash-merge commit message.
- Tag lookups match `v[0-9]*.[0-9]*.[0-9]*` only, so unrelated tags (like `showoff-latest`) are never mistaken for a version.
