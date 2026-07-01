package i0;

import i0.CallAdapter;
import i0.DefaultCallAdapterFactory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.i, reason: use source file name */
/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.a {
    public final Executor a;

    /* JADX INFO: renamed from: i0.i$a */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public class a implements CallAdapter<Object, Call3<?>> {
        public final /* synthetic */ Type a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f3740b;

        public a(DefaultCallAdapterFactory defaultCallAdapterFactory, Type type, Executor executor) {
            this.a = type;
            this.f3740b = executor;
        }

        @Override // i0.CallAdapter
        public Type a() {
            return this.a;
        }

        @Override // i0.CallAdapter
        public Call3<?> b(Call3<Object> call3) {
            Executor executor = this.f3740b;
            return executor == null ? call3 : new b(executor, call3);
        }
    }

    /* JADX INFO: renamed from: i0.i$b */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public static final class b<T> implements Call3<T> {
        public final Executor j;
        public final Call3<T> k;

        /* JADX INFO: renamed from: i0.i$b$a */
        /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
        public class a implements Callback3<T> {
            public final /* synthetic */ Callback3 a;

            public a(Callback3 callback3) {
                this.a = callback3;
            }

            @Override // i0.Callback3
            public void a(Call3<T> call3, final Throwable th) {
                Executor executor = b.this.j;
                final Callback3 callback3 = this.a;
                executor.execute(new Runnable() { // from class: i0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.b.a aVar = this.j;
                        callback3.a(DefaultCallAdapterFactory.b.this, th);
                    }
                });
            }

            @Override // i0.Callback3
            public void b(Call3<T> call3, final Response<T> response) {
                Executor executor = b.this.j;
                final Callback3 callback3 = this.a;
                executor.execute(new Runnable() { // from class: i0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.b.a aVar = this.j;
                        Callback3 callback4 = callback3;
                        Response response2 = response;
                        if (DefaultCallAdapterFactory.b.this.k.d()) {
                            callback4.a(DefaultCallAdapterFactory.b.this, new IOException("Canceled"));
                        } else {
                            callback4.b(DefaultCallAdapterFactory.b.this, response2);
                        }
                    }
                });
            }
        }

        public b(Executor executor, Call3<T> call3) {
            this.j = executor;
            this.k = call3;
        }

        @Override // i0.Call3
        public void C(Callback3<T> callback3) {
            this.k.C(new a(callback3));
        }

        @Override // i0.Call3
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public Call3<T> clone() {
            return new b(this.j, this.k.clone());
        }

        @Override // i0.Call3
        public Request c() {
            return this.k.c();
        }

        @Override // i0.Call3
        public void cancel() {
            this.k.cancel();
        }

        @Override // i0.Call3
        public boolean d() {
            return this.k.d();
        }

        @Override // i0.Call3
        public Response<T> execute() throws IOException {
            return this.k.execute();
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.a = executor;
    }

    @Override // i0.CallAdapter.a
    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        if (Utils8.f(type) != Call3.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(this, Utils8.e(0, (ParameterizedType) type), Utils8.i(annotationArr, SkipCallbackExecutor.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
