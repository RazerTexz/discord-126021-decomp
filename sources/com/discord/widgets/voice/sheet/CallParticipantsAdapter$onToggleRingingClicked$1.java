package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreVoiceParticipants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$onToggleRingingClicked$1 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
    public static final CallParticipantsAdapter$onToggleRingingClicked$1 INSTANCE = new CallParticipantsAdapter$onToggleRingingClicked$1();

    public CallParticipantsAdapter$onToggleRingingClicked$1() {
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
