package agfj.core.entity;

import agfj.core.interaction.Action;
import agfj.core.interaction.Interaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InteractionTest {

    CharacterState target;
    Action action;

    Interaction subject;

    @BeforeAll
    void setUp(){

    }
}
