package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.options, trackGuildWelcomeScreen.options) && C12238m.areEqual(this.optionsChannelIds, trackGuildWelcomeScreen.optionsChannelIds) && C12238m.areEqual(this.guildDescription, trackGuildWelcomeScreen.guildDescription) && C12238m.areEqual(this.hasCustomEmojis, trackGuildWelcomeScreen.hasCustomEmojis);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGuildWelcomeScreen(options=");
        sbM833U.append(this.options);
        sbM833U.append(", optionsChannelIds=");
        sbM833U.append(this.optionsChannelIds);
        sbM833U.append(", guildDescription=");
        sbM833U.append(this.guildDescription);
        sbM833U.append(", hasCustomEmojis=");
        return C1643a.m816D(sbM833U, this.hasCustomEmojis, ")");
    }
}
