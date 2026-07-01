package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.guilds.MemberVerificationUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetChannelsListAdapter$ItemGuildJoinRequest this$0;

    public WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1(WidgetChannelsListAdapter$ItemGuildJoinRequest widgetChannelsListAdapter$ItemGuildJoinRequest, Context context) {
        this.this$0 = widgetChannelsListAdapter$ItemGuildJoinRequest;
        this.$context = context;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
        Context context = this.$context;
        m.checkNotNullExpressionValue(context, "context");
        MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, context, WidgetChannelsListAdapter.access$getFragmentManager$p(WidgetChannelsListAdapter$ItemGuildJoinRequest.access$getAdapter$p(this.this$0)), WidgetChannelsListAdapter$ItemGuildJoinRequest.access$getAdapter$p(this.this$0).getSelectedGuildId(), "Channel Notice", null, null, WidgetChannelsListAdapter$ItemGuildJoinRequest$onConfigure$1$1.INSTANCE, 48, null);
    }
}
