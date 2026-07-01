package d0.g0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.g0.q, reason: use source file name */
/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class StringBuilder extends StringBuilderJVM {
    public static final java.lang.StringBuilder append(java.lang.StringBuilder sb, String... strArr) {
        Intrinsics3.checkNotNullParameter(sb, "$this$append");
        Intrinsics3.checkNotNullParameter(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
