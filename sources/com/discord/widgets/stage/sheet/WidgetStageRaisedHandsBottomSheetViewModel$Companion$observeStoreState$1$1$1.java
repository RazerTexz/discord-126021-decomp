package com.discord.widgets.stage.sheet;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1 extends o implements Function1<StoreVoiceParticipants$VoiceUser, Boolean> {
    public static final WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1 INSTANCE = new WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1();

    public WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        return Boolean.valueOf(invoke2(storeVoiceParticipants$VoiceUser));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "voiceUser");
        return storeVoiceParticipants$VoiceUser.getIsRequestingToSpeak();
    }
}
