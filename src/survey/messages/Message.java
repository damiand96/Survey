package survey.messages;

import java.io.Serializable;
// Serializacja danych
public abstract class Message implements Serializable {
    private static final long serialVersionUID = 123456789L;

    public String name;

    @Override
    public String toString() {
        return this.getClass() +  ", name: " + name;
    }
}
