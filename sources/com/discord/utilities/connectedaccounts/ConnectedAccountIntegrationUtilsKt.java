package com.discord.utilities.connectedaccounts;

import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationAccount;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ConnectedAccountIntegrationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedAccountIntegrationUtilsKt {
    public static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    public static final String YOUTUBE_URL_PREFIX = "youtube.com/channel/";

    public static final String getDisplayName(ConnectedAccountIntegration connectedAccountIntegration) {
        C12238m.checkNotNullParameter(connectedAccountIntegration, "$this$getDisplayName");
        if (C12238m.areEqual("twitch", connectedAccountIntegration.getType())) {
            StringBuilder sbM833U = C1643a.m833U(TWITCH_URL_PREFIX);
            ConnectedIntegrationAccount account = connectedAccountIntegration.getAccount();
            sbM833U.append(account != null ? account.getName() : null);
            return sbM833U.toString();
        }
        if (C12238m.areEqual("youtube", connectedAccountIntegration.getType())) {
            StringBuilder sbM833U2 = C1643a.m833U(YOUTUBE_URL_PREFIX);
            ConnectedIntegrationAccount account2 = connectedAccountIntegration.getAccount();
            sbM833U2.append(account2 != null ? account2.getName() : null);
            return sbM833U2.toString();
        }
        ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
        if (guild != null) {
            return guild.getName();
        }
        return null;
    }
}
