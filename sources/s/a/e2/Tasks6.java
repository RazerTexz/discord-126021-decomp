package s.a.e2;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;

/* JADX INFO: renamed from: s.a.e2.j, reason: use source file name */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Tasks6 extends Tasks4 {
    public final Runnable l;

    public Tasks6(Runnable runnable, long j, Tasks5 tasks5) {
        super(j, tasks5);
        this.l = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.l.run();
        } finally {
            this.k.f();
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("Task[");
        sbU.append(b.i.a.f.e.o.f.e0(this.l));
        sbU.append(MentionUtils.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this.l));
        sbU.append(", ");
        sbU.append(this.j);
        sbU.append(", ");
        sbU.append(this.k);
        sbU.append(']');
        return sbU.toString();
    }
}
