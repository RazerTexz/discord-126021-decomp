package com.discord.widgets.stage.model;

import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stage.model.StageCallModel$Companion$create$2, reason: use source file name */
/* JADX INFO: compiled from: StageCallModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallModel2 extends Lambda implements Function1<StageCallItem.SpeakerItem, Boolean> {
    public static final StageCallModel2 INSTANCE = new StageCallModel2();

    public StageCallModel2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageCallItem.SpeakerItem speakerItem) {
        return Boolean.valueOf(invoke2(speakerItem));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageCallItem.SpeakerItem speakerItem) {
        Intrinsics3.checkNotNullParameter(speakerItem, "it");
        return speakerItem.getVoiceUser().getIsSpeaking() && !speakerItem.getVoiceUser().isMe();
    }
}
