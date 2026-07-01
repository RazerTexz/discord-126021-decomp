package i0;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.r, reason: use source file name */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class ParameterHandler<T> extends ParameterHandler3<Iterable<T>> {
    public final /* synthetic */ ParameterHandler3 a;

    public ParameterHandler(ParameterHandler3 parameterHandler3) {
        this.a = parameterHandler3;
    }

    @Override // i0.ParameterHandler3
    public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
        Iterable iterable = (Iterable) obj;
        if (iterable == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            this.a.a(requestBuilder, it.next());
        }
    }
}
