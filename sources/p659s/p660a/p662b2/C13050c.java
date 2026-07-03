package p659s.p660a.p662b2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p507d0.C12112k;
import p507d0.C12113l;

/* JADX INFO: renamed from: s.a.b2.c */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13050c {
    static {
        Object objM11474constructorimpl;
        try {
            C12112k.a aVar = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(new C13048a(m11197a(Looper.getMainLooper(), true), null, false));
        } catch (Throwable th) {
            C12112k.a aVar2 = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public static final Handler m11197a(Looper looper, boolean z2) throws IllegalAccessException, InvocationTargetException {
        if (!z2) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
