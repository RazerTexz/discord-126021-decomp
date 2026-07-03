package p507d0.p578f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.p584w.p585h.C12182b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.f0.l */
/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12073l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.l$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function2 f25104a;

        public a(Function2 function2) {
            this.f25104a = function2;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return C12073l.iterator(this.f25104a);
        }
    }

    public static final <T> Iterator<T> iterator(Function2<? super AbstractC12072k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(function2, "block");
        C12071j c12071j = new C12071j();
        c12071j.setNextStep(C12182b.createCoroutineUnintercepted(function2, c12071j, c12071j));
        return c12071j;
    }

    public static final <T> Sequence<T> sequence(Function2<? super AbstractC12072k<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(function2, "block");
        return new a(function2);
    }
}
