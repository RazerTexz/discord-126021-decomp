package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$GuildMFA;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1 implements View$OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $mfaEnabled;
    public final /* synthetic */ WidgetServerSettingsSecurity$ToggleMfaDialog this$0;

    public WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1(WidgetServerSettingsSecurity$ToggleMfaDialog widgetServerSettingsSecurity$ToggleMfaDialog, boolean z2, long j) {
        this.this$0 = widgetServerSettingsSecurity$ToggleMfaDialog;
        this.$mfaEnabled = z2;
        this.$guildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = !this.$mfaEnabled ? 1 : 0;
        TextInputLayout textInputLayout = WidgetServerSettingsSecurity$ToggleMfaDialog.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsSecurityServerMfaCode");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().setMfaLevel(this.$guildId, new RestAPIParams$GuildMFA(i, ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1$1(this), 60, (Object) null);
    }
}
