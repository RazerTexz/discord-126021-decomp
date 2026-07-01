package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants extends Store {
    private final BehaviorSubject<Long> selectedParticipantSubject;
    private final StoreStream stream;

    public StoreVoiceParticipants(StoreStream storeStream) {
        m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.selectedParticipantSubject = BehaviorSubject.l0(0L);
    }

    public static final /* synthetic */ Map access$create(StoreVoiceParticipants storeVoiceParticipants, MeUser meUser, Collection collection, Map map, Set set, Collection collection2, Map map2, Map map3, Map map4, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration, Map map5) {
        return storeVoiceParticipants.create(meUser, collection, map, set, collection2, map2, map3, map4, storeMediaSettings$VoiceConfiguration, map5);
    }

    public static final /* synthetic */ Observable access$getOtherVoiceUsers(StoreVoiceParticipants storeVoiceParticipants, Channel channel, Map map) {
        return storeVoiceParticipants.getOtherVoiceUsers(channel, map);
    }

    public static final /* synthetic */ Observable access$getStreamContextsForUsers(StoreVoiceParticipants storeVoiceParticipants, List list) {
        return storeVoiceParticipants.getStreamContextsForUsers(list);
    }

    private final Map<Long, StoreVoiceParticipants$VoiceUser> create(MeUser meUser, Collection<? extends User> otherUsers, Map<Long, VoiceState> voiceStates, Set<Long> speakingUsers, Collection<Long> ringingUsers, Map<Long, StoreVideoStreams$UserStreams> videoStreams, Map<Long, GuildMember> guildMembers, Map<String, ? extends List<Long>> streamSpectators, StoreMediaSettings$VoiceConfiguration voiceConfiguration, Map<Long, StreamContext> streamContexts) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map$Entry<String, ? extends List<Long>> map$Entry : streamSpectators.entrySet()) {
            if (map$Entry.getValue().contains(Long.valueOf(meUser.getId()))) {
                linkedHashMap2.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map$Entry) it.next()).getKey());
        }
        String str = (String) u.firstOrNull((List) arrayList);
        VoiceState voiceState = voiceStates.get(Long.valueOf(meUser.getId()));
        boolean zContains = ringingUsers.contains(Long.valueOf(meUser.getId()));
        StoreVideoStreams$UserStreams storeVideoStreams$UserStreams = videoStreams.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember = guildMembers.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = guildMembers.get(Long.valueOf(meUser.getId()));
        linkedHashMap.put(Long.valueOf(meUser.getId()), new StoreVoiceParticipants$VoiceUser(meUser, voiceState, zContains, storeVideoStreams$UserStreams, true, guildMember, str, null, (guildMember2 != null ? guildMember2.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(meUser.getId()))));
        ArrayList<StoreVoiceParticipants$VoiceUser> arrayList2 = new ArrayList(o.collectionSizeOrDefault(otherUsers, 10));
        for (User user : otherUsers) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map$Entry<String, ? extends List<Long>> map$Entry2 : streamSpectators.entrySet()) {
                if (map$Entry2.getValue().contains(Long.valueOf(user.getId()))) {
                    linkedHashMap3.put(map$Entry2.getKey(), map$Entry2.getValue());
                }
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap3.size());
            Iterator it2 = linkedHashMap3.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList3.add((String) ((Map$Entry) it2.next()).getKey());
            }
            String str2 = (String) u.firstOrNull((List) arrayList3);
            VoiceState voiceState2 = (VoiceState) a.f(user, voiceStates);
            boolean zContains2 = ringingUsers.contains(Long.valueOf(user.getId()));
            StoreVideoStreams$UserStreams storeVideoStreams$UserStreams2 = (StoreVideoStreams$UserStreams) a.f(user, videoStreams);
            GuildMember guildMember3 = (GuildMember) a.f(user, guildMembers);
            StreamContext streamContext = (StreamContext) a.f(user, streamContexts);
            GuildMember guildMember4 = (GuildMember) a.f(user, guildMembers);
            arrayList2.add(new StoreVoiceParticipants$VoiceUser(user, voiceState2, zContains2, storeVideoStreams$UserStreams2, false, guildMember3, str2, streamContext, (guildMember4 != null ? guildMember4.getPremiumSince() : null) != null, voiceConfiguration, speakingUsers.contains(Long.valueOf(user.getId()))));
        }
        for (StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser : arrayList2) {
            linkedHashMap.put(Long.valueOf(storeVoiceParticipants$VoiceUser.getUser().getId()), storeVoiceParticipants$VoiceUser);
        }
        return linkedHashMap;
    }

    private final Observable<Collection<User>> getOtherVoiceUsers(Channel channel, Map<Long, VoiceState> voiceStates) {
        if (ChannelUtils.B(channel)) {
            k kVar = new k(ChannelUtils.g(channel));
            m.checkNotNullExpressionValue(kVar, "Observable.just(channel.getRecipients())");
            return kVar;
        }
        if (ChannelUtils.w(channel)) {
            Observable observableY = StoreStream.Companion.getUsers().observeMeId().Y(new StoreVoiceParticipants$getOtherVoiceUsers$1(channel, voiceStates));
            m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            return observableY;
        }
        k kVar2 = new k(n.emptyList());
        m.checkNotNullExpressionValue(kVar2, "Observable.just(emptyList())");
        return kVar2;
    }

    private final Observable<Map<Long, StreamContext>> getStreamContextsForUsers(List<Long> userIds) {
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(userIds, 10));
        for (Iterator it = userIds.iterator(); it.hasNext(); it = it) {
            arrayList.add(new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForUser(((Number) it.next()).longValue(), true));
        }
        Observable<Map<Long, StreamContext>> observableB = Observable.b(arrayList, new StoreVoiceParticipants$getStreamContextsForUsers$1(userIds));
        m.checkNotNullExpressionValue(observableB, "Observable\n        .comb…}\n          map\n        }");
        return observableB;
    }

    public final Observable<Map<Long, StoreVoiceParticipants$VoiceUser>> get(long channelId) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeChannel(channelId).Y(new StoreVoiceParticipants$get$1(this, channelId));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…  }\n          }\n        }");
        Observable<Map<Long, StoreVoiceParticipants$VoiceUser>> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        return observableR;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getVoiceChannelSelected().observeSelectedVoiceChannelId(), StoreVoiceParticipants.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreVoiceParticipants$init$1(this), 62, (Object) null);
    }

    public final void selectParticipant(Long userId) {
        this.selectedParticipantSubject.onNext(userId);
    }
}
