# Triggers and actions

Any entity instance can carry a priority-ordered list of `(Trigger, Action)` rules — the same mechanism drives a mouse-dragged paddle, a schedule-based NPC, and a proximity/event reaction. Highest-priority rule whose trigger currently holds wins; if none hold, the entity plays its `defaultActionId`.

## Rule shape

```json
"actionRules": [
  {
    "trigger": { "type": "HOVER" },
    "actionId": "idle",
    "priority": 10,
    "followTrigger": true
  }
]
```

| field | meaning |
|---|---|
| `trigger` | see types below |
| `actionId` | must be one of the entity's animation bindings |
| `priority` | higher evaluated first; ties broken by list order |
| `followTrigger` | if this rule wins, entity position tracks the trigger source (currently: the mouse) instead of its own `vx`/`vy`. Only one entity may be follow-driven at a time. |

## Trigger types

| type | fields | true when |
|---|---|---|
| `HOVER` | — | cursor is over the entity's bounding box |
| `CLICK` | — | left mouse pressed while over the entity, stays true (drag) until release, regardless of where the cursor moves meanwhile |
| `PROXIMITY` | `radius` | within `radius` world units of the scene's `cameraTarget` |
| `TIME_OF_DAY` | `startHour`, `endHour` (0-24) | current world-clock hour is in range (wraps past midnight if `startHour > endHour`, e.g. 22→6) |
| `ENVIRONMENT_EVENT` | `eventName` | that named event was raised this frame via `GameWorld.raiseEvent(name)` |

World-clock: a full day is `TriggerSystem.DAY_LENGTH_SECONDS` (120s) of `upTime`; `TIME_OF_DAY` is a pure function of it — an entity doesn't need to be actively simulated to "know" it should be asleep at night, it's evaluated fresh whenever queried.

`ENVIRONMENT_EVENT` is plumbing: nothing raises an event yet (a future collision-noise/sound system would call `world.raiseEvent("loud_sound")`).

## Camera target

```json
{ "entityDefinitionId": "hero", "cameraTarget": true, ... }
```

`Game.draw()` centers the viewport camera on whichever entity is flagged. Only one target makes sense at a time (last one wins if several instances set it).

## Simulation range

```json
{ "id": "my-scene", "simulationRange": 300, "entities": [...] }
```

Entities farther than `simulationRange` world units from the camera target skip physics (`animate()` — velocity integration, wall/entity collision) each frame; entities within range simulate normally. **Trigger/action evaluation still runs on every entity regardless of range** — a `TIME_OF_DAY`-driven villager stays behaviorally correct whether or not it's currently being physically simulated, since its action is a pure function of world-clock, not accumulated simulation. Omit `simulationRange` (or leave it unset) for unbounded — the default, matching every current demo.

## Collision (`solid`)

```json
{ "entityDefinitionId": "ball", "solid": true, ... }
```

Entities marked `solid` get pairwise AABB collision each frame (`CollisionSystem`): on overlap, both reflect velocity on the smaller-penetration axis and separate. A `followTrigger`-driven entity's velocity is never perturbed by collision (its position isn't driven by velocity while active).
