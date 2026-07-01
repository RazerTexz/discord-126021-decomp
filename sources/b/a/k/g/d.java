package b.a.k.g;

import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: FormattingParserProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public static final Lazy a = g.lazy(d$a.j);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f247b = null;
    public final ThreadLocal<a> c = new d$b();

    @Override // b.a.k.g.b
    public a a() {
        a aVar = this.c.get();
        m.checkNotNull(aVar);
        return aVar;
    }
}
