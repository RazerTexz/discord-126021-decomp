package com.discord.api.guild.welcome;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: GuildWelcomeScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildWelcomeScreen {
    private final String description;
    private final List<GuildWelcomeChannel> welcomeChannels;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<GuildWelcomeChannel> b() {
        return this.welcomeChannels;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeScreen)) {
            return false;
        }
        GuildWelcomeScreen guildWelcomeScreen = (GuildWelcomeScreen) other;
        return Intrinsics3.areEqual(this.description, guildWelcomeScreen.description) && Intrinsics3.areEqual(this.welcomeChannels, guildWelcomeScreen.welcomeChannels);
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<GuildWelcomeChannel> list = this.welcomeChannels;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildWelcomeScreen(description=");
        sbU.append(this.description);
        sbU.append(", welcomeChannels=");
        return outline.L(sbU, this.welcomeChannels, ")");
    }
}
