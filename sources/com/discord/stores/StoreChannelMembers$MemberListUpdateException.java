package com.discord.stores;

import d0.z.d.m;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$MemberListUpdateException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelMembers$MemberListUpdateException(Exception exc) {
        super(exc);
        m.checkNotNullParameter(exc, "e");
    }
}
