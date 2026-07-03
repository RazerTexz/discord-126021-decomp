package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: b.i.a.f.h.l.x6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3892x6<K, V> implements Iterator<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: j */
    public int f10405j = -1;

    /* JADX INFO: renamed from: k */
    public boolean f10406k;

    /* JADX INFO: renamed from: l */
    public Iterator<Map.Entry<K, V>> f10407l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C3814r6 f10408m;

    public C3892x6(C3814r6 c3814r6, C3840t6 c3840t6) {
        this.f10408m = c3814r6;
    }

    /* JADX INFO: renamed from: a */
    public final Iterator<Map.Entry<K, V>> m5361a() {
        if (this.f10407l == null) {
            this.f10407l = this.f10408m.f10291m.entrySet().iterator();
        }
        return this.f10407l;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10405j + 1 < this.f10408m.f10290l.size() || (!this.f10408m.f10291m.isEmpty() && m5361a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.f10406k = true;
        int i = this.f10405j + 1;
        this.f10405j = i;
        return i < this.f10408m.f10290l.size() ? this.f10408m.f10290l.get(this.f10405j) : m5361a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f10406k) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f10406k = false;
        C3814r6 c3814r6 = this.f10408m;
        int i = C3814r6.f10288j;
        c3814r6.m5210h();
        if (this.f10405j >= this.f10408m.f10290l.size()) {
            m5361a().remove();
            return;
        }
        C3814r6 c3814r7 = this.f10408m;
        int i2 = this.f10405j;
        this.f10405j = i2 - 1;
        c3814r7.m5208f(i2);
    }
}
