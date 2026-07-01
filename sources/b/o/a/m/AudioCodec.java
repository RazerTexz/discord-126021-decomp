package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.b, reason: use source file name */
/* JADX INFO: compiled from: AudioCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public enum AudioCodec implements Control {
    DEVICE_DEFAULT(0),
    AAC(1),
    HE_AAC(2),
    AAC_ELD(3);

    private int value;

    AudioCodec(int i) {
        this.value = i;
    }

    @NonNull
    public static AudioCodec f(int i) {
        AudioCodec[] audioCodecArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            AudioCodec audioCodec = audioCodecArrValues[i2];
            if (audioCodec.value == i) {
                return audioCodec;
            }
        }
        return DEVICE_DEFAULT;
    }

    public int g() {
        return this.value;
    }
}
