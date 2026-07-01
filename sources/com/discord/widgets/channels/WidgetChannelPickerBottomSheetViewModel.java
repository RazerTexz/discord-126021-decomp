package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel extends d0<WidgetChannelPickerBottomSheetViewModel$ViewState> {
    public static final WidgetChannelPickerBottomSheetViewModel$Companion Companion = new WidgetChannelPickerBottomSheetViewModel$Companion(null);
    private WidgetChannelPickerBottomSheetViewModel$StoreState currentStoreState;
    private final long guildId;
    private final boolean hideAnnouncementChannels;
    private String searchQuery;
    private final long selectedChannelId;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreChannels channels = (i & 16) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        this(j, j2, z2, observationDeck2, channels, (i & 32) != 0 ? WidgetChannelPickerBottomSheetViewModel$Companion.access$observeStoreState(Companion, j, observationDeck2, channels, z2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel, WidgetChannelPickerBottomSheetViewModel$StoreState widgetChannelPickerBottomSheetViewModel$StoreState) {
        widgetChannelPickerBottomSheetViewModel.handleStoreState(widgetChannelPickerBottomSheetViewModel$StoreState);
    }

    private final List<ChannelPickerAdapterItem> buildChannelItemList(List<Channel> channels) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ChannelPickerAdapterItem$CreateChannelItem.INSTANCE);
        for (Channel channel : channels) {
            if (t.isBlank(this.searchQuery) || w.contains$default((CharSequence) ChannelUtils.c(channel), (CharSequence) this.searchQuery, false, 2, (Object) null)) {
                arrayList.add(new ChannelPickerAdapterItem$ChannelItem(channel, channel.getId() == this.selectedChannelId));
            }
        }
        return arrayList;
    }

    private final WidgetChannelPickerBottomSheetViewModel$ViewState generateViewState(WidgetChannelPickerBottomSheetViewModel$StoreState storeState) {
        if (storeState instanceof WidgetChannelPickerBottomSheetViewModel$StoreState$Invalid) {
            return WidgetChannelPickerBottomSheetViewModel$ViewState$Loading.INSTANCE;
        }
        if (storeState instanceof WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded) {
            return new WidgetChannelPickerBottomSheetViewModel$ViewState$Loaded(buildChannelItemList(((WidgetChannelPickerBottomSheetViewModel$StoreState$Loaded) storeState).getChannels()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleStoreState(WidgetChannelPickerBottomSheetViewModel$StoreState storeState) {
        this.currentStoreState = storeState;
        updateViewState(generateViewState(storeState));
    }

    public final void updateSearchQuery(String query) {
        m.checkNotNullParameter(query, "query");
        if (m.areEqual(query, this.searchQuery)) {
            return;
        }
        this.searchQuery = query;
        WidgetChannelPickerBottomSheetViewModel$StoreState widgetChannelPickerBottomSheetViewModel$StoreState = this.currentStoreState;
        if (widgetChannelPickerBottomSheetViewModel$StoreState != null) {
            updateViewState(generateViewState(widgetChannelPickerBottomSheetViewModel$StoreState));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel(long j, long j2, boolean z2, ObservationDeck observationDeck, StoreChannels storeChannels, Observable<WidgetChannelPickerBottomSheetViewModel$StoreState> observable) {
        super(WidgetChannelPickerBottomSheetViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.selectedChannelId = j2;
        this.hideAnnouncementChannels = z2;
        this.searchQuery = "";
        Observable<WidgetChannelPickerBottomSheetViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelPickerBottomSheetViewModel$1(this), 62, (Object) null);
    }
}
