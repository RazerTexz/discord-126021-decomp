package com.discord.widgets.voice.fullscreen.grid;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PrivateCallBlurredGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallBlurredGridView$configure$callUserOrderChanged$1 extends o implements Function2<StoreVoiceParticipants$VoiceUser, StoreVoiceParticipants$VoiceUser, Boolean> {
    public static final PrivateCallBlurredGridView$configure$callUserOrderChanged$1 INSTANCE = new PrivateCallBlurredGridView$configure$callUserOrderChanged$1();

    public PrivateCallBlurredGridView$configure$callUserOrderChanged$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2) {
        return Boolean.valueOf(invoke2(storeVoiceParticipants$VoiceUser, storeVoiceParticipants$VoiceUser2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "o1");
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser2, "o2");
        return storeVoiceParticipants$VoiceUser.getUser().getId() == storeVoiceParticipants$VoiceUser2.getUser().getId();
    }
}
