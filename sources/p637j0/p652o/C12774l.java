package p637j0.p652o;

import java.io.PrintStream;
import p007b.p100d.p104b.p105a.C1643a;
import p637j0.C12578d;
import p637j0.C12582h;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: j0.o.l */
/* JADX INFO: compiled from: RxJavaHooks.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12774l {

    /* JADX INFO: renamed from: a */
    public static volatile Action1<Throwable> f27374a = new C12768f();

    /* JADX INFO: renamed from: e */
    public static volatile Func2<Observable, Observable.InterfaceC13005a, Observable.InterfaceC13005a> f27378e = new C12769g();

    /* JADX INFO: renamed from: g */
    public static volatile InterfaceC12589b<Subscription, Subscription> f27380g = new C12770h();

    /* JADX INFO: renamed from: f */
    public static volatile InterfaceC12589b<Action0, Action0> f27379f = new C12771i();

    /* JADX INFO: renamed from: h */
    public static volatile InterfaceC12589b<Throwable, Throwable> f27381h = new C12772j();

    /* JADX INFO: renamed from: i */
    public static volatile InterfaceC12589b<Observable.InterfaceC13006b, Observable.InterfaceC13006b> f27382i = new C12773k();

    /* JADX INFO: renamed from: b */
    public static volatile InterfaceC12589b<Observable.InterfaceC13005a, Observable.InterfaceC13005a> f27375b = new C12765c();

    /* JADX INFO: renamed from: c */
    public static volatile InterfaceC12589b<C12582h.a, C12582h.a> f27376c = new C12766d();

    /* JADX INFO: renamed from: d */
    public static volatile InterfaceC12589b<C12578d.a, C12578d.a> f27377d = new C12767e();

    /* JADX INFO: renamed from: a */
    public static <T> Observable.InterfaceC13005a<T> m10862a(Observable.InterfaceC13005a<T> interfaceC13005a) {
        InterfaceC12589b<Observable.InterfaceC13005a, Observable.InterfaceC13005a> interfaceC12589b = f27375b;
        return interfaceC12589b != null ? interfaceC12589b.call(interfaceC13005a) : interfaceC13005a;
    }

    /* JADX INFO: renamed from: b */
    public static void m10863b(Throwable th) {
        Action1<Throwable> action1 = f27374a;
        if (action1 != null) {
            try {
                action1.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                StringBuilder sbM833U = C1643a.m833U("The onError handler threw an Exception. It shouldn't. => ");
                sbM833U.append(th2.getMessage());
                printStream.println(sbM833U.toString());
                th2.printStackTrace();
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    /* JADX INFO: renamed from: c */
    public static Throwable m10864c(Throwable th) {
        InterfaceC12589b<Throwable, Throwable> interfaceC12589b = f27381h;
        return interfaceC12589b != null ? interfaceC12589b.call(th) : th;
    }

    /* JADX INFO: renamed from: d */
    public static Action0 m10865d(Action0 action0) {
        InterfaceC12589b<Action0, Action0> interfaceC12589b = f27379f;
        return interfaceC12589b != null ? interfaceC12589b.call(action0) : action0;
    }
}
