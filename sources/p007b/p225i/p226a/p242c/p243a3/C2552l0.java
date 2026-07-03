package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.p243a3.p244p0.C2562c;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.a3.l0 */
/* JADX INFO: compiled from: SinglePeriodTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2552l0 extends AbstractC2832o2 {

    /* JADX INFO: renamed from: k */
    public static final Object f5639k = new Object();

    /* JADX INFO: renamed from: l */
    public final long f5640l;

    /* JADX INFO: renamed from: m */
    public final long f5641m;

    /* JADX INFO: renamed from: n */
    public final boolean f5642n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final C2831o1 f5643o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final C2831o1.g f5644p;

    static {
        C2831o1.d.a aVar = new C2831o1.d.a();
        C2831o1.f.a aVar2 = new C2831o1.f.a(null);
        List listEmptyList = Collections.emptyList();
        AbstractC4523p<Object> abstractC4523p = C4508h0.f12012l;
        C2831o1.g.a aVar3 = new C2831o1.g.a();
        Uri uri = Uri.EMPTY;
        C1460d.m426D(aVar2.f7299b == null || aVar2.f7298a != null);
        if (uri != null) {
            new C2831o1.i(uri, null, aVar2.f7298a != null ? new C2831o1.f(aVar2, null) : null, null, listEmptyList, null, abstractC4523p, null, null);
        }
        aVar.m3322a();
        new C2831o1.g(aVar3, null);
        C2835p1 c2835p1 = C2835p1.f7368j;
    }

    public C2552l0(long j, boolean z2, boolean z3, boolean z4, @Nullable Object obj, C2831o1 c2831o1) {
        C2831o1.g gVar = z4 ? c2831o1.f7264m : null;
        this.f5640l = j;
        this.f5641m = j;
        this.f5642n = z2;
        Objects.requireNonNull(c2831o1);
        this.f5643o = c2831o1;
        this.f5644p = gVar;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: b */
    public int mo2554b(Object obj) {
        return f5639k.equals(obj) ? 0 : -1;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: g */
    public AbstractC2832o2.b mo2513g(int i, AbstractC2832o2.b bVar, boolean z2) {
        C1460d.m571t(i, 0, 1);
        Object obj = z2 ? f5639k : null;
        long j = this.f5640l;
        Objects.requireNonNull(bVar);
        bVar.m3337f(null, obj, 0, j, 0L, C2562c.f5680j, false);
        return bVar;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: i */
    public int mo2555i() {
        return 1;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: m */
    public Object mo2556m(int i) {
        C1460d.m571t(i, 0, 1);
        return f5639k;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: o */
    public AbstractC2832o2.c mo2514o(int i, AbstractC2832o2.c cVar, long j) {
        C1460d.m571t(i, 0, 1);
        cVar.m3342e(AbstractC2832o2.c.f7345j, this.f5643o, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.f5642n, false, this.f5644p, 0L, this.f5641m, 0, 0, 0L);
        return cVar;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: p */
    public int mo2557p() {
        return 1;
    }
}
