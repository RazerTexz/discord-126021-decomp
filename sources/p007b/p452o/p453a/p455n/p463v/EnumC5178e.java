package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.n.v.e */
/* JADX INFO: compiled from: CameraState.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC5178e {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);

    private int mState;

    EnumC5178e(int i) {
        this.mState = i;
    }

    /* JADX INFO: renamed from: f */
    public boolean m7367f(@NonNull EnumC5178e enumC5178e) {
        return this.mState >= enumC5178e.mState;
    }
}
