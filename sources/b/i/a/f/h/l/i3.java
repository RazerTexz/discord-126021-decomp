package b.i.a.f.h.l;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class i3 {
    public final ConcurrentHashMap<h3, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f1450b = new ReferenceQueue<>();
}
