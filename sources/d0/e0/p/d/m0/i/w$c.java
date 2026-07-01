package d0.e0.p.d.m0.i;

/* JADX INFO: compiled from: WireFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public enum w$c {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(c.j),
    ENUM(null),
    MESSAGE(null);

    private final Object defaultDefault;

    w$c(Object obj) {
        this.defaultDefault = obj;
    }
}
