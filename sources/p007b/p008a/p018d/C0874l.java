package p007b.p008a.p018d;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import java.util.ArrayList;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: b.a.d.l */
/* JADX INFO: compiled from: AppState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0874l {

    /* JADX INFO: renamed from: c */
    public static final C0874l f530c = new C0874l();

    /* JADX INFO: renamed from: a */
    public static final ArrayList<Object> f528a = new ArrayList<>(4);

    /* JADX INFO: renamed from: b */
    public static final BehaviorSubject<Integer> f529b = BehaviorSubject.m11130l0(0);

    /* JADX INFO: renamed from: a */
    public final synchronized void m161a(Object obj) {
        C12238m.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = f528a;
        arrayList.add(obj);
        Logger.d$default(AppLog.f14950g, "Gateway Connection consumer add " + obj, null, 2, null);
        f529b.onNext(Integer.valueOf(arrayList.size()));
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m162b(Object obj) {
        C12238m.checkNotNullParameter(obj, "consumer");
        ArrayList<Object> arrayList = f528a;
        arrayList.remove(obj);
        Logger.d$default(AppLog.f14950g, "Gateway Connection consumer rm " + obj, null, 2, null);
        f529b.onNext(Integer.valueOf(arrayList.size()));
    }
}
