package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildWelcomeScreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildWelcomeScreen {
    private final List<CharSequence> options = null;
    private final List<Long> optionsChannelIds = null;
    private final CharSequence guildDescription = null;
    private final Boolean hasCustomEmojis = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildWelcomeScreen)) {
            return false;
        }
        TrackGuildWelcomeScreen trackGuildWelcomeScreen = (TrackGuildWelcomeScreen) other;
        return m.areEqual(this.options, trackGuildWelcomeScreen.options) && m.areEqual(this.optionsChannelIds, trackGuildWelcomeScreen.optionsChannelIds) && m.areEqual(this.guildDescription, trackGuildWelcomeScreen.guildDescription) && m.areEqual(this.hasCustomEmojis, trackGuildWelcomeScreen.hasCustomEmojis);
    }

    public int hashCode() {
        List<CharSequence> list = this.options;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Long> list2 = this.optionsChannelIds;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.guildDescription;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasCustomEmojis;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildWelcomeScreen(options=");
        sbU.append(this.options);
        sbU.append(", optionsChannelIds=");
        sbU.append(this.optionsChannelIds);
        sbU.append(", guildDescription=");
        sbU.append(this.guildDescription);
        sbU.append(", hasCustomEmojis=");
        return a.D(sbU, this.hasCustomEmojis, ")");
    }
}
