package d0.e0.p.d.m0.e.a.h0;

import d0.z.d.m;

/* JADX INFO: compiled from: AnnotationDefaultValue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends a {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str) {
        super(null);
        m.checkNotNullParameter(str, "value");
        this.a = str;
    }

    public final String getValue() {
        return this.a;
    }
}
