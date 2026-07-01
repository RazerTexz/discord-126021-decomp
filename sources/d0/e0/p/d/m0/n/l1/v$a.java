package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.i1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v$a {
    public static final v$a j;
    public static final v$a k;
    public static final v$a l;
    public static final v$a m;
    public static final /* synthetic */ v$a[] n;

    static {
        v$a$c v_a_c = new v$a$c("START", 0);
        j = v_a_c;
        v$a$a v_a_a = new v$a$a("ACCEPT_NULL", 1);
        k = v_a_a;
        v$a$d v_a_d = new v$a$d("UNKNOWN", 2);
        l = v_a_d;
        v$a$b v_a_b = new v$a$b("NOT_NULL", 3);
        m = v_a_b;
        n = new v$a[]{v_a_c, v_a_a, v_a_d, v_a_b};
    }

    public v$a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        super(str, i);
    }

    public static v$a valueOf(String str) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        return (v$a) Enum.valueOf(v$a.class, str);
    }

    public static v$a[] values() {
        v$a[] v_aArr = n;
        v$a[] v_aArr2 = new v$a[v_aArr.length];
        System.arraycopy(v_aArr, 0, v_aArr2, 0, v_aArr.length);
        return v_aArr2;
    }

    public abstract v$a combine(i1 i1Var);

    public final v$a f(i1 i1Var) {
        d0.z.d.m.checkNotNullParameter(i1Var, "<this>");
        if (i1Var.isMarkedNullable()) {
            return k;
        }
        return n.a.isSubtypeOfAny(i1Var) ? m : l;
    }
}
