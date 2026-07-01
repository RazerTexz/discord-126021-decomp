package com.discord.widgets.voice.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet3 extends Lambda implements Function0<WidgetNoiseCancellationBottomSheetViewModel> {
    public static final WidgetNoiseCancellationBottomSheet3 INSTANCE = new WidgetNoiseCancellationBottomSheet3();

    public WidgetNoiseCancellationBottomSheet3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetNoiseCancellationBottomSheetViewModel invoke() {
        return new WidgetNoiseCancellationBottomSheetViewModel(null, 1, null);
    }
}
