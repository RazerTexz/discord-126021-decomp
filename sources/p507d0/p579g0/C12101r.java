package p507d0.p579g0;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.r */
/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12101r extends C12100q {
    public static final Double toDoubleOrNull(String str) {
        C12238m.checkNotNullParameter(str, "$this$toDoubleOrNull");
        try {
            if (C12093j.f25162a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        C12238m.checkNotNullParameter(str, "$this$toFloatOrNull");
        try {
            if (C12093j.f25162a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
