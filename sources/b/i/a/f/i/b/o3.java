package b.i.a.f.i.b;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o3 extends r5 {
    public static final AtomicReference<String[]> c = new AtomicReference<>();
    public static final AtomicReference<String[]> d = new AtomicReference<>();
    public static final AtomicReference<String[]> e = new AtomicReference<>();

    public o3(u4 u4Var) {
        super(u4Var);
    }

    @Nullable
    public static String v(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Objects.requireNonNull(atomicReference, "null reference");
        AnimatableValueParser.l(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (t9.q0(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Override // b.i.a.f.i.b.r5
    public final boolean r() {
        return false;
    }

    @Nullable
    public final String s(Bundle bundle) {
        String strW;
        if (bundle == null) {
            return null;
        }
        if (!z()) {
            return bundle.toString();
        }
        StringBuilder sbU = outline.U("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbU.length() != 8) {
                sbU.append(", ");
            }
            sbU.append(x(str));
            sbU.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                strW = w(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                strW = w((Object[]) obj);
            } else {
                strW = obj instanceof ArrayList ? w(((ArrayList) obj).toArray()) : String.valueOf(obj);
            }
            sbU.append(strW);
        }
        sbU.append("}]");
        return sbU.toString();
    }

    @Nullable
    public final String t(zzaq zzaqVar) {
        String string;
        if (!z()) {
            return zzaqVar.toString();
        }
        StringBuilder sbU = outline.U("origin=");
        sbU.append(zzaqVar.l);
        sbU.append(",name=");
        sbU.append(u(zzaqVar.j));
        sbU.append(",params=");
        zzap zzapVar = zzaqVar.k;
        if (zzapVar == null) {
            string = null;
        } else {
            string = !z() ? zzapVar.toString() : s(zzapVar.x0());
        }
        sbU.append(string);
        return sbU.toString();
    }

    @Nullable
    public final String u(String str) {
        if (str == null) {
            return null;
        }
        return !z() ? str : v(str, v5.c, v5.a, c);
    }

    @Nullable
    public final String w(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbU = outline.U("[");
        for (Object obj : objArr) {
            String strS = obj instanceof Bundle ? s((Bundle) obj) : String.valueOf(obj);
            if (strS != null) {
                if (sbU.length() != 1) {
                    sbU.append(", ");
                }
                sbU.append(strS);
            }
        }
        sbU.append("]");
        return sbU.toString();
    }

    @Nullable
    public final String x(String str) {
        if (str == null) {
            return null;
        }
        return !z() ? str : v(str, u5.f1575b, u5.a, d);
    }

    @Nullable
    public final String y(String str) {
        if (str == null) {
            return null;
        }
        if (!z()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return v(str, x5.f1578b, x5.a, e);
        }
        return "experiment_id(" + str + ")";
    }

    public final boolean z() {
        return this.a.v() && this.a.g().x(3);
    }
}
