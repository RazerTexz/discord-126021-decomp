package b.g.a.a;

/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public enum i$c {
    ANY,
    NATURAL,
    SCALAR,
    ARRAY,
    OBJECT,
    NUMBER,
    NUMBER_FLOAT,
    NUMBER_INT,
    STRING,
    BOOLEAN,
    BINARY;

    public boolean f() {
        return this == NUMBER || this == NUMBER_INT || this == NUMBER_FLOAT;
    }
}
