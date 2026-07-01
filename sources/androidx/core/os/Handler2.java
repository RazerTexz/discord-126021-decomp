package androidx.core.os;

import android.os.Handler;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.core.os.HandlerKt, reason: use source file name */
/* JADX INFO: compiled from: Handler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Handler2 {
    public static final Runnable postAtTime(Handler handler, long j, Object obj, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler3 handler3 = new Handler3(function0);
        handler.postAtTime(handler3, obj, j);
        return handler3;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler3 handler3 = new Handler3(function0);
        handler.postAtTime(handler3, obj, j);
        return handler3;
    }

    public static final Runnable postDelayed(Handler handler, long j, Object obj, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler4 handler4 = new Handler4(function0);
        if (obj == null) {
            handler.postDelayed(handler4, j);
        } else {
            HandlerCompat.postDelayed(handler, handler4, obj, j);
        }
        return handler4;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics3.checkNotNullParameter(handler, "<this>");
        Intrinsics3.checkNotNullParameter(function0, "action");
        Handler4 handler4 = new Handler4(function0);
        if (obj == null) {
            handler.postDelayed(handler4, j);
        } else {
            HandlerCompat.postDelayed(handler, handler4, obj, j);
        }
        return handler4;
    }
}
