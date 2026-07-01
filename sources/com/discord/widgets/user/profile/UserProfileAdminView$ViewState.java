package com.discord.widgets.user.profile;

import b.d.b.a.a;

/* JADX INFO: compiled from: UserProfileAdminView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileAdminView$ViewState {
    private final boolean isAdminSectionEnabled;
    private final boolean isCommunicationDisabled;
    private final boolean isMe;
    private final boolean isMultiUserDM;
    private final boolean isServerDeafened;
    private final boolean isServerMuted;
    private final boolean showBanButton;
    private final boolean showDisableCommunicationButton;
    private final boolean showEditMemberButton;
    private final boolean showKickButton;
    private final boolean showServerDeafenButton;
    private final boolean showServerMoveAndDisconnectButtons;
    private final boolean showServerMuteButton;

    public UserProfileAdminView$ViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.showEditMemberButton = z2;
        this.showKickButton = z3;
        this.showDisableCommunicationButton = z4;
        this.isMultiUserDM = z5;
        this.showBanButton = z6;
        this.showServerMuteButton = z7;
        this.isServerMuted = z8;
        this.showServerDeafenButton = z9;
        this.isServerDeafened = z10;
        this.showServerMoveAndDisconnectButtons = z11;
        this.isAdminSectionEnabled = z12;
        this.isMe = z13;
        this.isCommunicationDisabled = z14;
    }

    public static /* synthetic */ UserProfileAdminView$ViewState copy$default(UserProfileAdminView$ViewState userProfileAdminView$ViewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i, Object obj) {
        return userProfileAdminView$ViewState.copy((i & 1) != 0 ? userProfileAdminView$ViewState.showEditMemberButton : z2, (i & 2) != 0 ? userProfileAdminView$ViewState.showKickButton : z3, (i & 4) != 0 ? userProfileAdminView$ViewState.showDisableCommunicationButton : z4, (i & 8) != 0 ? userProfileAdminView$ViewState.isMultiUserDM : z5, (i & 16) != 0 ? userProfileAdminView$ViewState.showBanButton : z6, (i & 32) != 0 ? userProfileAdminView$ViewState.showServerMuteButton : z7, (i & 64) != 0 ? userProfileAdminView$ViewState.isServerMuted : z8, (i & 128) != 0 ? userProfileAdminView$ViewState.showServerDeafenButton : z9, (i & 256) != 0 ? userProfileAdminView$ViewState.isServerDeafened : z10, (i & 512) != 0 ? userProfileAdminView$ViewState.showServerMoveAndDisconnectButtons : z11, (i & 1024) != 0 ? userProfileAdminView$ViewState.isAdminSectionEnabled : z12, (i & 2048) != 0 ? userProfileAdminView$ViewState.isMe : z13, (i & 4096) != 0 ? userProfileAdminView$ViewState.isCommunicationDisabled : z14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowEditMemberButton() {
        return this.showEditMemberButton;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowServerMoveAndDisconnectButtons() {
        return this.showServerMoveAndDisconnectButtons;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsAdminSectionEnabled() {
        return this.isAdminSectionEnabled;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsCommunicationDisabled() {
        return this.isCommunicationDisabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowKickButton() {
        return this.showKickButton;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowDisableCommunicationButton() {
        return this.showDisableCommunicationButton;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsMultiUserDM() {
        return this.isMultiUserDM;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowBanButton() {
        return this.showBanButton;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowServerMuteButton() {
        return this.showServerMuteButton;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsServerMuted() {
        return this.isServerMuted;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowServerDeafenButton() {
        return this.showServerDeafenButton;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsServerDeafened() {
        return this.isServerDeafened;
    }

    public final UserProfileAdminView$ViewState copy(boolean showEditMemberButton, boolean showKickButton, boolean showDisableCommunicationButton, boolean isMultiUserDM, boolean showBanButton, boolean showServerMuteButton, boolean isServerMuted, boolean showServerDeafenButton, boolean isServerDeafened, boolean showServerMoveAndDisconnectButtons, boolean isAdminSectionEnabled, boolean isMe, boolean isCommunicationDisabled) {
        return new UserProfileAdminView$ViewState(showEditMemberButton, showKickButton, showDisableCommunicationButton, isMultiUserDM, showBanButton, showServerMuteButton, isServerMuted, showServerDeafenButton, isServerDeafened, showServerMoveAndDisconnectButtons, isAdminSectionEnabled, isMe, isCommunicationDisabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileAdminView$ViewState)) {
            return false;
        }
        UserProfileAdminView$ViewState userProfileAdminView$ViewState = (UserProfileAdminView$ViewState) other;
        return this.showEditMemberButton == userProfileAdminView$ViewState.showEditMemberButton && this.showKickButton == userProfileAdminView$ViewState.showKickButton && this.showDisableCommunicationButton == userProfileAdminView$ViewState.showDisableCommunicationButton && this.isMultiUserDM == userProfileAdminView$ViewState.isMultiUserDM && this.showBanButton == userProfileAdminView$ViewState.showBanButton && this.showServerMuteButton == userProfileAdminView$ViewState.showServerMuteButton && this.isServerMuted == userProfileAdminView$ViewState.isServerMuted && this.showServerDeafenButton == userProfileAdminView$ViewState.showServerDeafenButton && this.isServerDeafened == userProfileAdminView$ViewState.isServerDeafened && this.showServerMoveAndDisconnectButtons == userProfileAdminView$ViewState.showServerMoveAndDisconnectButtons && this.isAdminSectionEnabled == userProfileAdminView$ViewState.isAdminSectionEnabled && this.isMe == userProfileAdminView$ViewState.isMe && this.isCommunicationDisabled == userProfileAdminView$ViewState.isCommunicationDisabled;
    }

    public final boolean getShowBanButton() {
        return this.showBanButton;
    }

    public final boolean getShowDisableCommunicationButton() {
        return this.showDisableCommunicationButton;
    }

    public final boolean getShowEditMemberButton() {
        return this.showEditMemberButton;
    }

    public final boolean getShowKickButton() {
        return this.showKickButton;
    }

    public final boolean getShowServerDeafenButton() {
        return this.showServerDeafenButton;
    }

    public final boolean getShowServerMoveAndDisconnectButtons() {
        return this.showServerMoveAndDisconnectButtons;
    }

    public final boolean getShowServerMuteButton() {
        return this.showServerMuteButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.showEditMemberButton;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.showKickButton;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.showDisableCommunicationButton;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isMultiUserDM;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.showBanButton;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.showServerMuteButton;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.isServerMuted;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.showServerDeafenButton;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i8 = (i7 + r8) * 31;
        boolean z10 = this.isServerDeafened;
        ?? r9 = z10;
        if (z10) {
            r9 = 1;
        }
        int i9 = (i8 + r9) * 31;
        boolean z11 = this.showServerMoveAndDisconnectButtons;
        ?? r10 = z11;
        if (z11) {
            r10 = 1;
        }
        int i10 = (i9 + r10) * 31;
        boolean z12 = this.isAdminSectionEnabled;
        ?? r11 = z12;
        if (z12) {
            r11 = 1;
        }
        int i11 = (i10 + r11) * 31;
        boolean z13 = this.isMe;
        ?? r12 = z13;
        if (z13) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z14 = this.isCommunicationDisabled;
        return i12 + (z14 ? 1 : z14);
    }

    public final boolean isAdminSectionEnabled() {
        return this.isAdminSectionEnabled;
    }

    public final boolean isCommunicationDisabled() {
        return this.isCommunicationDisabled;
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final boolean isMultiUserDM() {
        return this.isMultiUserDM;
    }

    public final boolean isServerDeafened() {
        return this.isServerDeafened;
    }

    public final boolean isServerMuted() {
        return this.isServerMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(showEditMemberButton=");
        sbU.append(this.showEditMemberButton);
        sbU.append(", showKickButton=");
        sbU.append(this.showKickButton);
        sbU.append(", showDisableCommunicationButton=");
        sbU.append(this.showDisableCommunicationButton);
        sbU.append(", isMultiUserDM=");
        sbU.append(this.isMultiUserDM);
        sbU.append(", showBanButton=");
        sbU.append(this.showBanButton);
        sbU.append(", showServerMuteButton=");
        sbU.append(this.showServerMuteButton);
        sbU.append(", isServerMuted=");
        sbU.append(this.isServerMuted);
        sbU.append(", showServerDeafenButton=");
        sbU.append(this.showServerDeafenButton);
        sbU.append(", isServerDeafened=");
        sbU.append(this.isServerDeafened);
        sbU.append(", showServerMoveAndDisconnectButtons=");
        sbU.append(this.showServerMoveAndDisconnectButtons);
        sbU.append(", isAdminSectionEnabled=");
        sbU.append(this.isAdminSectionEnabled);
        sbU.append(", isMe=");
        sbU.append(this.isMe);
        sbU.append(", isCommunicationDisabled=");
        return a.O(sbU, this.isCommunicationDisabled, ")");
    }
}
