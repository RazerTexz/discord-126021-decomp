package com.discord.widgets.settings.premium;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$onViewBoundOrOnResume$1 extends o implements Function1<SettingsPremiumViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetSettingsPremium this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$onViewBoundOrOnResume$1(WidgetSettingsPremium widgetSettingsPremium) {
        super(1);
        this.this$0 = widgetSettingsPremium;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel$ViewState settingsPremiumViewModel$ViewState) {
        invoke2(settingsPremiumViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsPremiumViewModel$ViewState settingsPremiumViewModel$ViewState) {
        if (settingsPremiumViewModel$ViewState instanceof SettingsPremiumViewModel$ViewState$Loaded) {
            WidgetSettingsPremium.access$showContent(this.this$0, (SettingsPremiumViewModel$ViewState$Loaded) settingsPremiumViewModel$ViewState);
        } else if (settingsPremiumViewModel$ViewState instanceof SettingsPremiumViewModel$ViewState$Loading) {
            WidgetSettingsPremium.access$showLoadingUI(this.this$0);
        } else if (settingsPremiumViewModel$ViewState instanceof SettingsPremiumViewModel$ViewState$Failure) {
            WidgetSettingsPremium.access$showFailureUI(this.this$0);
        }
    }
}
