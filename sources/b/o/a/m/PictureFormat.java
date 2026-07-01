package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.j, reason: use source file name */
/* JADX INFO: compiled from: PictureFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public enum PictureFormat implements Control {
    JPEG(0),
    DNG(1);

    private int value;

    PictureFormat(int i) {
        this.value = i;
    }

    @NonNull
    public static PictureFormat f(int i) {
        PictureFormat[] pictureFormatArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            PictureFormat pictureFormat = pictureFormatArrValues[i2];
            if (pictureFormat.value == i) {
                return pictureFormat;
            }
        }
        return JPEG;
    }

    public int g() {
        return this.value;
    }
}
