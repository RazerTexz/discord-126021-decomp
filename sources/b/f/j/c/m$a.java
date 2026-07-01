package b.f.j.c;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: compiled from: CountingMemoryCache.java */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class m$a<K, V> {
    public final K a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CloseableReference<V> f558b;
    public int c;
    public boolean d;
    public final m$b<K> e;
    public int f;

    public m$a(K k, CloseableReference<V> closeableReference, m$b<K> m_b, int i) {
        Objects.requireNonNull(k);
        this.a = k;
        CloseableReference<V> closeableReferenceN = CloseableReference.n(closeableReference);
        Objects.requireNonNull(closeableReferenceN);
        this.f558b = closeableReferenceN;
        this.c = 0;
        this.d = false;
        this.e = m_b;
        this.f = i;
    }
}
