package com.discord.widgets.stage.usersheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserProfileStageActionsView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserProfileStageActionsView$ViewState {
    private final boolean canMuteMembers;
    private final Channel channel;
    private final boolean isInvitingToSpeak;
    private final boolean isMe;
    private final boolean isUpdatingSuppressed;
    private final boolean userInSameVoiceChannel;
    private final StageRequestToSpeakState userRequestToSpeakState;
    private final StageRoles userStageRole;

    private UserProfileStageActionsView$ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.isMe = z2;
        this.channel = channel;
        this.userStageRole = stageRoles;
        this.userRequestToSpeakState = stageRequestToSpeakState;
        this.userInSameVoiceChannel = z3;
        this.canMuteMembers = z4;
        this.isUpdatingSuppressed = z5;
        this.isInvitingToSpeak = z6;
    }

    /* JADX INFO: renamed from: copy-am1GJgw$default, reason: not valid java name */
    public static /* synthetic */ UserProfileStageActionsView$ViewState m51copyam1GJgw$default(UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState, boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        return userProfileStageActionsView$ViewState.m53copyam1GJgw((i & 1) != 0 ? userProfileStageActionsView$ViewState.isMe : z2, (i & 2) != 0 ? userProfileStageActionsView$ViewState.channel : channel, (i & 4) != 0 ? userProfileStageActionsView$ViewState.userStageRole : stageRoles, (i & 8) != 0 ? userProfileStageActionsView$ViewState.userRequestToSpeakState : stageRequestToSpeakState, (i & 16) != 0 ? userProfileStageActionsView$ViewState.userInSameVoiceChannel : z3, (i & 32) != 0 ? userProfileStageActionsView$ViewState.canMuteMembers : z4, (i & 64) != 0 ? userProfileStageActionsView$ViewState.isUpdatingSuppressed : z5, (i & 128) != 0 ? userProfileStageActionsView$ViewState.isInvitingToSpeak : z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getUserStageRole() {
        return this.userStageRole;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StageRequestToSpeakState getUserRequestToSpeakState() {
        return this.userRequestToSpeakState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getUserInSameVoiceChannel() {
        return this.userInSameVoiceChannel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanMuteMembers() {
        return this.canMuteMembers;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsUpdatingSuppressed() {
        return this.isUpdatingSuppressed;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsInvitingToSpeak() {
        return this.isInvitingToSpeak;
    }

    /* JADX INFO: renamed from: copy-am1GJgw, reason: not valid java name */
    public final UserProfileStageActionsView$ViewState m53copyam1GJgw(boolean isMe, Channel channel, StageRoles userStageRole, StageRequestToSpeakState userRequestToSpeakState, boolean userInSameVoiceChannel, boolean canMuteMembers, boolean isUpdatingSuppressed, boolean isInvitingToSpeak) {
        m.checkNotNullParameter(userRequestToSpeakState, "userRequestToSpeakState");
        return new UserProfileStageActionsView$ViewState(isMe, channel, userStageRole, userRequestToSpeakState, userInSameVoiceChannel, canMuteMembers, isUpdatingSuppressed, isInvitingToSpeak);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileStageActionsView$ViewState)) {
            return false;
        }
        UserProfileStageActionsView$ViewState userProfileStageActionsView$ViewState = (UserProfileStageActionsView$ViewState) other;
        return this.isMe == userProfileStageActionsView$ViewState.isMe && m.areEqual(this.channel, userProfileStageActionsView$ViewState.channel) && m.areEqual(this.userStageRole, userProfileStageActionsView$ViewState.userStageRole) && m.areEqual(this.userRequestToSpeakState, userProfileStageActionsView$ViewState.userRequestToSpeakState) && this.userInSameVoiceChannel == userProfileStageActionsView$ViewState.userInSameVoiceChannel && this.canMuteMembers == userProfileStageActionsView$ViewState.canMuteMembers && this.isUpdatingSuppressed == userProfileStageActionsView$ViewState.isUpdatingSuppressed && this.isInvitingToSpeak == userProfileStageActionsView$ViewState.isInvitingToSpeak;
    }

    public final boolean getCanMuteMembers() {
        return this.canMuteMembers;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getUserInSameVoiceChannel() {
        return this.userInSameVoiceChannel;
    }

    public final StageRequestToSpeakState getUserRequestToSpeakState() {
        return this.userRequestToSpeakState;
    }

    /* JADX INFO: renamed from: getUserStageRole-twRsX-0, reason: not valid java name */
    public final StageRoles m54getUserStageRoletwRsX0() {
        return this.userStageRole;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public int hashCode() {
        boolean z2 = this.isMe;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Channel channel = this.channel;
        int iHashCode = (i + (channel != null ? channel.hashCode() : 0)) * 31;
        StageRoles stageRoles = this.userStageRole;
        int iHashCode2 = (iHashCode + (stageRoles != null ? stageRoles.hashCode() : 0)) * 31;
        StageRequestToSpeakState stageRequestToSpeakState = this.userRequestToSpeakState;
        int iHashCode3 = (iHashCode2 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31;
        boolean z3 = this.userInSameVoiceChannel;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode3 + r2) * 31;
        boolean z4 = this.canMuteMembers;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isUpdatingSuppressed;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isInvitingToSpeak;
        return i4 + (z6 ? 1 : z6);
    }

    public final boolean isInvitingToSpeak() {
        return this.isInvitingToSpeak;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean isUpdatingSuppressed() {
        return this.isUpdatingSuppressed;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isMe=");
        sbU.append(this.isMe);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", userStageRole=");
        sbU.append(this.userStageRole);
        sbU.append(", userRequestToSpeakState=");
        sbU.append(this.userRequestToSpeakState);
        sbU.append(", userInSameVoiceChannel=");
        sbU.append(this.userInSameVoiceChannel);
        sbU.append(", canMuteMembers=");
        sbU.append(this.canMuteMembers);
        sbU.append(", isUpdatingSuppressed=");
        sbU.append(this.isUpdatingSuppressed);
        sbU.append(", isInvitingToSpeak=");
        return a.O(sbU, this.isInvitingToSpeak, ")");
    }

    public /* synthetic */ UserProfileStageActionsView$ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, channel, stageRoles, stageRequestToSpeakState, z3, z4, z5, z6);
    }

    public /* synthetic */ UserProfileStageActionsView$ViewState(boolean z2, Channel channel, StageRoles stageRoles, StageRequestToSpeakState stageRequestToSpeakState, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, channel, stageRoles, stageRequestToSpeakState, z3, z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? false : z6);
    }
}
