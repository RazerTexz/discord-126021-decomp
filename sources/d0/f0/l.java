package d0.f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static final <T> Iterator<T> iterator(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        d0.z.d.m.checkNotNullParameter(function2, "block");
        j jVar = new j();
        jVar.setNextStep(d0.w.h.b.createCoroutineUnintercepted(function2, jVar, jVar));
        return jVar;
    }

    public static final <T> Sequence<T> sequence(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        d0.z.d.m.checkNotNullParameter(function2, "block");
        return new l$a(function2);
    }
}
