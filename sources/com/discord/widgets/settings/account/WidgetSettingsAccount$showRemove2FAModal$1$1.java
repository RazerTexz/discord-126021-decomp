package com.discord.widgets.settings.account;

import com.discord.api.auth.mfa.DisableMfaResponse;
import com.discord.stores.StoreMFA$MFAActivationState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$showRemove2FAModal$1$1 extends o implements Function1<DisableMfaResponse, Unit> {
    public final /* synthetic */ WidgetSettingsAccount$showRemove2FAModal$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccount$showRemove2FAModal$1$1(WidgetSettingsAccount$showRemove2FAModal$1 widgetSettingsAccount$showRemove2FAModal$1) {
        super(1);
        this.this$0 = widgetSettingsAccount$showRemove2FAModal$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DisableMfaResponse disableMfaResponse) {
        invoke2(disableMfaResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DisableMfaResponse disableMfaResponse) {
        m.checkNotNullParameter(disableMfaResponse, "it");
        b.a.d.m.h(this.this$0.this$0.requireContext(), this.this$0.this$0.requireContext().getString(2131896930), 0, null, 12);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getAuthentication().setAuthed(disableMfaResponse.getToken());
        storeStream$Companion.getMFA().updatePendingMFAState(StoreMFA$MFAActivationState.PENDING_DISABLED);
    }
}
