package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p664d2.C13084f;
import p659s.p660a.p664d2.InterfaceC13082d;
import p659s.p660a.p664d2.InterfaceC13083e;

/* JADX INFO: compiled from: FlowLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1 */
    /* JADX INFO: compiled from: FlowLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", m10085f = "FlowLiveData.kt", m10086l = {96, 100, 101}, m10087m = "invokeSuspend")
    public static final class C04331<T> extends AbstractC12194k implements Function2<InterfaceC13083e<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ LiveData $this_asFlow;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: FlowLiveData.kt */
        @InterfaceC12188e(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", m10085f = "FlowLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass1(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) {
                C12183c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
                C04331.this.$this_asFlow.observeForever(this.$observer);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FlowLiveData.kt */
        @InterfaceC12188e(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", m10085f = "FlowLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
        public static final class AnonymousClass2 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Observer $observer;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Observer observer, Continuation continuation) {
                super(2, continuation);
                this.$observer = observer;
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass2(this.$observer, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) {
                C12183c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
                C04331.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04331(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_asFlow = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C04331 c04331 = new C04331(this.$this_asFlow, continuation);
            c04331.L$0 = obj;
            return c04331;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04331) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0097 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:28:0x0098  */
        /* JADX WARN: Code duplicated, block: B:31:0x00a5 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:29:0x009d, B:31:0x00a5), top: B:45:0x009d }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00b7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b8  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4, types: [androidx.lifecycle.Observer] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v20 */
        /* JADX WARN: Type inference failed for: r6v3, types: [androidx.lifecycle.Observer, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v6 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, s.a.d2.e] */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b8 -> B:47:0x0089). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 243
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.view.FlowLiveDataConversions.C04331.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1 */
    /* JADX INFO: compiled from: FlowLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", m10085f = "FlowLiveData.kt", m10086l = {Opcodes.FCMPL}, m10087m = "invokeSuspend")
    public static final class C04341<T> extends AbstractC12194k implements Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ InterfaceC13082d $this_asLiveData;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04341(InterfaceC13082d interfaceC13082d, Continuation continuation) {
            super(2, continuation);
            this.$this_asLiveData = interfaceC13082d;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C04341 c04341 = new C04341(this.$this_asLiveData, continuation);
            c04341.L$0 = obj;
            return c04341;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04341) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                InterfaceC13082d interfaceC13082d = this.$this_asLiveData;
                InterfaceC13083e<T> interfaceC13083e = new InterfaceC13083e<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1
                    @Override // p659s.p660a.p664d2.InterfaceC13083e
                    public Object emit(Object obj2, Continuation continuation) {
                        Object objEmit = liveDataScope.emit(obj2, continuation);
                        return objEmit == C12183c.getCOROUTINE_SUSPENDED() ? objEmit : Unit.f27425a;
                    }
                };
                this.label = 1;
                if (interfaceC13082d.mo11246a(interfaceC13083e, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    public static final <T> InterfaceC13082d<T> asFlow(LiveData<T> liveData) {
        C12238m.checkNotNullParameter(liveData, "$this$asFlow");
        return new C13084f(new C04331(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC13082d<? extends T> interfaceC13082d) {
        return asLiveData$default(interfaceC13082d, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC13082d<? extends T> interfaceC13082d, CoroutineContext coroutineContext) {
        return asLiveData$default(interfaceC13082d, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(InterfaceC13082d<? extends T> interfaceC13082d, CoroutineContext coroutineContext, long j) {
        C12238m.checkNotNullParameter(interfaceC13082d, "$this$asLiveData");
        C12238m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new C04341(interfaceC13082d, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC13082d interfaceC13082d, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(interfaceC13082d, coroutineContext, j);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(InterfaceC13082d<? extends T> interfaceC13082d, CoroutineContext coroutineContext, Duration duration) {
        C12238m.checkNotNullParameter(interfaceC13082d, "$this$asLiveData");
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(duration, "timeout");
        return asLiveData(interfaceC13082d, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(InterfaceC13082d interfaceC13082d, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        return asLiveData(interfaceC13082d, coroutineContext, duration);
    }
}
