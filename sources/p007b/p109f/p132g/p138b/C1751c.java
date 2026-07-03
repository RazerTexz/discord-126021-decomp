package p007b.p109f.p132g.p138b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: renamed from: b.f.g.b.c */
/* JADX INFO: compiled from: DraweeEventTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class C1751c {

    /* JADX INFO: renamed from: a */
    public static final C1751c f3260a = new C1751c();

    /* JADX INFO: renamed from: b */
    public static boolean f3261b = true;

    /* JADX INFO: renamed from: c */
    public final Queue<a> f3262c = new ArrayBlockingQueue(20);

    /* JADX INFO: renamed from: b.f.g.b.c$a */
    /* JADX INFO: compiled from: DraweeEventTracker.java */
    public enum a {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    /* JADX INFO: renamed from: a */
    public void m1084a(a aVar) {
        if (f3261b) {
            if (this.f3262c.size() + 1 > 20) {
                this.f3262c.poll();
            }
            this.f3262c.add(aVar);
        }
    }

    public String toString() {
        return this.f3262c.toString();
    }
}
