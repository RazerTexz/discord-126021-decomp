package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsBlockedUsersViewModel$Item $data;
    public final /* synthetic */ WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder this$0;

    public WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder$onConfigure$1(WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder widgetSettingsBlockedUsersAdapter$BlockedUserViewHolder, WidgetSettingsBlockedUsersViewModel$Item widgetSettingsBlockedUsersViewModel$Item) {
        this.this$0 = widgetSettingsBlockedUsersAdapter$BlockedUserViewHolder;
        this.$data = widgetSettingsBlockedUsersViewModel$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsBlockedUsersAdapter$BlockedUserViewHolder.access$getAdapter$p(this.this$0).getOnClickUserProfile().invoke(this.$data.getUser());
    }
}
