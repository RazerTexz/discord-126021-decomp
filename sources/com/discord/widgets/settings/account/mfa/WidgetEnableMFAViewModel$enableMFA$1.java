package com.discord.widgets.settings.account.mfa;

import com.discord.api.auth.mfa.EnableMfaResponse;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFAViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAViewModel$enableMFA$1 extends o implements Function1<EnableMfaResponse, Unit> {
    public final /* synthetic */ WidgetEnableMFAViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableMFAViewModel$enableMFA$1(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        super(1);
        this.this$0 = widgetEnableMFAViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EnableMfaResponse enableMfaResponse) {
        invoke2(enableMfaResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EnableMfaResponse enableMfaResponse) {
        WidgetEnableMFAViewModel.access$handleMFASuccess(this.this$0, enableMfaResponse.getToken());
    }
}
