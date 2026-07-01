package b.i.a.c.g3;

import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager$DisplayListener;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(17)
public final class v$d implements v$b, DisplayManager$DisplayListener {
    public final DisplayManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public v$b$a f994b;

    public v$d(DisplayManager displayManager) {
        this.a = displayManager;
    }

    @Override // b.i.a.c.g3.v$b
    public void a(v$b$a v_b_a) {
        this.f994b = v_b_a;
        this.a.registerDisplayListener(this, e0.j());
        ((b) v_b_a).a(this.a.getDisplay(0));
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayChanged(int i) {
        v$b$a v_b_a = this.f994b;
        if (v_b_a == null || i != 0) {
            return;
        }
        ((b) v_b_a).a(this.a.getDisplay(0));
    }

    @Override // android.hardware.display.DisplayManager$DisplayListener
    public void onDisplayRemoved(int i) {
    }

    @Override // b.i.a.c.g3.v$b
    public void unregister() {
        this.a.unregisterDisplayListener(this);
        this.f994b = null;
    }
}
