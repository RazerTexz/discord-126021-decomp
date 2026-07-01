package b.a.d;

import android.content.Context;
import com.discord.app.AppFragment;
import com.discord.utilities.error.Error;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable$c;
import rx.functions.Action1;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o a = new o();

    public static final <K, T> Observable$c<Map<K, T>, Map<K, T>> a(Collection<? extends K> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "filterKeys");
        return b(collection, o$a.j);
    }

    public static final <K, V, V1> Observable$c<Map<K, V>, Map<K, V1>> b(Collection<? extends K> collection, Function1<? super V, ? extends V1> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "valueMapper");
        return (collection == null || collection.isEmpty()) ? o$b.j : new o$c(collection, function1);
    }

    public static final <T> Observable$c<T, T> c(Function1<? super T, Boolean> function1, T t, long j, TimeUnit timeUnit) {
        d0.z.d.m.checkNotNullParameter(function1, "predicate");
        d0.z.d.m.checkNotNullParameter(timeUnit, "timeUnit");
        return new o$d(function1, t, j, timeUnit);
    }

    public static /* synthetic */ Observable$c d(Function1 function1, Object obj, long j, TimeUnit timeUnit, int i) {
        if ((i & 4) != 0) {
            j = 5000;
        }
        return c(function1, obj, j, (i & 8) != 0 ? TimeUnit.MILLISECONDS : null);
    }

    public static final <T> Observable$c<T, T> e(Action1<? super T> action1, Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(action1, "onNext");
        d0.z.d.m.checkNotNullParameter(cls, "errorClass");
        return new w(null, cls, null, action1, null);
    }

    public static Observable$c f(o oVar, Function1 function1, String str, Function1 function2, Function1 function3, Context context, Function0 function0, int i) {
        Function1 function4 = (i & 4) != 0 ? null : function2;
        int i2 = i & 8;
        Context context2 = (i & 16) != 0 ? null : context;
        int i3 = i & 32;
        d0.z.d.m.checkNotNullParameter(function1, "onNext");
        d0.z.d.m.checkNotNullParameter(str, "errorTag");
        return new y(context2, str, null, function1, function4, null);
    }

    public static final <T> Observable$c<T, T> h(Action1<? super T> action1, Context context, Action1<Error> action2) {
        d0.z.d.m.checkNotNullParameter(action1, "onNext");
        o$e o_e = new o$e(action1);
        c0 c0Var = (40 & 4) != 0 ? null : action2 != null ? new c0(action2) : null;
        int i = 40 & 8;
        Context context2 = (40 & 16) != 0 ? null : context;
        int i2 = 40 & 32;
        d0.z.d.m.checkNotNullParameter(o_e, "onNext");
        d0.z.d.m.checkNotNullParameter("restClient", "errorTag");
        return new y(context2, "restClient", null, o_e, c0Var, null);
    }

    public static final <T> Observable$c<T, T> i(Action1<? super T> action1, AppFragment appFragment) {
        d0.z.d.m.checkNotNullParameter(action1, "onNext");
        d0.z.d.m.checkNotNullParameter(appFragment, "fragment");
        return a.g(appFragment.getContext(), new o$f(action1), null);
    }

    public static /* synthetic */ Observable$c j(Action1 action1, Context context, Action1 action2, int i) {
        int i2 = i & 4;
        return h(action1, context, null);
    }

    public final <T> Observable$c<T, T> g(Context context, Function1<? super T, Unit> function1, Action1<Error> action1) {
        d0.z.d.m.checkNotNullParameter(function1, "onNext");
        return f(this, function1, "restClient", action1 != null ? new c0(action1) : null, null, context, null, 40);
    }
}
