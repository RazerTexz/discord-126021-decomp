package com.discord.widgets.user.usersheet;

import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserNotes;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.streams.StreamContextService;
import d0.z.d.m;
import j0.l.a.r;
import j0.l.e.k;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetUserSheetViewModelStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModelStoreState {
    public static final WidgetUserSheetViewModelStoreState INSTANCE = new WidgetUserSheetViewModelStoreState();

    private WidgetUserSheetViewModelStoreState() {
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetUserSheetViewModelStoreState widgetUserSheetViewModelStoreState, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler scheduler, int i, Object obj) {
        Scheduler scheduler2;
        StoreUser users = (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUserProfile userProfile = (i & 64) != 0 ? StoreStream.Companion.getUserProfile() : storeUserProfile;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.Companion.getUserRelationships() : storeUserRelationships;
        StoreVoiceStates voiceStates = (i & 256) != 0 ? StoreStream.Companion.getVoiceStates() : storeVoiceStates;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StoreMediaSettings mediaSettings = (i & 1024) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings;
        StoreUserPresence presences = (i & 2048) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreUserNotes usersNotes = (i & 8192) != 0 ? StoreStream.Companion.getUsersNotes() : storeUserNotes;
        StoreStageChannels stageChannels = (i & 16384) != 0 ? StoreStream.Companion.getStageChannels() : storeStageChannels;
        StreamContextService streamContextService2 = (32768 & i) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService;
        if ((i & 65536) != 0) {
            Scheduler schedulerA = a.a();
            m.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
            scheduler2 = schedulerA;
        } else {
            scheduler2 = scheduler;
        }
        return widgetUserSheetViewModelStoreState.observeStoreState(j, l, l2, users, channels, voiceChannelSelected, userProfile, userRelationships, voiceStates, guilds, mediaSettings, presences, permissions, usersNotes, stageChannels, streamContextService2, scheduler2);
    }

    public final Observable<WidgetUserSheetViewModel$StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUserProfile storeUserProfile, StoreUserRelationships storeUserRelationships, StoreVoiceStates storeVoiceStates, StoreGuilds storeGuilds, StoreMediaSettings storeMediaSettings, StoreUserPresence storeUserPresence, StorePermissions storePermissions, StoreUserNotes storeUserNotes, StoreStageChannels storeStageChannels, StreamContextService streamContextService, Scheduler storeStateRxScheduler) {
        Observable<Channel> kVar;
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        m.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        m.checkNotNullParameter(storeVoiceStates, "storeVoiceStates");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeMediaSettings, "storeMediaSettings");
        m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeUserNotes, "storeUserNotes");
        m.checkNotNullParameter(storeStageChannels, "storeStageChannels");
        m.checkNotNullParameter(streamContextService, "streamContextService");
        m.checkNotNullParameter(storeStateRxScheduler, "storeStateRxScheduler");
        Observable<User> observableObserveUser = storeUser.observeUser(userId);
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
        if (channelId == null || (kVar = storeChannels.observeChannel(channelId.longValue())) == null) {
            kVar = new k<>(null);
        }
        Observable<Channel> observableObserveSelectedChannel = storeVoiceChannelSelected.observeSelectedChannel();
        WidgetUserSheetViewModelStoreState$observeStoreState$2 widgetUserSheetViewModelStoreState$observeStoreState$2 = WidgetUserSheetViewModelStoreState$observeStoreState$2.INSTANCE;
        Object widgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0 = widgetUserSheetViewModelStoreState$observeStoreState$2;
        if (widgetUserSheetViewModelStoreState$observeStoreState$2 != null) {
            widgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0 = new WidgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0(widgetUserSheetViewModelStoreState$observeStoreState$2);
        }
        Observable<WidgetUserSheetViewModel$StoreState> observableR = Observable.h0(new r(Observable.h(observableObserveUser, observableObserveMe$default, kVar, observableObserveSelectedChannel, (Func4) widgetUserSheetViewModelStoreState$sam$rx_functions_Func4$0).Y(new WidgetUserSheetViewModelStoreState$observeStoreState$3(guildId, storeGuilds, storeVoiceStates, storeUserPresence, storePermissions, streamContextService, storeStageChannels, storeMediaSettings, storeUserProfile, storeUserRelationships, storeUserNotes)).j, new LeadingEdgeThrottle(250L, TimeUnit.MILLISECONDS, storeStateRxScheduler))).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
        return observableR;
    }
}
