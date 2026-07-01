package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaViewHolder$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ StageCallItem$MediaItem $item;
    public final /* synthetic */ MediaViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaViewHolder$onConfigure$2(MediaViewHolder mediaViewHolder, StageCallItem$MediaItem stageCallItem$MediaItem) {
        super(1);
        this.this$0 = mediaViewHolder;
        this.$item = stageCallItem$MediaItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        MediaViewHolder.access$getAdapter$p(this.this$0).getOnMediaParticipantLongClicked().invoke(this.$item.getUserOrStreamParticipant());
    }
}
