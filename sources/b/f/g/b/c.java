package b.f.g.b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: DraweeEventTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f494b = true;
    public final Queue<c$a> c = new ArrayBlockingQueue(20);

    public void a(c$a c_a) {
        if (f494b) {
            if (this.c.size() + 1 > 20) {
                this.c.poll();
            }
            this.c.add(c_a);
        }
    }

    public String toString() {
        return this.c.toString();
    }
}
