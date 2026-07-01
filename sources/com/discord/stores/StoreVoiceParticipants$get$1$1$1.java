package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import d0.o;
import java.util.Collection;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1$1$1<T1, T2, R> implements Func2<MeUser, Collection<? extends User>, Pair<? extends MeUser, ? extends Collection<? extends User>>> {
    public static final StoreVoiceParticipants$get$1$1$1 INSTANCE = new StoreVoiceParticipants$get$1$1$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends MeUser, ? extends Collection<? extends User>> call(MeUser meUser, Collection<? extends User> collection) {
        return call2(meUser, collection);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MeUser, Collection<User>> call2(MeUser meUser, Collection<? extends User> collection) {
        return o.to(meUser, collection);
    }
}
