package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$ChannelPreview {
    private final Guild guild;
    private final StageInstance stageInstance;

    public MobileReportsViewModel$ChannelPreview(Guild guild, StageInstance stageInstance) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(stageInstance, "stageInstance");
        this.guild = guild;
        this.stageInstance = stageInstance;
    }

    public static /* synthetic */ MobileReportsViewModel$ChannelPreview copy$default(MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview, Guild guild, StageInstance stageInstance, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = mobileReportsViewModel$ChannelPreview.guild;
        }
        if ((i & 2) != 0) {
            stageInstance = mobileReportsViewModel$ChannelPreview.stageInstance;
        }
        return mobileReportsViewModel$ChannelPreview.copy(guild, stageInstance);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final MobileReportsViewModel$ChannelPreview copy(Guild guild, StageInstance stageInstance) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(stageInstance, "stageInstance");
        return new MobileReportsViewModel$ChannelPreview(guild, stageInstance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$ChannelPreview)) {
            return false;
        }
        MobileReportsViewModel$ChannelPreview mobileReportsViewModel$ChannelPreview = (MobileReportsViewModel$ChannelPreview) other;
        return m.areEqual(this.guild, mobileReportsViewModel$ChannelPreview.guild) && m.areEqual(this.stageInstance, mobileReportsViewModel$ChannelPreview.stageInstance);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        StageInstance stageInstance = this.stageInstance;
        return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelPreview(guild=");
        sbU.append(this.guild);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(")");
        return sbU.toString();
    }
}
