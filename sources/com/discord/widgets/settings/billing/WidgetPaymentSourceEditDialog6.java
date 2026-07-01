package com.discord.widgets.settings.billing;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog6 extends Lambda implements Function0<SettingsBillingViewModel> {
    public static final WidgetPaymentSourceEditDialog6 INSTANCE = new WidgetPaymentSourceEditDialog6();

    public WidgetPaymentSourceEditDialog6() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsBillingViewModel invoke() {
        return new SettingsBillingViewModel(null, null, null, 7, null);
    }
}
