package com.discord.views.calls;

import android.content.Context;
import b.a.k.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView$StreamResolution$a extends VideoCallParticipantView$StreamResolution {
    public final int a;

    public VideoCallParticipantView$StreamResolution$a(int i) {
        super(null);
        this.a = i;
    }

    @Override // com.discord.views.calls.VideoCallParticipantView$StreamResolution
    public CharSequence a(Context context) {
        m.checkNotNullParameter(context, "context");
        return b.h(context, 2131895282, new Object[]{Integer.valueOf(this.a)}, null, 4);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof VideoCallParticipantView$StreamResolution$a) && this.a == ((VideoCallParticipantView$StreamResolution$a) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return a.B(a.U("Fixed(heightPx="), this.a, ")");
    }
}
