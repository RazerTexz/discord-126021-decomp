package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit$submitName$2 extends o implements Function1<ConnectedAccount, Unit> {
    public final /* synthetic */ WidgetSettingsAccountContactsNameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountContactsNameEdit$submitName$2(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        super(1);
        this.this$0 = widgetSettingsAccountContactsNameEdit;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
        invoke2(connectedAccount);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "it");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
