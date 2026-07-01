package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> implements Sequence<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3571b;
    public final Function1<T, Boolean> c;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Sequence<? extends T> sequence, boolean z2, Function1<? super T, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        this.a = sequence;
        this.f3571b = z2;
        this.c = function1;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(g gVar) {
        return gVar.c;
    }

    public static final /* synthetic */ boolean access$getSendWhen$p(g gVar) {
        return gVar.f3571b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(g gVar) {
        return gVar.a;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new g$a(this);
    }
}
