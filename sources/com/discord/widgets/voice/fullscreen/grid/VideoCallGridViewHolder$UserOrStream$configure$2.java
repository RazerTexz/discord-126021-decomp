package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridViewHolder$UserOrStream$configure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ CallParticipant$UserOrStreamParticipant $callParticipant;
    public final /* synthetic */ Function1 $onLongClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallGridViewHolder$UserOrStream$configure$2(Function1 function1, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant) {
        super(1);
        this.$onLongClicked = function1;
        this.$callParticipant = callParticipant$UserOrStreamParticipant;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$onLongClicked.invoke(this.$callParticipant);
    }
}
