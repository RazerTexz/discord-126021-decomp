package com.discord.utilities.permissions;

import com.discord.models.message.Message;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionsContextsKt {
    private static final Set<Integer> DELETEABLE_MESSAGE_TYPES = n0.setOf((Object[]) new Integer[]{0, 6, 7, 8, 9, 10, 11, 12, 18, 19, 20, 22, 23, 25});

    public static final Set<Integer> getDELETEABLE_MESSAGE_TYPES() {
        return DELETEABLE_MESSAGE_TYPES;
    }

    public static final boolean isDeleteable(Message message) {
        m.checkNotNullParameter(message, "$this$isDeleteable");
        return u.contains(DELETEABLE_MESSAGE_TYPES, message.getType()) || message.isLocal();
    }
}
