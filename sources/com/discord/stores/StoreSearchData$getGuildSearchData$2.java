package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.validation.SearchData;
import com.discord.utilities.search.validation.SearchData$Builder;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreSearchData$getGuildSearchData$2 extends k implements Function4<Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, SearchData> {
    public StoreSearchData$getGuildSearchData$2(SearchData$Builder searchData$Builder) {
        super(4, searchData$Builder, SearchData$Builder.class, "buildForGuild", "buildForGuild(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SearchData invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends User> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4) {
        return invoke2((Map<Long, GuildMember>) map, map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SearchData invoke2(Map<Long, GuildMember> map, Map<Long, ? extends User> map2, Map<Long, Channel> map3, Map<Long, Long> map4) {
        m.checkNotNullParameter(map, "p1");
        m.checkNotNullParameter(map2, "p2");
        m.checkNotNullParameter(map3, "p3");
        m.checkNotNullParameter(map4, "p4");
        return ((SearchData$Builder) this.receiver).buildForGuild(map, map2, map3, map4);
    }
}
