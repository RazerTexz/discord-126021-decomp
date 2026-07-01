package b.i.a.c.g3;

import android.view.WindowManager;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$c implements v$b {
    public final WindowManager a;

    public v$c(WindowManager windowManager) {
        this.a = windowManager;
    }

    @Override // b.i.a.c.g3.v$b
    public void a(v$b$a v_b_a) {
        ((b) v_b_a).a(this.a.getDefaultDisplay());
    }

    @Override // b.i.a.c.g3.v$b
    public void unregister() {
    }
}
