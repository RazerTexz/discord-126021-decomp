package com.discord.widgets.auth;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyLoginLauncher$1 extends o implements Function1<WidgetAuthPhoneVerify$Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyLoginLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        invoke2(widgetAuthPhoneVerify$Result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        m.checkNotNullParameter(widgetAuthPhoneVerify$Result, "result");
        if (widgetAuthPhoneVerify$Result instanceof WidgetAuthPhoneVerify$Result$Token) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getAuthentication().authorizeIP(((WidgetAuthPhoneVerify$Result$Token) widgetAuthPhoneVerify$Result).getToken()), this.this$0, null, 2, null), WidgetAuthLogin.access$getBinding$p(this.this$0).h, 0L, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, new WidgetAuthLogin$phoneVerifyLoginLauncher$1$1(this.this$0), (Function0) null, (Function0) null, new WidgetAuthLogin$phoneVerifyLoginLauncher$1$2(this), 52, (Object) null);
        }
    }
}
