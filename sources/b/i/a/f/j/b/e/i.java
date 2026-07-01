package b.i.a.f.j.b.e;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a$a;
import b.i.a.f.e.h.a$g;
import b.i.a.f.e.h.b$a;
import b.i.a.f.e.h.j.k$a;
import b.i.a.f.e.k.c$a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends MessagesClient {
    public static final a$g<f> j;
    public static final a$a<f, b.i.a.f.j.b.a> k;
    public static final b.i.a.f.e.h.a<b.i.a.f.j.b.a> l;
    public final int m;

    static {
        a$g<f> a_g = new a$g<>();
        j = a_g;
        q qVar = new q();
        k = qVar;
        l = new b.i.a.f.e.h.a<>("Nearby.MESSAGES_API", qVar, a_g);
    }

    public i(Activity activity, @Nullable b.i.a.f.j.b.a aVar) {
        super(activity, l, aVar, b$a.a);
        this.m = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new z(activity, this, null));
    }

    public static b.i.a.f.e.h.j.k j(i iVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(iVar);
        t tVar = new t(taskCompletionSource);
        String name = Status.class.getName();
        Looper looper = iVar.e;
        b.c.a.a0.d.z(tVar, "Listener must not be null");
        b.c.a.a0.d.z(looper, "Looper must not be null");
        b.c.a.a0.d.z(name, "Listener type must not be null");
        return new b.i.a.f.e.h.j.k(looper, tVar, name);
    }

    @Override // b.i.a.f.e.h.b
    public final c$a a() {
        return super.a();
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> f(Message message, PublishOptions publishOptions) {
        b.i.a.f.e.h.j.k kVarM = m(message);
        return k(kVarM, new j(this, message, new r(this, m(publishOptions.f3017b), kVarM), publishOptions), new k(message));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> g(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        b.c.a.a0.d.o(subscribeOptions.a.f3018s == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        b.i.a.f.e.h.j.k kVarM = m(messageListener);
        return k(kVarM, new l(this, kVarM, new s(this, m(subscribeOptions.c), kVarM), subscribeOptions), new m(kVarM));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> h(Message message) {
        return l(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> i(MessageListener messageListener) {
        return l(messageListener);
    }

    public final <T> Task<Void> k(b.i.a.f.e.h.j.k<T> kVar, a0 a0Var, a0 a0Var2) {
        v vVar = new v(this, kVar, a0Var);
        k$a<T> k_a = kVar.c;
        x xVar = new x(this, k_a, a0Var2);
        b.c.a.a0.d.z(kVar.c, "Listener has already been released.");
        b.c.a.a0.d.z(k_a, "Listener has already been released.");
        b.c.a.a0.d.o(b.c.a.a0.d.h0(kVar.c, k_a), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        b.i.a.f.e.h.j.g gVar = this.i;
        Runnable runnable = b.i.a.f.e.h.k.j;
        Objects.requireNonNull(gVar);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b.i.a.f.e.h.j.n0 n0Var = new b.i.a.f.e.h.j.n0(new b.i.a.f.e.h.j.d0(vVar, xVar, runnable), taskCompletionSource);
        Handler handler = gVar.f1359x;
        handler.sendMessage(handler.obtainMessage(8, new b.i.a.f.e.h.j.c0(n0Var, gVar.f1358s.get(), this)));
        return taskCompletionSource.a;
    }

    public final <T> Task<Void> l(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String name = t.getClass().getName();
        b.c.a.a0.d.z(t, "Listener must not be null");
        b.c.a.a0.d.z(name, "Listener type must not be null");
        b.c.a.a0.d.v(name, "Listener type must not be empty");
        b(new k$a<>(t, name)).b(new u(taskCompletionSource));
        return taskCompletionSource.a;
    }

    public final <T> b.i.a.f.e.h.j.k<T> m(T t) {
        if (t == null) {
            return null;
        }
        String name = t.getClass().getName();
        Looper looper = this.e;
        b.c.a.a0.d.z(t, "Listener must not be null");
        b.c.a.a0.d.z(looper, "Looper must not be null");
        b.c.a.a0.d.z(name, "Listener type must not be null");
        return new b.i.a.f.e.h.j.k<>(looper, t, name);
    }
}
