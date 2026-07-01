package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l implements b {
    public final String a;

    public l(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = str;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b$a.invoke(this, xVar);
    }
}
