package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
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
        return Intrinsics3.areEqual(this.options, trackGuildWelcomeScreen.options) && Intrinsics3.areEqual(this.optionsChannelIds, trackGuildWelcomeScreen.optionsChannelIds) && Intrinsics3.areEqual(this.guildDescription, trackGuildWelcomeScreen.guildDescription) && Intrinsics3.areEqual(this.hasCustomEmojis, trackGuildWelcomeScreen.hasCustomEmojis);
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
        StringBuilder sbU = outline.U("TrackGuildWelcomeScreen(options=");
        sbU.append(this.options);
        sbU.append(", optionsChannelIds=");
        sbU.append(this.optionsChannelIds);
        sbU.append(", guildDescription=");
        sbU.append(this.guildDescription);
        sbU.append(", hasCustomEmojis=");
        return outline.D(sbU, this.hasCustomEmojis, ")");
    }
}
