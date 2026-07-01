package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$b<T> extends d0.z.d.o implements Function1<Sequence<? extends T>, Iterator<? extends T>> {
    public static final n$b j = new n$b();

    public n$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Sequence) obj);
    }

    public final Iterator<T> invoke(Sequence<? extends T> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "it");
        return sequence.iterator();
    }
}
