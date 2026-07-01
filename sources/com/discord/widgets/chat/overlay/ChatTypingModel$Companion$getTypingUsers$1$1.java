package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel$Companion$getTypingUsers$1$1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends String>> {
    public static final ChatTypingModel$Companion$getTypingUsers$1$1 INSTANCE = new ChatTypingModel$Companion$getTypingUsers$1$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends String> call(Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2) {
        return call2(map, (Map<Long, GuildMember>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<String> call2(Map<Long, ? extends User> map, Map<Long, GuildMember> map2) {
        Collection<? extends User> collectionValues = map.values();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
        for (User user : collectionValues) {
            arrayList.add(GuildMember.Companion.getNickOrUsername((GuildMember) a.f(user, map2), user));
        }
        return arrayList;
    }
}
