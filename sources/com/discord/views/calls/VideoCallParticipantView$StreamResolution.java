package com.discord.views.calls;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class VideoCallParticipantView$StreamResolution {
    public VideoCallParticipantView$StreamResolution() {
    }

    public abstract CharSequence a(Context context);

    public final boolean b() {
        return (this instanceof VideoCallParticipantView$StreamResolution$b) || ((this instanceof VideoCallParticipantView$StreamResolution$a) && ((VideoCallParticipantView$StreamResolution$a) this).a == 1080);
    }

    public VideoCallParticipantView$StreamResolution(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
