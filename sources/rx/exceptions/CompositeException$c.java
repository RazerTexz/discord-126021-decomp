package rx.exceptions;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException$c extends CompositeException$b {
    public final PrintStream a;

    public CompositeException$c(PrintStream printStream) {
        this.a = printStream;
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
