package b.g.a.c.f0;

import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.f0.a, reason: use source file name */
/* JADX INFO: compiled from: JsonNodeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class JsonNodeFactory implements Serializable {
    public static final JsonNodeFactory j;
    public static final JsonNodeFactory k;
    private static final long serialVersionUID = 1;
    private final boolean _cfgBigDecimalExact;

    static {
        JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);
        j = jsonNodeFactory;
        k = jsonNodeFactory;
    }

    public JsonNodeFactory() {
        this._cfgBigDecimalExact = false;
    }

    public JsonNodeFactory(boolean z2) {
        this._cfgBigDecimalExact = z2;
    }
}
