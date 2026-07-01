package b.g.a.c.f0;

import java.io.Serializable;

/* JADX INFO: compiled from: JsonNodeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Serializable {
    public static final a j;
    public static final a k;
    private static final long serialVersionUID = 1;
    private final boolean _cfgBigDecimalExact;

    static {
        a aVar = new a(false);
        j = aVar;
        k = aVar;
    }

    public a() {
        this._cfgBigDecimalExact = false;
    }

    public a(boolean z2) {
        this._cfgBigDecimalExact = z2;
    }
}
