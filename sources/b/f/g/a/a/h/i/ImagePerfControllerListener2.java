package b.f.g.a.a.h.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import b.f.d.k.MonotonicClock;
import b.f.g.a.a.h.ImagePerfMonitor;
import b.f.g.a.a.h.ImagePerfNotifier;
import b.f.g.a.a.h.ImagePerfState;
import b.f.h.b.a.BaseControllerListener2;
import b.f.h.b.a.ControllerListener2;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.g.a.a.h.i.a, reason: use source file name */
/* JADX INFO: compiled from: ImagePerfControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePerfControllerListener2 extends BaseControllerListener2<ImageInfo> implements Closeable {
    public static Handler j;
    public final MonotonicClock k;
    public final ImagePerfState l;
    public final ImagePerfNotifier m;
    public final Supplier<Boolean> n;
    public final Supplier<Boolean> o;

    /* JADX INFO: renamed from: b.f.g.a.a.h.i.a$a */
    /* JADX INFO: compiled from: ImagePerfControllerListener2.java */
    public static class a extends Handler {
        public final ImagePerfNotifier a;

        public a(@NonNull Looper looper, @NonNull ImagePerfNotifier imagePerfNotifier) {
            super(looper);
            this.a = imagePerfNotifier;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            Objects.requireNonNull(obj);
            ImagePerfState imagePerfState = (ImagePerfState) obj;
            int i = message.what;
            if (i == 1) {
                ((ImagePerfMonitor) this.a).b(imagePerfState, message.arg1);
            } else {
                if (i != 2) {
                    return;
                }
                ((ImagePerfMonitor) this.a).a(imagePerfState, message.arg1);
            }
        }
    }

    public ImagePerfControllerListener2(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfNotifier imagePerfNotifier, Supplier<Boolean> supplier, Supplier<Boolean> supplier2) {
        this.k = monotonicClock;
        this.l = imagePerfState;
        this.m = imagePerfNotifier;
        this.n = supplier;
        this.o = supplier2;
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void a(String str, Object obj, ControllerListener2.a aVar) {
        long jNow = this.k.now();
        ImagePerfState imagePerfStateE = e();
        imagePerfStateE.b();
        imagePerfStateE.i = jNow;
        imagePerfStateE.a = str;
        imagePerfStateE.d = obj;
        imagePerfStateE.A = aVar;
        n(imagePerfStateE, 0);
        imagePerfStateE.w = 1;
        imagePerfStateE.f488x = jNow;
        q(imagePerfStateE, 1);
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void b(String str, Throwable th, ControllerListener2.a aVar) {
        long jNow = this.k.now();
        ImagePerfState imagePerfStateE = e();
        imagePerfStateE.A = aVar;
        imagePerfStateE.l = jNow;
        imagePerfStateE.a = str;
        imagePerfStateE.u = th;
        n(imagePerfStateE, 5);
        imagePerfStateE.w = 2;
        imagePerfStateE.f489y = jNow;
        q(imagePerfStateE, 2);
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void c(String str, ControllerListener2.a aVar) {
        long jNow = this.k.now();
        ImagePerfState imagePerfStateE = e();
        imagePerfStateE.A = aVar;
        imagePerfStateE.a = str;
        int i = imagePerfStateE.v;
        if (i != 3 && i != 5 && i != 6) {
            imagePerfStateE.m = jNow;
            n(imagePerfStateE, 4);
        }
        imagePerfStateE.w = 2;
        imagePerfStateE.f489y = jNow;
        q(imagePerfStateE, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e().a();
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void d(String str, Object obj, ControllerListener2.a aVar) {
        long jNow = this.k.now();
        ImagePerfState imagePerfStateE = e();
        imagePerfStateE.A = aVar;
        imagePerfStateE.k = jNow;
        imagePerfStateE.o = jNow;
        imagePerfStateE.a = str;
        imagePerfStateE.e = (ImageInfo) obj;
        n(imagePerfStateE, 3);
    }

    public final ImagePerfState e() {
        return Boolean.FALSE.booleanValue() ? new ImagePerfState() : this.l;
    }

    public final boolean f() {
        boolean zBooleanValue = this.n.get().booleanValue();
        if (zBooleanValue && j == null) {
            synchronized (this) {
                if (j == null) {
                    HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    Objects.requireNonNull(looper);
                    j = new a(looper, this.m);
                }
            }
        }
        return zBooleanValue;
    }

    public final void n(ImagePerfState imagePerfState, int i) {
        if (!f()) {
            ((ImagePerfMonitor) this.m).b(imagePerfState, i);
            return;
        }
        Handler handler = j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = imagePerfState;
        j.sendMessage(messageObtainMessage);
    }

    public final void q(ImagePerfState imagePerfState, int i) {
        if (!f()) {
            ((ImagePerfMonitor) this.m).a(imagePerfState, i);
            return;
        }
        Handler handler = j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = imagePerfState;
        j.sendMessage(messageObtainMessage);
    }
}
