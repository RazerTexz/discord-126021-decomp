package s.a.d2.g;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.InlineMarker;
import d0.z.d.TypeIntrinsics;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import s.a.d2.FlowCollector;

/* JADX INFO: renamed from: s.a.d2.g.f, reason: use source file name */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollector4 {
    public static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new a(), 3);

    /* JADX INFO: renamed from: s.a.d2.g.f$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function3<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object> {
        public a() {
            super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(FlowCollector<? super Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
            InlineMarker.mark(0);
            Object objEmit = flowCollector.emit(obj, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            return objEmit;
        }
    }
}
