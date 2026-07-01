package com.discord.widgets.contact_sync;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$onResume$1 extends o implements Function1<WidgetContactSyncViewModel$ViewState, Unit> {
    public final /* synthetic */ ContactSyncUpsellSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncUpsellSheet$onResume$1(ContactSyncUpsellSheet contactSyncUpsellSheet) {
        super(1);
        this.this$0 = contactSyncUpsellSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        invoke2(widgetContactSyncViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        m.checkNotNullParameter(widgetContactSyncViewModel$ViewState, "it");
        ContactSyncUpsellSheet.access$configureUI(this.this$0, widgetContactSyncViewModel$ViewState);
    }
}
