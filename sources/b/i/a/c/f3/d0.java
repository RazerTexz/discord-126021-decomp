package b.i.a.c.f3;

import androidx.annotation.GuardedBy;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import java.util.Objects;

/* JADX INFO: compiled from: TimestampAdjuster.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    @GuardedBy("this")
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public long f966b;

    @GuardedBy("this")
    public long c;
    public final ThreadLocal<Long> d = new ThreadLocal<>();

    public d0(long j) {
        e(j);
    }

    public synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f966b == -9223372036854775807L) {
            long jLongValue = this.a;
            if (jLongValue == 9223372036854775806L) {
                Long l = this.d.get();
                Objects.requireNonNull(l);
                jLongValue = l.longValue();
            }
            this.f966b = jLongValue - j;
            notifyAll();
        }
        this.c = j;
        return j + this.f966b;
    }

    public synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.c;
        if (j2 != -9223372036854775807L) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (Permission.REQUEST_TO_SPEAK + j3) / Permission.MANAGE_EVENTS;
            long j5 = ((j4 - 1) * Permission.MANAGE_EVENTS) + j;
            long j6 = (j4 * Permission.MANAGE_EVENTS) + j;
            j = Math.abs(j5 - j3) < Math.abs(j6 - j3) ? j5 : j6;
        }
        return a((j * 1000000) / 90000);
    }

    public synchronized long c() {
        long j;
        j = this.a;
        if (j == RecyclerView.FOREVER_NS || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long d() {
        return this.f966b;
    }

    public synchronized void e(long j) {
        this.a = j;
        this.f966b = j == RecyclerView.FOREVER_NS ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }
}
