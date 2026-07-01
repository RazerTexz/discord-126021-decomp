package com.discord.utilities.handoff;

import android.content.Context;
import b.i.a.f.e.o.f;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.utilities.coroutines.RxCoroutineExtensions;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.Dispatchers;

/* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1, reason: use source file name */
/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1", f = "MobileWebHandoff.kt", l = {45}, m = "invokeSuspend")
public final class MobileWebHandoff2 extends ContinuationImpl6 implements Function1<Continuation<? super HandoffToken>, Object> {
    public final /* synthetic */ Ref$ObjectRef $nonce;
    public int label;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MobileWebHandoff.kt */
    @DebugMetadata(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1", f = "MobileWebHandoff.kt", l = {48}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super HandoffToken>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return MobileWebHandoff2.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HandoffToken> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    Observable<HandoffToken> observableCreateHandoffTokenWithNonce = MobileWebHandoff2.this.this$0.restAPI.createHandoffTokenWithNonce((String) MobileWebHandoff2.this.$nonce.element);
                    Context context = MobileWebHandoff2.this.this$0.context;
                    this.label = 1;
                    obj = RxCoroutineExtensions.appAwaitFirst(observableCreateHandoffTokenWithNonce, context, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return (HandoffToken) obj;
            } catch (Throwable th) {
                MobileWebHandoff2.this.this$0.analytics.track(new TrackMobileWebHandoffFailure("handoff_token_fetch_failure", null, 2));
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff2(MobileWebHandoff mobileWebHandoff, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(1, continuation);
        this.this$0 = mobileWebHandoff;
        this.$nonce = ref$ObjectRef;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff2(this.this$0, this.$nonce, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super HandoffToken> continuation) {
        return ((MobileWebHandoff2) create(continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f3842b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            obj = f.C1(coroutineDispatcher, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        return obj;
    }
}
