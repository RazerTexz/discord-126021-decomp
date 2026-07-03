package com.discord.widgets.user;

import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: UserMutualGuildsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserMutualGuildsManager {
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreGuildsSorted storeGuildsSorted;

    /* JADX INFO: renamed from: com.discord.widgets.user.UserMutualGuildsManager$observeMutualGuilds$1 */
    /* JADX INFO: compiled from: UserMutualGuildsManager.kt */
    public static final class C101841 extends AbstractC12240o implements Function0<Map<Long, ? extends List<? extends Guild>>> {
        public final /* synthetic */ Collection $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101841(Collection collection) {
            super(0);
            this.$userIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends List<? extends Guild>> invoke() {
            LinkedHashMap<Long, Guild> orderedGuilds = UserMutualGuildsManager.this.storeGuildsSorted.getOrderedGuilds();
            Map<Long, Map<Long, GuildMember>> members = UserMutualGuildsManager.this.storeGuilds.getMembers();
            Collection<Guild> collectionValues = orderedGuilds.values();
            Collection<Number> collection = this.$userIds;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(collection, 10)), 16));
            for (Number number : collection) {
                Long lValueOf = Long.valueOf(number.longValue());
                long jLongValue = number.longValue();
                C12238m.checkNotNullExpressionValue(collectionValues, "guildsList");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    Map map = (Map) C1643a.m847e((Guild) obj, members);
                    if (map != null && map.containsKey(Long.valueOf(jLongValue))) {
                        arrayList.add(obj);
                    }
                }
                linkedHashMap.put(lValueOf, arrayList);
            }
            return linkedHashMap;
        }
    }

    public UserMutualGuildsManager() {
        this(null, null, null, 7, null);
    }

    public UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeGuildsSorted = storeGuildsSorted;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
    }

    public final Observable<Map<Long, List<Guild>>> observeMutualGuilds(Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, List<Guild>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuildsSorted, this.storeGuilds}, false, null, null, new C101841(userIds), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public /* synthetic */ UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
