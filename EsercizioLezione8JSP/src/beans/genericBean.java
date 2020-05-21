package src.beans;

public class genericBean {

    // Attributo per la JSP calcolatrice
    private String value = "";
    private int[] values = new int[1];
    private int index = 0;

    public genericBean(){}

    public String getValue() {
        if (this.index > 0) {
            String history = this.value;
            history = history.concat(", [");
            for (int v: this.values) {
                history = history.concat(String.format(" %d", v));
            }
            history = history.concat("]");
            return history;
        } else {
            return "Nessun calcolo recente";
        }
    }

    public void setValue(String value) {
        this.value = value;
        this.setValues(Integer.parseInt(value));
    }

    public void setValues(int value) {
        this.value = String.valueOf(value);
        this.values[this.index++] = value;
        int[] newvalue = new int[this.index + 1];
        int tmp = 0;
        while (tmp < this.index){
            newvalue[tmp] = this.values[tmp];
        }
        this.values = newvalue;
    }
}