package com.discord.widgets.channels.permissions;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PermissionOwner implements Serializable {
    private final long entityId;

    private PermissionOwner(long j) {
        this.entityId = j;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public /* synthetic */ PermissionOwner(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
