package p630i0;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.r */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12564r<T> extends AbstractC12566t<Iterable<T>> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC12566t f26569a;

    public C12564r(AbstractC12566t abstractC12566t) {
        this.f26569a = abstractC12566t;
    }

    @Override // p630i0.AbstractC12566t
    /* JADX INFO: renamed from: a */
    public void mo10715a(C12568v c12568v, Object obj) throws IOException {
        Iterable iterable = (Iterable) obj;
        if (iterable == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            this.f26569a.mo10715a(c12568v, it.next());
        }
    }
}
