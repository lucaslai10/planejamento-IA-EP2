package problem;

public class Edge {
    private String origin;
    private String destiny;
    private double probability;

    public Edge() {
    }

    public Edge(String origin, String destiny, double probability) {
        this.origin = origin;
        this.destiny = destiny;
        this.probability = probability;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
