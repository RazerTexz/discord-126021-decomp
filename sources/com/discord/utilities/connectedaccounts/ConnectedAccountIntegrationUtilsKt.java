package com.discord.utilities.connectedaccounts;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationAccount;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectedAccountIntegrationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedAccountIntegrationUtilsKt {
    public static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    public static final String YOUTUBE_URL_PREFIX = "youtube.com/channel/";

    public static final String getDisplayName(ConnectedAccountIntegration connectedAccountIntegration) {
        m.checkNotNullParameter(connectedAccountIntegration, "$this$getDisplayName");
        if (m.areEqual("twitch", connectedAccountIntegration.getType())) {
            StringBuilder sbU = a.U(TWITCH_URL_PREFIX);
            ConnectedIntegrationAccount account = connectedAccountIntegration.getAccount();
            sbU.append(account != null ? account.getName() : null);
            return sbU.toString();
        }
        if (m.areEqual("youtube", connectedAccountIntegration.getType())) {
            StringBuilder sbU2 = a.U(YOUTUBE_URL_PREFIX);
            ConnectedIntegrationAccount account2 = connectedAccountIntegration.getAccount();
            sbU2.append(account2 != null ? account2.getName() : null);
            return sbU2.toString();
        }
        ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
        if (guild != null) {
            return guild.getName();
        }
        return null;
    }
}
