package s.a.d2.g;

import b.d.b.a.outline;
import d0.Result3;
import d0.t._Collections;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Produce;
import org.objectweb.asm.Opcodes;
import s.a.CoroutineContext2;
import s.a.c2.BufferOverflow;
import s.a.c2.Produce3;
import s.a.d2.Flow3;
import s.a.d2.FlowCollector;

/* JADX INFO: renamed from: s.a.d2.g.a, reason: use source file name */
/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ChannelFlow<T> implements Flow3 {
    public final CoroutineContext a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3837b;
    public final BufferOverflow c;

    /* JADX INFO: renamed from: s.a.d2.g.a$a */
    /* JADX INFO: compiled from: ChannelFlow.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {Opcodes.I2D}, m = "invokeSuspend")
    public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ FlowCollector $collector;
        public Object L$0;
        public int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FlowCollector flowCollector, Continuation continuation) {
            super(2, continuation);
            this.$collector = flowCollector;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            a aVar = new a(this.$collector, continuation);
            aVar.p$ = coroutineScope;
            return aVar.invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                FlowCollector flowCollector = this.$collector;
                ChannelFlow channelFlow = ChannelFlow.this;
                CoroutineContext coroutineContext = channelFlow.a;
                int i2 = channelFlow.f3837b;
                if (i2 == -3) {
                    i2 = -2;
                }
                BufferOverflow bufferOverflow = channelFlow.c;
                CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
                ChannelFlow2 channelFlow2 = new ChannelFlow2(channelFlow, null);
                Produce3 produce3 = new Produce3(CoroutineContext2.a(coroutineScope, coroutineContext), b.i.a.f.e.o.f.b(i2, bufferOverflow, null, 4));
                produce3.j0(coroutineStart, produce3, channelFlow2);
                this.L$0 = coroutineScope;
                this.label = 1;
                Object objU = b.i.a.f.e.o.f.U(flowCollector, produce3, true, this);
                if (objU != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    objU = Unit.a;
                }
                if (objU == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public ChannelFlow(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.f3837b = i;
        this.c = bufferOverflow;
    }

    @Override // s.a.d2.Flow3
    public Object a(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        Object objM = b.i.a.f.e.o.f.M(new a(flowCollector, null), continuation);
        return objM == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM : Unit.a;
    }

    public abstract Object b(Produce<? super T> produce, Continuation<? super Unit> continuation);

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        if (this.a != CoroutineContextImpl4.j) {
            StringBuilder sbU = outline.U("context=");
            sbU.append(this.a);
            arrayList.add(sbU.toString());
        }
        if (this.f3837b != -3) {
            StringBuilder sbU2 = outline.U("capacity=");
            sbU2.append(this.f3837b);
            arrayList.add(sbU2.toString());
        }
        if (this.c != BufferOverflow.SUSPEND) {
            StringBuilder sbU3 = outline.U("onBufferOverflow=");
            sbU3.append(this.c);
            arrayList.add(sbU3.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return outline.H(sb, _Collections.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null), ']');
    }
}
