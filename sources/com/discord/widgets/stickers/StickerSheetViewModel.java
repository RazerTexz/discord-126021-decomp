package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStickers$StickerPackState;
import com.discord.stores.StoreStickers$StickerPackState$Loaded;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerSheetViewModel extends d0<StickerSheetViewModel$ViewState> {
    public static final StickerSheetViewModel$Companion Companion = new StickerSheetViewModel$Companion(null);
    private boolean hasFiredAnalytics;
    private final String location;
    private final Sticker sticker;
    private final StoreStickers storeStickers;
    private final StoreUser storeUser;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStickers stickers = (i & 2) != 0 ? StoreStream.Companion.getStickers() : storeStickers;
        StoreUser users = (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        this(sticker, stickers, users, str, (i & 16) != 0 ? StickerSheetViewModel$Companion.access$observeStoreState(Companion, stickers, users, sticker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerSheetViewModel stickerSheetViewModel, StickerSheetViewModel$StoreState stickerSheetViewModel$StoreState) {
        stickerSheetViewModel.handleStoreState(stickerSheetViewModel$StoreState);
    }

    private final void fetchStickersData() {
        StoreStickers storeStickers = this.storeStickers;
        Long packId = this.sticker.getPackId();
        m.checkNotNull(packId);
        storeStickers.fetchStickerPack(packId.longValue());
        this.storeStickers.fetchEnabledStickerDirectory();
    }

    private final void handleLoadedStoreState(StickerSheetViewModel$StoreState storeState) {
        boolean z2;
        MeUser meUser = storeState.getMeUser();
        StoreStickers$StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers$StickerPackState$Loaded) stickerPack).getStickerPack();
        if (!this.hasFiredAnalytics && this.location != null) {
            StickerPurchaseLocation popoutPurchaseLocation = StickerPurchaseLocation.Companion.getPopoutPurchaseLocation(stickerPack2.canBePurchased());
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Long packId = this.sticker.getPackId();
            m.checkNotNull(packId);
            analyticsTracker.stickerPopoutOpened(packId.longValue(), this.location, new Traits$Location(null, popoutPurchaseLocation.getAnalyticsValue(), null, null, null, 29, null));
            this.hasFiredAnalytics = true;
        }
        Sticker sticker = this.sticker;
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.storeStickers.getEnabledStickerPacks();
        boolean z3 = false;
        if (!(enabledStickerPacks instanceof Collection) || !enabledStickerPacks.isEmpty()) {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (it.hasNext()) {
                List<Sticker> stickers = ((ModelStickerPack) it.next()).getStickers();
                if (!(stickers instanceof Collection) || !stickers.isEmpty()) {
                    Iterator<T> it2 = stickers.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        } else {
                            if (((Sticker) it2.next()).getId() == this.sticker.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                } else {
                    z2 = false;
                    break;
                    break;
                }
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        }
        updateViewState(new StickerSheetViewModel$ViewState(stickerPack2, sticker, premiumTier, z3));
    }

    @MainThread
    private final void handleStoreState(StickerSheetViewModel$StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers$StickerPackState$Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable<StickerSheetViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.storeStickers = storeStickers;
        this.storeUser = storeUser;
        this.location = str;
        fetchStickersData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StickerSheetViewModel$1(this), 62, (Object) null);
    }
}
