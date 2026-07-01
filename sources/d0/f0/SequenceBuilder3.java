package d0.f0;

import d0.w.h.IntrinsicsJvm;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.f0.l, reason: use source file name */
/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public class SequenceBuilder3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.f0.l$a */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements Sequence<T> {
        public final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return SequenceBuilder3.iterator(this.a);
        }
    }

    public static final <T> Iterator<T> iterator(Function2<? super SequenceBuilder2<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(function2, "block");
        SequenceBuilder sequenceBuilder = new SequenceBuilder();
        sequenceBuilder.setNextStep(IntrinsicsJvm.createCoroutineUnintercepted(function2, sequenceBuilder, sequenceBuilder));
        return sequenceBuilder;
    }

    public static final <T> Sequence<T> sequence(Function2<? super SequenceBuilder2<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(function2, "block");
        return new a(function2);
    }
}
