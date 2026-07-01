package b.c.a.y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import b.c.a.LottieComposition;

/* JADX INFO: renamed from: b.c.a.y.h, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LottieCompositionCache {
    public static final LottieCompositionCache a = new LottieCompositionCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, LottieComposition> f409b = new LruCache<>(20);

    @VisibleForTesting
    public LottieCompositionCache() {
    }
}
