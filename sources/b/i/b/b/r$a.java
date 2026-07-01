package b.i.b.b;

import java.io.Serializable;

/* JADX INFO: compiled from: ImmutableSet.java */
/* JADX INFO: loaded from: classes3.dex */
public class r$a implements Serializable {
    private static final long serialVersionUID = 0;
    public final Object[] elements;

    public r$a(Object[] objArr) {
        this.elements = objArr;
    }

    public Object readResolve() {
        return r.n(this.elements);
    }
}
