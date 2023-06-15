package com.haemimont.cars.funny;

public class Joke {
    String type;
    String setup;
    String punchline;
    int id;

    public Joke(String type, String setup, String punchline, int id) {
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                ", id=" + id +
                '}';
    }
}
