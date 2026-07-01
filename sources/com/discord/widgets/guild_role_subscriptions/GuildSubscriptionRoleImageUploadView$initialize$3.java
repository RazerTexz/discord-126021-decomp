package com.discord.widgets.guild_role_subscriptions;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptionRoleImageUploadView$initialize$3 implements View$OnClickListener {
    public final /* synthetic */ GuildSubscriptionRoleImageUploadView this$0;

    public GuildSubscriptionRoleImageUploadView$initialize$3(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView) {
        this.this$0 = guildSubscriptionRoleImageUploadView;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(this.this$0);
        if (function0Access$getOnImageChooserClickListener$p != null) {
        }
    }
}
