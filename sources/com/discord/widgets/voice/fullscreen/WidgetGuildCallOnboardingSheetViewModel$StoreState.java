package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGuildCallOnboardingSheetViewModel$StoreState {
    private final Long guildId;
    private final VoiceChannelJoinability voiceChannelJoinability;

    public WidgetGuildCallOnboardingSheetViewModel$StoreState(Long l, VoiceChannelJoinability voiceChannelJoinability) {
        m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        this.guildId = l;
        this.voiceChannelJoinability = voiceChannelJoinability;
    }

    public static /* synthetic */ WidgetGuildCallOnboardingSheetViewModel$StoreState copy$default(WidgetGuildCallOnboardingSheetViewModel$StoreState widgetGuildCallOnboardingSheetViewModel$StoreState, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetGuildCallOnboardingSheetViewModel$StoreState.guildId;
        }
        if ((i & 2) != 0) {
            voiceChannelJoinability = widgetGuildCallOnboardingSheetViewModel$StoreState.voiceChannelJoinability;
        }
        return widgetGuildCallOnboardingSheetViewModel$StoreState.copy(l, voiceChannelJoinability);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VoiceChannelJoinability getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    public final WidgetGuildCallOnboardingSheetViewModel$StoreState copy(Long guildId, VoiceChannelJoinability voiceChannelJoinability) {
        m.checkNotNullParameter(voiceChannelJoinability, "voiceChannelJoinability");
        return new WidgetGuildCallOnboardingSheetViewModel$StoreState(guildId, voiceChannelJoinability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCallOnboardingSheetViewModel$StoreState)) {
            return false;
        }
        WidgetGuildCallOnboardingSheetViewModel$StoreState widgetGuildCallOnboardingSheetViewModel$StoreState = (WidgetGuildCallOnboardingSheetViewModel$StoreState) other;
        return m.areEqual(this.guildId, widgetGuildCallOnboardingSheetViewModel$StoreState.guildId) && m.areEqual(this.voiceChannelJoinability, widgetGuildCallOnboardingSheetViewModel$StoreState.voiceChannelJoinability);
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final VoiceChannelJoinability getVoiceChannelJoinability() {
        return this.voiceChannelJoinability;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        VoiceChannelJoinability voiceChannelJoinability = this.voiceChannelJoinability;
        return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildId=");
        sbU.append(this.guildId);
        sbU.append(", voiceChannelJoinability=");
        sbU.append(this.voiceChannelJoinability);
        sbU.append(")");
        return sbU.toString();
    }
}
