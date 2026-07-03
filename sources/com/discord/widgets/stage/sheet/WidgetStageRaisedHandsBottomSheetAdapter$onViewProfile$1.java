package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1 INSTANCE = new WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1();

    public WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
        invoke2(voiceUser);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
        C12238m.checkNotNullParameter(voiceUser, "it");
    }
}
