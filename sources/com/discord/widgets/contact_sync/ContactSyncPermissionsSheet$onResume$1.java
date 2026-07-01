package com.discord.widgets.contact_sync;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$onResume$1 extends o implements Function1<WidgetContactSyncViewModel$ViewState, Unit> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$onResume$1(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(1);
        this.this$0 = contactSyncPermissionsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        invoke2(widgetContactSyncViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        m.checkNotNullParameter(widgetContactSyncViewModel$ViewState, "it");
        ContactSyncPermissionsSheet.access$configureUI(this.this$0, widgetContactSyncViewModel$ViewState);
    }
}
