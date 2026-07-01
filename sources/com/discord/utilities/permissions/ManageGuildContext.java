package com.discord.utilities.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ManageGuildContext {
    public static final ManageGuildContext$Companion Companion = new ManageGuildContext$Companion(null);
    private final boolean canManageBans;
    private final boolean canManageChannels;
    private final boolean canManageEmojisAndStickers;
    private final boolean canManageEvents;
    private final boolean canManageNicknames;
    private final boolean canManageRoles;
    private final boolean canManageServer;
    private final boolean canViewAuditLogs;
    private final boolean isOwnerWithRequiredMFALevel;

    public ManageGuildContext(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.canManageServer = z2;
        this.canManageChannels = z3;
        this.canManageRoles = z4;
        this.canManageBans = z5;
        this.canManageNicknames = z6;
        this.canManageEmojisAndStickers = z7;
        this.canViewAuditLogs = z8;
        this.canManageEvents = z9;
        this.isOwnerWithRequiredMFALevel = z10;
    }

    public static /* synthetic */ ManageGuildContext copy$default(ManageGuildContext manageGuildContext, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Object obj) {
        return manageGuildContext.copy((i & 1) != 0 ? manageGuildContext.canManageServer : z2, (i & 2) != 0 ? manageGuildContext.canManageChannels : z3, (i & 4) != 0 ? manageGuildContext.canManageRoles : z4, (i & 8) != 0 ? manageGuildContext.canManageBans : z5, (i & 16) != 0 ? manageGuildContext.canManageNicknames : z6, (i & 32) != 0 ? manageGuildContext.canManageEmojisAndStickers : z7, (i & 64) != 0 ? manageGuildContext.canViewAuditLogs : z8, (i & 128) != 0 ? manageGuildContext.canManageEvents : z9, (i & 256) != 0 ? manageGuildContext.isOwnerWithRequiredMFALevel : z10);
    }

    public static final ManageGuildContext from(List<Channel> list, boolean z2, Long l, Map<Long, Long> map, int i, boolean z3) {
        return Companion.from(list, z2, l, map, i, z3);
    }

    public final boolean canManage() {
        return this.canManageServer || this.canManageChannels || this.canManageRoles || this.canManageBans || this.canViewAuditLogs || this.canManageEmojisAndStickers || this.isOwnerWithRequiredMFALevel;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public final ManageGuildContext copy(boolean canManageServer, boolean canManageChannels, boolean canManageRoles, boolean canManageBans, boolean canManageNicknames, boolean canManageEmojisAndStickers, boolean canViewAuditLogs, boolean canManageEvents, boolean isOwnerWithRequiredMFALevel) {
        return new ManageGuildContext(canManageServer, canManageChannels, canManageRoles, canManageBans, canManageNicknames, canManageEmojisAndStickers, canViewAuditLogs, canManageEvents, isOwnerWithRequiredMFALevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageGuildContext)) {
            return false;
        }
        ManageGuildContext manageGuildContext = (ManageGuildContext) other;
        return this.canManageServer == manageGuildContext.canManageServer && this.canManageChannels == manageGuildContext.canManageChannels && this.canManageRoles == manageGuildContext.canManageRoles && this.canManageBans == manageGuildContext.canManageBans && this.canManageNicknames == manageGuildContext.canManageNicknames && this.canManageEmojisAndStickers == manageGuildContext.canManageEmojisAndStickers && this.canViewAuditLogs == manageGuildContext.canViewAuditLogs && this.canManageEvents == manageGuildContext.canManageEvents && this.isOwnerWithRequiredMFALevel == manageGuildContext.isOwnerWithRequiredMFALevel;
    }

    public final boolean getCanManageBans() {
        return this.canManageBans;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final boolean getCanManageEmojisAndStickers() {
        return this.canManageEmojisAndStickers;
    }

    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final boolean getCanManageNicknames() {
        return this.canManageNicknames;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getCanManageServer() {
        return this.canManageServer;
    }

    public final boolean getCanViewAuditLogs() {
        return this.canViewAuditLogs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
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
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.canManageServer;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canManageChannels;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canManageRoles;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canManageBans;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.canManageNicknames;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.canManageEmojisAndStickers;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.canViewAuditLogs;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.canManageEvents;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i8 = (i7 + r8) * 31;
        boolean z10 = this.isOwnerWithRequiredMFALevel;
        return i8 + (z10 ? 1 : z10);
    }

    public final boolean isOwnerWithRequiredMFALevel() {
        return this.isOwnerWithRequiredMFALevel;
    }

    public String toString() {
        StringBuilder sbU = a.U("ManageGuildContext(canManageServer=");
        sbU.append(this.canManageServer);
        sbU.append(", canManageChannels=");
        sbU.append(this.canManageChannels);
        sbU.append(", canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", canManageBans=");
        sbU.append(this.canManageBans);
        sbU.append(", canManageNicknames=");
        sbU.append(this.canManageNicknames);
        sbU.append(", canManageEmojisAndStickers=");
        sbU.append(this.canManageEmojisAndStickers);
        sbU.append(", canViewAuditLogs=");
        sbU.append(this.canViewAuditLogs);
        sbU.append(", canManageEvents=");
        sbU.append(this.canManageEvents);
        sbU.append(", isOwnerWithRequiredMFALevel=");
        return a.O(sbU, this.isOwnerWithRequiredMFALevel, ")");
    }
}
