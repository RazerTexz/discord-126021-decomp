package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClaimOutboundPromoViewModel extends d0<ClaimOutboundPromoViewModel$ViewState> {
    private ClaimStatus claimStatus;
    private final PublishSubject<ClaimOutboundPromoViewModel$Event> eventSubject;
    private final StoreOutboundPromotions storeOutboundPromotions;

    public /* synthetic */ ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(claimStatus, (i & 2) != 0 ? StoreStream.Companion.getOutboundPromotions() : storeOutboundPromotions);
    }

    public static final /* synthetic */ ClaimStatus access$getClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.claimStatus;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        return claimOutboundPromoViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$setClaimStatus$p(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ClaimStatus claimStatus) {
        claimOutboundPromoViewModel.claimStatus = claimStatus;
    }

    public static final /* synthetic */ void access$updateViewState(ClaimOutboundPromoViewModel claimOutboundPromoViewModel, ClaimOutboundPromoViewModel$ViewState claimOutboundPromoViewModel$ViewState) {
        claimOutboundPromoViewModel.updateViewState(claimOutboundPromoViewModel$ViewState);
    }

    private final void claimPromo(long promoId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.storeOutboundPromotions.claimOutboundPromotion(promoId), false, 1, null), this, null, 2, null), ClaimOutboundPromoViewModel.class, (Context) null, (Function1) null, new ClaimOutboundPromoViewModel$claimPromo$2(this), (Function0) null, (Function0) null, new ClaimOutboundPromoViewModel$claimPromo$1(this), 54, (Object) null);
    }

    @MainThread
    private final void handleClaimStatus() {
        ClaimStatus claimStatus = this.claimStatus;
        if (claimStatus instanceof ClaimStatus$Claimed) {
            updateViewState(new ClaimOutboundPromoViewModel$ViewState$Claimed((ClaimStatus$Claimed) claimStatus));
        } else if (claimStatus instanceof ClaimStatus$Unclaimed) {
            claimPromo(((ClaimStatus$Unclaimed) claimStatus).getPromoId());
        }
    }

    @MainThread
    public final void copyClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus$Claimed)) {
            claimStatus = null;
        }
        ClaimStatus$Claimed claimStatus$Claimed = (ClaimStatus$Claimed) claimStatus;
        if (claimStatus$Claimed != null) {
            PublishSubject<ClaimOutboundPromoViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new ClaimOutboundPromoViewModel$Event$CopyCode(claimStatus$Claimed.getCode()));
        }
    }

    @MainThread
    public final void failureCloseClicked() {
        PublishSubject<ClaimOutboundPromoViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ClaimOutboundPromoViewModel$Event$Dismiss.INSTANCE);
    }

    @MainThread
    public final void maybeLaterClicked() {
        PublishSubject<ClaimOutboundPromoViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(ClaimOutboundPromoViewModel$Event$Dismiss.INSTANCE);
    }

    public final Observable<ClaimOutboundPromoViewModel$Event> observeEvents() {
        PublishSubject<ClaimOutboundPromoViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void redeemClicked() {
        ClaimStatus claimStatus = this.claimStatus;
        if (!(claimStatus instanceof ClaimStatus$Claimed)) {
            claimStatus = null;
        }
        ClaimStatus$Claimed claimStatus$Claimed = (ClaimStatus$Claimed) claimStatus;
        if (claimStatus$Claimed != null) {
            PublishSubject<ClaimOutboundPromoViewModel$Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new ClaimOutboundPromoViewModel$Event$OpenRedemptionUrl(claimStatus$Claimed.getLink()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel(ClaimStatus claimStatus, StoreOutboundPromotions storeOutboundPromotions) {
        super(ClaimOutboundPromoViewModel$ViewState$ClaimInProgress.INSTANCE);
        m.checkNotNullParameter(claimStatus, "claimStatus");
        m.checkNotNullParameter(storeOutboundPromotions, "storeOutboundPromotions");
        this.claimStatus = claimStatus;
        this.storeOutboundPromotions = storeOutboundPromotions;
        this.eventSubject = PublishSubject.k0();
        handleClaimStatus();
    }
}
