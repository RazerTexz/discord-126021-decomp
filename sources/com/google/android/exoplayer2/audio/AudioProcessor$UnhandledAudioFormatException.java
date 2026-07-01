package com.google.android.exoplayer2.audio;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioProcessor$UnhandledAudioFormatException extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public AudioProcessor$UnhandledAudioFormatException(AudioProcessor$a audioProcessor$a) {
        String strValueOf = String.valueOf(audioProcessor$a);
        super(a.j(strValueOf.length() + 18, "Unhandled format: ", strValueOf));
    }
}
