package com.discord.widgets.contact_sync;

import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onPhoneNumberSubmitted$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetContactSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$onPhoneNumberSubmitted$2(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        super(1);
        this.this$0 = widgetContactSyncViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled() && WidgetCaptchaKt.isCaptchaError(error)) {
            WidgetContactSyncViewModel.access$getCaptchaLauncher$p(this.this$0).invoke(error);
        } else {
            WidgetContactSyncViewModel.access$handlePhoneSubmittedError(this.this$0);
        }
    }
}
