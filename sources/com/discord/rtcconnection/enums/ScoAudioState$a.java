package com.discord.rtcconnection.enums;

import android.content.Intent;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScoAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScoAudioState$a {
    public ScoAudioState$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final ScoAudioState a(int i) {
        ScoAudioState[] scoAudioStateArrValues = ScoAudioState.values();
        for (int i2 = 0; i2 < 4; i2++) {
            ScoAudioState scoAudioState = scoAudioStateArrValues[i2];
            if (scoAudioState.getValue() == i) {
                return scoAudioState;
            }
        }
        return null;
    }

    public final ScoAudioState$b b(Intent intent) {
        m.checkNotNullParameter(intent, "intent");
        if (!m.areEqual(intent.getAction(), "android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ScoAudioState scoAudioStateA = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0));
        m.checkNotNull(scoAudioStateA);
        ScoAudioState scoAudioStateA2 = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", 0));
        m.checkNotNull(scoAudioStateA2);
        return new ScoAudioState$b(scoAudioStateA, scoAudioStateA2);
    }
}
