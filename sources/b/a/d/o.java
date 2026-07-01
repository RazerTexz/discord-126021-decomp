package b.a.d;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppFragment;
import com.discord.utilities.error.Error;
import d0.t.Maps6;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final o a = new o();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final class a<T> extends Lambda implements Function1<T, T> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final T invoke(T t) {
            Intrinsics3.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K, V1] */
    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final class b<T, R, K, V, V1> implements Observable.c<Map<K, ? extends V>, Map<K, ? extends V1>> {
        public static final b j = new b();

        @Override // j0.k.Func1
        public Object call(Object obj) {
            return new ScalarSynchronousObservable(Maps6.emptyMap());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K, V1] */
    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final class c<T, R, K, V, V1> implements Observable.c<Map<K, ? extends V>, Map<K, ? extends V1>> {
        public final /* synthetic */ Collection j;
        public final /* synthetic */ Function1 k;

        public c(Collection collection, Function1 function1) {
            this.j = collection;
            this.k = function1;
        }

        @Override // j0.k.Func1
        public Object call(Object obj) {
            return ((Observable) obj).Y(new s(this)).r();
        }
    }

    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final class d<T, R> implements Observable.c<T, T> {
        public final /* synthetic */ Function1 j;
        public final /* synthetic */ Object k;
        public final /* synthetic */ long l;
        public final /* synthetic */ TimeUnit m;

        public d(Function1 function1, Object obj, long j, TimeUnit timeUnit) {
            this.j = function1;
            this.k = obj;
            this.l = j;
            this.m = timeUnit;
        }

        @Override // j0.k.Func1
        public Object call(Object obj) {
            return ((Observable) obj).Y(new t(this));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final /* synthetic */ class e<T> extends FunctionReferenceImpl implements Function1<T, Unit> {
        public e(Action1 action1) {
            super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            ((Action1) this.receiver).call(obj);
            return Unit.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: AppTransformers.kt */
    public static final /* synthetic */ class f<T> extends FunctionReferenceImpl implements Function1<T, Unit> {
        public f(Action1 action1) {
            super(1, action1, Action1.class, NotificationCompat.CATEGORY_CALL, "call(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            ((Action1) this.receiver).call(obj);
            return Unit.a;
        }
    }

    public static final <K, T> Observable.c<Map<K, T>, Map<K, T>> a(Collection<? extends K> collection) {
        Intrinsics3.checkNotNullParameter(collection, "filterKeys");
        return b(collection, a.j);
    }

    public static final <K, V, V1> Observable.c<Map<K, V>, Map<K, V1>> b(Collection<? extends K> collection, Function1<? super V, ? extends V1> function1) {
        Intrinsics3.checkNotNullParameter(function1, "valueMapper");
        return (collection == null || collection.isEmpty()) ? b.j : new c(collection, function1);
    }

    public static final <T> Observable.c<T, T> c(Function1<? super T, Boolean> function1, T t, long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        return new d(function1, t, j, timeUnit);
    }

    public static /* synthetic */ Observable.c d(Function1 function1, Object obj, long j, TimeUnit timeUnit, int i) {
        if ((i & 4) != 0) {
            j = 5000;
        }
        return c(function1, obj, j, (i & 8) != 0 ? TimeUnit.MILLISECONDS : null);
    }

    public static final <T> Observable.c<T, T> e(Action1<? super T> action1, Class<?> cls) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        return new w(null, cls, null, action1, null);
    }

    public static Observable.c f(o oVar, Function1 function1, String str, Function1 function2, Function1 function3, Context context, Function0 function0, int i) {
        Function1 function4 = (i & 4) != 0 ? null : function2;
        int i2 = i & 8;
        Context context2 = (i & 16) != 0 ? null : context;
        int i3 = i & 32;
        Intrinsics3.checkNotNullParameter(function1, "onNext");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        return new y(context2, str, null, function1, function4, null);
    }

    public static final <T> Observable.c<T, T> h(Action1<? super T> action1, Context context, Action1<Error> action2) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        e eVar = new e(action1);
        c0 c0Var = (40 & 4) != 0 ? null : action2 != null ? new c0(action2) : null;
        int i = 40 & 8;
        Context context2 = (40 & 16) != 0 ? null : context;
        int i2 = 40 & 32;
        Intrinsics3.checkNotNullParameter(eVar, "onNext");
        Intrinsics3.checkNotNullParameter("restClient", "errorTag");
        return new y(context2, "restClient", null, eVar, c0Var, null);
    }

    public static final <T> Observable.c<T, T> i(Action1<? super T> action1, AppFragment appFragment) {
        Intrinsics3.checkNotNullParameter(action1, "onNext");
        Intrinsics3.checkNotNullParameter(appFragment, "fragment");
        return a.g(appFragment.getContext(), new f(action1), null);
    }

    public static /* synthetic */ Observable.c j(Action1 action1, Context context, Action1 action2, int i) {
        int i2 = i & 4;
        return h(action1, context, null);
    }

    public final <T> Observable.c<T, T> g(Context context, Function1<? super T, Unit> function1, Action1<Error> action1) {
        Intrinsics3.checkNotNullParameter(function1, "onNext");
        return f(this, function1, "restClient", action1 != null ? new c0(action1) : null, null, context, null, 40);
    }
}
