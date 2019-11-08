package problem;

public class ActionEdgeCost {
    private String state;
    private String action;
    private double cost;

    public ActionEdgeCost() {
    }

    public ActionEdgeCost(String state, String action, double cost) {
        this.state = state;
        this.action = action;
        this.cost = cost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
