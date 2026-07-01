package d0.e0.p.d.m0.j;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final p j;
    public static final p k;
    public static final /* synthetic */ p[] l;

    static {
        p$b p_b = new p$b("PLAIN", 0);
        j = p_b;
        p$a p_a = new p$a("HTML", 1);
        k = p_a;
        l = new p[]{p_b, p_a};
    }

    public p(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        super(str, i);
    }

    public static p valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        p[] pVarArr = l;
        p[] pVarArr2 = new p[pVarArr.length];
        System.arraycopy(pVarArr, 0, pVarArr2, 0, pVarArr.length);
        return pVarArr2;
    }

    public abstract String escape(String str);
}
