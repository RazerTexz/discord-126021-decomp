package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import rx.functions.Func2;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$getRenderContext$1<T1, T2, R> implements Func2<Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, HashMap<Long, String>> {
    public static final GuildScheduledEventDescriptionParser$getRenderContext$1 INSTANCE = new GuildScheduledEventDescriptionParser$getRenderContext$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ HashMap<Long, String> call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends String> map2) {
        return call2((Map<Long, GuildMember>) map, (Map<Long, String>) map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final HashMap<Long, String> call2(Map<Long, GuildMember> map, Map<Long, String> map2) {
        m.checkNotNullExpressionValue(map, "members");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, GuildMember> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().getNick() != null) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        HashMap<Long, String> map3 = new HashMap<>(map2);
        for (Map$Entry map$Entry2 : linkedHashMap.entrySet()) {
            Object key = map$Entry2.getKey();
            String nick = ((GuildMember) map$Entry2.getValue()).getNick();
            m.checkNotNull(nick);
            map3.put(key, nick);
        }
        return map3;
    }
}
