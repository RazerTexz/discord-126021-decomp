package b.c.a.y;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY})
public class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, b.c.a.d> f409b = new LruCache<>(20);

    @VisibleForTesting
    public h() {
    }
}
