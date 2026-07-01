package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.stores.Dispatcher;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import j0.l.e.k;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector {
    public static final ChannelSelector$Companion Companion = new ChannelSelector$Companion(null);
    private static ChannelSelector INSTANCE;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreStream stream;

    public ChannelSelector(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ ChannelSelector access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$gotoChannel(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        channelSelector.gotoChannel(j, j2, l, selectedChannelAnalyticsLocation);
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ChannelSelector channelSelector) {
        INSTANCE = channelSelector;
    }

    public static /* synthetic */ void findAndSetDirectMessage$default(ChannelSelector channelSelector, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        channelSelector.findAndSetDirectMessage(context, j);
    }

    public static final ChannelSelector getInstance() {
        return Companion.getInstance();
    }

    private final void gotoChannel(long guildId, long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        this.dispatcher.schedule(new ChannelSelector$gotoChannel$1(this, guildId, channelId, peekParent, analyticsLocation));
    }

    public static /* synthetic */ void openCreateThread$default(ChannelSelector channelSelector, long j, long j2, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        channelSelector.openCreateThread(j, j2, l, str);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, Channel channel, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            selectedChannelAnalyticsLocation = null;
        }
        channelSelector.selectChannel(channel, l, selectedChannelAnalyticsLocation);
    }

    public final void dismissCreateThread() {
        this.dispatcher.schedule(new ChannelSelector$dismissCreateThread$1(this));
    }

    public final void findAndSet(Context context, long channelId) {
        if (channelId <= 0) {
            return;
        }
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new ChannelSelector$findAndSet$1(this, channelId, context), 14, null).y(ChannelSelector$findAndSet$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "observationDeck\n        …   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, true, 1, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$findAndSet$3(this), 62, (Object) null);
    }

    public final void findAndSetDirectMessage(Context context, long userId) {
        m.checkNotNullParameter(context, "context");
        if (userId <= 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.Companion.getApi().createOrFetchDM(userId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$findAndSetDirectMessage$1(this, context), 60, (Object) null);
    }

    public final void findAndSetThread(Context context, long channelId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.Companion.getApi().getChannel(channelId))), ChannelSelector.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$findAndSetThread$1(this, context, channelId), 60, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String startThreadLocation) {
        this.dispatcher.schedule(new ChannelSelector$openCreateThread$1(this, guildId, channelId, parentMessageId, startThreadLocation));
    }

    public final void previewVoiceChannel(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WeakReference weakReference = new WeakReference(fragmentManager);
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new ChannelSelector$previewVoiceChannel$1(this, channelId), 14, null).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$previewVoiceChannel$2(weakReference, channelId), 62, (Object) null);
    }

    public final void selectChannel(Channel channel, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        if (channel != null) {
            selectChannel(channel.getGuildId(), channel.getId(), peekParent, analyticsLocation);
        }
    }

    public final void selectPreviousChannel(long guildId) {
        Observable<R> observableY = this.stream.getChannelsSelected().observePreviousId().Y(new ChannelSelector$selectPreviousChannel$1(this));
        m.checkNotNullExpressionValue(observableY, "stream.channelsSelected.…nnel(previousChannelId) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$selectPreviousChannel$2(this, guildId), 62, (Object) null);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        channelSelector.selectChannel(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : selectedChannelAnalyticsLocation);
    }

    public final void selectChannel(long guildId, long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        StoreNavigation.setNavigationPanelAction$default(this.stream.getNavigation(), StoreNavigation$PanelAction.CLOSE, null, 2, null);
        if (guildId == 0 || channelId == 0) {
            k kVar = new k(null);
            m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(kVar), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$selectChannel$1(this, guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        } else {
            Observable<R> observableG = this.stream.getChannels().observeChannel(channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null), ChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ChannelSelector$selectChannel$2(this, guildId, channelId, peekParent, analyticsLocation), 62, (Object) null);
        }
    }
}
