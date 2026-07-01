package b.i.a.c.f3;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import b.i.a.c.f3.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.f3.b0, reason: use source file name */
/* JADX INFO: compiled from: SystemHandlerWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemHandlerWrapper implements HandlerWrapper {

    @GuardedBy("messagePool")
    public static final List<b> a = new ArrayList(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f964b;

    /* JADX INFO: renamed from: b.i.a.c.f3.b0$b */
    /* JADX INFO: compiled from: SystemHandlerWrapper.java */
    public static final class b implements HandlerWrapper.a {

        @Nullable
        public Message a;

        public b() {
        }

        public final void a() {
            this.a = null;
            List<b> list = SystemHandlerWrapper.a;
            synchronized (list) {
                if (list.size() < 50) {
                    list.add(this);
                }
            }
        }

        public void b() {
            Message message = this.a;
            Objects.requireNonNull(message);
            message.sendToTarget();
            a();
        }

        public b(a aVar) {
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f964b = handler;
    }

    public static b k() {
        b bVar;
        List<b> list = a;
        synchronized (list) {
            bVar = list.isEmpty() ? new b(null) : list.remove(list.size() - 1);
        }
        return bVar;
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public HandlerWrapper.a a(int i, int i2, int i3) {
        b bVarK = k();
        bVarK.a = this.f964b.obtainMessage(i, i2, i3);
        return bVarK;
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public boolean b(Runnable runnable) {
        return this.f964b.post(runnable);
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public HandlerWrapper.a c(int i) {
        b bVarK = k();
        bVarK.a = this.f964b.obtainMessage(i);
        return bVarK;
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public boolean d(HandlerWrapper.a aVar) {
        b bVar = (b) aVar;
        Handler handler = this.f964b;
        Message message = bVar.a;
        Objects.requireNonNull(message);
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        bVar.a();
        return zSendMessageAtFrontOfQueue;
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public boolean e(int i) {
        return this.f964b.hasMessages(i);
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public boolean f(int i) {
        return this.f964b.sendEmptyMessage(i);
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public boolean g(int i, long j) {
        return this.f964b.sendEmptyMessageAtTime(i, j);
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public void h(int i) {
        this.f964b.removeMessages(i);
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public HandlerWrapper.a i(int i, @Nullable Object obj) {
        b bVarK = k();
        bVarK.a = this.f964b.obtainMessage(i, obj);
        return bVarK;
    }

    @Override // b.i.a.c.f3.HandlerWrapper
    public void j(@Nullable Object obj) {
        this.f964b.removeCallbacksAndMessages(null);
    }
}
