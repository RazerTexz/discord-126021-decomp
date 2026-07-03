package p507d0.p579g0;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.q */
/* JADX INFO: compiled from: StringBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12100q extends C12099p {
    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        C12238m.checkNotNullParameter(sb, "$this$append");
        C12238m.checkNotNullParameter(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
