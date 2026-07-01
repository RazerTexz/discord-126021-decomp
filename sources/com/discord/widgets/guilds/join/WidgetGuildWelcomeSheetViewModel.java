package com.discord.widgets.guilds.join;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens$State;
import com.discord.stores.StoreGuildWelcomeScreens$State$Failure;
import com.discord.stores.StoreGuildWelcomeScreens$State$Fetching;
import com.discord.stores.StoreGuildWelcomeScreens$State$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel extends d0<WidgetGuildWelcomeSheetViewModel$ViewState> {
    public static final WidgetGuildWelcomeSheetViewModel$Companion Companion = new WidgetGuildWelcomeSheetViewModel$Companion(null);
    private final long guildId;

    public /* synthetic */ WidgetGuildWelcomeSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Companion.observeStores(j) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGuildWelcomeSheetViewModel widgetGuildWelcomeSheetViewModel, WidgetGuildWelcomeSheetViewModel$StoreState widgetGuildWelcomeSheetViewModel$StoreState) {
        widgetGuildWelcomeSheetViewModel.handleStoreState(widgetGuildWelcomeSheetViewModel$StoreState);
    }

    private final void handleLoadedGuild(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new WidgetGuildWelcomeSheetViewModel$ViewState$Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen != null ? welcomeScreen.getDescription() : null, welcomeScreen != null ? welcomeScreen.b() : null));
    }

    private final void handleLoadedWelcomeScreen(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new WidgetGuildWelcomeSheetViewModel$ViewState$Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen.getDescription(), welcomeScreen.b()));
    }

    private final void handleStoreState(WidgetGuildWelcomeSheetViewModel$StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildWelcomeScreens$State guildWelcomeScreen = storeState.getGuildWelcomeScreen();
        StoreGuildWelcomeScreens$State$Loaded storeGuildWelcomeScreens$State$Loaded = (StoreGuildWelcomeScreens$State$Loaded) (!(guildWelcomeScreen instanceof StoreGuildWelcomeScreens$State$Loaded) ? null : guildWelcomeScreen);
        if (guild != null && guildWelcomeScreen == StoreGuildWelcomeScreens$State$Failure.INSTANCE) {
            updateViewState(WidgetGuildWelcomeSheetViewModel$ViewState$Invalid.INSTANCE);
            return;
        }
        if (guildWelcomeScreen == StoreGuildWelcomeScreens$State$Fetching.INSTANCE) {
            updateViewState(WidgetGuildWelcomeSheetViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (guild != null) {
            if ((storeGuildWelcomeScreens$State$Loaded != null ? storeGuildWelcomeScreens$State$Loaded.getData() : null) != null) {
                handleLoadedWelcomeScreen(guild, storeGuildWelcomeScreens$State$Loaded.getData());
                return;
            }
        }
        if (guild != null) {
            handleLoadedGuild(guild, storeGuildWelcomeScreens$State$Loaded != null ? storeGuildWelcomeScreens$State$Loaded.getData() : null);
            return;
        }
        if ((storeGuildWelcomeScreens$State$Loaded != null ? storeGuildWelcomeScreens$State$Loaded.getData() : null) == null) {
            updateViewState(WidgetGuildWelcomeSheetViewModel$ViewState$Invalid.INSTANCE);
        } else {
            updateViewState(WidgetGuildWelcomeSheetViewModel$ViewState$Loading.INSTANCE);
        }
    }

    public final void onClickChannel(long guildId, long channelId, int index, List<GuildWelcomeChannel> welcomeChannels) {
        m.checkNotNullParameter(welcomeChannels, "welcomeChannels");
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), guildId, channelId, null, null, 12, null);
        String description = welcomeChannels.get(index).getDescription();
        boolean z2 = welcomeChannels.get(index).getEmojiId() != null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GuildWelcomeChannel guildWelcomeChannel : welcomeChannels) {
            arrayList2.add(Long.valueOf(guildWelcomeChannel.getChannelId()));
            arrayList.add(guildWelcomeChannel.getDescription());
        }
        AnalyticsTracker.welcomeScreenChannelSelected(index, guildId, arrayList, arrayList2, description, z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheetViewModel(long j, Observable<WidgetGuildWelcomeSheetViewModel$StoreState> observable) {
        super(WidgetGuildWelcomeSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetGuildWelcomeSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildWelcomeSheetViewModel$1(this), 62, (Object) null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getGuildWelcomeScreens().fetchIfNonexisting(j);
        storeStream$Companion.getGuildWelcomeScreens().markWelcomeScreenShown(j);
        AnalyticsTracker.openModal("Guild Welcome Screen", "", Long.valueOf(j));
    }
}
