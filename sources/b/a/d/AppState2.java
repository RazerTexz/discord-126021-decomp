package b.a.d;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: b.a.d.l, reason: use source file name */
/* JADX INFO: compiled from: AppState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppState2 {
    public static final AppState2 c = new AppState2();
    public static final ArrayList<Object> a = new ArrayList<>(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BehaviorSubject<Integer> f59b = BehaviorSubject.l0(0);

    public final synchronized void a(Object obj) {
        Intrinsics3.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = a;
        arrayList.add(obj);
        Logger.d$default(AppLog.g, "Gateway Connection consumer add " + obj, null, 2, null);
        f59b.onNext(Integer.valueOf(arrayList.size()));
    }

    public final synchronized void b(Object obj) {
        Intrinsics3.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = a;
        arrayList.remove(obj);
        Logger.d$default(AppLog.g, "Gateway Connection consumer rm " + obj, null, 2, null);
        f59b.onNext(Integer.valueOf(arrayList.size()));
    }
}
