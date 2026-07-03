package p007b.p225i.p361c.p398s;

import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.s.u */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4830u {

    /* JADX INFO: renamed from: a */
    public final Executor f12894a;

    /* JADX INFO: renamed from: b */
    public final Map<Pair<String, String>, Task<InterfaceC4824o>> f12895b = new ArrayMap();

    public C4830u(Executor executor) {
        this.f12894a = executor;
    }
}
