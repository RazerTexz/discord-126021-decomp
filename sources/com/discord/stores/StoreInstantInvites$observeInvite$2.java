package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$observeInvite$2<T, R> implements b<Map<String, ? extends StoreInstantInvites$InviteState>, StoreInstantInvites$InviteState> {
    public final /* synthetic */ String $inviteKey;

    public StoreInstantInvites$observeInvite$2(String str) {
        this.$inviteKey = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreInstantInvites$InviteState call(Map<String, ? extends StoreInstantInvites$InviteState> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreInstantInvites$InviteState call2(Map<String, ? extends StoreInstantInvites$InviteState> map) {
        StoreInstantInvites$InviteState storeInstantInvites$InviteState = map.get(this.$inviteKey);
        return storeInstantInvites$InviteState != null ? storeInstantInvites$InviteState : StoreInstantInvites$InviteState$Loading.INSTANCE;
    }
}
