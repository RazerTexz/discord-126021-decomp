package d0.g0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.g0.p, reason: use source file name */
/* JADX INFO: compiled from: StringBuilderJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class StringBuilderJVM extends RegexExtensions {
    public static final StringBuilder clear(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }
}
