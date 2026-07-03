package com.discord.utilities.permissions;

import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ManageMessageContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canAddReactions;
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canManageMessages;
    private final boolean canMarkUnread;
    private final boolean canTogglePinned;

    /* JADX INFO: compiled from: PermissionsContexts.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:48:0x0082  */
        public final ManageMessageContext from(Message message, Long myPermissions, MeUser meUser, Integer guildMfaLevel, boolean isPrivateChannel, boolean isSystemDM, boolean isArchivedThread) {
            boolean z2;
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(meUser, "meUser");
            boolean zIsUserMessage = message.isUserMessage();
            User author = message.getAuthor();
            boolean z3 = false;
            boolean z4 = author != null && author.getId() == meUser.getId();
            boolean z5 = isPrivateChannel && !isSystemDM;
            boolean z6 = (guildMfaLevel == null || !PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, myPermissions, meUser.getMfaEnabled(), guildMfaLevel.intValue()) || isArchivedThread) ? false : true;
            boolean z7 = z6 || z5;
            boolean z8 = z6 || z4;
            if (z4 && zIsUserMessage) {
                List<Sticker> stickers = message.getStickers();
                if (stickers == null || stickers.isEmpty()) {
                    List<StickerPartial> stickerItems = message.getStickerItems();
                    if (!(stickerItems == null || stickerItems.isEmpty()) || isArchivedThread) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            boolean z9 = z8 && !isArchivedThread && PermissionsContextsKt.isDeleteable(message);
            boolean z10 = !message.isLocal() && (z5 || PermissionUtils.can(64L, myPermissions)) && !isArchivedThread;
            if (z7 && zIsUserMessage && !isSystemDM && !isArchivedThread) {
                z3 = true;
            }
            return new ManageMessageContext(z6, z2, z9, z10, z3, !isArchivedThread);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ManageMessageContext(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.canManageMessages = z2;
        this.canEdit = z3;
        this.canDelete = z4;
        this.canAddReactions = z5;
        this.canTogglePinned = z6;
        this.canMarkUnread = z7;
    }

    public static /* synthetic */ ManageMessageContext copy$default(ManageMessageContext manageMessageContext, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = manageMessageContext.canManageMessages;
        }
        if ((i & 2) != 0) {
            z3 = manageMessageContext.canEdit;
        }
        boolean z8 = z3;
        if ((i & 4) != 0) {
            z4 = manageMessageContext.canDelete;
        }
        boolean z9 = z4;
        if ((i & 8) != 0) {
            z5 = manageMessageContext.canAddReactions;
        }
        boolean z10 = z5;
        if ((i & 16) != 0) {
            z6 = manageMessageContext.canTogglePinned;
        }
        boolean z11 = z6;
        if ((i & 32) != 0) {
            z7 = manageMessageContext.canMarkUnread;
        }
        return manageMessageContext.copy(z2, z8, z9, z10, z11, z7);
    }

    public static final ManageMessageContext from(Message message, Long l, MeUser meUser, Integer num, boolean z2, boolean z3, boolean z4) {
        return INSTANCE.from(message, l, meUser, num, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final ManageMessageContext copy(boolean canManageMessages, boolean canEdit, boolean canDelete, boolean canAddReactions, boolean canTogglePinned, boolean canMarkUnread) {
        return new ManageMessageContext(canManageMessages, canEdit, canDelete, canAddReactions, canTogglePinned, canMarkUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageMessageContext)) {
            return false;
        }
        ManageMessageContext manageMessageContext = (ManageMessageContext) other;
        return this.canManageMessages == manageMessageContext.canManageMessages && this.canEdit == manageMessageContext.canEdit && this.canDelete == manageMessageContext.canDelete && this.canAddReactions == manageMessageContext.canAddReactions && this.canTogglePinned == manageMessageContext.canTogglePinned && this.canMarkUnread == manageMessageContext.canMarkUnread;
    }

    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.canManageMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canEdit;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canDelete;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canAddReactions;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.canTogglePinned;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.canMarkUnread;
        return i5 + (z7 ? 1 : z7);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ManageMessageContext(canManageMessages=");
        sbM833U.append(this.canManageMessages);
        sbM833U.append(", canEdit=");
        sbM833U.append(this.canEdit);
        sbM833U.append(", canDelete=");
        sbM833U.append(this.canDelete);
        sbM833U.append(", canAddReactions=");
        sbM833U.append(this.canAddReactions);
        sbM833U.append(", canTogglePinned=");
        sbM833U.append(this.canTogglePinned);
        sbM833U.append(", canMarkUnread=");
        return C1643a.m827O(sbM833U, this.canMarkUnread, ")");
    }
}
