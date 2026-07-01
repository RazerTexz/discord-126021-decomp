package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.utilities.voice.VoiceChannelJoinability;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded extends WidgetGuildCallOnboardingSheetViewModel$ViewState {
    private final Long guildId;
    private final VoiceChannelJoinability joinability;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded(Long l, VoiceChannelJoinability voiceChannelJoinability) {
        super(null);
        m.checkNotNullParameter(voiceChannelJoinability, "joinability");
        this.guildId = l;
        this.joinability = voiceChannelJoinability;
    }

    public static /* synthetic */ WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded copy$default(WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded, Long l, VoiceChannelJoinability voiceChannelJoinability, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.guildId;
        }
        if ((i & 2) != 0) {
            voiceChannelJoinability = widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.joinability;
        }
        return widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.copy(l, voiceChannelJoinability);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VoiceChannelJoinability getJoinability() {
        return this.joinability;
    }

    public final WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded copy(Long guildId, VoiceChannelJoinability joinability) {
        m.checkNotNullParameter(joinability, "joinability");
        return new WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded(guildId, joinability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded = (WidgetGuildCallOnboardingSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.guildId, widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.guildId) && m.areEqual(this.joinability, widgetGuildCallOnboardingSheetViewModel$ViewState$Loaded.joinability);
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final VoiceChannelJoinability getJoinability() {
        return this.joinability;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        VoiceChannelJoinability voiceChannelJoinability = this.joinability;
        return iHashCode + (voiceChannelJoinability != null ? voiceChannelJoinability.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guildId=");
        sbU.append(this.guildId);
        sbU.append(", joinability=");
        sbU.append(this.joinability);
        sbU.append(")");
        return sbU.toString();
    }
}
