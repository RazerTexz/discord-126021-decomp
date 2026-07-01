package b.o.a.p;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final b.o.a.b a = new b.o.a.b(b.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1945b;
    public Object c = null;
    public long d = -1;
    public long e = -1;

    public b(@NonNull c cVar) {
        this.f1945b = cVar;
    }

    public long a() {
        if (this.c != null) {
            return this.d;
        }
        a.a(3, "Frame is dead! time:", Long.valueOf(this.d), "lastTime:", Long.valueOf(this.e));
        throw new RuntimeException("You should not access a released frame. If this frame was passed to a FrameProcessor, you can only use its contents synchronously, for the duration of the process() method.");
    }

    public void b() {
        if (this.c != null) {
            a.a(0, "Frame with time", Long.valueOf(this.d), "is being released.");
            Object obj = this.c;
            this.c = null;
            this.d = -1L;
            c cVar = this.f1945b;
            if (cVar.b()) {
                cVar.c(obj, cVar.g.offer(this));
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).d == this.d;
    }
}
