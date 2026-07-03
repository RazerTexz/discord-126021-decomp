package p007b.p109f.p161j.p170e;

import com.facebook.cache.disk.DiskCacheConfig;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p007b.p109f.p111b.p113b.C1661d;
import p007b.p109f.p111b.p113b.C1662e;
import p007b.p109f.p111b.p113b.InterfaceC1665h;

/* JADX INFO: renamed from: b.f.j.e.c */
/* JADX INFO: compiled from: DiskStorageCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class C1888c implements InterfaceC1891f {

    /* JADX INFO: renamed from: a */
    public C1889d f3732a;

    public C1888c(C1889d c1889d) {
        this.f3732a = c1889d;
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC1665h m1261a(DiskCacheConfig diskCacheConfig) {
        Objects.requireNonNull(this.f3732a);
        C1662e c1662e = new C1662e(diskCacheConfig.f19421a, diskCacheConfig.f19423c, diskCacheConfig.f19422b, diskCacheConfig.f19428h);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        return new C1661d(c1662e, diskCacheConfig.f19427g, new C1661d.c(diskCacheConfig.f19426f, diskCacheConfig.f19425e, diskCacheConfig.f19424d), diskCacheConfig.f19429i, diskCacheConfig.f19428h, diskCacheConfig.f19430j, executorServiceNewSingleThreadExecutor, false);
    }
}
