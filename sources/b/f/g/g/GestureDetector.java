package b.f.g.g;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: renamed from: b.f.g.g.a, reason: use source file name */
/* JADX INFO: compiled from: GestureDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class GestureDetector {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final float f524b;

    @VisibleForTesting
    public long e;

    @VisibleForTesting
    public float f;

    @VisibleForTesting
    public float g;

    @VisibleForTesting
    public a a = null;

    @VisibleForTesting
    public boolean c = false;

    @VisibleForTesting
    public boolean d = false;

    /* JADX INFO: renamed from: b.f.g.g.a$a */
    /* JADX INFO: compiled from: GestureDetector.java */
    public interface a {
    }

    public GestureDetector(Context context) {
        this.f524b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
