package j0.o;

import b.d.b.a.outline;
import j0.Completable3;
import j0.Single2;
import j0.k.Func1;
import java.io.PrintStream;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func2;

/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static volatile Action1<Throwable> a = new f();
    public static volatile Func2<Observable, Observable.a, Observable.a> e = new g();
    public static volatile Func1<Subscription, Subscription> g = new h();
    public static volatile Func1<Action0, Action0> f = new i();
    public static volatile Func1<Throwable, Throwable> h = new j();
    public static volatile Func1<Observable.b, Observable.b> i = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Func1<Observable.a, Observable.a> f3801b = new c();
    public static volatile Func1<Single2.a, Single2.a> c = new d();
    public static volatile Func1<Completable3.a, Completable3.a> d = new e();

    public static <T> Observable.a<T> a(Observable.a<T> aVar) {
        Func1<Observable.a, Observable.a> func1 = f3801b;
        return func1 != null ? func1.call(aVar) : aVar;
    }

    public static void b(Throwable th) {
        Action1<Throwable> action1 = a;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                StringBuilder sbU = outline.U("The onError handler threw an Exception. It shouldn't. => ");
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
        Func1<Throwable, Throwable> func1 = h;
        return func1 != null ? func1.call(th) : th;
    }

    public static Action0 d(Action0 action0) {
        Func1<Action0, Action0> func1 = f;
        return func1 != null ? func1.call(action0) : action0;
    }
}
