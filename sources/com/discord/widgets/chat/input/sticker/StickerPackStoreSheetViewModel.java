package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.premium.PremiumTier;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.User;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStickers$StickerPackState;
import com.discord.stores.StoreStickers$StickerPackState$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel extends d0<StickerPackStoreSheetViewModel$ViewState> {
    public static final StickerPackStoreSheetViewModel$Companion Companion = new StickerPackStoreSheetViewModel$Companion(null);
    private final StickerPackStoreSheetAnalytics analytics;
    private final long stickerPackId;
    private final StoreStickers stickersStore;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeStickers = (i & 2) != 0 ? StoreStream.Companion.getStickers() : storeStickers;
        if ((i & 8) != 0) {
            StickerPackStoreSheetViewModel$Companion stickerPackStoreSheetViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = StickerPackStoreSheetViewModel$Companion.access$observeStoreState(stickerPackStoreSheetViewModel$Companion, j, storeStickers, storeStream$Companion.getUserSettings(), storeStream$Companion.getUsers());
        }
        this(j, storeStickers, stickerPackStoreSheetAnalytics, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerPackStoreSheetViewModel stickerPackStoreSheetViewModel, StickerPackStoreSheetViewModel$StoreState stickerPackStoreSheetViewModel$StoreState) {
        stickerPackStoreSheetViewModel.handleStoreState(stickerPackStoreSheetViewModel$StoreState);
    }

    private final void handleLoadedStoreState(StickerPackStoreSheetViewModel$StoreState storeState) {
        int stickerAnimationSettings = storeState.getStickerAnimationSettings();
        User meUser = storeState.getMeUser();
        ArrayList arrayList = new ArrayList();
        StoreStickers$StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers$StickerPackState$Loaded) stickerPack).getStickerPack();
        arrayList.addAll(StickerPackStoreSheetViewModel$Companion.access$buildStoreStickerListItems(Companion, stickerPack2, stickerAnimationSettings, storeState.getMeUser()));
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.stickersStore.getEnabledStickerPacks();
        boolean z2 = true;
        if ((enabledStickerPacks instanceof Collection) && enabledStickerPacks.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (it.hasNext()) {
                if (((ModelStickerPack) it.next()).getId() == this.stickerPackId) {
                }
            }
            z2 = false;
        }
        updateViewState(new StickerPackStoreSheetViewModel$ViewState(stickerPack2, arrayList, premiumTier, z2));
    }

    @MainThread
    private final void handleStoreState(StickerPackStoreSheetViewModel$StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers$StickerPackState$Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    private final void trackStickerPackStoreSheetViewed() {
        AnalyticsTracker.INSTANCE.stickerPackViewAllViewed(this.analytics.getSticker(), this.analytics.getType().ordinal() != 0 ? "Sticker Pack Detail Sheet" : "Sticker Pack Detail Sheet (Sticker Upsell Popout)", this.analytics.getLocation(), new Traits$Location(null, this.analytics.getLocation(), null, null, null, 29, null));
    }

    public final void fetchStickersData() {
        this.stickersStore.fetchStickerPack(this.stickerPackId);
        this.stickersStore.fetchEnabledStickerDirectory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPackStoreSheetViewModel(long j, StoreStickers storeStickers, StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics, Observable<StickerPackStoreSheetViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(storeStickers, "stickersStore");
        m.checkNotNullParameter(stickerPackStoreSheetAnalytics, "analytics");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.stickerPackId = j;
        this.stickersStore = storeStickers;
        this.analytics = stickerPackStoreSheetAnalytics;
        fetchStickersData();
        trackStickerPackStoreSheetViewed();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StickerPackStoreSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StickerPackStoreSheetViewModel$1(this), 62, (Object) null);
    }
}
