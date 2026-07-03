package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.channels.ChannelPickerAdapterItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreState currentStoreState;
    private final long guildId;
    private final boolean hideAnnouncementChannels;
    private String searchQuery;
    private final long selectedChannelId;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static final class C73341 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C73341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel = WidgetChannelPickerBottomSheetViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetChannelPickerBottomSheetViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels, boolean hideAnnouncementChannels) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels}, false, null, null, new C7335xde672eda(storeChannels, guildId, hideAnnouncementChannels), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final List<Channel> channels;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Channel> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "channels");
                this.channels = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.channels;
                }
                return loaded.copy(list);
            }

            public final List<Channel> component1() {
                return this.channels;
            }

            public final Loaded copy(List<Channel> channels) {
                C12238m.checkNotNullParameter(channels, "channels");
                return new Loaded(channels);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.channels, ((Loaded) other).channels);
                }
                return true;
            }

            public final List<Channel> getChannels() {
                return this.channels;
            }

            public int hashCode() {
                List<Channel> list = this.channels;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(channels="), this.channels, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<ChannelPickerAdapterItem> adapterItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ChannelPickerAdapterItem> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                return loaded.copy(list);
            }

            public final List<ChannelPickerAdapterItem> component1() {
                return this.adapterItems;
            }

            public final Loaded copy(List<? extends ChannelPickerAdapterItem> adapterItems) {
                C12238m.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.adapterItems, ((Loaded) other).adapterItems);
                }
                return true;
            }

            public final List<ChannelPickerAdapterItem> getAdapterItems() {
                return this.adapterItems;
            }

            public int hashCode() {
                List<ChannelPickerAdapterItem> list = this.adapterItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(adapterItems="), this.adapterItems, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        this(j, j2, z2, observationDeck2, channels, (i & 32) != 0 ? INSTANCE.observeStoreState(j, observationDeck2, channels, z2) : observable);
    }

    private final List<ChannelPickerAdapterItem> buildChannelItemList(List<Channel> channels) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ChannelPickerAdapterItem.CreateChannelItem.INSTANCE);
        for (Channel channel : channels) {
            if (C12103t.isBlank(this.searchQuery) || C12106w.contains$default((CharSequence) ChannelUtils.m7679c(channel), (CharSequence) this.searchQuery, false, 2, (Object) null)) {
                arrayList.add(new ChannelPickerAdapterItem.ChannelItem(channel, channel.getId() == this.selectedChannelId));
            }
        }
        return arrayList;
    }

    private final ViewState generateViewState(StoreState storeState) {
        if (storeState instanceof StoreState.Invalid) {
            return ViewState.Loading.INSTANCE;
        }
        if (storeState instanceof StoreState.Loaded) {
            return new ViewState.Loaded(buildChannelItemList(((StoreState.Loaded) storeState).getChannels()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        updateViewState(generateViewState(storeState));
    }

    public final void updateSearchQuery(String query) {
        C12238m.checkNotNullParameter(query, "query");
        if (C12238m.areEqual(query, this.searchQuery)) {
            return;
        }
        this.searchQuery = query;
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.selectedChannelId = j2;
        this.hideAnnouncementChannels = z2;
        this.searchQuery = "";
        Observable<StoreState> observableM11112r = observable.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetChannelPickerBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C73341());
    }
}
