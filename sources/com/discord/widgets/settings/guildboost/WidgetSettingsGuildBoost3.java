package com.discord.widgets.settings.guildboost;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost3 extends Lambda implements Function0<SettingsGuildBoostViewModel> {
    public static final WidgetSettingsGuildBoost3 INSTANCE = new WidgetSettingsGuildBoost3();

    public WidgetSettingsGuildBoost3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsGuildBoostViewModel invoke() {
        return new SettingsGuildBoostViewModel(null, null, null, 7, null);
    }
}
