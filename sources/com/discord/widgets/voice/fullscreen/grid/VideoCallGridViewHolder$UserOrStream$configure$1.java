package com.discord.widgets.voice.fullscreen.grid;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridViewHolder$UserOrStream$configure$1 implements View$OnClickListener {
    public final /* synthetic */ CallParticipant$UserOrStreamParticipant $callParticipant;
    public final /* synthetic */ Function1 $onTapped;

    public VideoCallGridViewHolder$UserOrStream$configure$1(Function1 function1, CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant) {
        this.$onTapped = function1;
        this.$callParticipant = callParticipant$UserOrStreamParticipant;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onTapped.invoke(this.$callParticipant);
    }
}
