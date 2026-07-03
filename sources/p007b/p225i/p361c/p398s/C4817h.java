package p007b.p225i.p361c.p398s;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;

/* JADX INFO: renamed from: b.i.c.s.h */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4817h {

    /* JADX INFO: renamed from: a */
    public static final Executor f12866a = ExecutorC4816g.f12865j;

    /* JADX INFO: renamed from: a */
    public static ExecutorService m6726a() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3408a("firebase-iid-executor"));
    }
}
