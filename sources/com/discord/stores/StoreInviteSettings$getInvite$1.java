package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInviteSettings$getInvite$1<T, R> implements b<StoreInviteSettings$InviteCode, Observable<? extends StoreInstantInvites$InviteState>> {
    public static final StoreInviteSettings$getInvite$1 INSTANCE = new StoreInviteSettings$getInvite$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StoreInstantInvites$InviteState> call(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode) {
        return call2(storeInviteSettings$InviteCode);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreInstantInvites$InviteState> call2(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode) {
        return storeInviteSettings$InviteCode == null ? new k(null) : StoreStream.Companion.getInstantInvites().observeInvite(ModelInvite.getInviteStoreKey(storeInviteSettings$InviteCode.getInviteCode(), storeInviteSettings$InviteCode.getEventId()));
    }
}
