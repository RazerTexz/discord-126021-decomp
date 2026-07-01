package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: _Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q$d<R> extends d0.z.d.k implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final q$d j = new q$d();

    public q$d() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Sequence) obj);
    }

    public final Iterator<R> invoke(Sequence<? extends R> sequence) {
        d0.z.d.m.checkNotNullParameter(sequence, "p1");
        return sequence.iterator();
    }
}
