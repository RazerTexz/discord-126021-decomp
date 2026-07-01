package b.i.b.b;

import java.io.Serializable;

/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$c implements Serializable {
    private static final long serialVersionUID = 0;
    public final Object[] elements;

    public p$c(Object[] objArr) {
        this.elements = objArr;
    }

    public Object readResolve() {
        return p.o(this.elements);
    }
}
