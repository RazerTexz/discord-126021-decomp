package com.discord.widgets.stage.model;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.widgets.stage.StageRoles;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageChannel {
    private final int audienceSize;
    private final boolean canAccess;
    private final Channel channel;
    private final boolean containsMe;
    private final StageRoles myRoles;
    private final List<User> participants;
    private final Set<Long> speakerIds;
    private final List<UserGuildMember> speakers;
    private final StageInstance stageInstance;

    /* JADX WARN: Multi-variable type inference failed */
    private StageChannel(Channel channel, List<? extends User> list, StageRoles stageRoles, Set<Long> set, List<UserGuildMember> list2, int i, StageInstance stageInstance, boolean z2, boolean z3) {
        this.channel = channel;
        this.participants = list;
        this.myRoles = stageRoles;
        this.speakerIds = set;
        this.speakers = list2;
        this.audienceSize = i;
        this.stageInstance = stageInstance;
        this.canAccess = z2;
        this.containsMe = z3;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<User> component2() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component3-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyRoles() {
        return this.myRoles;
    }

    public final Set<Long> component4() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> component5() {
        return this.speakers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanAccess() {
        return this.canAccess;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getContainsMe() {
        return this.containsMe;
    }

    /* JADX INFO: renamed from: copy-LcZnYPc, reason: not valid java name */
    public final StageChannel m11422copyLcZnYPc(Channel channel, List<? extends User> participants, StageRoles myRoles, Set<Long> speakerIds, List<UserGuildMember> speakers, int audienceSize, StageInstance stageInstance, boolean canAccess, boolean containsMe) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(participants, "participants");
        C12238m.checkNotNullParameter(speakerIds, "speakerIds");
        C12238m.checkNotNullParameter(speakers, "speakers");
        return new StageChannel(channel, participants, myRoles, speakerIds, speakers, audienceSize, stageInstance, canAccess, containsMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageChannel)) {
            return false;
        }
        StageChannel stageChannel = (StageChannel) other;
        return C12238m.areEqual(this.channel, stageChannel.channel) && C12238m.areEqual(this.participants, stageChannel.participants) && C12238m.areEqual(this.myRoles, stageChannel.myRoles) && C12238m.areEqual(this.speakerIds, stageChannel.speakerIds) && C12238m.areEqual(this.speakers, stageChannel.speakers) && this.audienceSize == stageChannel.audienceSize && C12238m.areEqual(this.stageInstance, stageChannel.stageInstance) && this.canAccess == stageChannel.canAccess && this.containsMe == stageChannel.containsMe;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getCanAccess() {
        return this.canAccess;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getContainsMe() {
        return this.containsMe;
    }

    public final boolean getHasActiveStageInstance() {
        return this.stageInstance != null;
    }

    /* JADX INFO: renamed from: getMyRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m11423getMyRolestwRsX0() {
        return this.myRoles;
    }

    public final List<User> getParticipants() {
        return this.participants;
    }

    public final Set<Long> getSpeakerIds() {
        return this.speakerIds;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        List<User> list = this.participants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.myRoles;
        int iHashCode3 = (iHashCode2 + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        Set<Long> set = this.speakerIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        List<UserGuildMember> list2 = this.speakers;
        int iHashCode5 = (((iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode6 = (iHashCode5 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z2 = this.canAccess;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode6 + r1) * 31;
        boolean z3 = this.containsMe;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StageChannel(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", participants=");
        sbM833U.append(this.participants);
        sbM833U.append(", myRoles=");
        sbM833U.append(this.myRoles);
        sbM833U.append(", speakerIds=");
        sbM833U.append(this.speakerIds);
        sbM833U.append(", speakers=");
        sbM833U.append(this.speakers);
        sbM833U.append(", audienceSize=");
        sbM833U.append(this.audienceSize);
        sbM833U.append(", stageInstance=");
        sbM833U.append(this.stageInstance);
        sbM833U.append(", canAccess=");
        sbM833U.append(this.canAccess);
        sbM833U.append(", containsMe=");
        return C1643a.m827O(sbM833U, this.containsMe, ")");
    }

    public /* synthetic */ StageChannel(Channel channel, List list, StageRoles stageRoles, Set set, List list2, int i, StageInstance stageInstance, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, list, stageRoles, set, list2, i, stageInstance, z2, z3);
    }
}
