package com.discord.utilities.permissions;

import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageMessageContext$Companion {
    private ManageMessageContext$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    public final ManageMessageContext from(Message message, Long myPermissions, MeUser meUser, Integer guildMfaLevel, boolean isPrivateChannel, boolean isSystemDM, boolean isArchivedThread) {
        boolean z2;
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(meUser, "meUser");
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

    public /* synthetic */ ManageMessageContext$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
