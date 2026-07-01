package com.discord.widgets.stage;

import b.d.b.a.a;

/* JADX INFO: compiled from: StageRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageRoles {
    private static final int AUDIENCE;
    public static final StageRoles$Companion Companion;
    private static final int IS_INVITED_TO_SPEAK = 4;
    private static final int IS_MODERATOR = 2;
    private static final int IS_SPEAKER = 1;
    private final int rolesFlags;

    static {
        StageRoles$Companion stageRoles$Companion = new StageRoles$Companion(null);
        Companion = stageRoles$Companion;
        AUDIENCE = StageRoles$Companion.m36invokeH48EO60$default(stageRoles$Companion, false, false, false, 7, null);
    }

    private /* synthetic */ StageRoles(int i) {
        this.rolesFlags = i;
    }

    /* JADX INFO: renamed from: access$getAUDIENCE$cp-1LxfuJo, reason: not valid java name */
    public static final /* synthetic */ int m24access$getAUDIENCE$cp1LxfuJo() {
        return AUDIENCE;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StageRoles m25boximpl(int i) {
        return new StageRoles(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m26constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m27equalsimpl(int i, Object obj) {
        return (obj instanceof StageRoles) && i == ((StageRoles) obj).m35unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m28equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m29hashCodeimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: isAudience-impl, reason: not valid java name */
    public static final boolean m30isAudienceimpl(int i) {
        return (m33isSpeakerimpl(i) || m32isModeratorimpl(i)) ? false : true;
    }

    /* JADX INFO: renamed from: isInvitedToSpeak-impl, reason: not valid java name */
    public static final boolean m31isInvitedToSpeakimpl(int i) {
        return (i & 4) != 0;
    }

    /* JADX INFO: renamed from: isModerator-impl, reason: not valid java name */
    public static final boolean m32isModeratorimpl(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: renamed from: isSpeaker-impl, reason: not valid java name */
    public static final boolean m33isSpeakerimpl(int i) {
        return (i & 1) != 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m34toStringimpl(int i) {
        return a.r("StageRoles(rolesFlags=", i, ")");
    }

    public boolean equals(Object obj) {
        return m27equalsimpl(this.rolesFlags, obj);
    }

    public final int getRolesFlags() {
        return this.rolesFlags;
    }

    public int hashCode() {
        return m29hashCodeimpl(this.rolesFlags);
    }

    public String toString() {
        return m34toStringimpl(this.rolesFlags);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m35unboximpl() {
        return this.rolesFlags;
    }
}
