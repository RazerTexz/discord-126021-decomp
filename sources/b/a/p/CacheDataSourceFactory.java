package b.a.p;

import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DefaultDataSource;
import b.i.a.c.e3.b0.CacheDataSource;
import b.i.a.c.e3.b0.SimpleCache2;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.p.j, reason: use source file name */
/* JADX INFO: compiled from: CacheDataSourceFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CacheDataSourceFactory implements DataSource3.a {
    public final DefaultDataSource.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f253b;

    public CacheDataSourceFactory(DefaultDataSource.a aVar, long j) {
        Intrinsics3.checkNotNullParameter(aVar, "defaultDatasourceFactory");
        this.a = aVar;
        this.f253b = j;
    }

    @Override // b.i.a.c.e3.DataSource3.a
    public DataSource3 a() {
        SimpleCacheProvider simpleCacheProvider = SimpleCacheProvider.f254b;
        SimpleCache2 simpleCache2 = (SimpleCache2) SimpleCacheProvider.a.getValue();
        DefaultDataSource.a aVar = this.a;
        return new CacheDataSource(simpleCache2, new DefaultDataSource(aVar.a, aVar.f949b.a()), new FileDataSource(), new CacheDataSink(simpleCache2, this.f253b), 3, null);
    }
}
