package p507d0.p588x.p589d;

import p507d0.p588x.C12195a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.x.d.a */
/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12198a extends C12195a {
    @Override // p507d0.p588x.C12195a
    public void addSuppressed(Throwable th, Throwable th2) {
        C12238m.checkNotNullParameter(th, "cause");
        C12238m.checkNotNullParameter(th2, "exception");
        th.addSuppressed(th2);
    }
}
