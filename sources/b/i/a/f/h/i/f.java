package b.i.a.f.h.i;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final ConcurrentHashMap<i, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f1408b = new ReferenceQueue<>();
}
