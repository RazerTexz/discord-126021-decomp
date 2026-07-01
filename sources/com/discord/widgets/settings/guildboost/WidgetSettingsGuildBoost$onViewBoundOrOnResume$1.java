package com.discord.widgets.settings.guildboost;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$onViewBoundOrOnResume$1 extends o implements Function1<SettingsGuildBoostViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoost$onViewBoundOrOnResume$1(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(1);
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel$ViewState settingsGuildBoostViewModel$ViewState) {
        invoke2(settingsGuildBoostViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGuildBoostViewModel$ViewState settingsGuildBoostViewModel$ViewState) {
        if (settingsGuildBoostViewModel$ViewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded) {
            WidgetSettingsGuildBoost.access$showContent(this.this$0, (SettingsGuildBoostViewModel$ViewState$Loaded) settingsGuildBoostViewModel$ViewState);
        } else if (settingsGuildBoostViewModel$ViewState instanceof SettingsGuildBoostViewModel$ViewState$Loading) {
            WidgetSettingsGuildBoost.access$showLoadingUI(this.this$0);
        } else if (settingsGuildBoostViewModel$ViewState instanceof SettingsGuildBoostViewModel$ViewState$Failure) {
            WidgetSettingsGuildBoost.access$showFailureUI(this.this$0);
        }
    }
}
