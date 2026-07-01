package com.discord.utilities.handoff;

import android.content.Context;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.utilities.coroutines.RxCoroutineExtensionsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1", f = "MobileWebHandoff.kt", l = {48}, m = "invokeSuspend")
public final class MobileWebHandoff$redirectWithHandoffToken$token$1$1 extends k implements Function2<CoroutineScope, Continuation<? super HandoffToken>, Object> {
    public int label;
    public final /* synthetic */ MobileWebHandoff$redirectWithHandoffToken$token$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff$redirectWithHandoffToken$token$1$1(MobileWebHandoff$redirectWithHandoffToken$token$1 mobileWebHandoff$redirectWithHandoffToken$token$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mobileWebHandoff$redirectWithHandoffToken$token$1;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff$redirectWithHandoffToken$token$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HandoffToken> continuation) {
        return ((MobileWebHandoff$redirectWithHandoffToken$token$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                l.throwOnFailure(obj);
                Observable<HandoffToken> observableCreateHandoffTokenWithNonce = MobileWebHandoff.access$getRestAPI$p(this.this$0.this$0).createHandoffTokenWithNonce((String) this.this$0.$nonce.element);
                Context contextAccess$getContext$p = MobileWebHandoff.access$getContext$p(this.this$0.this$0);
                this.label = 1;
                obj = RxCoroutineExtensionsKt.appAwaitFirst(observableCreateHandoffTokenWithNonce, contextAccess$getContext$p, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return (HandoffToken) obj;
        } catch (Throwable th) {
            MobileWebHandoff.access$getAnalytics$p(this.this$0.this$0).track(new TrackMobileWebHandoffFailure("handoff_token_fetch_failure", null, 2));
            throw th;
        }
    }
}
