package com.discord.widgets.botuikit.views.select;

import java.io.Serializable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ComponentContext implements Serializable {
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final Long messageFlags;
    private final long messageId;

    public ComponentContext(Long l, long j, long j2, Long l2, long j3) {
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

    public final ComponentContext copy(Long guildId, long messageId, long channelId, Long messageFlags, long applicationId) {
        return new ComponentContext(guildId, messageId, channelId, messageFlags, applicationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentContext)) {
            return false;
        }
        ComponentContext componentContext = (ComponentContext) other;
        return C12238m.areEqual(this.guildId, componentContext.guildId) && this.messageId == componentContext.messageId && this.channelId == componentContext.channelId && C12238m.areEqual(this.messageFlags, componentContext.messageFlags) && this.applicationId == componentContext.applicationId;
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
        int iM3a = (C0002b.m3a(this.channelId) + ((C0002b.m3a(this.messageId) + ((l != null ? l.hashCode() : 0) * 31)) * 31)) * 31;
        Long l2 = this.messageFlags;
        return C0002b.m3a(this.applicationId) + ((iM3a + (l2 != null ? l2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ComponentContext(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", messageFlags=");
        sbM833U.append(this.messageFlags);
        sbM833U.append(", applicationId=");
        return C1643a.m815C(sbM833U, this.applicationId, ")");
    }
}
