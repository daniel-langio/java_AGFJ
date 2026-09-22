package vendredi.soir.agfj.data;

/** Closed, engine-level vocabulary - a new type needs new evaluation code in TriggerSystem anyway. */
public enum TriggerType {
  PROXIMITY,
  CLICK,
  HOVER,
  TIME_OF_DAY,
  ENVIRONMENT_EVENT
}
