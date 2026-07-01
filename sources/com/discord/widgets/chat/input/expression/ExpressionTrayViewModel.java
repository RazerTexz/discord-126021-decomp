package com.discord.widgets.chat.input.expression;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ExpressionTrayViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionTrayViewModel extends d0<ExpressionTrayViewModel$ViewState> {
    public static final ExpressionTrayViewModel$Companion Companion = new ExpressionTrayViewModel$Companion(null);
    private final PublishSubject<ExpressionTrayViewModel$Event> eventSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreExpressionPickerNavigation storeExpressionPickerNavigation;
    private final StoreGuildStickers storeGuildStickers;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private boolean wasActive;

    public ExpressionTrayViewModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable observable, Observable observable2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAnalytics analytics = (i & 1) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        StoreExpressionPickerNavigation expressionPickerNavigation = (i & 2) != 0 ? StoreStream.Companion.getExpressionPickerNavigation() : storeExpressionPickerNavigation;
        StoreChannelsSelected channelsSelected = (i & 4) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreUser users = (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreGuildStickers guildStickers = (i & 16) != 0 ? StoreStream.Companion.getGuildStickers() : storeGuildStickers;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        this(analytics, expressionPickerNavigation, channelsSelected, users, guildStickers, guilds, (i & 64) != 0 ? ExpressionTrayViewModel$Companion.access$observeStoreState(Companion, expressionPickerNavigation, channelsSelected, users, guildStickers, guilds) : observable, (i & 128) != 0 ? ExpressionPickerEventBus.Companion.getINSTANCE().observeExpressionPickerEvents() : observable2);
    }

    public static final /* synthetic */ void access$handleExpressionPickerEvents(ExpressionTrayViewModel expressionTrayViewModel, ExpressionPickerEvent expressionPickerEvent) {
        expressionTrayViewModel.handleExpressionPickerEvents(expressionPickerEvent);
    }

    public static final /* synthetic */ void access$handleStoreState(ExpressionTrayViewModel expressionTrayViewModel, ExpressionTrayViewModel$StoreState expressionTrayViewModel$StoreState) {
        expressionTrayViewModel.handleStoreState(expressionTrayViewModel$StoreState);
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
        if (m.areEqual(expressionPickerEvent, ExpressionPickerEvent$CloseExpressionPicker.INSTANCE)) {
            hideExpressionPicker();
            return;
        }
        if (expressionPickerEvent instanceof ExpressionPickerEvent$OpenStickerPicker) {
            ExpressionPickerEvent$OpenStickerPicker expressionPickerEvent$OpenStickerPicker = (ExpressionPickerEvent$OpenStickerPicker) expressionPickerEvent;
            if (!expressionPickerEvent$OpenStickerPicker.getInline()) {
                showStickerPickerSheet(expressionPickerEvent$OpenStickerPicker.getStickerPackId(), expressionPickerEvent$OpenStickerPicker.getSearchText());
            }
            Long stickerPackId = expressionPickerEvent$OpenStickerPicker.getStickerPackId();
            long jLongValue = stickerPackId != null ? stickerPackId.longValue() : -1L;
            selectTab(ExpressionTrayTab.STICKER);
            showStickerPickerInline(Long.valueOf(jLongValue), expressionPickerEvent$OpenStickerPicker.getSearchText());
        }
    }

    private final void handleStoreState(ExpressionTrayViewModel$StoreState storeState) {
        updateViewState2(ExpressionTrayViewModel$ViewState.copy$default(requireViewState(), storeState.getSelectedExpressionTab(), null, false, !storeState.isThreadDraft(), 6, null));
    }

    private final void hideExpressionPicker() {
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ExpressionTrayViewModel$Event$HideExpressionTray.INSTANCE);
    }

    private final void showEmojiPickerSheet() {
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ExpressionTrayViewModel$Event$ShowEmojiPickerSheet.INSTANCE);
    }

    private final void showGifPickerSheet() {
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ExpressionTrayViewModel$Event$ShowGifPickerSheet.INSTANCE);
    }

    private final void showStickerPickerInline(Long stickerPackId, String searchText) {
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new ExpressionTrayViewModel$Event$ShowStickerPicker(stickerPackId, searchText, true));
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
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new ExpressionTrayViewModel$Event$ShowStickerPicker(stickerPackId, searchText, false, 4, null));
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
        ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewStateRequireViewState = requireViewState();
        if (expressionTrayViewModel$ViewStateRequireViewState.getExpressionDetailPage() != null) {
            updateViewState2(ExpressionTrayViewModel$ViewState.copy$default(expressionTrayViewModel$ViewStateRequireViewState, null, null, false, false, 13, null));
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
        ExpressionTrayViewModel$ViewState viewState;
        ExpressionTrayTab selectedExpressionTab;
        if (isActive && !this.wasActive && (viewState = getViewState()) != null && (selectedExpressionTab = viewState.getSelectedExpressionTab()) != null) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab));
        }
        this.wasActive = isActive;
    }

    public final Observable<ExpressionTrayViewModel$Event> observeEvents() {
        PublishSubject<ExpressionTrayViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectGifCategory(GifCategoryItem gifCategoryItem) {
        m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        updateViewState2(ExpressionTrayViewModel$ViewState.copy$default(requireViewState(), null, new ExpressionDetailPage$GifCategoryPage(gifCategoryItem), false, false, 13, null));
    }

    public final void selectTab(ExpressionTrayTab expressionTrayTab) {
        m.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.storeExpressionPickerNavigation.onSelectTab(expressionTrayTab);
    }

    public final void showStickersSearchBar(boolean show) {
        updateViewState2(ExpressionTrayViewModel$ViewState.copy$default(requireViewState(), null, null, show, false, 11, null));
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState) {
        updateViewState2(expressionTrayViewModel$ViewState);
    }

    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ExpressionTrayViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        ExpressionTrayViewModel$ViewState viewState2 = getViewState();
        ExpressionTrayTab selectedExpressionTab = viewState2 != null ? viewState2.getSelectedExpressionTab() : null;
        ExpressionTrayTab selectedExpressionTab2 = viewState.getSelectedExpressionTab();
        if (viewState.getShowLandingPage() && selectedExpressionTab != selectedExpressionTab2 && this.wasActive) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab2));
        }
        super.updateViewState(viewState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable<ExpressionTrayViewModel$StoreState> observable, Observable<ExpressionPickerEvent> observable2) {
        super(new ExpressionTrayViewModel$ViewState(ExpressionTrayTab.EMOJI, null, true, true, 2, null));
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(storeExpressionPickerNavigation, "storeExpressionPickerNavigation");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(observable2, "expressionPickerNavigationObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUser = storeUser;
        this.storeGuildStickers = storeGuildStickers;
        this.storeGuilds = storeGuilds;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), ExpressionTrayViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ExpressionTrayViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), ExpressionTrayViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ExpressionTrayViewModel$2(this), 62, (Object) null);
    }
}
