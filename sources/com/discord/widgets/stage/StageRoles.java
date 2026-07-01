package com.discord.widgets.stage;

import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageRoles {
    private static final int AUDIENCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final int IS_INVITED_TO_SPEAK = 4;
    private static final int IS_MODERATOR = 2;
    private static final int IS_SPEAKER = 1;
    private final int rolesFlags;

    /* JADX INFO: compiled from: StageRoles.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: invoke-H48EO60$default, reason: not valid java name */
        public static /* synthetic */ int m36invokeH48EO60$default(Companion companion, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            if ((i & 2) != 0) {
                z3 = false;
            }
            if ((i & 4) != 0) {
                z4 = false;
            }
            return companion.m38invokeH48EO60(z2, z3, z4);
        }

        /* JADX INFO: renamed from: getAUDIENCE-1LxfuJo, reason: not valid java name */
        public final int m37getAUDIENCE1LxfuJo() {
            return StageRoles.AUDIENCE;
        }

        /* JADX INFO: renamed from: invoke-H48EO60, reason: not valid java name */
        public final int m38invokeH48EO60(boolean isSpeaker, boolean isModerator, boolean isInvitedToSpeak) {
            int i = isSpeaker ? 1 : 0;
            if (isModerator) {
                i |= 2;
            }
            if (isInvitedToSpeak) {
                i |= 4;
            }
            return StageRoles.m26constructorimpl(i);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        AUDIENCE = Companion.m36invokeH48EO60$default(companion, false, false, false, 7, null);
    }

    private /* synthetic */ StageRoles(int i) {
        this.rolesFlags = i;
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
        return outline.r("StageRoles(rolesFlags=", i, ")");
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
