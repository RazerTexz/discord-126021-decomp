package com.discord.widgets.chat.list.adapter;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.SpotifyListenTogetherEntry;
import d0.d0.f;
import d0.t.d0;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion {
    private WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion() {
    }

    public static final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether$Model access$create(WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion widgetChatListAdapterItemSpotifyListenTogether$Model$Companion, Presence presence, Map map, SpotifyListenTogetherEntry spotifyListenTogetherEntry, boolean z2) {
        return widgetChatListAdapterItemSpotifyListenTogether$Model$Companion.create(presence, map, spotifyListenTogetherEntry, z2);
    }

    private final WidgetChatListAdapterItemSpotifyListenTogether$Model create(Presence presence, Map<Long, ? extends User> userMap, SpotifyListenTogetherEntry item, boolean isMe) {
        ActivityParty party;
        HashMap map = new HashMap();
        for (User user : userMap.values()) {
            map.put(Long.valueOf(user.getId()), new CollapsedUser(user, false, 0L, 6, null));
        }
        if (isMe) {
            MeUser meSnapshot = StoreStream.Companion.getUsers().getMeSnapshot();
            map.put(Long.valueOf(meSnapshot.getId()), new CollapsedUser(meSnapshot, false, 0L, 6, null));
        }
        Activity spotifyListeningActivity = presence != null ? PresenceUtils.INSTANCE.getSpotifyListeningActivity(presence) : null;
        long maxSize = (spotifyListeningActivity == null || (party = spotifyListeningActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
        Collection collectionValues = map.values();
        m.checkNotNullExpressionValue(collectionValues, "collapsedUserMap.values");
        List mutableList = u.toMutableList(collectionValues);
        Iterator<Long> it = f.until(userMap.size(), Math.min(6L, maxSize)).iterator();
        while (it.hasNext()) {
            mutableList.add(CollapsedUser.Companion.createEmptyUser(((d0) it).nextLong() == 5 ? maxSize - 6 : 0L));
        }
        return new WidgetChatListAdapterItemSpotifyListenTogether$Model(presence, mutableList, item, isMe);
    }

    public final Observable<WidgetChatListAdapterItemSpotifyListenTogether$Model> get(SpotifyListenTogetherEntry item) {
        m.checkNotNullParameter(item, "item");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getPresences().observePresenceForUser(item.getUserId()), storeStream$Companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), storeStream$Companion.getUsers().observeMeId(), new WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion$get$1(item));
        m.checkNotNullExpressionValue(observableI, "Observable\n             …m.userId)\n              }");
        Observable<WidgetChatListAdapterItemSpotifyListenTogether$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
