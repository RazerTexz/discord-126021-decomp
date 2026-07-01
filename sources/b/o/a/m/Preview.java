package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.k, reason: use source file name */
/* JADX INFO: compiled from: Preview.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Preview implements Control {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;

    Preview(int i) {
        this.value = i;
    }

    @NonNull
    public static Preview f(int i) {
        Preview[] previewArrValues = values();
        for (int i2 = 0; i2 < 3; i2++) {
            Preview preview = previewArrValues[i2];
            if (preview.value == i) {
                return preview;
            }
        }
        return GL_SURFACE;
    }

    public int g() {
        return this.value;
    }
}
