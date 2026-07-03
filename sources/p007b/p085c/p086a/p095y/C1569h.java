package p007b.p085c.p086a.p095y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import p007b.p085c.p086a.C1505d;

/* JADX INFO: renamed from: b.c.a.y.h */
/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C1569h {

    /* JADX INFO: renamed from: a */
    public static final C1569h f2715a = new C1569h();

    /* JADX INFO: renamed from: b */
    public final LruCache<String, C1505d> f2716b = new LruCache<>(20);

    @VisibleForTesting
    public C1569h() {
    }
}
