package com.discord.widgets.guild_role_subscriptions;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet7 extends Lambda implements Function0<PriceTierPickerBottomSheetViewModel> {
    public static final WidgetPriceTierPickerBottomSheet7 INSTANCE = new WidgetPriceTierPickerBottomSheet7();

    public WidgetPriceTierPickerBottomSheet7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PriceTierPickerBottomSheetViewModel invoke() {
        return new PriceTierPickerBottomSheetViewModel(null, null, 3, null);
    }
}
