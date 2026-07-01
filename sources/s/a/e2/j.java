package s.a.e2;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends h {
    public final Runnable l;

    public j(Runnable runnable, long j, i iVar) {
        super(j, iVar);
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
        StringBuilder sbU = b.d.b.a.a.U("Task[");
        sbU.append(b.i.a.f.e.o.f.e0(this.l));
        sbU.append(MentionUtilsKt.MENTIONS_CHAR);
        sbU.append(b.i.a.f.e.o.f.l0(this.l));
        sbU.append(", ");
        sbU.append(this.j);
        sbU.append(", ");
        sbU.append(this.k);
        sbU.append(']');
        return sbU.toString();
    }
}
