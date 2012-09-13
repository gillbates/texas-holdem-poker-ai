package edu.ntnu.texasai.controller;

import edu.ntnu.texasai.controller.opponentmodeling.OpponentModeler;
import edu.ntnu.texasai.model.BettingDecision;
import edu.ntnu.texasai.model.GameHand;
import edu.ntnu.texasai.model.Player;

import javax.inject.Inject;

public class PlayerControllerPhaseIIIConservative extends PlayerControllerPhaseIII {
    @Inject
    public PlayerControllerPhaseIIIConservative(PlayerControllerPhaseII playerControllerPhaseII,
                                                HandStrengthEvaluator handStrengthEvaluator,
                                                OpponentModeler opponentModeler) {
        super(playerControllerPhaseII, handStrengthEvaluator, opponentModeler);
    }

    @Override
    protected BettingDecision decideBet(GameHand gameHand, Player player,
                                        Integer oppponentsWithBetterEstimatedHandStrength,
                                        Integer opponentsModeledCount) {
        if (oppponentsWithBetterEstimatedHandStrength == 0) {
            return BettingDecision.RAISE;
        } else if (canCheck(gameHand, player)) {
            return BettingDecision.CALL;
        } else {
            return BettingDecision.FOLD;
        }
    }
}