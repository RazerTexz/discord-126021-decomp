package i0;

import i0.CallAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.g, reason: use source file name */
/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class CompletableFutureCallAdapterFactory extends CallAdapter.a {
    public static final CallAdapter.a a = new CompletableFutureCallAdapterFactory();

    /* JADX INFO: renamed from: i0.g$a */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class a<R> implements CallAdapter<R, CompletableFuture<R>> {
        public final Type a;

        /* JADX INFO: renamed from: i0.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        public class C0424a implements Callback3<R> {
            public final CompletableFuture<R> a;

            public C0424a(a aVar, CompletableFuture<R> completableFuture) {
                this.a = completableFuture;
            }

            @Override // i0.Callback3
            public void a(Call3<R> call3, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // i0.Callback3
            public void b(Call3<R> call3, Response<R> response) {
                if (response.a()) {
                    this.a.complete(response.f3824b);
                } else {
                    this.a.completeExceptionally(new HttpException(response));
                }
            }
        }

        public a(Type type) {
            this.a = type;
        }

        @Override // i0.CallAdapter
        public Type a() {
            return this.a;
        }

        @Override // i0.CallAdapter
        public Object b(Call3 call3) {
            b bVar = new b(call3);
            call3.C(new C0424a(this, bVar));
            return bVar;
        }
    }

    /* JADX INFO: renamed from: i0.g$b */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {
        public final Call3<?> j;

        public b(Call3<?> call3) {
            this.j = call3;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            if (z2) {
                this.j.cancel();
            }
            return super.cancel(z2);
        }
    }

    /* JADX INFO: renamed from: i0.g$c */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class c<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        public final Type a;

        /* JADX INFO: renamed from: i0.g$c$a */
        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        public class a implements Callback3<R> {
            public final CompletableFuture<Response<R>> a;

            public a(c cVar, CompletableFuture<Response<R>> completableFuture) {
                this.a = completableFuture;
            }

            @Override // i0.Callback3
            public void a(Call3<R> call3, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // i0.Callback3
            public void b(Call3<R> call3, Response<R> response) {
                this.a.complete(response);
            }
        }

        public c(Type type) {
            this.a = type;
        }

        @Override // i0.CallAdapter
        public Type a() {
            return this.a;
        }

        @Override // i0.CallAdapter
        public Object b(Call3 call3) {
            b bVar = new b(call3);
            call3.C(new a(this, bVar));
            return bVar;
        }
    }

    @Override // i0.CallAdapter.a
    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        if (Utils8.f(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeE = Utils8.e(0, (ParameterizedType) type);
        if (Utils8.f(typeE) != Response.class) {
            return new a(typeE);
        }
        if (typeE instanceof ParameterizedType) {
            return new c(Utils8.e(0, (ParameterizedType) typeE));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
