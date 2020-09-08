package fifteen.serializable;

import java.io.ObjectStreamException;

public class Orientation {
    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation( 2 );
    private int value;
    private Orientation(int value){
        this.value = value;
    }

    private Object readResolve() throws ObjectStreamException{
        if(value == 1){
            return HORIZONTAL;
        }else if(value == 2){
            return VERTICAL;
        }
        return null;
    }
}
