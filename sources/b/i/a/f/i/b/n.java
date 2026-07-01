package b.i.a.f.i.b;

import com.google.android.gms.measurement.internal.zzap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements Iterator<String> {
    public Iterator<String> j;
    public final /* synthetic */ zzap k;

    public n(zzap zzapVar) {
        this.k = zzapVar;
        this.j = zzapVar.j.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.j.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.j.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
