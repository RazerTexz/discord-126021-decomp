package p659s.p660a;

import androidx.recyclerview.widget.RecyclerView;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.t0 */
/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13151t0 {

    /* JADX INFO: renamed from: a */
    public static final C13037t f27903a = new C13037t("REMOVED_TASK");

    /* JADX INFO: renamed from: b */
    public static final C13037t f27904b = new C13037t("CLOSED_EMPTY");

    /* JADX INFO: renamed from: a */
    public static final long m11348a(long j) {
        if (j <= 0) {
            return 0L;
        }
        return j >= 9223372036854L ? RecyclerView.FOREVER_NS : 1000000 * j;
    }
}
