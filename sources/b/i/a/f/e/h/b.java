package b.i.a.f.e.h;

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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.a.d;
import b.i.a.f.e.h.j.a1;
import b.i.a.f.e.h.j.c0;
import b.i.a.f.e.h.j.k;
import b.i.a.f.e.h.j.n;
import b.i.a.f.e.h.j.o0;
import b.i.a.f.e.h.j.p;
import b.i.a.f.e.h.j.p0;
import b.i.a.f.e.h.j.q0;
import b.i.a.f.e.h.j.y;
import b.i.a.f.e.k.c;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b<O extends a.d> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.f.e.h.a<O> f1351b;
    public final O c;
    public final b.i.a.f.e.h.j.b<O> d;
    public final Looper e;
    public final int f;

    @NotOnlyInitialized
    public final c g;
    public final n h;
    public final b.i.a.f.e.h.j.g i;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class a {
        public static final a a = new a(new b.i.a.f.e.h.j.a(), null, Looper.getMainLooper());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f1352b;
        public final Looper c;

        public a(n nVar, Account account, Looper looper) {
            this.f1352b = nVar;
            this.c = looper;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public b(@NonNull Context context, b.i.a.f.e.h.a<O> aVar, O o, n nVar) {
        this(context, aVar, o, new a(nVar, null, Looper.getMainLooper()));
        AnimatableValueParser.z(nVar, "StatusExceptionMapper must not be null.");
    }

    @Nullable
    public static String e(Object obj) {
        if (!(Build.VERSION.SDK_INT >= 30)) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public c.a a() {
        GoogleSignInAccount googleSignInAccountL;
        GoogleSignInAccount googleSignInAccountL2;
        c.a aVar = new c.a();
        O o = this.c;
        Account accountT = null;
        if (!(o instanceof a.d.b) || (googleSignInAccountL2 = ((a.d.b) o).L()) == null) {
            O o2 = this.c;
            if (o2 instanceof a.d.InterfaceC0036a) {
                accountT = ((a.d.InterfaceC0036a) o2).T();
            }
        } else if (googleSignInAccountL2.m != null) {
            accountT = new Account(googleSignInAccountL2.m, "com.google");
        }
        aVar.a = accountT;
        O o3 = this.c;
        Set<Scope> setEmptySet = (!(o3 instanceof a.d.b) || (googleSignInAccountL = ((a.d.b) o3).L()) == null) ? Collections.emptySet() : googleSignInAccountL.w0();
        if (aVar.f1381b == null) {
            aVar.f1381b = new ArraySet<>();
        }
        aVar.f1381b.addAll(setEmptySet);
        aVar.d = this.a.getClass().getName();
        aVar.c = this.a.getPackageName();
        return aVar;
    }

    public Task<Boolean> b(@NonNull k.a<?> aVar) {
        AnimatableValueParser.z(aVar, "Listener key cannot be null.");
        b.i.a.f.e.h.j.g gVar = this.i;
        Objects.requireNonNull(gVar);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        p0 p0Var = new p0(aVar, taskCompletionSource);
        Handler handler = gVar.f1359x;
        handler.sendMessage(handler.obtainMessage(13, new c0(p0Var, gVar.f1358s.get(), this)));
        return taskCompletionSource.a;
    }

    public <TResult, A extends a.b> Task<TResult> c(p<A, TResult> pVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b.i.a.f.e.h.j.g gVar = this.i;
        n nVar = this.h;
        Objects.requireNonNull(gVar);
        q0 q0Var = new q0(1, pVar, taskCompletionSource, nVar);
        Handler handler = gVar.f1359x;
        handler.sendMessage(handler.obtainMessage(4, new c0(q0Var, gVar.f1358s.get(), this)));
        return taskCompletionSource.a;
    }

    public final <A extends a.b, T extends b.i.a.f.e.h.j.d<? extends h, A>> T d(int i, @NonNull T t) {
        t.k = t.k || BasePendingResult.a.get().booleanValue();
        b.i.a.f.e.h.j.g gVar = this.i;
        Objects.requireNonNull(gVar);
        o0 o0Var = new o0(i, t);
        Handler handler = gVar.f1359x;
        handler.sendMessage(handler.obtainMessage(4, new c0(o0Var, gVar.f1358s.get(), this)));
        return t;
    }

    @MainThread
    public b(@NonNull Activity activity, b.i.a.f.e.h.a<O> aVar, O o, a aVar2) {
        AnimatableValueParser.z(activity, "Null activity is not permitted.");
        AnimatableValueParser.z(aVar, "Api must not be null.");
        AnimatableValueParser.z(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = activity.getApplicationContext();
        this.a = applicationContext;
        e(activity);
        this.f1351b = aVar;
        this.c = o;
        this.e = aVar2.c;
        b.i.a.f.e.h.j.b<O> bVar = new b.i.a.f.e.h.j.b<>(aVar, o);
        this.d = bVar;
        this.g = new y(this);
        b.i.a.f.e.h.j.g gVarA = b.i.a.f.e.h.j.g.a(applicationContext);
        this.i = gVarA;
        this.f = gVarA.r.getAndIncrement();
        this.h = aVar2.f1352b;
        if (!(activity instanceof GoogleApiActivity)) {
            try {
                a1.o(activity, gVarA, bVar);
            } catch (IllegalStateException | ConcurrentModificationException unused) {
            }
        }
        Handler handler = this.i.f1359x;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    public b(@NonNull Context context, b.i.a.f.e.h.a<O> aVar, O o, a aVar2) {
        AnimatableValueParser.z(context, "Null context is not permitted.");
        AnimatableValueParser.z(aVar, "Api must not be null.");
        AnimatableValueParser.z(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        e(context);
        this.f1351b = aVar;
        this.c = o;
        this.e = aVar2.c;
        this.d = new b.i.a.f.e.h.j.b<>(aVar, o);
        this.g = new y(this);
        b.i.a.f.e.h.j.g gVarA = b.i.a.f.e.h.j.g.a(applicationContext);
        this.i = gVarA;
        this.f = gVarA.r.getAndIncrement();
        this.h = aVar2.f1352b;
        Handler handler = gVarA.f1359x;
        handler.sendMessage(handler.obtainMessage(7, this));
    }
}
