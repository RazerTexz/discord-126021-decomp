package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.a, reason: use source file name */
/* JADX INFO: compiled from: Audio.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Audio implements Control {
    OFF(0),
    ON(1),
    MONO(2),
    STEREO(3);

    private int value;

    Audio(int i) {
        this.value = i;
    }

    @NonNull
    public static Audio f(int i) {
        Audio[] audioArrValues = values();
        for (int i2 = 0; i2 < 4; i2++) {
            Audio audio = audioArrValues[i2];
            if (audio.value == i) {
                return audio;
            }
        }
        return ON;
    }

    public int g() {
        return this.value;
    }
}
