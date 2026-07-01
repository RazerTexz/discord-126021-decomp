package b.a.d;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: AppState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final l c = new l();
    public static final ArrayList<Object> a = new ArrayList<>(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BehaviorSubject<Integer> f59b = BehaviorSubject.l0(0);

    public final synchronized void a(Object obj) {
        d0.z.d.m.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = a;
        arrayList.add(obj);
        Logger.d$default(AppLog.g, "Gateway Connection consumer add " + obj, null, 2, null);
        f59b.onNext(Integer.valueOf(arrayList.size()));
    }

    public final synchronized void b(Object obj) {
        d0.z.d.m.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = a;
        arrayList.remove(obj);
        Logger.d$default(AppLog.g, "Gateway Connection consumer rm " + obj, null, 2, null);
        f59b.onNext(Integer.valueOf(arrayList.size()));
    }
}
