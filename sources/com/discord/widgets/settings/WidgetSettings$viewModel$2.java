package com.discord.widgets.settings;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$viewModel$2 extends AbstractC12240o implements Function0<SettingsViewModel> {
    public static final WidgetSettings$viewModel$2 INSTANCE = new WidgetSettings$viewModel$2();

    public WidgetSettings$viewModel$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsViewModel invoke() {
        return new SettingsViewModel(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }
}
