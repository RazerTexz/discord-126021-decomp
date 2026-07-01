package s.a;

import androidx.recyclerview.widget.RecyclerView;
import s.a.a.Symbol3;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public static final Symbol3 a = new Symbol3("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Symbol3 f3844b = new Symbol3("CLOSED_EMPTY");

    public static final long a(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j;
    }
}
