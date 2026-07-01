package f0.e0.f;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.e0.Util6;
import f0.e0.Util7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: f0.e0.f.d, reason: use source file name */
/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskRunner {
    public static final TaskRunner a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3611b;
    public static final b c = new b(null);
    public int d;
    public boolean e;
    public long f;
    public final List<TaskQueue2> g;
    public final List<TaskQueue2> h;
    public final Runnable i;
    public final a j;

    /* JADX INFO: renamed from: f0.e0.f.d$a */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public interface a {
        void a(TaskRunner taskRunner);

        void b(TaskRunner taskRunner, long j);

        long c();

        void execute(Runnable runnable);
    }

    /* JADX INFO: renamed from: f0.e0.f.d$b */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$c */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class c implements a {
        public final ThreadPoolExecutor a;

        public c(ThreadFactory threadFactory) {
            Intrinsics3.checkParameterIsNotNull(threadFactory, "threadFactory");
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // f0.e0.f.TaskRunner.a
        public void a(TaskRunner taskRunner) {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // f0.e0.f.TaskRunner.a
        public void b(TaskRunner taskRunner, long j) throws InterruptedException {
            Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        @Override // f0.e0.f.TaskRunner.a
        public long c() {
            return System.nanoTime();
        }

        @Override // f0.e0.f.TaskRunner.a
        public void execute(Runnable runnable) {
            Intrinsics3.checkParameterIsNotNull(runnable, "runnable");
            this.a.execute(runnable);
        }
    }

    /* JADX INFO: renamed from: f0.e0.f.d$d */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Task2 task2C;
            while (true) {
                synchronized (TaskRunner.this) {
                    task2C = TaskRunner.this.c();
                }
                if (task2C == null) {
                    return;
                }
                TaskQueue2 taskQueue2 = task2C.a;
                if (taskQueue2 == null) {
                    Intrinsics3.throwNpe();
                }
                long jC = -1;
                b bVar = TaskRunner.c;
                boolean zIsLoggable = TaskRunner.f3611b.isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jC = taskQueue2.e.j.c();
                    f.e(task2C, taskQueue2, "starting");
                }
                try {
                    TaskRunner.a(TaskRunner.this, task2C);
                    if (zIsLoggable) {
                        long jC2 = taskQueue2.e.j.c() - jC;
                        StringBuilder sbU = outline.U("finished run in ");
                        sbU.append(f.a0(jC2));
                        f.e(task2C, taskQueue2, sbU.toString());
                    }
                } catch (Throwable th) {
                    try {
                        TaskRunner.this.j.execute(this);
                        throw th;
                    } catch (Throwable th2) {
                        if (zIsLoggable) {
                            long jC3 = taskQueue2.e.j.c() - jC;
                            StringBuilder sbU2 = outline.U("failed a run in ");
                            sbU2.append(f.a0(jC3));
                            f.e(task2C, taskQueue2, sbU2.toString());
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    static {
        String str = Util7.g + " TaskRunner";
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        a = new TaskRunner(new c(new Util6(str, true)));
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics3.checkExpressionValueIsNotNull(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f3611b = logger;
    }

    public TaskRunner(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "backend");
        this.j = aVar;
        this.d = 10000;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new d();
    }

    public static final void a(TaskRunner taskRunner, Task2 task2) {
        Objects.requireNonNull(taskRunner);
        byte[] bArr = Util7.a;
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task2.c);
        try {
            long jA = task2.a();
            synchronized (taskRunner) {
                taskRunner.b(task2, jA);
            }
        } finally {
            synchronized (taskRunner) {
                taskRunner.b(task2, -1L);
                threadCurrentThread.setName(name);
            }
        }
    }

    public final void b(Task2 task2, long j) {
        byte[] bArr = Util7.a;
        TaskQueue2 taskQueue2 = task2.a;
        if (taskQueue2 == null) {
            Intrinsics3.throwNpe();
        }
        if (!(taskQueue2.f3610b == task2)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean z2 = taskQueue2.d;
        taskQueue2.d = false;
        taskQueue2.f3610b = null;
        this.g.remove(taskQueue2);
        if (j != -1 && !z2 && !taskQueue2.a) {
            taskQueue2.e(task2, j, true);
        }
        if (!taskQueue2.c.isEmpty()) {
            this.h.add(taskQueue2);
        }
    }

    public final Task2 c() {
        boolean z2;
        byte[] bArr = Util7.a;
        while (!this.h.isEmpty()) {
            long jC = this.j.c();
            long jMin = RecyclerView.FOREVER_NS;
            Iterator<TaskQueue2> it = this.h.iterator();
            Task2 task2 = null;
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                Task2 task3 = it.next().c.get(0);
                long jMax = Math.max(0L, task3.f3609b - jC);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z2 = true;
                        break;
                    }
                    task2 = task3;
                }
            }
            if (task2 != null) {
                byte[] bArr2 = Util7.a;
                task2.f3609b = -1L;
                TaskQueue2 taskQueue2 = task2.a;
                if (taskQueue2 == null) {
                    Intrinsics3.throwNpe();
                }
                taskQueue2.c.remove(task2);
                this.h.remove(taskQueue2);
                taskQueue2.f3610b = task2;
                this.g.add(taskQueue2);
                if (z2 || (!this.e && (!this.h.isEmpty()))) {
                    this.j.execute(this.i);
                }
                return task2;
            }
            if (this.e) {
                if (jMin < this.f - jC) {
                    this.j.a(this);
                }
                return null;
            }
            this.e = true;
            this.f = jC + jMin;
            try {
                try {
                    this.j.b(this, jMin);
                } catch (InterruptedException unused) {
                    d();
                }
                this.e = false;
            } catch (Throwable th) {
                this.e = false;
                throw th;
            }
        }
        return null;
    }

    public final void d() {
        for (int size = this.g.size() - 1; size >= 0; size--) {
            this.g.get(size).b();
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            TaskQueue2 taskQueue2 = this.h.get(size2);
            taskQueue2.b();
            if (taskQueue2.c.isEmpty()) {
                this.h.remove(size2);
            }
        }
    }

    public final void e(TaskQueue2 taskQueue2) {
        Intrinsics3.checkParameterIsNotNull(taskQueue2, "taskQueue");
        byte[] bArr = Util7.a;
        if (taskQueue2.f3610b == null) {
            if (!taskQueue2.c.isEmpty()) {
                List<TaskQueue2> list = this.h;
                Intrinsics3.checkParameterIsNotNull(list, "$this$addIfAbsent");
                if (!list.contains(taskQueue2)) {
                    list.add(taskQueue2);
                }
            } else {
                this.h.remove(taskQueue2);
            }
        }
        if (this.e) {
            this.j.a(this);
        } else {
            this.j.execute(this.i);
        }
    }

    public final TaskQueue2 f() {
        int i;
        synchronized (this) {
            i = this.d;
            this.d = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new TaskQueue2(this, sb.toString());
    }
}
