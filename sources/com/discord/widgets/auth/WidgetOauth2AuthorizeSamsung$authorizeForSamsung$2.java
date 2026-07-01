package com.discord.widgets.auth;

import b.i.a.f.e.o.f;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponsePost;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2 extends o implements Function1<RestAPIParams$OAuth2Authorize$ResponsePost, Unit> {
    public final /* synthetic */ String $samsungAuthCode;
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
        this.$samsungAuthCode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams$OAuth2Authorize$ResponsePost restAPIParams$OAuth2Authorize$ResponsePost) {
        invoke2(restAPIParams$OAuth2Authorize$ResponsePost);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestAPIParams$OAuth2Authorize$ResponsePost restAPIParams$OAuth2Authorize$ResponsePost) {
        m.checkNotNullParameter(restAPIParams$OAuth2Authorize$ResponsePost, "it");
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(WidgetOauth2AuthorizeSamsung.Companion, "POST /authorize success");
        f.H0(x0.j, k0.f3842b, null, new WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1(this, restAPIParams$OAuth2Authorize$ResponsePost, null), 2, null);
    }
}
