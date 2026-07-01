package com.discord.widgets.stage.start;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ModeratorStartStageViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageViewModel extends d0<ModeratorStartStageViewModel$ViewState> {
    public static final ModeratorStartStageViewModel$Companion Companion = new ModeratorStartStageViewModel$Companion(null);
    private static final int MAX_DISPLAY_WAITING_USERS = 3;
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreVoiceParticipants voiceParticipants;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 8) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreVoiceParticipants voiceParticipants = (i & 32) != 0 ? StoreStream.Companion.getVoiceParticipants() : storeVoiceParticipants;
        this(j, channels, guildScheduledEvents, voiceChannelSelected, permissions, voiceParticipants, (i & 64) != 0 ? ModeratorStartStageViewModel$Companion.access$observeStores(Companion, j, channels, guildScheduledEvents, permissions, voiceParticipants) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ModeratorStartStageViewModel moderatorStartStageViewModel, ModeratorStartStageViewModel$StoreState moderatorStartStageViewModel$StoreState) {
        moderatorStartStageViewModel.handleStoreState(moderatorStartStageViewModel$StoreState);
    }

    private final void handleStoreState(ModeratorStartStageViewModel$StoreState storeState) {
        Object next;
        Object obj = null;
        List listMutableListOf = n.mutableListOf(new ModeratorStartStageItem$Header(0, null, 3, null));
        if (storeState.getCanStartEvent()) {
            Iterator<T> it = storeState.getChannelEvents().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!GuildScheduledEventUtilitiesKt.getEventTiming((GuildScheduledEvent) next).isStartable());
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (guildScheduledEvent != null) {
                listMutableListOf.add(new ModeratorStartStageItem$ListItem$Event(guildScheduledEvent));
            }
        }
        listMutableListOf.add(new ModeratorStartStageItem$ListItem$StaticOption$StartStage(null, 1, null));
        if (storeState.getCanStartEvent()) {
            listMutableListOf.add(new ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent(null, 1, null));
        }
        listMutableListOf.add(new ModeratorStartStageItem$Continue(0, null, 3, null));
        if (!storeState.getVoiceParticipants().isEmpty()) {
            listMutableListOf.add(new ModeratorStartStageItem$Waiting(0, null, u.take(storeState.getVoiceParticipants(), 3), 3, null));
        }
        List<GuildScheduledEvent> channelEvents = storeState.getChannelEvents();
        for (Object obj2 : storeState.getChannelEvents()) {
            if (((GuildScheduledEvent) obj2).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = obj2;
                break;
            }
        }
        updateViewState(new ModeratorStartStageViewModel$ViewState(channelEvents, listMutableListOf, obj != null));
    }

    public final void disconnectFromStage() {
        this.selectedVoiceChannelStore.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageViewModel(long j, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreVoiceParticipants storeVoiceParticipants, Observable<ModeratorStartStageViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeVoiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.channelsStore = storeChannels;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.permissionsStore = storePermissions;
        this.voiceParticipants = storeVoiceParticipants;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ModeratorStartStageViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ModeratorStartStageViewModel$1(this), 62, (Object) null);
    }
}
