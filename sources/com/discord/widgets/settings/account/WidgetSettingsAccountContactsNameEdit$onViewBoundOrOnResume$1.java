package com.discord.widgets.settings.account;

import com.discord.stores.StoreUserConnections$State;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1 extends o implements Function1<StoreUserConnections$State, Unit> {
    public final /* synthetic */ WidgetSettingsAccountContactsNameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        super(1);
        this.this$0 = widgetSettingsAccountContactsNameEdit;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreUserConnections$State storeUserConnections$State) {
        invoke2(storeUserConnections$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreUserConnections$State storeUserConnections$State) {
        m.checkNotNullParameter(storeUserConnections$State, "it");
        WidgetSettingsAccountContactsNameEdit.access$configureUI(this.this$0, storeUserConnections$State);
    }
}
