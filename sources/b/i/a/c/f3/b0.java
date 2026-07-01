package b.i.a.c.f3;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SystemHandlerWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements o {

    @GuardedBy("messagePool")
    public static final List<b0$b> a = new ArrayList(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f964b;

    public b0(Handler handler) {
        this.f964b = handler;
    }

    public static b0$b k() {
        b0$b b0_b;
        List<b0$b> list = a;
        synchronized (list) {
            b0_b = list.isEmpty() ? new b0$b(null) : list.remove(list.size() - 1);
        }
        return b0_b;
    }

    @Override // b.i.a.c.f3.o
    public o$a a(int i, int i2, int i3) {
        b0$b b0_bK = k();
        b0_bK.a = this.f964b.obtainMessage(i, i2, i3);
        return b0_bK;
    }

    @Override // b.i.a.c.f3.o
    public boolean b(Runnable runnable) {
        return this.f964b.post(runnable);
    }

    @Override // b.i.a.c.f3.o
    public o$a c(int i) {
        b0$b b0_bK = k();
        b0_bK.a = this.f964b.obtainMessage(i);
        return b0_bK;
    }

    @Override // b.i.a.c.f3.o
    public boolean d(o$a o_a) {
        b0$b b0_b = (b0$b) o_a;
        Handler handler = this.f964b;
        Message message = b0_b.a;
        Objects.requireNonNull(message);
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        b0_b.a();
        return zSendMessageAtFrontOfQueue;
    }

    @Override // b.i.a.c.f3.o
    public boolean e(int i) {
        return this.f964b.hasMessages(i);
    }

    @Override // b.i.a.c.f3.o
    public boolean f(int i) {
        return this.f964b.sendEmptyMessage(i);
    }

    @Override // b.i.a.c.f3.o
    public boolean g(int i, long j) {
        return this.f964b.sendEmptyMessageAtTime(i, j);
    }

    @Override // b.i.a.c.f3.o
    public void h(int i) {
        this.f964b.removeMessages(i);
    }

    @Override // b.i.a.c.f3.o
    public o$a i(int i, @Nullable Object obj) {
        b0$b b0_bK = k();
        b0_bK.a = this.f964b.obtainMessage(i, obj);
        return b0_bK;
    }

    @Override // b.i.a.c.f3.o
    public void j(@Nullable Object obj) {
        this.f964b.removeCallbacksAndMessages(null);
    }
}
