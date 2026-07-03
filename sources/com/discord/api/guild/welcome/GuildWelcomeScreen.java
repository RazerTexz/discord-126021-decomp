package com.discord.api.guild.welcome;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildWelcomeScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildWelcomeScreen {
    private final String description;
    private final List<GuildWelcomeChannel> welcomeChannels;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: b */
    public final List<GuildWelcomeChannel> m7899b() {
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
        return C12238m.areEqual(this.description, guildWelcomeScreen.description) && C12238m.areEqual(this.welcomeChannels, guildWelcomeScreen.welcomeChannels);
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<GuildWelcomeChannel> list = this.welcomeChannels;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildWelcomeScreen(description=");
        sbM833U.append(this.description);
        sbM833U.append(", welcomeChannels=");
        return C1643a.m824L(sbM833U, this.welcomeChannels, ")");
    }
}
