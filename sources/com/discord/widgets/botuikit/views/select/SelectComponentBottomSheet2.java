package com.discord.widgets.botuikit.views.select;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.views.select.ComponentContext, reason: use source file name */
/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SelectComponentBottomSheet2 implements Serializable {
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final Long messageFlags;
    private final long messageId;

    public SelectComponentBottomSheet2(Long l, long j, long j2, Long l2, long j3) {
        this.guildId = l;
        this.messageId = j;
        this.channelId = j2;
        this.messageFlags = l2;
        this.applicationId = j3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    public final SelectComponentBottomSheet2 copy(Long guildId, long messageId, long channelId, Long messageFlags, long applicationId) {
        return new SelectComponentBottomSheet2(guildId, messageId, channelId, messageFlags, applicationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponentBottomSheet2)) {
            return false;
        }
        SelectComponentBottomSheet2 selectComponentBottomSheet2 = (SelectComponentBottomSheet2) other;
        return Intrinsics3.areEqual(this.guildId, selectComponentBottomSheet2.guildId) && this.messageId == selectComponentBottomSheet2.messageId && this.channelId == selectComponentBottomSheet2.channelId && Intrinsics3.areEqual(this.messageFlags, selectComponentBottomSheet2.messageFlags) && this.applicationId == selectComponentBottomSheet2.applicationId;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iA = (b.a(this.channelId) + ((b.a(this.messageId) + ((l != null ? l.hashCode() : 0) * 31)) * 31)) * 31;
        Long l2 = this.messageFlags;
        return b.a(this.applicationId) + ((iA + (l2 != null ? l2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ComponentContext(guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageFlags=");
        sbU.append(this.messageFlags);
        sbU.append(", applicationId=");
        return outline.C(sbU, this.applicationId, ")");
    }
}
