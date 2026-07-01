package com.discord.widgets.settings.premium;

import com.discord.api.premium.ClaimedOutboundPromotion;
import d0.z.d.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$maybeCheckClaimedPromos$3 extends k implements Function1<List<? extends ClaimedOutboundPromotion>, Unit> {
    public SettingsGiftingViewModel$maybeCheckClaimedPromos$3(BehaviorSubject behaviorSubject) {
        super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ClaimedOutboundPromotion> list) {
        invoke2((List<ClaimedOutboundPromotion>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ClaimedOutboundPromotion> list) {
        ((BehaviorSubject) this.receiver).onNext(list);
    }
}
