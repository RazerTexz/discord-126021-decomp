package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.voice.fullscreen.CallParticipant$EmbeddedActivityParticipant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridViewHolder$EmbeddedActivity$configure$1 implements View$OnClickListener {
    public final /* synthetic */ CallParticipant$EmbeddedActivityParticipant $callParticipant;
    public final /* synthetic */ Function1 $onTapped;

    public VideoCallGridViewHolder$EmbeddedActivity$configure$1(Function1 function1, CallParticipant$EmbeddedActivityParticipant callParticipant$EmbeddedActivityParticipant) {
        this.$onTapped = function1;
        this.$callParticipant = callParticipant$EmbeddedActivityParticipant;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onTapped.invoke(this.$callParticipant);
    }
}
