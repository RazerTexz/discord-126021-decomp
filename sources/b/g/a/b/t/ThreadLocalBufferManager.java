package b.g.a.b.t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.b.t.l, reason: use source file name */
/* JADX INFO: compiled from: ThreadLocalBufferManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadLocalBufferManager {
    public final Map<SoftReference<BufferRecycler>, Boolean> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<BufferRecycler> f679b = new ReferenceQueue<>();

    /* JADX INFO: renamed from: b.g.a.b.t.l$a */
    /* JADX INFO: compiled from: ThreadLocalBufferManager.java */
    public static final class a {
        public static final ThreadLocalBufferManager a = new ThreadLocalBufferManager();
    }
}
