package p507d0.p513e0.p514p.p515d.p517m0.p521c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.f */
/* JADX INFO: compiled from: ClassKind.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11333f {
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
