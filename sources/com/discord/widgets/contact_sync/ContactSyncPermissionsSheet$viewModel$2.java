package com.discord.widgets.contact_sync;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$viewModel$2 extends o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$viewModel$2(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(0);
        this.this$0 = contactSyncPermissionsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(WidgetContactSync.Companion.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), false, false, null, null, null, false, ContactSyncPermissionsSheet$viewModel$2$1.INSTANCE, 126, null);
    }
}
