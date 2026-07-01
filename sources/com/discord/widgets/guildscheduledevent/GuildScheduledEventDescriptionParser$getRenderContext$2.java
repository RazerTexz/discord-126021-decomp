package com.discord.widgets.guildscheduledevent;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import java.util.HashMap;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$getRenderContext$2<T1, T2, T3, R> implements Func3<Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, GuildScheduledEventDescriptionParser$MessageRenderContextModel> {
    public static final GuildScheduledEventDescriptionParser$getRenderContext$2 INSTANCE = new GuildScheduledEventDescriptionParser$getRenderContext$2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ GuildScheduledEventDescriptionParser$MessageRenderContextModel call(Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
        return call2((Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildScheduledEventDescriptionParser$MessageRenderContextModel call2(Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
        return new GuildScheduledEventDescriptionParser$MessageRenderContextModel(map, map2, map3);
    }
}
