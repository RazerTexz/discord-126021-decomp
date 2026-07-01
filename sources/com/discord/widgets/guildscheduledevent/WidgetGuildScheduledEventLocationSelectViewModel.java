package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel extends d0<WidgetGuildScheduledEventLocationSelectViewModel$ViewState> {
    public static final WidgetGuildScheduledEventLocationSelectViewModel$Companion Companion = new WidgetGuildScheduledEventLocationSelectViewModel$Companion(null);
    private final StoreChannels channelsStore;
    private WidgetGuildScheduledEventLocationSelectViewModel$StoreState currentStoreState;
    private final Long existingGuildScheduledEventId;
    private final Long initialChannelId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 32) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 64) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents;
        this(j, l, l2, channels, guilds, permissions, guildScheduledEvents, (i & 128) != 0 ? WidgetGuildScheduledEventLocationSelectViewModel$Companion.access$observeStores(Companion, j, l2, guilds, channels, permissions, guildScheduledEvents) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel, WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState) {
        widgetGuildScheduledEventLocationSelectViewModel.handleStoreState(widgetGuildScheduledEventLocationSelectViewModel$StoreState);
    }

    private final GuildScheduledEventEntityType getEntityTypeForChannel(Channel channel) {
        if (channel == null) {
            return GuildScheduledEventEntityType.NONE;
        }
        if (ChannelUtils.J(channel)) {
            return GuildScheduledEventEntityType.VOICE;
        }
        return ChannelUtils.D(channel) ? GuildScheduledEventEntityType.STAGE_INSTANCE : GuildScheduledEventEntityType.NONE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f  */
    @MainThread
    private final void handleStoreState(WidgetGuildScheduledEventLocationSelectViewModel$StoreState storeState) {
        Long channelId;
        GuildScheduledEvent existingGuildScheduledEvent;
        GuildScheduledEventEntityMetadata entityMetadata;
        boolean z2;
        Set<GuildFeature> features;
        this.currentStoreState = storeState;
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid)) {
            viewState = null;
        }
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid = (WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) viewState;
        boolean zCanCreateExternalEvent = GuildScheduledEventUtilities.Companion.canCreateExternalEvent(storeState.getGuildPermissions());
        Map<Long, Channel> channels = storeState.getChannels();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Channel> map$Entry : channels.entrySet()) {
            Channel value = map$Entry.getValue();
            if (GuildScheduledEventUtilities.Companion.canStartEventInChannel(value, (Long) a.d(value, storeState.getChannelPermissions()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Channel channel : linkedHashMap.values()) {
            if (ChannelUtils.J(channel)) {
                hashSet2.add(Long.valueOf(channel.getId()));
            } else if (ChannelUtils.D(channel)) {
                hashSet.add(Long.valueOf(channel.getId()));
            }
        }
        boolean z3 = this.existingGuildScheduledEventId != null;
        if (widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid != null) {
            Channel selectedChannel = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedChannel();
            if (selectedChannel != null) {
                channelId = Long.valueOf(selectedChannel.getId());
            } else {
                channelId = null;
            }
        } else if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent2 = storeState.getExistingGuildScheduledEvent();
            if (existingGuildScheduledEvent2 != null) {
                channelId = existingGuildScheduledEvent2.getChannelId();
            } else {
                channelId = null;
            }
        } else {
            channelId = this.initialChannelId;
        }
        Channel channel2 = (Channel) linkedHashMap.get(channelId);
        GuildScheduledEventEntityType selectedLocationOption = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid != null ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedLocationOption() : storeState.getExistingGuildScheduledEvent() != null ? storeState.getExistingGuildScheduledEvent().getEntityType() : getEntityTypeForChannel(channel2);
        if (selectedLocationOption == GuildScheduledEventEntityType.STAGE_INSTANCE && hashSet.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.VOICE && hashSet2.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.EXTERNAL && !zCanCreateExternalEvent) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        }
        GuildScheduledEventEntityType guildScheduledEventEntityType = selectedLocationOption;
        Guild guild = storeState.getGuild();
        boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.COMMUNITY);
        String externalLocation = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid != null ? widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getExternalLocation() : (!z3 || channelId != null || (existingGuildScheduledEvent = storeState.getExistingGuildScheduledEvent()) == null || (entityMetadata = existingGuildScheduledEvent.getEntityMetadata()) == null) ? null : entityMetadata.getLocation();
        if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent3 = storeState.getExistingGuildScheduledEvent();
            if ((existingGuildScheduledEvent3 != null ? GuildScheduledEventUtilitiesKt.getEventTiming(existingGuildScheduledEvent3) : null) == GuildScheduledEventTiming.LIVE) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (externalLocation == null) {
            externalLocation = "";
        }
        updateViewState(new WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid(guildScheduledEventEntityType, channel2, externalLocation, linkedHashMap, hashSet2, hashSet, zCanCreateExternalEvent, zContains, z2));
    }

    public final WidgetGuildScheduledEventLocationSelectViewModel$StoreState getCurrentStoreState() {
        return this.currentStoreState;
    }

    public final void selectChannel(long channelId) {
        WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState;
        Map<Long, Channel> channels;
        Channel channel;
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) || (widgetGuildScheduledEventLocationSelectViewModel$StoreState = this.currentStoreState) == null || (channels = widgetGuildScheduledEventLocationSelectViewModel$StoreState.getChannels()) == null || (channel = channels.get(Long.valueOf(channelId))) == null) {
            return;
        }
        updateViewState(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.copy$default((WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) viewState, null, channel, null, null, null, null, false, false, false, 509, null));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void selectLocationOption(GuildScheduledEventEntityType locationOption) {
        Channel channel;
        Channel channel2;
        Map<Long, Channel> channels;
        m.checkNotNullParameter(locationOption, "locationOption");
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState viewState = getViewState();
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) {
            WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid = (WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) viewState;
            if (locationOption == widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedLocationOption()) {
                return;
            }
            Long l = this.initialChannelId;
            Object obj = null;
            if (l != null) {
                l.longValue();
                WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState = this.currentStoreState;
                if (widgetGuildScheduledEventLocationSelectViewModel$StoreState == null || (channels = widgetGuildScheduledEventLocationSelectViewModel$StoreState.getChannels()) == null) {
                    channel = null;
                } else {
                    channel = channels.get(this.initialChannelId);
                }
            } else {
                channel = null;
            }
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            if (locationOption == guildScheduledEventEntityType && channel != null && channel.getType() == 2) {
                channel2 = channel;
            } else {
                if (locationOption == guildScheduledEventEntityType) {
                    for (Object obj2 : widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getAvailableChannels().values()) {
                        if (((Channel) obj2).getType() == 2) {
                            obj = obj2;
                            break;
                        }
                    }
                    obj = (Channel) obj;
                } else {
                    GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
                    if (locationOption == guildScheduledEventEntityType2 && channel != null && channel.getType() == 13) {
                        channel2 = channel;
                    } else if (locationOption == guildScheduledEventEntityType2) {
                        for (Object obj3 : widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getAvailableChannels().values()) {
                            if (((Channel) obj3).getType() == 13) {
                                obj = obj3;
                                break;
                            }
                        }
                        obj = (Channel) obj;
                    }
                }
                channel2 = obj;
            }
            updateViewState(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.copy$default(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid, locationOption, channel2, "", null, null, null, false, false, false, 504, null));
        }
    }

    public final void setCurrentStoreState(WidgetGuildScheduledEventLocationSelectViewModel$StoreState widgetGuildScheduledEventLocationSelectViewModel$StoreState) {
        this.currentStoreState = widgetGuildScheduledEventLocationSelectViewModel$StoreState;
    }

    public final void setExternalLocation(String newExternalLocation) {
        m.checkNotNullParameter(newExternalLocation, "newExternalLocation");
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState viewState = getViewState();
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) {
            updateViewState(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.copy$default((WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) viewState, null, null, newExternalLocation, null, null, null, false, false, false, 507, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable<WidgetGuildScheduledEventLocationSelectViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "channelsStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.initialChannelId = l;
        this.existingGuildScheduledEventId = l2;
        this.channelsStore = storeChannels;
        Observable<WidgetGuildScheduledEventLocationSelectViewModel$StoreState> observableX = observable.X(j0.p.a.a());
        m.checkNotNullExpressionValue(observableX, "storeStateObservable\n   …Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableX, this, null, 2, null), WidgetGuildScheduledEventLocationSelectViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventLocationSelectViewModel$1(this), 62, (Object) null);
    }
}
