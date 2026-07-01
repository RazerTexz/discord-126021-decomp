package b.a.p;

import b.i.a.c.e3.b0.r;
import b.i.a.c.e3.q;
import b.i.a.c.e3.q$a;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import d0.z.d.m;

/* JADX INFO: compiled from: CacheDataSourceFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j implements b.i.a.c.e3.l$a {
    public final q$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253b;

    public j(q$a q_a, long j) {
        m.checkNotNullParameter(q_a, "defaultDatasourceFactory");
        this.a = q_a;
        this.f253b = j;
    }

    @Override // b.i.a.c.e3.l$a
    public b.i.a.c.e3.l a() {
        l lVar = l.f254b;
        r rVar = (r) l.a.getValue();
        q$a q_a = this.a;
        return new b.i.a.c.e3.b0.c(rVar, new q(q_a.a, q_a.f949b.a()), new FileDataSource(), new CacheDataSink(rVar, this.f253b), 3, null);
    }
}
