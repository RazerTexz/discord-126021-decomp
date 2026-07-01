package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1$3<T, R> implements b<List<? extends Long>, Observable<? extends Collection<? extends User>>> {
    public final /* synthetic */ StoreVoiceParticipants$getOtherVoiceUsers$1 this$0;

    public StoreVoiceParticipants$getOtherVoiceUsers$1$3(StoreVoiceParticipants$getOtherVoiceUsers$1 storeVoiceParticipants$getOtherVoiceUsers$1) {
        this.this$0 = storeVoiceParticipants$getOtherVoiceUsers$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(List<? extends Long> list) {
        return call2((List<Long>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Collection<User>> call2(List<Long> list) {
        StoreUser users = StoreStream.Companion.getUsers();
        m.checkNotNullExpressionValue(list, "otherMemberIds");
        return users.observeUsers(list).u(new StoreVoiceParticipants$getOtherVoiceUsers$1$3$1(this)).G(StoreVoiceParticipants$getOtherVoiceUsers$1$3$2.INSTANCE);
    }
}
