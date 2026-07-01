package com.discord.models.domain;

/* JADX INFO: loaded from: classes.dex */
public enum ModelInvite$InviteTargetTypes {
    STREAM(1, "Stream"),
    EMBEDDED_APPLICATION(2, "Application"),
    GDM(-1, "GDM Invite"),
    SERVER(-1, "Server Invite");

    private final int code;
    private final String name;

    ModelInvite$InviteTargetTypes(int i, String str) {
        this.code = i;
        this.name = str;
    }

    public static /* synthetic */ int access$000(ModelInvite$InviteTargetTypes modelInvite$InviteTargetTypes) {
        return modelInvite$InviteTargetTypes.code;
    }

    public static /* synthetic */ String access$100(ModelInvite$InviteTargetTypes modelInvite$InviteTargetTypes) {
        return modelInvite$InviteTargetTypes.name;
    }
}
