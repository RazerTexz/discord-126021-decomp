package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.app.Activity;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.RunnableC3333k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3282c0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3285d0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3308n0;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3931h;
import p007b.p225i.p226a.p288f.p313h.p326m.BinderC3933j;
import p007b.p225i.p226a.p288f.p313h.p326m.C3938o;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;

/* JADX INFO: renamed from: b.i.a.f.j.b.e.i */
/* JADX INFO: loaded from: classes3.dex */
public final class C4286i extends MessagesClient {

    /* JADX INFO: renamed from: j */
    public static final C3266a.g<C4280f> f11413j;

    /* JADX INFO: renamed from: k */
    public static final C3266a.a<C4280f, C4264a> f11414k;

    /* JADX INFO: renamed from: l */
    public static final C3266a<C4264a> f11415l;

    /* JADX INFO: renamed from: m */
    public final int f11416m;

    static {
        C3266a.g<C4280f> gVar = new C3266a.g<>();
        f11413j = gVar;
        C4302q c4302q = new C4302q();
        f11414k = c4302q;
        f11415l = new C3266a<>("Nearby.MESSAGES_API", c4302q, gVar);
    }

    public C4286i(Activity activity, @Nullable C4264a c4264a) {
        super(activity, f11415l, c4264a, C3267b.a.f9335a);
        this.f11416m = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new C4320z(activity, this, null));
    }

    /* JADX INFO: renamed from: j */
    public static C3301k m5983j(C4286i c4286i, TaskCompletionSource taskCompletionSource) {
        Objects.requireNonNull(c4286i);
        C4308t c4308t = new C4308t(taskCompletionSource);
        String name = Status.class.getName();
        Looper looper = c4286i.f9330e;
        C1460d.m595z(c4308t, "Listener must not be null");
        C1460d.m595z(looper, "Looper must not be null");
        C1460d.m595z(name, "Listener type must not be null");
        return new C3301k(looper, c4308t, name);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.C3267b
    /* JADX INFO: renamed from: a */
    public final C3347c.a mo4044a() {
        return super.mo4044a();
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: f */
    public final Task<Void> mo5984f(final Message message, final PublishOptions publishOptions) {
        C3301k c3301kM5990m = m5990m(message);
        final BinderC4304r binderC4304r = new BinderC4304r(this, m5990m(publishOptions.f20726b), c3301kM5990m);
        return m5988k(c3301kM5990m, new InterfaceC4269a0(this, message, binderC4304r, publishOptions) { // from class: b.i.a.f.j.b.e.j

            /* JADX INFO: renamed from: a */
            public final C4286i f11417a;

            /* JADX INFO: renamed from: b */
            public final Message f11418b;

            /* JADX INFO: renamed from: c */
            public final BinderC4272b0 f11419c;

            /* JADX INFO: renamed from: d */
            public final PublishOptions f11420d;

            {
                this.f11417a = this;
                this.f11418b = message;
                this.f11419c = binderC4304r;
                this.f11420d = publishOptions;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                C4286i c4286i = this.f11417a;
                Message message2 = this.f11418b;
                BinderC4272b0 binderC4272b0 = this.f11419c;
                PublishOptions publishOptions2 = this.f11420d;
                Objects.requireNonNull(c4286i);
                zzaf zzafVar = new zzaf(1, message2);
                int i = c4286i.f11416m;
                Objects.requireNonNull(c4280f);
                ((InterfaceC4311u0) c4280f.m4142w()).mo5995n(new zzbz(2, zzafVar, publishOptions2.f20725a, new BinderC3933j(c3301k), null, null, false, binderC4272b0, false, null, i));
            }
        }, new InterfaceC4269a0(message) { // from class: b.i.a.f.j.b.e.k

            /* JADX INFO: renamed from: a */
            public final Message f11421a;

            {
                this.f11421a = message;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                zzaf zzafVar = new zzaf(1, this.f11421a);
                Objects.requireNonNull(c4280f);
                ((InterfaceC4311u0) c4280f.m4142w()).mo5992P(new zzce(1, zzafVar, new BinderC3933j(c3301k), null, null, false, null));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: g */
    public final Task<Void> mo5985g(MessageListener messageListener, final SubscribeOptions subscribeOptions) {
        C1460d.m551o(subscribeOptions.f20737a.f20736s == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        final C3301k c3301kM5990m = m5990m(messageListener);
        final BinderC4306s binderC4306s = new BinderC4306s(this, m5990m(subscribeOptions.f20739c), c3301kM5990m);
        return m5988k(c3301kM5990m, new InterfaceC4269a0(this, c3301kM5990m, binderC4306s, subscribeOptions) { // from class: b.i.a.f.j.b.e.l

            /* JADX INFO: renamed from: a */
            public final C4286i f11422a;

            /* JADX INFO: renamed from: b */
            public final C3301k f11423b;

            /* JADX INFO: renamed from: c */
            public final BinderC4277d0 f11424c;

            /* JADX INFO: renamed from: d */
            public final SubscribeOptions f11425d;

            {
                this.f11422a = this;
                this.f11423b = c3301kM5990m;
                this.f11424c = binderC4306s;
                this.f11425d = subscribeOptions;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                C4286i c4286i = this.f11422a;
                C3301k c3301k2 = this.f11423b;
                BinderC4277d0 binderC4277d0 = this.f11424c;
                SubscribeOptions subscribeOptions2 = this.f11425d;
                int i = c4286i.f11416m;
                if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
                    C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
                    c3938o.f10465a.put(c3301k2.f9430c, new WeakReference<>(new BinderC3931h(c3301k2)));
                }
                ((InterfaceC4311u0) c4280f.m4142w()).mo5991C(new SubscribeRequest(3, c4280f.f11408A.m5408b(c3301k2.f9430c), subscribeOptions2.f20737a, new BinderC3933j(c3301k), subscribeOptions2.f20738b, null, 0, null, null, null, false, binderC4277d0, false, null, subscribeOptions2.f20740d, 0, i));
            }
        }, new InterfaceC4269a0(c3301kM5990m) { // from class: b.i.a.f.j.b.e.m

            /* JADX INFO: renamed from: a */
            public final C3301k f11426a;

            {
                this.f11426a = c3301kM5990m;
            }

            @Override // p007b.p225i.p226a.p288f.p333j.p334b.p335e.InterfaceC4269a0
            /* JADX INFO: renamed from: a */
            public final void mo5981a(C4280f c4280f, C3301k c3301k) throws RemoteException {
                C3301k c3301k2 = this.f11426a;
                Objects.requireNonNull(c4280f);
                BinderC3933j binderC3933j = new BinderC3933j(c3301k);
                if (!c4280f.f11408A.m5407a(c3301k2.f9430c)) {
                    binderC3933j.m5406g(new Status(0, null));
                    return;
                }
                ((InterfaceC4311u0) c4280f.m4142w()).mo5994j0(new zzcg(1, c4280f.f11408A.m5408b(c3301k2.f9430c), binderC3933j, null, 0, null, null, false, null));
                C3938o<C3301k.a, IBinder> c3938o = c4280f.f11408A;
                c3938o.f10465a.remove(c3301k2.f9430c);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: h */
    public final Task<Void> mo5986h(Message message) {
        return m5989l(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    /* JADX INFO: renamed from: i */
    public final Task<Void> mo5987i(MessageListener messageListener) {
        return m5989l(messageListener);
    }

    /* JADX INFO: renamed from: k */
    public final <T> Task<Void> m5988k(C3301k<T> c3301k, InterfaceC4269a0 interfaceC4269a0, InterfaceC4269a0 interfaceC4269a1) {
        C4312v c4312v = new C4312v(this, c3301k, interfaceC4269a0);
        C3301k.a<T> aVar = c3301k.f9430c;
        C4316x c4316x = new C4316x(this, aVar, interfaceC4269a1);
        C1460d.m595z(c3301k.f9430c, "Listener has already been released.");
        C1460d.m595z(aVar, "Listener has already been released.");
        C1460d.m551o(C1460d.m524h0(c3301k.f9430c, aVar), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        C3293g c3293g = this.f9334i;
        Runnable runnable = RunnableC3333k.f9473j;
        Objects.requireNonNull(c3293g);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3308n0 c3308n0 = new C3308n0(new C3285d0(c4312v, c4316x, runnable), taskCompletionSource);
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(8, new C3282c0(c3308n0, c3293g.f9385s.get(), this)));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: l */
    public final <T> Task<Void> m5989l(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        String name = t.getClass().getName();
        C1460d.m595z(t, "Listener must not be null");
        C1460d.m595z(name, "Listener type must not be null");
        C1460d.m579v(name, "Listener type must not be empty");
        m4045b(new C3301k.a<>(t, name)).mo6007b(new C4310u(taskCompletionSource));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: m */
    public final <T> C3301k<T> m5990m(T t) {
        if (t == null) {
            return null;
        }
        String name = t.getClass().getName();
        Looper looper = this.f9330e;
        C1460d.m595z(t, "Listener must not be null");
        C1460d.m595z(looper, "Looper must not be null");
        C1460d.m595z(name, "Listener type must not be null");
        return new C3301k<>(looper, t, name);
    }
}
