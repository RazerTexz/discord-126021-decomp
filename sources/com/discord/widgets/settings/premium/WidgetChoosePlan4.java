package com.discord.widgets.settings.premium;

import com.discord.app.AppActivity;
import com.discord.utilities.billing.GooglePlayBillingManager;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$handleEvent$onDismiss$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetChoosePlan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan4(WidgetChoosePlan widgetChoosePlan) {
        super(0);
        this.this$0 = widgetChoosePlan;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() throws Exception {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() throws Exception {
        GooglePlayBillingManager.INSTANCE.queryPurchases();
        AppActivity appActivityRequireAppActivity = this.this$0.requireAppActivity();
        appActivityRequireAppActivity.setResult(-1);
        appActivityRequireAppActivity.onBackPressed();
    }
}
