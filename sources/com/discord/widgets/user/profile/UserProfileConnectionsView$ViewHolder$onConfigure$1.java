package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.platform.Platform;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileConnectionsView$ViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ String $profileUrl;
    public final /* synthetic */ int $themedPlatformImageRes;
    public final /* synthetic */ String $username;
    public final /* synthetic */ UserProfileConnectionsView$ViewHolder this$0;

    public UserProfileConnectionsView$ViewHolder$onConfigure$1(UserProfileConnectionsView$ViewHolder userProfileConnectionsView$ViewHolder, Platform platform, String str, int i, String str2) {
        this.this$0 = userProfileConnectionsView$ViewHolder;
        this.$platform = platform;
        this.$username = str;
        this.$themedPlatformImageRes = i;
        this.$profileUrl = str2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.connectedAccountViewed(this.$platform.getPlatformId());
        UserProfileConnectionsView$ViewHolder.access$getAdapter$p(this.this$0).getOnConnectedAccountClick().invoke(this.$username, Integer.valueOf(this.$themedPlatformImageRes), this.$profileUrl);
    }
}
