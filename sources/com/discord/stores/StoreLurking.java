package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIInterface$DefaultImpls;
import com.discord.restapi.RestAPIParams$InviteCode;
import com.discord.restapi.RestAPIParams$LeaveGuildBody;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking {
    public static final StoreLurking$Companion Companion = new StoreLurking$Companion(null);
    private final Dispatcher dispatcher;
    private final StoreGuilds guildsStore;
    private StoreLurking$LurkRequest lurkRequest;
    private final Map<Long, StoreLurking$LurkContext> lurkedGuilds;
    private final BehaviorSubject<Map<Long, StoreLurking$LurkContext>> lurkedGuildsSubject;
    private String sessionId;
    private final StoreStream stream;

    public StoreLurking(StoreStream storeStream, StoreGuilds storeGuilds, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.lurkedGuilds = new LinkedHashMap();
        this.lurkedGuildsSubject = BehaviorSubject.l0(new LinkedHashMap());
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreLurking storeLurking) {
        return storeLurking.dispatcher;
    }

    public static final /* synthetic */ StoreLurking$LurkRequest access$getLurkRequest$p(StoreLurking storeLurking) {
        return storeLurking.lurkRequest;
    }

    public static final /* synthetic */ Map access$getLurkedGuilds$p(StoreLurking storeLurking) {
        return storeLurking.lurkedGuilds;
    }

    public static final /* synthetic */ BehaviorSubject access$getLurkedGuildsSubject$p(StoreLurking storeLurking) {
        return storeLurking.lurkedGuildsSubject;
    }

    public static final /* synthetic */ String access$getSessionId$p(StoreLurking storeLurking) {
        return storeLurking.sessionId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreLurking storeLurking) {
        return storeLurking.stream;
    }

    public static final /* synthetic */ void access$setLurkRequest$p(StoreLurking storeLurking, StoreLurking$LurkRequest storeLurking$LurkRequest) {
        storeLurking.lurkRequest = storeLurking$LurkRequest;
    }

    public static final /* synthetic */ void access$setSessionId$p(StoreLurking storeLurking, String str) {
        storeLurking.sessionId = str;
    }

    private final void postLeaveGuild(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().leaveGuild(guildId, new RestAPIParams$LeaveGuildBody(true)), false, 1, null), StoreLurking.class, (Context) null, (Function1) null, new StoreLurking$postLeaveGuild$3(onFailure), (Function0) null, (Function0) null, new StoreLurking$postLeaveGuild$4(onSuccess), 54, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postLeaveGuild$default(StoreLurking storeLurking, long j, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = StoreLurking$postLeaveGuild$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = StoreLurking$postLeaveGuild$2.INSTANCE;
        }
        storeLurking.postLeaveGuild(j, function0, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startLurking$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z2;
        if ((i & 8) != 0) {
            function3 = StoreLurking$startLurking$1.INSTANCE;
        }
        Function3 function4 = function3;
        if ((i & 16) != 0) {
            function0 = StoreLurking$startLurking$2.INSTANCE;
        }
        storeLurking.startLurking(j, l, z3, function4, function0);
    }

    public static /* synthetic */ void startLurkingAndNavigate$default(StoreLurking storeLurking, long j, Long l, Context context, int i, Object obj) {
        if ((i & 4) != 0) {
            context = null;
        }
        storeLurking.startLurkingAndNavigate(j, l, context);
    }

    @StoreThread
    private final void startLurkingInternal(long guildId, Long channelId, boolean navigateToGuild, Function3<? super Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking, Context context) {
        if (this.sessionId == null) {
            Logger.w$default(AppLog.g, "Cannot lurk " + guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + channelId + " with no session", null, 2, null);
            onErrorLurking.invoke();
            return;
        }
        if (guildId != 0 || guildId == -1) {
            Guild guild = this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
            if (guild != null && !isLurking$app_productionGoogleRelease(guild)) {
                onGuildLurked.invoke(guild, channelId, Boolean.TRUE);
                return;
            }
            this.lurkedGuilds.put(Long.valueOf(guildId), new StoreLurking$LurkContext(guildId, navigateToGuild));
            this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface$DefaultImpls.joinGuild$default(RestAPI.Companion.getApi(), guildId, true, this.sessionId, null, new RestAPIParams$InviteCode(null, null), null, 32, null), false, 1, null)), StoreLurking.class, context, (Function1) null, new StoreLurking$startLurkingInternal$3(this, guildId), (Function0) null, (Function0) null, new StoreLurking$startLurkingInternal$4(this, guildId, onGuildLurked, channelId), 52, (Object) null);
            return;
        }
        Logger.w$default(AppLog.g, "Invalid ids for lurking " + guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + channelId, null, 2, null);
        onErrorLurking.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startLurkingInternal$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, Context context, int i, Object obj) {
        storeLurking.startLurkingInternal(j, l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? StoreLurking$startLurkingInternal$1.INSTANCE : function3, (i & 16) != 0 ? StoreLurking$startLurkingInternal$2.INSTANCE : function0, (i & 32) != 0 ? null : context);
    }

    @StoreThread
    private final void stopLurkingInternal(long guildId) {
        if (this.lurkedGuilds.remove(Long.valueOf(guildId)) != null) {
            this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
        }
    }

    public final Observable<Set<Long>> getLurkingGuildIds() {
        Observable observableG = this.lurkedGuildsSubject.G(StoreLurking$getLurkingGuildIds$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "lurkedGuildsSubject.map { it.keys }");
        return observableG;
    }

    public final Set<Long> getLurkingGuildIdsSync() {
        return this.lurkedGuilds.keySet();
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        StoreLurking$LurkRequest storeLurking$LurkRequest = this.lurkRequest;
        if (storeLurking$LurkRequest != null) {
            AppLog.i("Processing lurk request from app link");
            startLurkingAndNavigate$default(this, storeLurking$LurkRequest.getGuildId(), storeLurking$LurkRequest.getChannelId(), null, 4, null);
        }
        this.lurkRequest = null;
    }

    @StoreThread
    public final void handleGuildAdd$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        StoreLurking$LurkContext storeLurking$LurkContext;
        m.checkNotNullParameter(guild, "guild");
        if (this.lurkedGuilds.keySet().contains(Long.valueOf(guild.getId()))) {
            if (guild.getJoinedAt() == null && (storeLurking$LurkContext = this.lurkedGuilds.get(Long.valueOf(guild.getId()))) != null && storeLurking$LurkContext.getShouldNavigate()) {
                this.stream.getGuildSelected().handleGuildSelected(guild.getId());
            } else if (guild.getJoinedAt() != null) {
                stopLurkingInternal(guild.getId());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        stopLurkingInternal(guild.getId());
    }

    @StoreThread
    public final void handleGuildSelected$app_productionGoogleRelease(long guildId) {
        StoreLurking$LurkRequest storeLurking$LurkRequest = this.lurkRequest;
        if ((storeLurking$LurkRequest == null || guildId != storeLurking$LurkRequest.getGuildId()) && this.sessionId != null) {
            this.lurkRequest = null;
        }
        removeOldLurkingGuilds(guildId);
    }

    @StoreThread
    public final void handleVoiceChannelSelected$app_productionGoogleRelease(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (channel == null || ((Number) obj).longValue() != channel.getGuildId()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (jLongValue != this.stream.getGuildSelected().getSelectedGuildIdInternal$app_productionGoogleRelease()) {
                postLeaveGuild$default(this, jLongValue, null, null, 6, null);
            }
        }
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return StoreLurking$Companion.access$isLurking(Companion, guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    public final Observable<Boolean> isLurkingObs(long guildId) {
        Observable<Boolean> observableR = Observable.j(getLurkingGuildIds(), this.stream.getGuilds().observeGuild(guildId), StoreLurking$isLurkingObs$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }

    public final void postJoinGuildAsMember(long guildId, Context context) {
        m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild$default(context, guildId, false, this.sessionId, null, null, StoreLurking.class, null, null, null, StoreLurking$postJoinGuildAsMember$1.INSTANCE, 944, null);
    }

    public final void removeOldLurkingGuilds(long currentlyLurkedGuildId) {
        Channel channel = this.stream.getChannels().getChannel(this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId());
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue != currentlyLurkedGuildId && (lValueOf == null || jLongValue != lValueOf.longValue())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Guild guild = this.guildsStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
            if (guild != null) {
                arrayList2.add(guild);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            postLeaveGuild$default(this, ((Guild) it2.next()).getId(), null, null, 6, null);
        }
    }

    public final void startLurking(long guildId, Long channelId, boolean navigateToGuild, Function3<? super Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking) {
        m.checkNotNullParameter(onGuildLurked, "onGuildLurked");
        m.checkNotNullParameter(onErrorLurking, "onErrorLurking");
        this.dispatcher.schedule(new StoreLurking$startLurking$3(this, guildId, channelId, navigateToGuild, onGuildLurked, onErrorLurking));
    }

    public final void startLurkingAndNavigate(long guildId, Long channelId, Context context) {
        this.dispatcher.schedule(new StoreLurking$startLurkingAndNavigate$1(this, guildId, channelId, context));
    }

    public final void stopLurking(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFailure, "onFailure");
        postLeaveGuild(guildId, onSuccess, onFailure);
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return StoreLurking$Companion.access$isLurking(Companion, guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(long guildId) {
        return StoreLurking$Companion.access$isLurking(Companion, false, guildId, this.lurkedGuilds.keySet());
    }
}
