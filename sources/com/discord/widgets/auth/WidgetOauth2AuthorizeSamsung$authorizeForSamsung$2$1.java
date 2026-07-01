package com.discord.widgets.auth;

import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponsePost;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1", f = "WidgetOauth2AuthorizeSamsung.kt", l = {157}, m = "invokeSuspend")
public final class WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ RestAPIParams$OAuth2Authorize$ResponsePost $it;
    public int label;
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1(WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2 widgetOauth2AuthorizeSamsung$authorizeForSamsung$2, RestAPIParams$OAuth2Authorize$ResponsePost restAPIParams$OAuth2Authorize$ResponsePost, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetOauth2AuthorizeSamsung$authorizeForSamsung$2;
        this.$it = restAPIParams$OAuth2Authorize$ResponsePost;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung = this.this$0.this$0;
            String location = this.$it.getLocation();
            String str = this.this$0.$samsungAuthCode;
            this.label = 1;
            if (widgetOauth2AuthorizeSamsung.samsungCallbackHandshake(location, str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
