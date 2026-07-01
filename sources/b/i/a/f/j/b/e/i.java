package b.i.a.f.j.b.e;

import android.app.Activity;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.b;
import b.i.a.f.e.h.j.k;
import b.i.a.f.e.k.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import com.google.android.gms.nearby.messages.internal.zzaf;
import com.google.android.gms.nearby.messages.internal.zzbz;
import com.google.android.gms.nearby.messages.internal.zzce;
import com.google.android.gms.nearby.messages.internal.zzcg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends MessagesClient {
    public static final a.g<f> j;
    public static final a.AbstractC0035a<f, b.i.a.f.j.b.a> k;
    public static final b.i.a.f.e.h.a<b.i.a.f.j.b.a> l;
    public final int m;

    static {
        a.g<f> gVar = new a.g<>();
        j = gVar;
        q qVar = new q();
        k = qVar;
        l = new b.i.a.f.e.h.a<>("Nearby.MESSAGES_API", qVar, gVar);
    }

    public i(Activity activity, @Nullable b.i.a.f.j.b.a aVar) {
        super(activity, l, aVar, b.a.a);
        this.m = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new z(activity, this, null));
    }

    public static b.i.a.f.e.h.j.k j(i iVar, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(iVar);
        t tVar = new t(taskCompletionSource);
        String name = Status.class.getName();
        Looper looper = iVar.e;
        AnimatableValueParser.z(tVar, "Listener must not be null");
        AnimatableValueParser.z(looper, "Looper must not be null");
        AnimatableValueParser.z(name, "Listener type must not be null");
        return new b.i.a.f.e.h.j.k(looper, tVar, name);
    }

    @Override // b.i.a.f.e.h.b
    public final c.a a() {
        return super.a();
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> f(final Message message, final PublishOptions publishOptions) {
        b.i.a.f.e.h.j.k kVarM = m(message);
        final r rVar = new r(this, m(publishOptions.f3017b), kVarM);
        return k(kVarM, new a0(this, message, rVar, publishOptions) { // from class: b.i.a.f.j.b.e.j
            public final i a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Message f1584b;
            public final b0 c;
            public final PublishOptions d;

            {
                this.a = this;
                this.f1584b = message;
                this.c = rVar;
                this.d = publishOptions;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                i iVar = this.a;
                Message message2 = this.f1584b;
                b0 b0Var = this.c;
                PublishOptions publishOptions2 = this.d;
                Objects.requireNonNull(iVar);
                zzaf zzafVar = new zzaf(1, message2);
                int i = iVar.m;
                Objects.requireNonNull(fVar);
                ((u0) fVar.w()).n(new zzbz(2, zzafVar, publishOptions2.a, new b.i.a.f.h.m.j(kVar), null, null, false, b0Var, false, null, i));
            }
        }, new a0(message) { // from class: b.i.a.f.j.b.e.k
            public final Message a;

            {
                this.a = message;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                zzaf zzafVar = new zzaf(1, this.a);
                Objects.requireNonNull(fVar);
                ((u0) fVar.w()).P(new zzce(1, zzafVar, new b.i.a.f.h.m.j(kVar), null, null, false, null));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> g(MessageListener messageListener, final SubscribeOptions subscribeOptions) {
        AnimatableValueParser.o(subscribeOptions.a.f3018s == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        final b.i.a.f.e.h.j.k kVarM = m(messageListener);
        final s sVar = new s(this, m(subscribeOptions.c), kVarM);
        return k(kVarM, new a0(this, kVarM, sVar, subscribeOptions) { // from class: b.i.a.f.j.b.e.l
            public final i a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final b.i.a.f.e.h.j.k f1585b;
            public final d0 c;
            public final SubscribeOptions d;

            {
                this.a = this;
                this.f1585b = kVarM;
                this.c = sVar;
                this.d = subscribeOptions;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                i iVar = this.a;
                b.i.a.f.e.h.j.k kVar2 = this.f1585b;
                d0 d0Var = this.c;
                SubscribeOptions subscribeOptions2 = this.d;
                int i = iVar.m;
                if (!fVar.A.a(kVar2.c)) {
                    b.i.a.f.h.m.o<k.a, IBinder> oVar = fVar.A;
                    oVar.a.put(kVar2.c, new WeakReference<>(new b.i.a.f.h.m.h(kVar2)));
                }
                ((u0) fVar.w()).C(new SubscribeRequest(3, fVar.A.b(kVar2.c), subscribeOptions2.a, new b.i.a.f.h.m.j(kVar), subscribeOptions2.f3019b, null, 0, null, null, null, false, d0Var, false, null, subscribeOptions2.d, 0, i));
            }
        }, new a0(kVarM) { // from class: b.i.a.f.j.b.e.m
            public final b.i.a.f.e.h.j.k a;

            {
                this.a = kVarM;
            }

            @Override // b.i.a.f.j.b.e.a0
            public final void a(f fVar, b.i.a.f.e.h.j.k kVar) throws RemoteException {
                b.i.a.f.e.h.j.k kVar2 = this.a;
                Objects.requireNonNull(fVar);
                b.i.a.f.h.m.j jVar = new b.i.a.f.h.m.j(kVar);
                if (!fVar.A.a(kVar2.c)) {
                    jVar.g(new Status(0, null));
                    return;
                }
                ((u0) fVar.w()).j0(new zzcg(1, fVar.A.b(kVar2.c), jVar, null, 0, null, null, false, null));
                b.i.a.f.h.m.o<k.a, IBinder> oVar = fVar.A;
                oVar.a.remove(kVar2.c);
            }
        });
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
        k.a<T> aVar = kVar.c;
        x xVar = new x(this, aVar, a0Var2);
        AnimatableValueParser.z(kVar.c, "Listener has already been released.");
        AnimatableValueParser.z(aVar, "Listener has already been released.");
        AnimatableValueParser.o(AnimatableValueParser.h0(kVar.c, aVar), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
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
        AnimatableValueParser.z(t, "Listener must not be null");
        AnimatableValueParser.z(name, "Listener type must not be null");
        AnimatableValueParser.v(name, "Listener type must not be empty");
        b(new k.a<>(t, name)).b(new u(taskCompletionSource));
        return taskCompletionSource.a;
    }

    public final <T> b.i.a.f.e.h.j.k<T> m(T t) {
        if (t == null) {
            return null;
        }
        String name = t.getClass().getName();
        Looper looper = this.e;
        AnimatableValueParser.z(t, "Listener must not be null");
        AnimatableValueParser.z(looper, "Looper must not be null");
        AnimatableValueParser.z(name, "Listener type must not be null");
        return new b.i.a.f.e.h.j.k<>(looper, t, name);
    }
}
