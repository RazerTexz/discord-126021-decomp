package d0.e0.p.d.m0.e.b;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$c extends k {
    public final String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c(String str) {
        super(null);
        d0.z.d.m.checkNotNullParameter(str, "internalName");
        this.j = str;
    }

    public final String getInternalName() {
        return this.j;
    }
}
