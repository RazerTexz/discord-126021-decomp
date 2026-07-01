package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$onVoiceUserClicked$1 extends o implements Function1<StoreVoiceParticipants$VoiceUser, Unit> {
    public static final CallParticipantsAdapter$onVoiceUserClicked$1 INSTANCE = new CallParticipantsAdapter$onVoiceUserClicked$1();

    public CallParticipantsAdapter$onVoiceUserClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        invoke2(storeVoiceParticipants$VoiceUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        m.checkNotNullParameter(storeVoiceParticipants$VoiceUser, "it");
    }
}
