package b.o.a.r;

import android.content.Context;
import android.hardware.display.DisplayManager$DisplayListener;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: OrientationHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1951b;
    public final f$c c;

    @VisibleForTesting
    public final OrientationEventListener d;
    public boolean h;
    public final Handler a = new Handler(Looper.getMainLooper());
    public int e = -1;
    public int g = -1;

    @VisibleForTesting
    public final DisplayManager$DisplayListener f = new f$b(this);

    public f(@NonNull Context context, @NonNull f$c f_c) {
        this.f1951b = context;
        this.c = f_c;
        this.d = new f$a(this, context.getApplicationContext(), 3);
    }

    public final int a() {
        int rotation = ((WindowManager) this.f1951b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
