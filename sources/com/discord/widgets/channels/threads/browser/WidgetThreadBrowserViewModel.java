package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel extends d0<WidgetThreadBrowserViewModel$ViewState> {
    public static final WidgetThreadBrowserViewModel$Companion Companion = new WidgetThreadBrowserViewModel$Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        this(j, j2, channels, guilds, permissions, (i & 32) != 0 ? WidgetThreadBrowserViewModel$Companion.access$observeStoreState(Companion, j2, j, channels, guilds, permissions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel, WidgetThreadBrowserViewModel$StoreState widgetThreadBrowserViewModel$StoreState) {
        widgetThreadBrowserViewModel.handleStoreState(widgetThreadBrowserViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetThreadBrowserViewModel$StoreState storeState) {
        if (getViewState() instanceof WidgetThreadBrowserViewModel$ViewState$GoToChannel) {
            return;
        }
        Channel channel = storeState.getChannel();
        String strC = channel != null ? ChannelUtils.c(channel) : null;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        boolean zCanCreateThread = threadUtils.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild());
        boolean zCanViewAllPublicArchivedThreads = threadUtils.canViewAllPublicArchivedThreads(storeState.getChannel(), storeState.getPermissions());
        Channel channel2 = storeState.getChannel();
        updateViewState(new WidgetThreadBrowserViewModel$ViewState$Browser(strC, zCanCreateThread, zCanViewAllPublicArchivedThreads, channel2 != null && channel2.getType() == 15));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void openThread(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        updateViewState(new WidgetThreadBrowserViewModel$ViewState$GoToChannel(channel));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable<WidgetThreadBrowserViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadBrowserViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserViewModel$1(this), 62, (Object) null);
    }
}
