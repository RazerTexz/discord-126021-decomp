package s.a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {
    public static final s.a.a.t a = new s.a.a.t("REMOVED_TASK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s.a.a.t f3844b = new s.a.a.t("CLOSED_EMPTY");

    public static final long a(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j;
    }
}
