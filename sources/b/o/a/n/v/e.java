package b.o.a.n.v;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CameraState.java */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);

    private int mState;

    e(int i) {
        this.mState = i;
    }

    public boolean f(@NonNull e eVar) {
        return this.mState >= eVar.mState;
    }
}
