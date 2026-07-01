package com.discord.widgets.settings.premium;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting4 extends Lambda implements Function0<SettingsGiftingViewModel> {
    public static final WidgetSettingsGifting4 INSTANCE = new WidgetSettingsGifting4();

    public WidgetSettingsGifting4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsGiftingViewModel invoke() {
        return new SettingsGiftingViewModel(null, null, null, null, null, null, null, Opcodes.LAND, null);
    }
}
