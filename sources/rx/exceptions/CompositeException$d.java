package rx.exceptions;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException$d extends CompositeException$b {
    public final PrintWriter a;

    public CompositeException$d(PrintWriter printWriter) {
        this.a = printWriter;
    }

    @Override // rx.exceptions.CompositeException$b
    public Object a() {
        return this.a;
    }

    @Override // rx.exceptions.CompositeException$b
    public void b(Object obj) {
        this.a.println(obj);
    }
}
