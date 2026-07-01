package com.discord.widgets.contact_sync;

import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onNameSubmitted$2 extends o implements Function1<ConnectedAccount, Unit> {
    public final /* synthetic */ WidgetContactSyncViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$onNameSubmitted$2(WidgetContactSyncViewModel widgetContactSyncViewModel) {
        super(1);
        this.this$0 = widgetContactSyncViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
        invoke2(connectedAccount);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "it");
        WidgetContactSyncViewModel.access$handleContactsEnabled(this.this$0);
    }
}
