package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationPendingViewModel$ViewState$Loaded extends MemberVerificationPendingViewModel$ViewState {
    private final MemberVerificationPendingViewModel$DialogState dialogState;
    private final boolean isPreviewEnabled;
    private final String rejectionReason;
    private final boolean showPendingImage;
    private final boolean showTertiaryButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel$ViewState$Loaded(MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, boolean z2, boolean z3, boolean z4, String str) {
        super(null);
        m.checkNotNullParameter(memberVerificationPendingViewModel$DialogState, "dialogState");
        this.dialogState = memberVerificationPendingViewModel$DialogState;
        this.showPendingImage = z2;
        this.showTertiaryButton = z3;
        this.isPreviewEnabled = z4;
        this.rejectionReason = str;
    }

    public static /* synthetic */ MemberVerificationPendingViewModel$ViewState$Loaded copy$default(MemberVerificationPendingViewModel$ViewState$Loaded memberVerificationPendingViewModel$ViewState$Loaded, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            memberVerificationPendingViewModel$DialogState = memberVerificationPendingViewModel$ViewState$Loaded.dialogState;
        }
        if ((i & 2) != 0) {
            z2 = memberVerificationPendingViewModel$ViewState$Loaded.showPendingImage;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            z3 = memberVerificationPendingViewModel$ViewState$Loaded.showTertiaryButton;
        }
        boolean z6 = z3;
        if ((i & 8) != 0) {
            z4 = memberVerificationPendingViewModel$ViewState$Loaded.isPreviewEnabled;
        }
        boolean z7 = z4;
        if ((i & 16) != 0) {
            str = memberVerificationPendingViewModel$ViewState$Loaded.rejectionReason;
        }
        return memberVerificationPendingViewModel$ViewState$Loaded.copy(memberVerificationPendingViewModel$DialogState, z5, z6, z7, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MemberVerificationPendingViewModel$DialogState getDialogState() {
        return this.dialogState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowPendingImage() {
        return this.showPendingImage;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowTertiaryButton() {
        return this.showTertiaryButton;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPreviewEnabled() {
        return this.isPreviewEnabled;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    public final MemberVerificationPendingViewModel$ViewState$Loaded copy(MemberVerificationPendingViewModel$DialogState dialogState, boolean showPendingImage, boolean showTertiaryButton, boolean isPreviewEnabled, String rejectionReason) {
        m.checkNotNullParameter(dialogState, "dialogState");
        return new MemberVerificationPendingViewModel$ViewState$Loaded(dialogState, showPendingImage, showTertiaryButton, isPreviewEnabled, rejectionReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationPendingViewModel$ViewState$Loaded)) {
            return false;
        }
        MemberVerificationPendingViewModel$ViewState$Loaded memberVerificationPendingViewModel$ViewState$Loaded = (MemberVerificationPendingViewModel$ViewState$Loaded) other;
        return m.areEqual(this.dialogState, memberVerificationPendingViewModel$ViewState$Loaded.dialogState) && this.showPendingImage == memberVerificationPendingViewModel$ViewState$Loaded.showPendingImage && this.showTertiaryButton == memberVerificationPendingViewModel$ViewState$Loaded.showTertiaryButton && this.isPreviewEnabled == memberVerificationPendingViewModel$ViewState$Loaded.isPreviewEnabled && m.areEqual(this.rejectionReason, memberVerificationPendingViewModel$ViewState$Loaded.rejectionReason);
    }

    public final MemberVerificationPendingViewModel$DialogState getDialogState() {
        return this.dialogState;
    }

    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    public final boolean getShowPendingImage() {
        return this.showPendingImage;
    }

    public final boolean getShowTertiaryButton() {
        return this.showTertiaryButton;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState = this.dialogState;
        int iHashCode = (memberVerificationPendingViewModel$DialogState != null ? memberVerificationPendingViewModel$DialogState.hashCode() : 0) * 31;
        boolean z2 = this.showPendingImage;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.showTertiaryButton;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isPreviewEnabled;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        String str = this.rejectionReason;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isPreviewEnabled() {
        return this.isPreviewEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(dialogState=");
        sbU.append(this.dialogState);
        sbU.append(", showPendingImage=");
        sbU.append(this.showPendingImage);
        sbU.append(", showTertiaryButton=");
        sbU.append(this.showTertiaryButton);
        sbU.append(", isPreviewEnabled=");
        sbU.append(this.isPreviewEnabled);
        sbU.append(", rejectionReason=");
        return a.J(sbU, this.rejectionReason, ")");
    }
}
