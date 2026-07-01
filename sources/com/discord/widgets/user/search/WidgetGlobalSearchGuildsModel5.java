package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$create$guildItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel5 extends Lambda implements Function1<Long, Guild> {
    public final /* synthetic */ Map $guilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel5(Map map) {
        super(1);
        this.$guilds = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Guild invoke(long j) {
        return (Guild) this.$guilds.get(Long.valueOf(j));
    }
}
