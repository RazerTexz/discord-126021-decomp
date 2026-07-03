package com.discord.widgets.guilds.join;

import com.discord.api.guild.welcome.GuildWelcomeChannel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static final class C87241 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C87241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetGuildWelcomeSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableM11076j = Observable.m11076j(companion.getGuilds().observeGuild(guildId), companion.getGuildWelcomeScreens().observeGuildWelcomeScreen(guildId), new Func2<Guild, StoreGuildWelcomeScreens.State, StoreState>() { // from class: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1
                @Override // p658rx.functions.Func2
                public final WidgetGuildWelcomeSheetViewModel.StoreState call(Guild guild, StoreGuildWelcomeScreens.State state) {
                    return new WidgetGuildWelcomeSheetViewModel.StoreState(guild, state);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n            .…          )\n            }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildWelcomeScreens.State guildWelcomeScreen;

        public StoreState(Guild guild, StoreGuildWelcomeScreens.State state) {
            this.guild = guild;
            this.guildWelcomeScreen = state;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, StoreGuildWelcomeScreens.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                state = storeState.guildWelcomeScreen;
            }
            return storeState.copy(guild, state);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public final StoreState copy(Guild guild, StoreGuildWelcomeScreens.State guildWelcomeScreen) {
            return new StoreState(guild, guildWelcomeScreen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.guildWelcomeScreen, storeState.guildWelcomeScreen);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildWelcomeScreens.State getGuildWelcomeScreen() {
            return this.guildWelcomeScreen;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildWelcomeScreens.State state = this.guildWelcomeScreen;
            return iHashCode + (state != null ? state.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", guildWelcomeScreen=");
            sbM833U.append(this.guildWelcomeScreen);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final List<GuildWelcomeChannel> welcomeChannelsData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, List<GuildWelcomeChannel> list) {
                super(null);
                C12238m.checkNotNullParameter(str, "guildName");
                C12238m.checkNotNullParameter(str2, "guildShortName");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.welcomeChannelsData = list;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final List<GuildWelcomeChannel> component6() {
                return this.welcomeChannelsData;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, List<GuildWelcomeChannel> welcomeChannelsData) {
                C12238m.checkNotNullParameter(guildName, "guildName");
                C12238m.checkNotNullParameter(guildShortName, "guildShortName");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, welcomeChannelsData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && C12238m.areEqual(this.guildName, loaded.guildName) && C12238m.areEqual(this.guildShortName, loaded.guildShortName) && C12238m.areEqual(this.guildIcon, loaded.guildIcon) && C12238m.areEqual(this.guildDescription, loaded.guildDescription) && C12238m.areEqual(this.welcomeChannelsData, loaded.welcomeChannelsData);
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final List<GuildWelcomeChannel> getWelcomeChannelsData() {
                return this.welcomeChannelsData;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                List<GuildWelcomeChannel> list = this.welcomeChannelsData;
                return iHashCode4 + (list != null ? list.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", guildName=");
                sbM833U.append(this.guildName);
                sbM833U.append(", guildShortName=");
                sbM833U.append(this.guildShortName);
                sbM833U.append(", guildIcon=");
                sbM833U.append(this.guildIcon);
                sbM833U.append(", guildDescription=");
                sbM833U.append(this.guildDescription);
                sbM833U.append(", welcomeChannelsData=");
                return C1643a.m824L(sbM833U, this.welcomeChannelsData, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ WidgetGuildWelcomeSheetViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    private final void handleLoadedGuild(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen != null ? welcomeScreen.getDescription() : null, welcomeScreen != null ? welcomeScreen.m7899b() : null));
    }

    private final void handleLoadedWelcomeScreen(Guild guild, GuildWelcomeScreen welcomeScreen) {
        updateViewState(new ViewState.Loaded(guild.getId(), guild.getName(), guild.getShortName(), guild.getIcon(), welcomeScreen.getDescription(), welcomeScreen.m7899b()));
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildWelcomeScreens.State guildWelcomeScreen = storeState.getGuildWelcomeScreen();
        StoreGuildWelcomeScreens.State.Loaded loaded = (StoreGuildWelcomeScreens.State.Loaded) (!(guildWelcomeScreen instanceof StoreGuildWelcomeScreens.State.Loaded) ? null : guildWelcomeScreen);
        if (guild != null && guildWelcomeScreen == StoreGuildWelcomeScreens.State.Failure.INSTANCE) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (guildWelcomeScreen == StoreGuildWelcomeScreens.State.Fetching.INSTANCE) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (guild != null) {
            if ((loaded != null ? loaded.getData() : null) != null) {
                handleLoadedWelcomeScreen(guild, loaded.getData());
                return;
            }
        }
        if (guild != null) {
            handleLoadedGuild(guild, loaded != null ? loaded.getData() : null);
            return;
        }
        if ((loaded != null ? loaded.getData() : null) == null) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    public final void onClickChannel(long guildId, long channelId, int index, List<GuildWelcomeChannel> welcomeChannels) {
        C12238m.checkNotNullParameter(welcomeChannels, "welcomeChannels");
        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), guildId, channelId, null, null, 12, null);
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
    public WidgetGuildWelcomeSheetViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetGuildWelcomeSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87241());
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getGuildWelcomeScreens().fetchIfNonexisting(j);
        companion.getGuildWelcomeScreens().markWelcomeScreenShown(j);
        AnalyticsTracker.openModal("Guild Welcome Screen", "", Long.valueOf(j));
    }
}
