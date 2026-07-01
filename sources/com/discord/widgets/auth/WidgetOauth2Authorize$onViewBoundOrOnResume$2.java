package com.discord.widgets.auth;

import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$onViewBoundOrOnResume$2 extends o implements Function1<RestAPIParams$OAuth2Authorize$ResponseGet, Unit> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$onViewBoundOrOnResume$2(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(1);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams$OAuth2Authorize$ResponseGet restAPIParams$OAuth2Authorize$ResponseGet) {
        invoke2(restAPIParams$OAuth2Authorize$ResponseGet);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestAPIParams$OAuth2Authorize$ResponseGet restAPIParams$OAuth2Authorize$ResponseGet) {
        m.checkNotNullParameter(restAPIParams$OAuth2Authorize$ResponseGet, "response");
        this.this$0.getOauth2ViewModel().setOauthGetResponse(restAPIParams$OAuth2Authorize$ResponseGet);
        this.this$0.configureUI(restAPIParams$OAuth2Authorize$ResponseGet);
    }
}
