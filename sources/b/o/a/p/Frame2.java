package b.o.a.p;

import androidx.annotation.NonNull;
import b.o.a.CameraLogger;

/* JADX INFO: renamed from: b.o.a.p.b, reason: use source file name */
/* JADX INFO: compiled from: Frame.java */
/* JADX INFO: loaded from: classes3.dex */
public class Frame2 {
    public static final CameraLogger a = new CameraLogger(Frame2.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameManager f1945b;
    public Object c = null;
    public long d = -1;
    public long e = -1;

    public Frame2(@NonNull FrameManager frameManager) {
        this.f1945b = frameManager;
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
            FrameManager frameManager = this.f1945b;
            if (frameManager.b()) {
                frameManager.c(obj, frameManager.g.offer(this));
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Frame2) && ((Frame2) obj).d == this.d;
    }
}
