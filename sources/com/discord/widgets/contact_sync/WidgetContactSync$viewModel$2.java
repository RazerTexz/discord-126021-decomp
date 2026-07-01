package com.discord.widgets.contact_sync;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$viewModel$2 extends o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$viewModel$2(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        WidgetContactSync$Companion widgetContactSync$Companion = WidgetContactSync.Companion;
        return new WidgetContactSyncViewModel(widgetContactSync$Companion.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), widgetContactSync$Companion.getPhoneDiscoverableFromIntent(this.this$0.requireAppActivity()), widgetContactSync$Companion.getEmailDiscoverableFromIntent(this.this$0.requireAppActivity()), null, null, null, false, new WidgetContactSync$viewModel$2$1(this), 120, null);
    }
}
