package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.d0.f;
import d0.t.g0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserMutualGuildsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserMutualGuildsManager$observeMutualGuilds$1 extends o implements Function0<Map<Long, ? extends List<? extends Guild>>> {
    public final /* synthetic */ Collection $userIds;
    public final /* synthetic */ UserMutualGuildsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMutualGuildsManager$observeMutualGuilds$1(UserMutualGuildsManager userMutualGuildsManager, Collection collection) {
        super(0);
        this.this$0 = userMutualGuildsManager;
        this.$userIds = collection;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Guild>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends List<? extends Guild>> invoke2() {
        LinkedHashMap<Long, Guild> orderedGuilds = UserMutualGuildsManager.access$getStoreGuildsSorted$p(this.this$0).getOrderedGuilds();
        Map<Long, Map<Long, GuildMember>> members = UserMutualGuildsManager.access$getStoreGuilds$p(this.this$0).getMembers();
        Collection<Guild> collectionValues = orderedGuilds.values();
        Collection<Number> collection = this.$userIds;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(collection, 10)), 16));
        for (Number number : collection) {
            Long lValueOf = Long.valueOf(number.longValue());
            long jLongValue = number.longValue();
            m.checkNotNullExpressionValue(collectionValues, "guildsList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                Map map = (Map) a.e((Guild) obj, members);
                if (map != null && map.containsKey(Long.valueOf(jLongValue))) {
                    arrayList.add(obj);
                }
            }
            linkedHashMap.put(lValueOf, arrayList);
        }
        return linkedHashMap;
    }
}
