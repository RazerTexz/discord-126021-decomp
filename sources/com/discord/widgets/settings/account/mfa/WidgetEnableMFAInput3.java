package com.discord.widgets.settings.account.mfa;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAInput$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAInput3 extends Lambda implements Function0<WidgetEnableMFAViewModel> {
    public static final WidgetEnableMFAInput3 INSTANCE = new WidgetEnableMFAInput3();

    public WidgetEnableMFAInput3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetEnableMFAViewModel invoke() {
        return new WidgetEnableMFAViewModel();
    }
}
