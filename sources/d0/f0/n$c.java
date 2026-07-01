package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$c<T> extends d0.z.d.o implements Function1<Iterable<? extends T>, Iterator<? extends T>> {
    public static final n$c j = new n$c();

    public n$c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Iterable) obj);
    }

    public final Iterator<T> invoke(Iterable<? extends T> iterable) {
        d0.z.d.m.checkNotNullParameter(iterable, "it");
        return iterable.iterator();
    }
}
