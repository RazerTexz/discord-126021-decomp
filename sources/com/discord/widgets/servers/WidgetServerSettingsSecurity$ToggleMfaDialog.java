package com.discord.widgets.servers;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_MFA_ENABLED = "ARG_MFA_ENABLED";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: mfaEnabled$delegate, reason: from kotlin metadata */
    private final Lazy mfaEnabled;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsSecurity$ToggleMfaDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0)};
    public static final WidgetServerSettingsSecurity$ToggleMfaDialog$Companion Companion = new WidgetServerSettingsSecurity$ToggleMfaDialog$Companion(null);

    public WidgetServerSettingsSecurity$ToggleMfaDialog() {
        super(R$layout.widget_server_settings_security_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(this));
        this.mfaEnabled = g.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetServerSettingsSecurity$ToggleMfaDialog widgetServerSettingsSecurity$ToggleMfaDialog) {
        return widgetServerSettingsSecurity$ToggleMfaDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetServerSettingsSecurityDialogBinding access$getBinding$p(WidgetServerSettingsSecurity$ToggleMfaDialog widgetServerSettingsSecurity$ToggleMfaDialog) {
        return widgetServerSettingsSecurity$ToggleMfaDialog.getBinding();
    }

    private final WidgetServerSettingsSecurityDialogBinding getBinding() {
        return (WidgetServerSettingsSecurityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getMfaEnabled() {
        return ((Boolean) this.mfaEnabled.getValue()).booleanValue();
    }

    public final void configure(long guildId, boolean mfaEnabled) {
        if (guildId <= 0) {
            dismiss();
        }
        getBinding().c.setText(mfaEnabled ? 2131888462 : 2131888824);
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityDialogConfirm");
        WidgetServerSettingsSecurityDialogBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        LinearLayout linearLayout = binding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(linearLayout.getContext(), mfaEnabled ? 2131100382 : 2131100304)));
        getBinding().c.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1(this, mfaEnabled, guildId));
        getBinding().f2587b.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2(this));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AppDialog.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        configure(getGuildId(), getMfaEnabled());
    }
}
