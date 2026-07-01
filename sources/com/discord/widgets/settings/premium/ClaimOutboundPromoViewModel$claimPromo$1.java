package com.discord.widgets.settings.premium;

import com.discord.api.premium.ClaimedOutboundPromotion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClaimOutboundPromoViewModel$claimPromo$1 extends o implements Function1<ClaimedOutboundPromotion, Unit> {
    public final /* synthetic */ ClaimOutboundPromoViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel$claimPromo$1(ClaimOutboundPromoViewModel claimOutboundPromoViewModel) {
        super(1);
        this.this$0 = claimOutboundPromoViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ClaimedOutboundPromotion claimedOutboundPromotion) {
        invoke2(claimedOutboundPromotion);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ClaimedOutboundPromotion claimedOutboundPromotion) {
        m.checkNotNullParameter(claimedOutboundPromotion, "claimedPromo");
        ClaimOutboundPromoViewModel claimOutboundPromoViewModel = this.this$0;
        ClaimStatus$Claimed claimStatus$Claimed = new ClaimStatus$Claimed(claimedOutboundPromotion.getPromotion().getId(), claimedOutboundPromotion.getCode(), claimedOutboundPromotion.getPromotion().getOutboundRedemptionModalBody(), claimedOutboundPromotion.d(), claimedOutboundPromotion.c());
        ClaimOutboundPromoViewModel.access$updateViewState(this.this$0, new ClaimOutboundPromoViewModel$ViewState$Claimed(claimStatus$Claimed));
        ClaimOutboundPromoViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) new ClaimOutboundPromoViewModel$Event$Claimed(claimStatus$Claimed));
        ClaimOutboundPromoViewModel.access$setClaimStatus$p(claimOutboundPromoViewModel, claimStatus$Claimed);
    }
}
