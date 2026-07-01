package j0.o;

import j0.d$a;
import j0.h$a;
import java.io.PrintStream;
import rx.Observable;
import rx.Observable$a;
import rx.Observable$b;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func2;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static volatile Action1<Throwable> a = new f();
    public static volatile Func2<Observable, Observable$a, Observable$a> e = new g();
    public static volatile j0.k.b<Subscription, Subscription> g = new h();
    public static volatile j0.k.b<Action0, Action0> f = new i();
    public static volatile j0.k.b<Throwable, Throwable> h = new j();
    public static volatile j0.k.b<Observable$b, Observable$b> i = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile j0.k.b<Observable$a, Observable$a> f3801b = new c();
    public static volatile j0.k.b<h$a, h$a> c = new d();
    public static volatile j0.k.b<d$a, d$a> d = new e();

    public static <T> Observable$a<T> a(Observable$a<T> observable$a) {
        j0.k.b<Observable$a, Observable$a> bVar = f3801b;
        return bVar != null ? bVar.call(observable$a) : observable$a;
    }

    public static void b(Throwable th) {
        Action1<Throwable> action1 = a;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                StringBuilder sbU = b.d.b.a.a.U("The onError handler threw an Exception. It shouldn't. => ");
                sbU.append(th2.getMessage());
                printStream.println(sbU.toString());
                th2.printStackTrace();
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static Throwable c(Throwable th) {
        j0.k.b<Throwable, Throwable> bVar = h;
        return bVar != null ? bVar.call(th) : th;
    }

    public static Action0 d(Action0 action0) {
        j0.k.b<Action0, Action0> bVar = f;
        return bVar != null ? bVar.call(action0) : action0;
    }
}
