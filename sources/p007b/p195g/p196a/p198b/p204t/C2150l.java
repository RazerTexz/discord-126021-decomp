package p007b.p195g.p196a.p198b.p204t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: b.g.a.b.t.l */
/* JADX INFO: compiled from: ThreadLocalBufferManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2150l {

    /* JADX INFO: renamed from: a */
    public final Map<SoftReference<C2139a>, Boolean> f4614a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public final ReferenceQueue<C2139a> f4615b = new ReferenceQueue<>();

    /* JADX INFO: renamed from: b.g.a.b.t.l$a */
    /* JADX INFO: compiled from: ThreadLocalBufferManager.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C2150l f4616a = new C2150l();
    }
}
