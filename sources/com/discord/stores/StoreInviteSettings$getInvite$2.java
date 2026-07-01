package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.b;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$getInvite$2<T, R> implements b<StoreInstantInvites$InviteState, ModelInvite> {
    public static final StoreInviteSettings$getInvite$2 INSTANCE = new StoreInviteSettings$getInvite$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ModelInvite call(StoreInstantInvites$InviteState storeInstantInvites$InviteState) {
        return call2(storeInstantInvites$InviteState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ModelInvite call2(StoreInstantInvites$InviteState storeInstantInvites$InviteState) {
        if (storeInstantInvites$InviteState instanceof StoreInstantInvites$InviteState$Resolved) {
            return ((StoreInstantInvites$InviteState$Resolved) storeInstantInvites$InviteState).getInvite();
        }
        return null;
    }
}
