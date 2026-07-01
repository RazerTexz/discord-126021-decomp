package d0.e0.p.d.m0.k;

/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$d {
    public static final k$d a = new k$d(k$d$a.OVERRIDABLE, "SUCCESS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k$d$a f3469b;

    public k$d(k$d$a k_d_a, String str) {
        if (k_d_a == null) {
            a(3);
            throw null;
        }
        if (str != null) {
            this.f3469b = k_d_a;
        } else {
            a(4);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0031  */
    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
        if (i == 1 || i == 2) {
            objArr[0] = "debugMessage";
        } else if (i == 3) {
            objArr[0] = "success";
        } else if (i != 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
        } else {
            objArr[0] = "debugMessage";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                break;
            case 5:
                objArr[1] = "getResult";
                break;
            case 6:
                objArr[1] = "getDebugMessage";
                break;
            default:
                objArr[1] = "success";
                break;
        }
        if (i == 1) {
            objArr[2] = "incompatible";
        } else if (i == 2) {
            objArr[2] = "conflict";
        } else if (i == 3 || i == 4) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    public static k$d conflict(String str) {
        if (str != null) {
            return new k$d(k$d$a.CONFLICT, str);
        }
        a(2);
        throw null;
    }

    public static k$d incompatible(String str) {
        if (str != null) {
            return new k$d(k$d$a.INCOMPATIBLE, str);
        }
        a(1);
        throw null;
    }

    public static k$d success() {
        k$d k_d = a;
        if (k_d != null) {
            return k_d;
        }
        a(0);
        throw null;
    }

    public k$d$a getResult() {
        k$d$a k_d_a = this.f3469b;
        if (k_d_a != null) {
            return k_d_a;
        }
        a(5);
        throw null;
    }
}
