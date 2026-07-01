package d0.e0.p.d.m0.e.a;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$c {
    public static final e0$c j;
    public static final e0$c k;
    public static final e0$c l;
    public static final e0$c m;
    public static final /* synthetic */ e0$c[] n;
    private final Object defaultValue;

    static {
        e0$c e0_c = new e0$c("NULL", 0, null);
        j = e0_c;
        e0$c e0_c2 = new e0$c("INDEX", 1, -1);
        k = e0_c2;
        e0$c e0_c3 = new e0$c("FALSE", 2, Boolean.FALSE);
        l = e0_c3;
        e0$c$a e0_c_a = new e0$c$a("MAP_GET_OR_DEFAULT", 3);
        m = e0_c_a;
        n = new e0$c[]{e0_c, e0_c2, e0_c3, e0_c_a};
    }

    public e0$c(String str, int i, Object obj) {
        super(str, i);
        this.defaultValue = obj;
    }

    public static e0$c valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (e0$c) Enum.valueOf(e0$c.class, str);
    }

    public static e0$c[] values() {
        e0$c[] e0_cArr = n;
        e0$c[] e0_cArr2 = new e0$c[e0_cArr.length];
        System.arraycopy(e0_cArr, 0, e0_cArr2, 0, e0_cArr.length);
        return e0_cArr2;
    }

    public e0$c(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        super(str, i);
        this.defaultValue = obj;
    }
}
