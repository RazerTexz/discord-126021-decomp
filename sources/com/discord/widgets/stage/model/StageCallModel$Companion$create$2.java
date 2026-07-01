package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem$SpeakerItem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel$Companion$create$2 extends o implements Function1<StageCallItem$SpeakerItem, Boolean> {
    public static final StageCallModel$Companion$create$2 INSTANCE = new StageCallModel$Companion$create$2();

    public StageCallModel$Companion$create$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem$SpeakerItem stageCallItem$SpeakerItem) {
        return Boolean.valueOf(invoke2(stageCallItem$SpeakerItem));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem$SpeakerItem stageCallItem$SpeakerItem) {
        m.checkNotNullParameter(stageCallItem$SpeakerItem, "it");
        return stageCallItem$SpeakerItem.getVoiceUser().getIsSpeaking() && !stageCallItem$SpeakerItem.getVoiceUser().isMe();
    }
}
