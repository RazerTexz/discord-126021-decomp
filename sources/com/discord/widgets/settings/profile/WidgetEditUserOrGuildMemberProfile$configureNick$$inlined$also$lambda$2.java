package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState$inlined = settingsUserProfileViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateNickname("");
    }
}
