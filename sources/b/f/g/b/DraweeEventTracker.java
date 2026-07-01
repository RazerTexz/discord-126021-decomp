package b.f.g.b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: renamed from: b.f.g.b.c, reason: use source file name */
/* JADX INFO: compiled from: DraweeEventTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class DraweeEventTracker {
    public static final DraweeEventTracker a = new DraweeEventTracker();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f494b = true;
    public final Queue<a> c = new ArrayBlockingQueue(20);

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

    public void a(a aVar) {
        if (f494b) {
            if (this.c.size() + 1 > 20) {
                this.c.poll();
            }
            this.c.add(aVar);
        }
    }

    public String toString() {
        return this.c.toString();
    }
}
