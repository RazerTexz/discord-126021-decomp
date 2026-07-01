package i0;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class r<T> extends t<Iterable<T>> {
    public final /* synthetic */ t a;

    public r(t tVar) {
        this.a = tVar;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) throws IOException {
        Iterable iterable = (Iterable) obj;
        if (iterable == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            this.a.a(vVar, it.next());
        }
    }
}
