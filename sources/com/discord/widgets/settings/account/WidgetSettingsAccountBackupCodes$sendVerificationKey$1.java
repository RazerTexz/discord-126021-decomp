package com.discord.widgets.settings.account;

import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyResponse;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$sendVerificationKey$1 extends o implements Function1<GetBackupCodesSendVerificationKeyResponse, Unit> {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountBackupCodes$sendVerificationKey$1(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        super(1);
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
        invoke2(getBackupCodesSendVerificationKeyResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse) {
        WidgetSettingsAccountBackupCodes.access$setNonce$p(this.this$0, getBackupCodesSendVerificationKeyResponse.getNonce());
        WidgetSettingsAccountBackupCodes.access$setRegenerateNonce$p(this.this$0, getBackupCodesSendVerificationKeyResponse.getRegenerateNonce());
        WidgetSettingsAccountBackupCodes.access$showVerificationKeyModal(this.this$0);
    }
}
