package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> implements Sequence<T> {
    public final Function0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, T> f3573b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        d0.z.d.m.checkNotNullParameter(function0, "getInitialValue");
        d0.z.d.m.checkNotNullParameter(function1, "getNextValue");
        this.a = function0;
        this.f3573b = function1;
    }

    public static final /* synthetic */ Function0 access$getGetInitialValue$p(i iVar) {
        return iVar.a;
    }

    public static final /* synthetic */ Function1 access$getGetNextValue$p(i iVar) {
        return iVar.f3573b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new i$a(this);
    }
}
