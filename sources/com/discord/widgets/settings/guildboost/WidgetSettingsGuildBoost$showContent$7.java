package com.discord.widgets.settings.guildboost;

import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$showContent$7 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoost$showContent$7(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(0);
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetSettingsPremium$Companion.launch$default(WidgetSettingsPremium.Companion, this.this$0.requireContext(), null, null, 6, null);
    }
}
