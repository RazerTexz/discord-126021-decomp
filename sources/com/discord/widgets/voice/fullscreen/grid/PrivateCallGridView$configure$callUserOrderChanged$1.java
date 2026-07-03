package com.discord.widgets.voice.fullscreen.grid;

import com.discord.stores.StoreVoiceParticipants;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PrivateCallGridView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallGridView$configure$callUserOrderChanged$1 extends AbstractC12240o implements Function2<StoreVoiceParticipants.VoiceUser, StoreVoiceParticipants.VoiceUser, Boolean> {
    public static final PrivateCallGridView$configure$callUserOrderChanged$1 INSTANCE = new PrivateCallGridView$configure$callUserOrderChanged$1();

    public PrivateCallGridView$configure$callUserOrderChanged$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return Boolean.valueOf(invoke2(voiceUser, voiceUser2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        C12238m.checkNotNullParameter(voiceUser, "o1");
        C12238m.checkNotNullParameter(voiceUser2, "o2");
        return voiceUser.getUser().getId() == voiceUser2.getUser().getId();
    }
}
