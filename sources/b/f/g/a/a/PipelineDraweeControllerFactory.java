package b.f.g.a.a;

import android.content.res.Resources;
import b.f.d.d.ImmutableList;
import b.f.g.b.DeferredReleaser;
import b.f.j.c.MemoryCache;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableImage;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.g.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: PipelineDraweeControllerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerFactory {
    public Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DeferredReleaser f482b;
    public DrawableFactory c;
    public Executor d;
    public MemoryCache<CacheKey, CloseableImage> e;
    public ImmutableList<DrawableFactory> f;
    public Supplier<Boolean> g;
}
