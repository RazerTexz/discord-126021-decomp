package d0.z.d;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements Serializable {
    public static final d$a j = new d$a();

    private Object readResolve() throws ObjectStreamException {
        return j;
    }
}
