package com.discord.utilities.permissions;

import com.discord.models.message.Message;
import java.util.Set;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionsContextsKt {
    private static final Set<Integer> DELETEABLE_MESSAGE_TYPES = C12148n0.setOf((Object[]) new Integer[]{0, 6, 7, 8, 9, 10, 11, 12, 18, 19, 20, 22, 23, 25});

    public static final Set<Integer> getDELETEABLE_MESSAGE_TYPES() {
        return DELETEABLE_MESSAGE_TYPES;
    }

    public static final boolean isDeleteable(Message message) {
        C12238m.checkNotNullParameter(message, "$this$isDeleteable");
        return C12163u.contains(DELETEABLE_MESSAGE_TYPES, message.getType()) || message.isLocal();
    }
}
