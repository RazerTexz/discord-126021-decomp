package d0.e0.p.d.m0.c.g1;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.i, reason: use source file name */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Annotations5 {
    public static final Annotations4 composeAnnotations(Annotations4 annotations4, Annotations4 annotations5) {
        Intrinsics3.checkNotNullParameter(annotations4, "first");
        Intrinsics3.checkNotNullParameter(annotations5, "second");
        if (annotations4.isEmpty()) {
            return annotations5;
        }
        return annotations5.isEmpty() ? annotations4 : new Annotations6(annotations4, annotations5);
    }
}
