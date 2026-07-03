package p007b.p008a.p040p;

import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import p007b.p225i.p226a.p242c.p257e3.C2715q;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2684c;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2699r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.p.j */
/* JADX INFO: compiled from: CacheDataSourceFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1185j implements InterfaceC2710l.a {

    /* JADX INFO: renamed from: a */
    public final C2715q.a f1588a;

    /* JADX INFO: renamed from: b */
    public final long f1589b;

    public C1185j(C2715q.a aVar, long j) {
        C12238m.checkNotNullParameter(aVar, "defaultDatasourceFactory");
        this.f1588a = aVar;
        this.f1589b = j;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l.a
    /* JADX INFO: renamed from: a */
    public InterfaceC2710l mo234a() {
        C1187l c1187l = C1187l.f1597b;
        C2699r c2699r = (C2699r) C1187l.f1596a.getValue();
        C2715q.a aVar = this.f1588a;
        return new C2684c(c2699r, new C2715q(aVar.f6605a, aVar.f6606b.mo234a()), new FileDataSource(), new CacheDataSink(c2699r, this.f1589b), 3, null);
    }
}
