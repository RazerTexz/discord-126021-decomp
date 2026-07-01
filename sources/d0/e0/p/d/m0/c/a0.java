package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: ModalityUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final boolean isFinalClass(e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        return eVar.getModality() == z.FINAL && eVar.getKind() != f.ENUM_CLASS;
    }
}
