package problem;

import java.util.List;

public class ProblemProperties {
    private List<String> states;
    private List<Action> actions;
    private List<ActionEdgeCost> actionEdgeCosts;
    private String initialState;
    private String goalState;

    public ProblemProperties() {
    }

    public ProblemProperties(List<String> states, List<Action> actions, List<ActionEdgeCost> actionEdgeCosts, String initialState, String goalState) {
        this.states = states;
        this.actions = actions;
        this.actionEdgeCosts = actionEdgeCosts;
        this.initialState = initialState;
        this.goalState = goalState;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<ActionEdgeCost> getActionEdgeCosts() {
        return actionEdgeCosts;
    }

    public void setActionEdgeCosts(List<ActionEdgeCost> actionEdgeCosts) {
        this.actionEdgeCosts = actionEdgeCosts;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public String getGoalState() {
        return goalState;
    }

    public void setGoalState(String goalState) {
        this.goalState = goalState;
    }
}
