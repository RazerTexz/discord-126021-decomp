package b.f.j.e;

import android.content.Context;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.Objects;

/* JADX INFO: compiled from: ImagePipelineConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class j$a {
    public Supplier<MemoryCacheParams> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f574b;
    public DiskCacheConfig d;
    public DiskCacheConfig e;
    public boolean c = false;
    public final l$b f = new l$b(this);
    public boolean g = true;
    public b.f.j.g.a h = new b.f.j.g.a();

    public j$a(Context context, i iVar) {
        Objects.requireNonNull(context);
        this.f574b = context;
    }
}
