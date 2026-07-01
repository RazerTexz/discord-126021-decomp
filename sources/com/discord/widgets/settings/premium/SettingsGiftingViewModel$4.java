package com.discord.widgets.settings.premium;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$4 extends k implements Function1<SettingsGiftingViewModel$StoreState, Unit> {
    public SettingsGiftingViewModel$4(BehaviorSubject behaviorSubject) {
        super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState) {
        invoke2(settingsGiftingViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState) {
        ((BehaviorSubject) this.receiver).onNext(settingsGiftingViewModel$StoreState);
    }
}
