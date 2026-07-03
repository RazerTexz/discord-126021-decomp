package com.discord.widgets.stage.model;

import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion$create$3 extends AbstractC12240o implements Function1<StageCallItem.SpeakerItem, StoreVoiceParticipants.VoiceUser> {
    public static final StageCallModel$Companion$create$3 INSTANCE = new StageCallModel$Companion$create$3();

    public StageCallModel$Companion$create$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreVoiceParticipants.VoiceUser invoke(StageCallItem.SpeakerItem speakerItem) {
        C12238m.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser();
    }
}
