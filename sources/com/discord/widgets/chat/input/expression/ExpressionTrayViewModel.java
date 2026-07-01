package com.discord.widgets.chat.input.expression;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.expression.ExpressionDetailPage;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionTrayViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreExpressionPickerNavigation storeExpressionPickerNavigation;
    private final StoreGuildStickers storeGuildStickers;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private boolean wasActive;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((ExpressionTrayViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ExpressionPickerEvent, Unit> {
        public AnonymousClass2(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleExpressionPickerEvents", "handleExpressionPickerEvents(Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionPickerEvent expressionPickerEvent) {
            invoke2(expressionPickerEvent);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionPickerEvent expressionPickerEvent) {
            Intrinsics3.checkNotNullParameter(expressionPickerEvent, "p1");
            ((ExpressionTrayViewModel) this.receiver).handleExpressionPickerEvents(expressionPickerEvent);
        }
    }

    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds) {
            Observable<StoreState> observableG = Observable.g(storeExpressionPickerNavigation.observeSelectedTab(), storeChannelsSelected.observeResolvedSelectedChannel(), StoreUser.observeMe$default(storeUser, false, 1, null), storeGuildStickers.observeGuildStickers(), storeGuilds.observeGuilds(), new Func5<ExpressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel, MeUser, Map<Long, ? extends Map<Long, ? extends Sticker>>, Map<Long, ? extends Guild>, StoreState>() { // from class: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func5
                public /* bridge */ /* synthetic */ ExpressionTrayViewModel.StoreState call(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, ? extends Sticker>> map, Map<Long, ? extends Guild> map2) {
                    return call2(expressionTrayTab, resolvedSelectedChannel, meUser, (Map<Long, ? extends Map<Long, Sticker>>) map, (Map<Long, Guild>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final ExpressionTrayViewModel.StoreState call2(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Map<Long, Guild> map2) {
                    Intrinsics3.checkNotNullExpressionValue(expressionTrayTab, "lastSelectedTab");
                    Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
                    Long lValueOf = channelOrParent != null ? Long.valueOf(channelOrParent.getGuildId()) : null;
                    Intrinsics3.checkNotNullExpressionValue(map, "guildStickers");
                    return new ExpressionTrayViewModel.StoreState(expressionTrayTab, lValueOf, meUser, map, _Collections.toSet(map2.keySet()), resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…aft\n          )\n        }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
        public static final class HideExpressionTray extends Event {
            public static final HideExpressionTray INSTANCE = new HideExpressionTray();

            private HideExpressionTray() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
        public static final class ShowEmojiPickerSheet extends Event {
            public static final ShowEmojiPickerSheet INSTANCE = new ShowEmojiPickerSheet();

            private ShowEmojiPickerSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
        public static final class ShowGifPickerSheet extends Event {
            public static final ShowGifPickerSheet INSTANCE = new ShowGifPickerSheet();

            private ShowGifPickerSheet() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
        public static final /* data */ class ShowStickerPicker extends Event {
            private final boolean inline;
            private final String searchText;
            private final Long stickerPackId;

            public /* synthetic */ ShowStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(l, str, (i & 4) != 0 ? false : z2);
            }

            public static /* synthetic */ ShowStickerPicker copy$default(ShowStickerPicker showStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = showStickerPicker.stickerPackId;
                }
                if ((i & 2) != 0) {
                    str = showStickerPicker.searchText;
                }
                if ((i & 4) != 0) {
                    z2 = showStickerPicker.inline;
                }
                return showStickerPicker.copy(l, str, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Long getStickerPackId() {
                return this.stickerPackId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getSearchText() {
                return this.searchText;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getInline() {
                return this.inline;
            }

            public final ShowStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
                return new ShowStickerPicker(stickerPackId, searchText, inline);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowStickerPicker)) {
                    return false;
                }
                ShowStickerPicker showStickerPicker = (ShowStickerPicker) other;
                return Intrinsics3.areEqual(this.stickerPackId, showStickerPicker.stickerPackId) && Intrinsics3.areEqual(this.searchText, showStickerPicker.searchText) && this.inline == showStickerPicker.inline;
            }

            public final boolean getInline() {
                return this.inline;
            }

            public final String getSearchText() {
                return this.searchText;
            }

            public final Long getStickerPackId() {
                return this.stickerPackId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                Long l = this.stickerPackId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                String str = this.searchText;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.inline;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowStickerPicker(stickerPackId=");
                sbU.append(this.stickerPackId);
                sbU.append(", searchText=");
                sbU.append(this.searchText);
                sbU.append(", inline=");
                return outline.O(sbU, this.inline, ")");
            }

            public ShowStickerPicker(Long l, String str, boolean z2) {
                super(null);
                this.stickerPackId = l;
                this.searchText = str;
                this.inline = z2;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long guildId;
        private final Map<Long, Map<Long, Sticker>> guildStickers;
        private final boolean isThreadDraft;
        private final MeUser meUser;
        private final ExpressionTrayTab selectedExpressionTab;
        private final Set<Long> userGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Set<Long> set, boolean z2) {
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
            Intrinsics3.checkNotNullParameter(map, "guildStickers");
            Intrinsics3.checkNotNullParameter(set, "userGuildIds");
            this.selectedExpressionTab = expressionTrayTab;
            this.guildId = l;
            this.meUser = meUser;
            this.guildStickers = map;
            this.userGuildIds = set;
            this.isThreadDraft = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                expressionTrayTab = storeState.selectedExpressionTab;
            }
            if ((i & 2) != 0) {
                l = storeState.guildId;
            }
            Long l2 = l;
            if ((i & 4) != 0) {
                meUser = storeState.meUser;
            }
            MeUser meUser2 = meUser;
            if ((i & 8) != 0) {
                map = storeState.guildStickers;
            }
            Map map2 = map;
            if ((i & 16) != 0) {
                set = storeState.userGuildIds;
            }
            Set set2 = set;
            if ((i & 32) != 0) {
                z2 = storeState.isThreadDraft;
            }
            return storeState.copy(expressionTrayTab, l2, meUser2, map2, set2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Map<Long, Sticker>> component4() {
            return this.guildStickers;
        }

        public final Set<Long> component5() {
            return this.userGuildIds;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsThreadDraft() {
            return this.isThreadDraft;
        }

        public final StoreState copy(ExpressionTrayTab selectedExpressionTab, Long guildId, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> guildStickers, Set<Long> userGuildIds, boolean isThreadDraft) {
            Intrinsics3.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
            Intrinsics3.checkNotNullParameter(guildStickers, "guildStickers");
            Intrinsics3.checkNotNullParameter(userGuildIds, "userGuildIds");
            return new StoreState(selectedExpressionTab, guildId, meUser, guildStickers, userGuildIds, isThreadDraft);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.selectedExpressionTab, storeState.selectedExpressionTab) && Intrinsics3.areEqual(this.guildId, storeState.guildId) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.guildStickers, storeState.guildStickers) && Intrinsics3.areEqual(this.userGuildIds, storeState.userGuildIds) && this.isThreadDraft == storeState.isThreadDraft;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Map<Long, Map<Long, Sticker>> getGuildStickers() {
            return this.guildStickers;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        public final Set<Long> getUserGuildIds() {
            return this.userGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
            int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
            Long l = this.guildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            MeUser meUser = this.meUser;
            int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Map<Long, Map<Long, Sticker>> map = this.guildStickers;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Set<Long> set = this.userGuildIds;
            int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
            boolean z2 = this.isThreadDraft;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode5 + r1;
        }

        public final boolean isThreadDraft() {
            return this.isThreadDraft;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(selectedExpressionTab=");
            sbU.append(this.selectedExpressionTab);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(", guildStickers=");
            sbU.append(this.guildStickers);
            sbU.append(", userGuildIds=");
            sbU.append(this.userGuildIds);
            sbU.append(", isThreadDraft=");
            return outline.O(sbU, this.isThreadDraft, ")");
        }

        public /* synthetic */ StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expressionTrayTab, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : meUser, map, set, z2);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ExpressionTrayTab.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.EMOJI;
            iArr[expressionTrayTab.ordinal()] = 1;
            ExpressionTrayTab expressionTrayTab2 = ExpressionTrayTab.GIF;
            iArr[expressionTrayTab2.ordinal()] = 2;
            ExpressionTrayTab expressionTrayTab3 = ExpressionTrayTab.STICKER;
            iArr[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[expressionTrayTab.ordinal()] = 1;
            iArr2[expressionTrayTab2.ordinal()] = 2;
            iArr2[expressionTrayTab3.ordinal()] = 3;
        }
    }

    public ExpressionTrayViewModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable observable, Observable observable2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAnalytics analytics = (i & 1) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreExpressionPickerNavigation expressionPickerNavigation = (i & 2) != 0 ? StoreStream.INSTANCE.getExpressionPickerNavigation() : storeExpressionPickerNavigation;
        StoreChannelsSelected channelsSelected = (i & 4) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuildStickers guildStickers = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildStickers() : storeGuildStickers;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(analytics, expressionPickerNavigation, channelsSelected, users, guildStickers, guilds, (i & 64) != 0 ? INSTANCE.observeStoreState(expressionPickerNavigation, channelsSelected, users, guildStickers, guilds) : observable, (i & 128) != 0 ? ExpressionPickerEventBus.INSTANCE.getINSTANCE().observeExpressionPickerEvents() : observable2);
    }

    public static /* synthetic */ void clickSearch$default(ExpressionTrayViewModel expressionTrayViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expressionTrayViewModel.clickSearch(str);
    }

    private final String getChatInputComponentType(ExpressionTrayTab expressionTab) {
        int iOrdinal = expressionTab.ordinal();
        if (iOrdinal == 0) {
            return "emoji";
        }
        if (iOrdinal == 1) {
            return "GIF";
        }
        if (iOrdinal == 2) {
            return "sticker";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleExpressionPickerEvents(ExpressionPickerEvent expressionPickerEvent) {
        if (Intrinsics3.areEqual(expressionPickerEvent, ExpressionPickerEvent.CloseExpressionPicker.INSTANCE)) {
            hideExpressionPicker();
            return;
        }
        if (expressionPickerEvent instanceof ExpressionPickerEvent.OpenStickerPicker) {
            ExpressionPickerEvent.OpenStickerPicker openStickerPicker = (ExpressionPickerEvent.OpenStickerPicker) expressionPickerEvent;
            if (!openStickerPicker.getInline()) {
                showStickerPickerSheet(openStickerPicker.getStickerPackId(), openStickerPicker.getSearchText());
            }
            Long stickerPackId = openStickerPicker.getStickerPackId();
            long jLongValue = stickerPackId != null ? stickerPackId.longValue() : -1L;
            selectTab(ExpressionTrayTab.STICKER);
            showStickerPickerInline(Long.valueOf(jLongValue), openStickerPicker.getSearchText());
        }
    }

    private final void handleStoreState(StoreState storeState) {
        updateViewState(ViewState.copy$default(requireViewState(), storeState.getSelectedExpressionTab(), null, false, !storeState.isThreadDraft(), 6, null));
    }

    private final void hideExpressionPicker() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.HideExpressionTray.INSTANCE);
    }

    private final void showEmojiPickerSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowEmojiPickerSheet.INSTANCE);
    }

    private final void showGifPickerSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowGifPickerSheet.INSTANCE);
    }

    private final void showStickerPickerInline(Long stickerPackId, String searchText) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowStickerPicker(stickerPackId, searchText, true));
    }

    public static /* synthetic */ void showStickerPickerInline$default(ExpressionTrayViewModel expressionTrayViewModel, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        expressionTrayViewModel.showStickerPickerInline(l, str);
    }

    private final void showStickerPickerSheet(Long stickerPackId, String searchText) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowStickerPicker(stickerPackId, searchText, false, 4, null));
    }

    public static /* synthetic */ void showStickerPickerSheet$default(ExpressionTrayViewModel expressionTrayViewModel, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        expressionTrayViewModel.showStickerPickerSheet(l, str);
    }

    public final void clickBack() {
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState.getExpressionDetailPage() != null) {
            updateViewState(ViewState.copy$default(viewStateRequireViewState, null, null, false, false, 13, null));
        }
    }

    public final void clickSearch(String searchText) {
        int iOrdinal = requireViewState().getSelectedExpressionTab().ordinal();
        if (iOrdinal == 0) {
            showEmojiPickerSheet();
        } else if (iOrdinal == 1) {
            showGifPickerSheet();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            showStickerPickerSheet$default(this, null, searchText, 1, null);
        }
    }

    public final void handleIsActive(boolean isActive) {
        ViewState viewState;
        ExpressionTrayTab selectedExpressionTab;
        if (isActive && !this.wasActive && (viewState = getViewState()) != null && (selectedExpressionTab = viewState.getSelectedExpressionTab()) != null) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab));
        }
        this.wasActive = isActive;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectGifCategory(GifCategoryItem gifCategoryItem) {
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        updateViewState(ViewState.copy$default(requireViewState(), null, new ExpressionDetailPage.GifCategoryPage(gifCategoryItem), false, false, 13, null));
    }

    public final void selectTab(ExpressionTrayTab expressionTrayTab) {
        Intrinsics3.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.storeExpressionPickerNavigation.onSelectTab(expressionTrayTab);
    }

    public final void showStickersSearchBar(boolean show) {
        updateViewState(ViewState.copy$default(requireViewState(), null, null, show, false, 11, null));
    }

    @Override // b.a.d.AppViewModel
    public void updateViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ViewState viewState2 = getViewState();
        ExpressionTrayTab selectedExpressionTab = viewState2 != null ? viewState2.getSelectedExpressionTab() : null;
        ExpressionTrayTab selectedExpressionTab2 = viewState.getSelectedExpressionTab();
        if (viewState.getShowLandingPage() && selectedExpressionTab != selectedExpressionTab2 && this.wasActive) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab2));
        }
        super.updateViewState(viewState);
    }

    /* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
    public static final /* data */ class ViewState {
        private final ExpressionDetailPage expressionDetailPage;
        private final ExpressionTrayTab selectedExpressionTab;
        private final boolean showGifsAndStickers;
        private final boolean showLandingPage;
        private final boolean showSearchBar;
        private final boolean showStickersSearchBar;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ExpressionTrayTab.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[ExpressionTrayTab.EMOJI.ordinal()] = 1;
                iArr[ExpressionTrayTab.GIF.ordinal()] = 2;
                iArr[ExpressionTrayTab.STICKER.ordinal()] = 3;
            }
        }

        public ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
            this.selectedExpressionTab = expressionTrayTab;
            this.expressionDetailPage = expressionDetailPage;
            this.showStickersSearchBar = z2;
            this.showGifsAndStickers = z3;
            this.showLandingPage = expressionDetailPage == null;
            int iOrdinal = expressionTrayTab.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                z2 = true;
            } else if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.showSearchBar = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                expressionTrayTab = viewState.selectedExpressionTab;
            }
            if ((i & 2) != 0) {
                expressionDetailPage = viewState.expressionDetailPage;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showStickersSearchBar;
            }
            if ((i & 8) != 0) {
                z3 = viewState.showGifsAndStickers;
            }
            return viewState.copy(expressionTrayTab, expressionDetailPage, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ExpressionDetailPage getExpressionDetailPage() {
            return this.expressionDetailPage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowStickersSearchBar() {
            return this.showStickersSearchBar;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getShowGifsAndStickers() {
            return this.showGifsAndStickers;
        }

        public final ViewState copy(ExpressionTrayTab selectedExpressionTab, ExpressionDetailPage expressionDetailPage, boolean showStickersSearchBar, boolean showGifsAndStickers) {
            Intrinsics3.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
            return new ViewState(selectedExpressionTab, expressionDetailPage, showStickersSearchBar, showGifsAndStickers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedExpressionTab, viewState.selectedExpressionTab) && Intrinsics3.areEqual(this.expressionDetailPage, viewState.expressionDetailPage) && this.showStickersSearchBar == viewState.showStickersSearchBar && this.showGifsAndStickers == viewState.showGifsAndStickers;
        }

        public final ExpressionDetailPage getExpressionDetailPage() {
            return this.expressionDetailPage;
        }

        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        public final boolean getShowGifsAndStickers() {
            return this.showGifsAndStickers;
        }

        public final boolean getShowLandingPage() {
            return this.showLandingPage;
        }

        public final boolean getShowSearchBar() {
            return this.showSearchBar;
        }

        public final boolean getShowStickersSearchBar() {
            return this.showStickersSearchBar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
            int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
            ExpressionDetailPage expressionDetailPage = this.expressionDetailPage;
            int iHashCode2 = (iHashCode + (expressionDetailPage != null ? expressionDetailPage.hashCode() : 0)) * 31;
            boolean z2 = this.showStickersSearchBar;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.showGifsAndStickers;
            return i + (z3 ? 1 : z3);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedExpressionTab=");
            sbU.append(this.selectedExpressionTab);
            sbU.append(", expressionDetailPage=");
            sbU.append(this.expressionDetailPage);
            sbU.append(", showStickersSearchBar=");
            sbU.append(this.showStickersSearchBar);
            sbU.append(", showGifsAndStickers=");
            return outline.O(sbU, this.showGifsAndStickers, ")");
        }

        public /* synthetic */ ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expressionTrayTab, (i & 2) != 0 ? null : expressionDetailPage, z2, z3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable<StoreState> observable, Observable<ExpressionPickerEvent> observable2) {
        super(new ViewState(ExpressionTrayTab.EMOJI, null, true, true, 2, null));
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExpressionPickerNavigation, "storeExpressionPickerNavigation");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(observable2, "expressionPickerNavigationObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUser = storeUser;
        this.storeGuildStickers = storeGuildStickers;
        this.storeGuilds = storeGuilds;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) ExpressionTrayViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), (Class<?>) ExpressionTrayViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
