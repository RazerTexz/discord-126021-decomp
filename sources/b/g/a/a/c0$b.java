package b.g.a.a;

/* JADX INFO: compiled from: JsonTypeInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public enum c0$b {
    NONE(null),
    CLASS("@class"),
    MINIMAL_CLASS("@c"),
    NAME("@type"),
    DEDUCTION(null),
    CUSTOM(null);

    private final String _defaultPropertyName;

    c0$b(String str) {
        this._defaultPropertyName = str;
    }

    public String f() {
        return this._defaultPropertyName;
    }
}
