package p007b.p225i.p226a.p288f.p299e.p300h;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3275a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3277a1;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3278b;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3282c0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3310o0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3312p0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3314q0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3329y;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3307n;
import p007b.p225i.p226a.p288f.p299e.p304k.C3347c;

/* JADX INFO: renamed from: b.i.a.f.e.h.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3267b<O extends C3266a.d> {

    /* JADX INFO: renamed from: a */
    public final Context f9326a;

    /* JADX INFO: renamed from: b */
    public final C3266a<O> f9327b;

    /* JADX INFO: renamed from: c */
    public final O f9328c;

    /* JADX INFO: renamed from: d */
    public final C3278b<O> f9329d;

    /* JADX INFO: renamed from: e */
    public final Looper f9330e;

    /* JADX INFO: renamed from: f */
    public final int f9331f;

    /* JADX INFO: renamed from: g */
    @NotOnlyInitialized
    public final AbstractC3268c f9332g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC3307n f9333h;

    /* JADX INFO: renamed from: i */
    public final C3293g f9334i;

    /* JADX INFO: renamed from: b.i.a.f.e.h.b$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final a f9335a = new a(new C3275a(), null, Looper.getMainLooper());

        /* JADX INFO: renamed from: b */
        public final InterfaceC3307n f9336b;

        /* JADX INFO: renamed from: c */
        public final Looper f9337c;

        public a(InterfaceC3307n interfaceC3307n, Account account, Looper looper) {
            this.f9336b = interfaceC3307n;
            this.f9337c = looper;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public C3267b(@NonNull Context context, C3266a<O> c3266a, O o, InterfaceC3307n interfaceC3307n) {
        this(context, c3266a, o, new a(interfaceC3307n, null, Looper.getMainLooper()));
        C1460d.m595z(interfaceC3307n, "StatusExceptionMapper must not be null.");
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static String m4043e(Object obj) {
        if (!(Build.VERSION.SDK_INT >= 30)) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public C3347c.a mo4044a() {
        GoogleSignInAccount googleSignInAccountM4029L;
        GoogleSignInAccount googleSignInAccountM4029L2;
        C3347c.a aVar = new C3347c.a();
        O o = this.f9328c;
        Account accountM4028T = null;
        if (!(o instanceof C3266a.d.b) || (googleSignInAccountM4029L2 = ((C3266a.d.b) o).m4029L()) == null) {
            O o2 = this.f9328c;
            if (o2 instanceof C3266a.d.a) {
                accountM4028T = ((C3266a.d.a) o2).m4028T();
            }
        } else if (googleSignInAccountM4029L2.f20419m != null) {
            accountM4028T = new Account(googleSignInAccountM4029L2.f20419m, "com.google");
        }
        aVar.f9509a = accountM4028T;
        O o3 = this.f9328c;
        Set<Scope> setEmptySet = (!(o3 instanceof C3266a.d.b) || (googleSignInAccountM4029L = ((C3266a.d.b) o3).m4029L()) == null) ? Collections.emptySet() : googleSignInAccountM4029L.m9011w0();
        if (aVar.f9510b == null) {
            aVar.f9510b = new ArraySet<>();
        }
        aVar.f9510b.addAll(setEmptySet);
        aVar.f9512d = this.f9326a.getClass().getName();
        aVar.f9511c = this.f9326a.getPackageName();
        return aVar;
    }

    /* JADX INFO: renamed from: b */
    public Task<Boolean> m4045b(@NonNull C3301k.a<?> aVar) {
        C1460d.m595z(aVar, "Listener key cannot be null.");
        C3293g c3293g = this.f9334i;
        Objects.requireNonNull(c3293g);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3312p0 c3312p0 = new C3312p0(aVar, taskCompletionSource);
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(13, new C3282c0(c3312p0, c3293g.f9385s.get(), this)));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: c */
    public <TResult, A extends C3266a.b> Task<TResult> m4046c(AbstractC3311p<A, TResult> abstractC3311p) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        C3293g c3293g = this.f9334i;
        InterfaceC3307n interfaceC3307n = this.f9333h;
        Objects.requireNonNull(c3293g);
        C3314q0 c3314q0 = new C3314q0(1, abstractC3311p, taskCompletionSource, interfaceC3307n);
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(4, new C3282c0(c3314q0, c3293g.f9385s.get(), this)));
        return taskCompletionSource.f20845a;
    }

    /* JADX INFO: renamed from: d */
    public final <A extends C3266a.b, T extends AbstractC3284d<? extends InterfaceC3273h, A>> T m4047d(int i, @NonNull T t) {
        t.f20509k = t.f20509k || BasePendingResult.f20499a.get().booleanValue();
        C3293g c3293g = this.f9334i;
        Objects.requireNonNull(c3293g);
        C3310o0 c3310o0 = new C3310o0(i, t);
        Handler handler = c3293g.f9390x;
        handler.sendMessage(handler.obtainMessage(4, new C3282c0(c3310o0, c3293g.f9385s.get(), this)));
        return t;
    }

    @MainThread
    public C3267b(@NonNull Activity activity, C3266a<O> c3266a, O o, a aVar) {
        C1460d.m595z(activity, "Null activity is not permitted.");
        C1460d.m595z(c3266a, "Api must not be null.");
        C1460d.m595z(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.f9326a = applicationContext;
        m4043e(activity);
        this.f9327b = c3266a;
        this.f9328c = o;
        this.f9330e = aVar.f9337c;
        C3278b<O> c3278b = new C3278b<>(c3266a, o);
        this.f9329d = c3278b;
        this.f9332g = new C3329y(this);
        C3293g c3293gM4078a = C3293g.m4078a(applicationContext);
        this.f9334i = c3293gM4078a;
        this.f9331f = c3293gM4078a.f9384r.getAndIncrement();
        this.f9333h = aVar.f9336b;
        if (!(activity instanceof GoogleApiActivity)) {
            try {
                C3277a1.m4057o(activity, c3293gM4078a, c3278b);
            } catch (IllegalStateException | ConcurrentModificationException unused) {
            }
        }
        Handler handler = this.f9334i.f9390x;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    public C3267b(@NonNull Context context, C3266a<O> c3266a, O o, a aVar) {
        C1460d.m595z(context, "Null context is not permitted.");
        C1460d.m595z(c3266a, "Api must not be null.");
        C1460d.m595z(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f9326a = applicationContext;
        m4043e(context);
        this.f9327b = c3266a;
        this.f9328c = o;
        this.f9330e = aVar.f9337c;
        this.f9329d = new C3278b<>(c3266a, o);
        this.f9332g = new C3329y(this);
        C3293g c3293gM4078a = C3293g.m4078a(applicationContext);
        this.f9334i = c3293gM4078a;
        this.f9331f = c3293gM4078a.f9384r.getAndIncrement();
        this.f9333h = aVar.f9336b;
        Handler handler = c3293gM4078a.f9390x;
        handler.sendMessage(handler.obtainMessage(7, this));
    }
}
