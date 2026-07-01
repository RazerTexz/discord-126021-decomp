package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$initClearCommunicationDisabledObserver$1<T1, T2, R> implements Func2<List<? extends GuildMember>, Long, List<? extends GuildMember>> {
    public static final StoreGuilds$initClearCommunicationDisabledObserver$1 INSTANCE = new StoreGuilds$initClearCommunicationDisabledObserver$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends GuildMember> call(List<? extends GuildMember> list, Long l) {
        return call2((List<GuildMember>) list, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<GuildMember> call2(List<GuildMember> list, Long l) {
        ArrayList arrayListA0 = a.a0(list, "members");
        for (Object obj : list) {
            if (!((GuildMember) obj).isCommunicationDisabled()) {
                arrayListA0.add(obj);
            }
        }
        return arrayListA0;
    }
}
