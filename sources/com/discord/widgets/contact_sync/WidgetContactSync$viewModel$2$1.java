package com.discord.widgets.contact_sync;

import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$viewModel$2$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetContactSync$viewModel$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$viewModel$2$1(WidgetContactSync$viewModel$2 widgetContactSync$viewModel$2) {
        super(1);
        this.this$0 = widgetContactSync$viewModel$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
            WidgetContactSync.access$launchCaptchaFlow(this.this$0.this$0, error);
        }
    }
}
