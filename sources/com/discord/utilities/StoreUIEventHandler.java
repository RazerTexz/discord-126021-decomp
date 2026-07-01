package com.discord.utilities;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserGuildSettings$Event;
import com.discord.stores.StoreUserGuildSettings$Event$SettingsUpdated;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUIEventHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUIEventHandler {
    private final StoreChannels channelsStore;
    private final Context context;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreStageChannels stageChannelsStore;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    public StoreUIEventHandler(Context context, StoreMediaEngine storeMediaEngine, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageChannels storeStageChannels, StoreUserGuildSettings storeUserGuildSettings) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeStageChannels, "stageChannelsStore");
        m.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        this.context = context;
        this.mediaEngineStore = storeMediaEngine;
        this.channelsStore = storeChannels;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.stageChannelsStore = storeStageChannels;
        this.storeUserGuildSettings = storeUserGuildSettings;
        subscribeToStoreEvents();
    }

    public static final /* synthetic */ void access$handleKrispStatusEvent(StoreUIEventHandler storeUIEventHandler, KrispOveruseDetector$Status krispOveruseDetector$Status) {
        storeUIEventHandler.handleKrispStatusEvent(krispOveruseDetector$Status);
    }

    public static final /* synthetic */ void access$handleUserGuildSettingsEvent(StoreUIEventHandler storeUIEventHandler, StoreUserGuildSettings$Event storeUserGuildSettings$Event) {
        storeUIEventHandler.handleUserGuildSettingsEvent(storeUserGuildSettings$Event);
    }

    @MainThread
    private final void handleKrispStatusEvent(KrispOveruseDetector$Status krispStatusEvent) {
        int i;
        Channel channel;
        StageRoles stageRolesM15getMyRolesvisDeB4;
        if (krispStatusEvent == KrispOveruseDetector$Status.FAILED && (channel = this.channelsStore.getChannel(this.voiceChannelSelectedStore.getSelectedVoiceChannelId())) != null && ChannelUtils.D(channel) && (stageRolesM15getMyRolesvisDeB4 = this.stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) != null && StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return;
        }
        int iOrdinal = krispStatusEvent.ordinal();
        if (iOrdinal == 0) {
            i = 2131893028;
        } else if (iOrdinal == 1) {
            i = 2131893029;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131893010;
        }
        b.a.d.m.g(this.context, i, 0, null, 12);
    }

    @MainThread
    private final void handleUserGuildSettingsEvent(StoreUserGuildSettings$Event userGuildSettingsEvent) {
        int i;
        if (!(userGuildSettingsEvent instanceof StoreUserGuildSettings$Event$SettingsUpdated)) {
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((StoreUserGuildSettings$Event$SettingsUpdated) userGuildSettingsEvent).getType().ordinal();
        if (iOrdinal == 0) {
            i = 2131895592;
        } else if (iOrdinal == 1) {
            i = 2131887605;
        } else if (iOrdinal == 2) {
            i = 2131896394;
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131887473;
        }
        b.a.d.m.g(this.context, i, 0, null, 12);
        KotlinExtensionsKt.getExhaustive(Unit.a);
    }

    private final void subscribeToStoreEvents() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.mediaEngineStore.onKrispStatusEvent()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUIEventHandler$subscribeToStoreEvents$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(this.storeUserGuildSettings.observeEvents()), StoreUIEventHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUIEventHandler$subscribeToStoreEvents$2(this), 62, (Object) null);
    }
}
