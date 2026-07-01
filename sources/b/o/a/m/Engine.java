package b.o.a.m;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.m.d, reason: use source file name */
/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Engine implements Control {
    CAMERA1(0),
    CAMERA2(1);

    private int value;

    Engine(int i) {
        this.value = i;
    }

    @NonNull
    public static Engine f(int i) {
        Engine[] engineArrValues = values();
        for (int i2 = 0; i2 < 2; i2++) {
            Engine engine = engineArrValues[i2];
            if (engine.value == i) {
                return engine;
            }
        }
        return CAMERA1;
    }

    public int g() {
        return this.value;
    }
}
