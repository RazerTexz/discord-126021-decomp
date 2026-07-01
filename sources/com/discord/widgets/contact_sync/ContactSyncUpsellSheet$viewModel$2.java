package com.discord.widgets.contact_sync;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$viewModel$2 extends o implements Function0<WidgetContactSyncViewModel> {
    public static final ContactSyncUpsellSheet$viewModel$2 INSTANCE = new ContactSyncUpsellSheet$viewModel$2();

    public ContactSyncUpsellSheet$viewModel$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(ContactSyncMode.DEFAULT, false, false, null, null, null, false, ContactSyncUpsellSheet$viewModel$2$1.INSTANCE, 126, null);
    }
}
