package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.g */
/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class C12553g extends InterfaceC12512e.a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC12512e.a f26528a = new C12553g();

    /* JADX INFO: renamed from: i0.g$a */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class a<R> implements InterfaceC12512e<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a */
        public final Type f26529a;

        /* JADX INFO: renamed from: i0.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        public class C13346a implements InterfaceC12527f<R> {

            /* JADX INFO: renamed from: a */
            public final CompletableFuture<R> f26530a;

            public C13346a(a aVar, CompletableFuture<R> completableFuture) {
                this.f26530a = completableFuture;
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: a */
            public void mo10708a(InterfaceC12504d<R> interfaceC12504d, Throwable th) {
                this.f26530a.completeExceptionally(th);
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: b */
            public void mo10709b(InterfaceC12504d<R> interfaceC12504d, Response<R> response) {
                if (response.m11057a()) {
                    this.f26530a.complete(response.f27632b);
                } else {
                    this.f26530a.completeExceptionally(new HttpException(response));
                }
            }
        }

        public a(Type type) {
            this.f26529a = type;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: a */
        public Type mo10705a() {
            return this.f26529a;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: b */
        public Object mo10706b(InterfaceC12504d interfaceC12504d) {
            b bVar = new b(interfaceC12504d);
            interfaceC12504d.mo10697C(new C13346a(this, bVar));
            return bVar;
        }
    }

    /* JADX INFO: renamed from: i0.g$b */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: j */
        public final InterfaceC12504d<?> f26531j;

        public b(InterfaceC12504d<?> interfaceC12504d) {
            this.f26531j = interfaceC12504d;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            if (z2) {
                this.f26531j.cancel();
            }
            return super.cancel(z2);
        }
    }

    /* JADX INFO: renamed from: i0.g$c */
    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class c<R> implements InterfaceC12512e<R, CompletableFuture<Response<R>>> {

        /* JADX INFO: renamed from: a */
        public final Type f26532a;

        /* JADX INFO: renamed from: i0.g$c$a */
        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        public class a implements InterfaceC12527f<R> {

            /* JADX INFO: renamed from: a */
            public final CompletableFuture<Response<R>> f26533a;

            public a(c cVar, CompletableFuture<Response<R>> completableFuture) {
                this.f26533a = completableFuture;
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: a */
            public void mo10708a(InterfaceC12504d<R> interfaceC12504d, Throwable th) {
                this.f26533a.completeExceptionally(th);
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: b */
            public void mo10709b(InterfaceC12504d<R> interfaceC12504d, Response<R> response) {
                this.f26533a.complete(response);
            }
        }

        public c(Type type) {
            this.f26532a = type;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: a */
        public Type mo10705a() {
            return this.f26532a;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: b */
        public Object mo10706b(InterfaceC12504d interfaceC12504d) {
            b bVar = new b(interfaceC12504d);
            interfaceC12504d.mo10697C(new a(this, bVar));
            return bVar;
        }
    }

    @Override // p630i0.InterfaceC12512e.a
    /* JADX INFO: renamed from: a */
    public InterfaceC12512e<?, ?> mo10707a(Type type, Annotation[] annotationArr, C12571y c12571y) {
        if (C12503c0.m10686f(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeM10685e = C12503c0.m10685e(0, (ParameterizedType) type);
        if (C12503c0.m10686f(typeM10685e) != Response.class) {
            return new a(typeM10685e);
        }
        if (typeM10685e instanceof ParameterizedType) {
            return new c(C12503c0.m10685e(0, (ParameterizedType) typeM10685e));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
