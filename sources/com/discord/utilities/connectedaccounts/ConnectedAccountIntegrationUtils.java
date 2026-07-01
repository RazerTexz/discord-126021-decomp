package com.discord.utilities.connectedaccounts;

import b.d.b.a.outline;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationAccount;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.connectedaccounts.ConnectedAccountIntegrationUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: ConnectedAccountIntegrationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedAccountIntegrationUtils {
    public static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    public static final String YOUTUBE_URL_PREFIX = "youtube.com/channel/";

    public static final String getDisplayName(ConnectedAccountIntegration connectedAccountIntegration) {
        Intrinsics3.checkNotNullParameter(connectedAccountIntegration, "$this$getDisplayName");
        if (Intrinsics3.areEqual("twitch", connectedAccountIntegration.getType())) {
            StringBuilder sbU = outline.U(TWITCH_URL_PREFIX);
            ConnectedIntegrationAccount account = connectedAccountIntegration.getAccount();
            sbU.append(account != null ? account.getName() : null);
            return sbU.toString();
        }
        if (Intrinsics3.areEqual("youtube", connectedAccountIntegration.getType())) {
            StringBuilder sbU2 = outline.U(YOUTUBE_URL_PREFIX);
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
