package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageRaisedHandsBottomSheet$onViewCreated$4 extends k implements Function1<StoreVoiceParticipants$VoiceUser, Unit> {
    public WidgetStageRaisedHandsBottomSheet$onViewCreated$4(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
        super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "inviteToSpeak", "inviteToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        invoke2(storeVoiceParticipants$VoiceUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "p1");
        ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).inviteToSpeak(storeVoiceParticipants$VoiceUser);
    }
}
