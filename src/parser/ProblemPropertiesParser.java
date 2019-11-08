package parser;

import problem.Action;
import problem.ActionEdgeCost;
import problem.Edge;
import problem.ProblemProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProblemPropertiesParser {

    private final String STATES = "states";
    private final String END_STATES = "endstates";
    private final String ACTION = "action";
    private final String END_ACTION = "endaction";
    private final String COST = "cost";
    private final String END_COST = "endcost";
    private final String INITIAL_STATE = "initialstate";
    private final String END_INITIAL_STATE = "endinitialstate";
    private final String GOAL_STATE = "goalstate";
    private final String END_GOAL_STATE = "endgoalstate";

    private ProblemProperties problemProperties;
    private List<String> states;
    private List<Action> actions;
    private List<ActionEdgeCost> actionEdgeCosts;
    private String initialState;
    private String goalState;

    private Iterator<String> iterator;

    public ProblemProperties parseToProblemProperties(String fileName) {
        this.states = new LinkedList<>();
        this.actions = new LinkedList<>();
        this.actionEdgeCosts = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            ProblemProperties problemProperties = new ProblemProperties();
            this.iterator = stream.iterator();
            while (this.iterator.hasNext()) {
                String line = this.iterator.next();
                if (line.startsWith(STATES)) {
                    setStates();
                } else if (line.startsWith(ACTION)) {
                    setAction(line);
                } else if (line.startsWith(COST)) {
                    setCosts();
                } else if (line.startsWith(INITIAL_STATE)) {
                    setInitialState();
                } else if (line.startsWith(GOAL_STATE))
                    setGoalState();
            }
            this.problemProperties = new ProblemProperties(this.states,
                                                      this.actions,
                                                      this.actionEdgeCosts,
                                                      this.initialState,
                                                      this.goalState);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.problemProperties;
    }

    private void setStates() {
        while (this.iterator.hasNext()) {
            String line = this.iterator.next();
            if (line.startsWith(END_STATES)) {
                break;
            }
            String[] states = line.trim().split(",");
            this.states = Arrays.stream(states)
                                .map(this::toState)
                                .collect(Collectors.toList());
        }
    }

    private String toState(String s) {
        return s.trim();
    }

    private void setAction(String actionLine) {
        String actionName = actionLine.split(" ")[1];
        List<Edge> edges = new LinkedList<>();
        while (this.iterator.hasNext()) {
            String line = this.iterator.next();
            if (line.startsWith(END_ACTION)) {
                break;
            }
            String[] edgeProperties = line.split(" ");
            edges.add(new Edge(edgeProperties[0], edgeProperties[1], Double.parseDouble(edgeProperties[2])));
        }
        this.actions.add(new Action(actionName, edges));
    }

    private void setCosts() {
        while (this.iterator.hasNext()) {
            String line = this.iterator.next();
            if (line.startsWith(END_COST)) {
                break;
            }
            String[] edgeCost = line.split(" ");
            this.actionEdgeCosts.add(new ActionEdgeCost(edgeCost[0], edgeCost[1], Double.parseDouble(edgeCost[2])));
        }
    }

    private void setInitialState() {
        while (this.iterator.hasNext()) {
            String line = this.iterator.next();
            if (line.startsWith(INITIAL_STATE)) {
                break;
            }
            this.initialState = line.trim();
        }
    }

    private void setGoalState() {
        while (this.iterator.hasNext()) {
            String line = this.iterator.next();
            if (line.startsWith(GOAL_STATE)) {
                break;
            }
            this.goalState = line.trim();
        }
    }
}
