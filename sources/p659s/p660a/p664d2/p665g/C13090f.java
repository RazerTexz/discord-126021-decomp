package p659s.p660a.p664d2.p665g;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.C12224e0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12237l;
import p659s.p660a.p664d2.InterfaceC13083e;

/* JADX INFO: renamed from: s.a.d2.g.f */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13090f {

    /* JADX INFO: renamed from: a */
    public static final Function3<InterfaceC13083e<Object>, Object, Continuation<? super Unit>, Object> f27792a = (Function3) C12224e0.beforeCheckcastToFunctionOfArity(new a(), 3);

    /* JADX INFO: renamed from: s.a.d2.g.f$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final /* synthetic */ class a extends C12236k implements Function3<InterfaceC13083e<? super Object>, Object, Continuation<? super Unit>, Object> {
        public a() {
            super(3, InterfaceC13083e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public Object invoke(InterfaceC13083e<? super Object> interfaceC13083e, Object obj, Continuation<? super Unit> continuation) {
            C12237l.mark(0);
            Object objEmit = interfaceC13083e.emit(obj, continuation);
            C12237l.mark(2);
            C12237l.mark(1);
            return objEmit;
        }
    }
}
