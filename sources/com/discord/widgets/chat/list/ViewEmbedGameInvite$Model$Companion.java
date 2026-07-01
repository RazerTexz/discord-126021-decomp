package com.discord.widgets.chat.list;

import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.d0.f;
import d0.g0.s;
import d0.t.d0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ViewEmbedGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewEmbedGameInvite$Model$Companion {
    private ViewEmbedGameInvite$Model$Companion() {
    }

    public static final /* synthetic */ ViewEmbedGameInvite$Model access$create(ViewEmbedGameInvite$Model$Companion viewEmbedGameInvite$Model$Companion, GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map map) {
        return viewEmbedGameInvite$Model$Companion.create(gameInviteEntry, meUser, application, activity, map);
    }

    public static final /* synthetic */ ViewEmbedGameInvite$Model access$createForShare(ViewEmbedGameInvite$Model$Companion viewEmbedGameInvite$Model$Companion, MeUser meUser, long j, MessageActivity messageActivity, Activity activity, Map map, Application application) {
        return viewEmbedGameInvite$Model$Companion.createForShare(meUser, j, messageActivity, activity, map, application);
    }

    private final ViewEmbedGameInvite$Model create(GameInviteEntry item, MeUser meUser, Application application, Activity gameActivity, Map<Long, ? extends User> userMap) {
        return new ViewEmbedGameInvite$Model(meUser, item.getAuthorId(), SnowflakeUtils.DISCORD_EPOCH + (item.getMessageId() >>> 22), application != null ? application : item.getApplication(), item.getActivity(), gameActivity, createPartyUsers(userMap, gameActivity));
    }

    private final ViewEmbedGameInvite$Model createForShare(MeUser meUser, long creationTime, MessageActivity msgActivity, Activity gameActivity, Map<Long, ? extends User> userMap, Application application) {
        if (application != null) {
            return new ViewEmbedGameInvite$Model(meUser, meUser.getId(), creationTime, application, msgActivity, gameActivity, createPartyUsers(userMap, gameActivity));
        }
        return null;
    }

    private final ArrayList<CollapsedUser> createPartyUsers(Map<Long, ? extends User> userMap, Activity gameActivity) {
        ActivityParty party;
        ArrayList<CollapsedUser> arrayList = new ArrayList<>();
        Iterator<T> it = userMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(new CollapsedUser((User) it.next(), false, 0L, 6, null));
        }
        long maxSize = (gameActivity == null || (party = gameActivity.getParty()) == null) ? 0L : PresenceUtils.INSTANCE.getMaxSize(party);
        Iterator<Long> it2 = f.until(userMap.size(), Math.min(4L, maxSize)).iterator();
        while (it2.hasNext()) {
            arrayList.add(CollapsedUser.Companion.createEmptyUser(((d0) it2).nextLong() == 3 ? maxSize - 4 : 0L));
        }
        return arrayList;
    }

    public final Observable<ViewEmbedGameInvite$Model> get(GameInviteEntry item) {
        m.checkNotNullParameter(item, "item");
        k kVar = new k(item);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableG = Observable.g(kVar, StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getApplication().observeApplication(Long.valueOf(item.getApplication().getId())), storeStream$Companion.getPresences().observeApplicationActivity(item.getAuthorId(), item.getApplication().getId()), storeStream$Companion.getGameParty().observeUsersForPartyId(item.getActivity().getPartyId()), new ViewEmbedGameInvite$sam$rx_functions_Func5$0(new ViewEmbedGameInvite$Model$Companion$get$1(this)));
        m.checkNotNullExpressionValue(observableG, "Observable\n            .…   ::create\n            )");
        Observable<ViewEmbedGameInvite$Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<ViewEmbedGameInvite$Model> getForShare(Clock clock, Uri shareUri, Activity activity) {
        m.checkNotNullParameter(clock, "clock");
        if (shareUri == null) {
            k kVar = new k(null);
            m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
            return kVar;
        }
        String queryParameter = shareUri.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID);
        Long longOrNull = queryParameter != null ? s.toLongOrNull(queryParameter) : null;
        String queryParameter2 = shareUri.getQueryParameter("party_id");
        String queryParameter3 = shareUri.getQueryParameter("type");
        Integer intOrNull = queryParameter3 != null ? s.toIntOrNull(queryParameter3) : null;
        if (longOrNull == null || queryParameter2 == null || intOrNull == null || (!m.areEqual(shareUri.getPath(), "/send/activity"))) {
            Logger.w$default(AppLog.g, "Malformed Share URI: " + shareUri, null, 2, null);
            k kVar2 = new k(null);
            m.checkNotNullExpressionValue(kVar2, "Observable.just(null)");
            return kVar2;
        }
        MessageActivity messageActivity = new MessageActivity(MessageActivityType.Companion.a(intOrNull), queryParameter2);
        k kVar3 = new k(activity);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableF = Observable.f(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), new k(Long.valueOf(clock.currentTimeMillis())), new k(messageActivity), Observable.m(kVar3, storeStream$Companion.getUsers().observeMeId().Y(new ViewEmbedGameInvite$Model$Companion$getForShare$activityObs$1(longOrNull, queryParameter2))), storeStream$Companion.getGameParty().observeUsersForPartyId(messageActivity.getPartyId()), storeStream$Companion.getApplication().observeApplication(longOrNull), new ViewEmbedGameInvite$sam$rx_functions_Func6$0(new ViewEmbedGameInvite$Model$Companion$getForShare$1(this)));
        m.checkNotNullExpressionValue(observableF, "Observable\n            .…ateForShare\n            )");
        Observable<ViewEmbedGameInvite$Model> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ ViewEmbedGameInvite$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
