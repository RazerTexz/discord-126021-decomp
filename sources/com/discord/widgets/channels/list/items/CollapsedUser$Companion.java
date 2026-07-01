package com.discord.widgets.channels.list.items;

import com.discord.utilities.user.UserUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CollapsedUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CollapsedUser$Companion {
    private CollapsedUser$Companion() {
    }

    public static /* synthetic */ CollapsedUser createEmptyUser$default(CollapsedUser$Companion collapsedUser$Companion, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return collapsedUser$Companion.createEmptyUser(j);
    }

    public final CollapsedUser createEmptyUser(long extraCount) {
        return new CollapsedUser(UserUtils.INSTANCE.getEMPTY_USER(), true, Math.min(99L, extraCount));
    }

    public /* synthetic */ CollapsedUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
