package ch.idsia.agents.controllers;

import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
//import ch.idsia.benchmark.mario.environments.Environment;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, sergey_at_idsia_dot_ch
 * Date: May 9, 2009
 * Time: 1:42:03 PM
 * Package: ch.idsia.agents.controllers
 */

public class ScaredSpeedyAgent extends BasicMarioAIAgent implements Agent
{
    public ScaredSpeedyAgent()
    {
        super("ScaredSpeedyAgent");
    }

    int trueJumpCounter = 0;
//    int trueSpeedCounter = 0;

    public boolean[] getAction()
    {
        if (/*levelScene[11][13] != 0 ||*/ levelScene[11][12] != 0 ||
                /* levelScene[12][13] == 0 ||*/ levelScene[12][12] == 0)
        {
            if (isMarioAbleToJump || (!isMarioOnGround && action[Mario.KEY_JUMP]))
            {
                action[Mario.KEY_JUMP] = true;
            }
            ++trueJumpCounter;
        } else
        {
            action[Mario.KEY_JUMP] = false;
            trueJumpCounter = 0;
        }

        if (trueJumpCounter > 46)
        {
            trueJumpCounter = 0;
            action[Mario.KEY_JUMP] = false;
        }

        return action;
    }

    public void reset()
    {
        action[Mario.KEY_RIGHT] = true;
        action[Mario.KEY_SPEED] = true;
    }
}