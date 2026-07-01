package com.discord.widgets.stage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageRoles$Companion {
    private StageRoles$Companion() {
    }

    /* JADX INFO: renamed from: invoke-H48EO60$default, reason: not valid java name */
    public static /* synthetic */ int m36invokeH48EO60$default(StageRoles$Companion stageRoles$Companion, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = false;
        }
        if ((i & 4) != 0) {
            z4 = false;
        }
        return stageRoles$Companion.m38invokeH48EO60(z2, z3, z4);
    }

    /* JADX INFO: renamed from: getAUDIENCE-1LxfuJo, reason: not valid java name */
    public final int m37getAUDIENCE1LxfuJo() {
        return StageRoles.m24access$getAUDIENCE$cp1LxfuJo();
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

    public /* synthetic */ StageRoles$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
