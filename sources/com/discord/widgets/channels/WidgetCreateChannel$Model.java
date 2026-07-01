package com.discord.widgets.channels;

import com.discord.api.role.GuildRole;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$Model {
    public static final WidgetCreateChannel$Model$Companion Companion = new WidgetCreateChannel$Model$Companion(null);
    private final boolean canCreate;
    private final boolean canCreateCommunityChannels;
    private final boolean canCreateForumChannels;
    private final boolean canManageRoles;
    private final List<SingleTypePayload<GuildRole>> roleItems;

    private WidgetCreateChannel$Model(boolean z2, boolean z3, boolean z4, boolean z5, List<SingleTypePayload<GuildRole>> list) {
        this.canCreateForumChannels = z2;
        this.canCreate = z3;
        this.canManageRoles = z4;
        this.canCreateCommunityChannels = z5;
        this.roleItems = list;
    }

    public final boolean getCanCreate() {
        return this.canCreate;
    }

    public final boolean getCanCreateCommunityChannels() {
        return this.canCreateCommunityChannels;
    }

    public final boolean getCanCreateForumChannels() {
        return this.canCreateForumChannels;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final List<SingleTypePayload<GuildRole>> getRoleItems() {
        return this.roleItems;
    }

    public /* synthetic */ WidgetCreateChannel$Model(boolean z2, boolean z3, boolean z4, boolean z5, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, z4, z5, list);
    }
}
