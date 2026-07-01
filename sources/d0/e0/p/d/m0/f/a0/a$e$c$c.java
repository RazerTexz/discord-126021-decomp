package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.h$a;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public enum a$e$c$c implements h$a {
    NONE(0),
    INTERNAL_TO_CLASS_ID(1),
    DESC_TO_CLASS_ID(2);

    private final int value;

    a$e$c$c(int i) {
        this.value = i;
    }

    @Override // d0.e0.p.d.m0.i.h$a
    public final int getNumber() {
        return this.value;
    }

    public static a$e$c$c valueOf(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return INTERNAL_TO_CLASS_ID;
        }
        if (i != 2) {
            return null;
        }
        return DESC_TO_CLASS_ID;
    }
}
