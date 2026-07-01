package b.i.c.s;

import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Pair<String, String>, Task<o>> f1773b = new ArrayMap();

    public u(Executor executor) {
        this.a = executor;
    }
}
