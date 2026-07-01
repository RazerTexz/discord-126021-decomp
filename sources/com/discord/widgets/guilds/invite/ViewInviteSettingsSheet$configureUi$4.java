package com.discord.widgets.guilds.invite;

import android.widget.RadioGroup;
import android.widget.RadioGroup$OnCheckedChangeListener;
import com.discord.models.domain.ModelInvite$Settings;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$configureUi$4 implements RadioGroup$OnCheckedChangeListener {
    public final /* synthetic */ ViewInviteSettingsSheet this$0;

    public ViewInviteSettingsSheet$configureUi$4(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.this$0 = viewInviteSettingsSheet;
    }

    @Override // android.widget.RadioGroup$OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        ViewInviteSettingsSheet viewInviteSettingsSheet = this.this$0;
        ModelInvite$Settings modelInvite$SettingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(viewInviteSettingsSheet);
        ViewInviteSettingsSheet.access$setPendingInviteSettings$p(viewInviteSettingsSheet, modelInvite$SettingsAccess$getPendingInviteSettings$p != null ? modelInvite$SettingsAccess$getPendingInviteSettings$p.mergeMaxAge(i) : null);
    }
}
