package d0.g0;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class r extends q {
    public static final Double toDoubleOrNull(String str) {
        d0.z.d.m.checkNotNullParameter(str, "$this$toDoubleOrNull");
        try {
            if (j.a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        d0.z.d.m.checkNotNullParameter(str, "$this$toFloatOrNull");
        try {
            if (j.a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
