package f0.e0.f;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.f.TaskRunner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: renamed from: f0.e0.f.c, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue2 {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task2 f3610b;
    public final List<Task2> c;
    public boolean d;
    public final TaskRunner e;
    public final String f;

    public TaskQueue2(TaskRunner taskRunner, String str) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.e = taskRunner;
        this.f = str;
        this.c = new ArrayList();
    }

    public static /* synthetic */ void d(TaskQueue2 taskQueue2, Task2 task2, long j, int i) {
        if ((i & 2) != 0) {
            j = 0;
        }
        taskQueue2.c(task2, j);
    }

    public final void a() {
        byte[] bArr = Util7.a;
        synchronized (this.e) {
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public final boolean b() {
        Task2 task2 = this.f3610b;
        if (task2 != null) {
            if (task2 == null) {
                Intrinsics3.throwNpe();
            }
            if (task2.d) {
                this.d = true;
            }
        }
        boolean z2 = false;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (this.c.get(size).d) {
                Task2 task3 = this.c.get(size);
                Objects.requireNonNull(TaskRunner.c);
                if (TaskRunner.f3611b.isLoggable(Level.FINE)) {
                    f.e(task3, this, "canceled");
                }
                this.c.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(Task2 task2, long j) {
        Intrinsics3.checkParameterIsNotNull(task2, "task");
        synchronized (this.e) {
            if (!this.a) {
                if (e(task2, j, false)) {
                    this.e.e(this);
                }
            } else if (task2.d) {
                Objects.requireNonNull(TaskRunner.c);
                if (TaskRunner.f3611b.isLoggable(Level.FINE)) {
                    f.e(task2, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Objects.requireNonNull(TaskRunner.c);
                if (TaskRunner.f3611b.isLoggable(Level.FINE)) {
                    f.e(task2, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean e(Task2 task2, long j, boolean z2) {
        String string;
        Intrinsics3.checkParameterIsNotNull(task2, "task");
        Objects.requireNonNull(task2);
        Intrinsics3.checkParameterIsNotNull(this, "queue");
        TaskQueue2 taskQueue2 = task2.a;
        if (taskQueue2 != this) {
            if (!(taskQueue2 == null)) {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
            task2.a = this;
        }
        long jC = this.e.j.c();
        long j2 = jC + j;
        int iIndexOf = this.c.indexOf(task2);
        if (iIndexOf != -1) {
            if (task2.f3609b <= j2) {
                TaskRunner.b bVar = TaskRunner.c;
                if (TaskRunner.f3611b.isLoggable(Level.FINE)) {
                    f.e(task2, this, "already scheduled");
                }
                return false;
            }
            this.c.remove(iIndexOf);
        }
        task2.f3609b = j2;
        TaskRunner.b bVar2 = TaskRunner.c;
        if (TaskRunner.f3611b.isLoggable(Level.FINE)) {
            if (z2) {
                StringBuilder sbU = outline.U("run again after ");
                sbU.append(f.a0(j2 - jC));
                string = sbU.toString();
            } else {
                StringBuilder sbU2 = outline.U("scheduled after ");
                sbU2.append(f.a0(j2 - jC));
                string = sbU2.toString();
            }
            f.e(task2, this, string);
        }
        Iterator<Task2> it = this.c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().f3609b - jC > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.c.size();
        }
        this.c.add(size, task2);
        return size == 0;
    }

    public final void f() {
        byte[] bArr = Util7.a;
        synchronized (this.e) {
            this.a = true;
            if (b()) {
                this.e.e(this);
            }
        }
    }

    public String toString() {
        return this.f;
    }
}
