package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion$create$2 extends AbstractC12240o implements Function1<StageCallItem.SpeakerItem, Boolean> {
    public static final StageCallModel$Companion$create$2 INSTANCE = new StageCallModel$Companion$create$2();

    public StageCallModel$Companion$create$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem.SpeakerItem speakerItem) {
        return Boolean.valueOf(invoke2(speakerItem));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem.SpeakerItem speakerItem) {
        C12238m.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser().getIsSpeaking() && !speakerItem.getVoiceUser().isMe();
    }
}
