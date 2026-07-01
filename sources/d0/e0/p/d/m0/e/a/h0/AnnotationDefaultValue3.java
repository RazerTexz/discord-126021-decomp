package d0.e0.p.d.m0.e.a.h0;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.j, reason: use source file name */
/* JADX INFO: compiled from: AnnotationDefaultValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationDefaultValue3 extends AnnotationDefaultValue {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnotationDefaultValue3(String str) {
        super(null);
        Intrinsics3.checkNotNullParameter(str, "value");
        this.a = str;
    }

    public final String getValue() {
        return this.a;
    }
}
