package agfj.core.interaction;

import agfj.core.entity.BodyState;
import agfj.core.entity.CharacterMood;
import agfj.core.entity.CharacterState;
import agfj.core.physics.Vector2D;
import agfj.core.type.IntegerPosition;
import agfj.core.type.IntegerRange;
import agfj.core.type.LogicalOperator;
import agfj.core.type.ValueRelation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InteractionTest {

    CharacterStateRange target;
    Action action;

    Interaction subject;

    @BeforeAll
    void setUp(){
        BodyStateRange bodyStates = new BodyStateRange(
                new IntegerRange(new IntegerPosition(ValueRelation.SUPERIOR, 50), LogicalOperator.OR, new IntegerPosition(ValueRelation.EQUAL, 50)),
                new IntegerRange(new IntegerPosition(ValueRelation.SUPERIOR, 50), LogicalOperator.OR, new IntegerPosition(ValueRelation.EQUAL, 50)),
                new IntegerRange(new IntegerPosition(ValueRelation.SUPERIOR, 50), LogicalOperator.OR, new IntegerPosition(ValueRelation.EQUAL, 50)),
                new IntegerRange(new IntegerPosition(ValueRelation.SUPERIOR, 50), LogicalOperator.OR, new IntegerPosition(ValueRelation.EQUAL, 50))
        );

        this.target = new CharacterStateRange(bodyStates);
        this.action = new Speech(5, "You are in shape ein ?!", CharacterMood.NEUTRAL);
        this.subject = new Interaction(target, action);
    }

    @Test
    void state_inclusion(){
        Action idle = new Movement(1, 0, new Vector2D(0, 0));

        CharacterState includedState = new CharacterState(new BodyState(100, 50, 200, 100), idle);
        CharacterState nonIncludedState = new CharacterState(new BodyState(20, 50, 200, 100), idle);

        assertEquals(true, subject.targetState().isInclude(includedState));
        assertEquals(false, subject.targetState().isInclude(nonIncludedState));
    }
}
