package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: ClassKind.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
