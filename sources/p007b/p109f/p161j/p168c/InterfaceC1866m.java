package p007b.p109f.p161j.p168c;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import p007b.p109f.p115d.p122g.InterfaceC1695b;

/* JADX INFO: renamed from: b.f.j.c.m */
/* JADX INFO: compiled from: CountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1866m<K, V> extends InterfaceC1876w<K, V>, InterfaceC1695b {

    /* JADX INFO: renamed from: b.f.j.c.m$a */
    /* JADX INFO: compiled from: CountingMemoryCache.java */
    @VisibleForTesting
    public static class a<K, V> {

        /* JADX INFO: renamed from: a */
        public final K f3678a;

        /* JADX INFO: renamed from: b */
        public final CloseableReference<V> f3679b;

        /* JADX INFO: renamed from: c */
        public int f3680c;

        /* JADX INFO: renamed from: d */
        public boolean f3681d;

        /* JADX INFO: renamed from: e */
        public final b<K> f3682e;

        /* JADX INFO: renamed from: f */
        public int f3683f;

        public a(K k, CloseableReference<V> closeableReference, b<K> bVar, int i) {
            Objects.requireNonNull(k);
            this.f3678a = k;
            CloseableReference<V> closeableReferenceM8636n = CloseableReference.m8636n(closeableReference);
            Objects.requireNonNull(closeableReferenceM8636n);
            this.f3679b = closeableReferenceM8636n;
            this.f3680c = 0;
            this.f3681d = false;
            this.f3682e = bVar;
            this.f3683f = i;
        }
    }

    /* JADX INFO: renamed from: b.f.j.c.m$b */
    /* JADX INFO: compiled from: CountingMemoryCache.java */
    public interface b<K> {
    }

    /* JADX INFO: renamed from: b */
    CloseableReference<V> mo1227b(K k);

    /* JADX INFO: renamed from: c */
    CloseableReference<V> mo1228c(K k, CloseableReference<V> closeableReference, b<K> bVar);
}
