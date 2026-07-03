package com.discord.widgets.servers;

import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2 extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ WidgetServerSettingsSecurity.ToggleMfaDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(WidgetServerSettingsSecurity.ToggleMfaDialog toggleMfaDialog) {
        super(0);
        this.this$0 = toggleMfaDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getArgumentsOrDefault().getBoolean("ARG_MFA_ENABLED", false);
    }
}
