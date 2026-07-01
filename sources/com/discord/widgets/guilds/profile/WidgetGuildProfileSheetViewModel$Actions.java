package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$Actions {
    private final boolean canChangeNickname;
    private final boolean canLeaveGuild;
    private final boolean canManageChannels;
    private final boolean canManageEvents;
    private final boolean displayGuildIdentityRow;
    private final String guildAvatar;
    private final boolean hideMutedChannels;
    private final boolean isAllowDMChecked;
    private final boolean isDeveloper;
    private final boolean isUnread;
    private final String nick;
    private final String username;

    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    public WidgetGuildProfileSheetViewModel$Actions(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3) {
        boolean z10;
        m.checkNotNullParameter(str3, "username");
        this.isUnread = z2;
        this.canManageChannels = z3;
        this.canManageEvents = z4;
        this.canChangeNickname = z5;
        this.nick = str;
        this.guildAvatar = str2;
        this.isAllowDMChecked = z6;
        this.hideMutedChannels = z7;
        this.canLeaveGuild = z8;
        this.isDeveloper = z9;
        this.username = str3;
        if (str == null || str.length() == 0) {
            z10 = str2 == null || str2.length() == 0 ? false : true;
        }
        this.displayGuildIdentityRow = z10;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$Actions copy$default(WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3, int i, Object obj) {
        return widgetGuildProfileSheetViewModel$Actions.copy((i & 1) != 0 ? widgetGuildProfileSheetViewModel$Actions.isUnread : z2, (i & 2) != 0 ? widgetGuildProfileSheetViewModel$Actions.canManageChannels : z3, (i & 4) != 0 ? widgetGuildProfileSheetViewModel$Actions.canManageEvents : z4, (i & 8) != 0 ? widgetGuildProfileSheetViewModel$Actions.canChangeNickname : z5, (i & 16) != 0 ? widgetGuildProfileSheetViewModel$Actions.nick : str, (i & 32) != 0 ? widgetGuildProfileSheetViewModel$Actions.guildAvatar : str2, (i & 64) != 0 ? widgetGuildProfileSheetViewModel$Actions.isAllowDMChecked : z6, (i & 128) != 0 ? widgetGuildProfileSheetViewModel$Actions.hideMutedChannels : z7, (i & 256) != 0 ? widgetGuildProfileSheetViewModel$Actions.canLeaveGuild : z8, (i & 512) != 0 ? widgetGuildProfileSheetViewModel$Actions.isDeveloper : z9, (i & 1024) != 0 ? widgetGuildProfileSheetViewModel$Actions.username : str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsUnread() {
        return this.isUnread;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsDeveloper() {
        return this.isDeveloper;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGuildAvatar() {
        return this.guildAvatar;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsAllowDMChecked() {
        return this.isAllowDMChecked;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanLeaveGuild() {
        return this.canLeaveGuild;
    }

    public final WidgetGuildProfileSheetViewModel$Actions copy(boolean isUnread, boolean canManageChannels, boolean canManageEvents, boolean canChangeNickname, String nick, String guildAvatar, boolean isAllowDMChecked, boolean hideMutedChannels, boolean canLeaveGuild, boolean isDeveloper, String username) {
        m.checkNotNullParameter(username, "username");
        return new WidgetGuildProfileSheetViewModel$Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, guildAvatar, isAllowDMChecked, hideMutedChannels, canLeaveGuild, isDeveloper, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$Actions)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions = (WidgetGuildProfileSheetViewModel$Actions) other;
        return this.isUnread == widgetGuildProfileSheetViewModel$Actions.isUnread && this.canManageChannels == widgetGuildProfileSheetViewModel$Actions.canManageChannels && this.canManageEvents == widgetGuildProfileSheetViewModel$Actions.canManageEvents && this.canChangeNickname == widgetGuildProfileSheetViewModel$Actions.canChangeNickname && m.areEqual(this.nick, widgetGuildProfileSheetViewModel$Actions.nick) && m.areEqual(this.guildAvatar, widgetGuildProfileSheetViewModel$Actions.guildAvatar) && this.isAllowDMChecked == widgetGuildProfileSheetViewModel$Actions.isAllowDMChecked && this.hideMutedChannels == widgetGuildProfileSheetViewModel$Actions.hideMutedChannels && this.canLeaveGuild == widgetGuildProfileSheetViewModel$Actions.canLeaveGuild && this.isDeveloper == widgetGuildProfileSheetViewModel$Actions.isDeveloper && m.areEqual(this.username, widgetGuildProfileSheetViewModel$Actions.username);
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final boolean getCanLeaveGuild() {
        return this.canLeaveGuild;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final boolean getCanManageEvents() {
        return this.canManageEvents;
    }

    public final boolean getDisplayGuildIdentityRow() {
        return this.displayGuildIdentityRow;
    }

    public final String getGuildAvatar() {
        return this.guildAvatar;
    }

    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final String getNick() {
        return this.nick;
    }

    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
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
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public int hashCode() {
        boolean z2 = this.isUnread;
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
        boolean z4 = this.canManageEvents;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canChangeNickname;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        String str = this.nick;
        int iHashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildAvatar;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z6 = this.isAllowDMChecked;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (iHashCode2 + r5) * 31;
        boolean z7 = this.hideMutedChannels;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.canLeaveGuild;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.isDeveloper;
        int i8 = (i7 + (z9 ? 1 : z9)) * 31;
        String str3 = this.username;
        return i8 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isAllowDMChecked() {
        return this.isAllowDMChecked;
    }

    public final boolean isDeveloper() {
        return this.isDeveloper;
    }

    public final boolean isUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("Actions(isUnread=");
        sbU.append(this.isUnread);
        sbU.append(", canManageChannels=");
        sbU.append(this.canManageChannels);
        sbU.append(", canManageEvents=");
        sbU.append(this.canManageEvents);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", guildAvatar=");
        sbU.append(this.guildAvatar);
        sbU.append(", isAllowDMChecked=");
        sbU.append(this.isAllowDMChecked);
        sbU.append(", hideMutedChannels=");
        sbU.append(this.hideMutedChannels);
        sbU.append(", canLeaveGuild=");
        sbU.append(this.canLeaveGuild);
        sbU.append(", isDeveloper=");
        sbU.append(this.isDeveloper);
        sbU.append(", username=");
        return a.J(sbU, this.username, ")");
    }
}
