package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.i */
/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12555i extends InterfaceC12512e.a {

    /* JADX INFO: renamed from: a */
    public final Executor f26534a;

    /* JADX INFO: renamed from: i0.i$a */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public class a implements InterfaceC12512e<Object, InterfaceC12504d<?>> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Type f26535a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Executor f26536b;

        public a(C12555i c12555i, Type type, Executor executor) {
            this.f26535a = type;
            this.f26536b = executor;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: a */
        public Type mo10705a() {
            return this.f26535a;
        }

        @Override // p630i0.InterfaceC12512e
        /* JADX INFO: renamed from: b */
        public InterfaceC12504d<?> mo10706b(InterfaceC12504d<Object> interfaceC12504d) {
            Executor executor = this.f26536b;
            return executor == null ? interfaceC12504d : new b(executor, interfaceC12504d);
        }
    }

    /* JADX INFO: renamed from: i0.i$b */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public static final class b<T> implements InterfaceC12504d<T> {

        /* JADX INFO: renamed from: j */
        public final Executor f26537j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12504d<T> f26538k;

        /* JADX INFO: renamed from: i0.i$b$a */
        /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
        public class a implements InterfaceC12527f<T> {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ InterfaceC12527f f26539a;

            public a(InterfaceC12527f interfaceC12527f) {
                this.f26539a = interfaceC12527f;
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: a */
            public void mo10708a(InterfaceC12504d<T> interfaceC12504d, final Throwable th) {
                Executor executor = b.this.f26537j;
                final InterfaceC12527f interfaceC12527f = this.f26539a;
                executor.execute(new Runnable() { // from class: i0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12555i.b.a aVar = this.f26476j;
                        interfaceC12527f.mo10708a(C12555i.b.this, th);
                    }
                });
            }

            @Override // p630i0.InterfaceC12527f
            /* JADX INFO: renamed from: b */
            public void mo10709b(InterfaceC12504d<T> interfaceC12504d, final Response<T> response) {
                Executor executor = b.this.f26537j;
                final InterfaceC12527f interfaceC12527f = this.f26539a;
                executor.execute(new Runnable() { // from class: i0.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12555i.b.a aVar = this.f26479j;
                        InterfaceC12527f interfaceC12527f2 = interfaceC12527f;
                        Response response2 = response;
                        if (C12555i.b.this.f26538k.mo10700d()) {
                            interfaceC12527f2.mo10708a(C12555i.b.this, new IOException("Canceled"));
                        } else {
                            interfaceC12527f2.mo10709b(C12555i.b.this, response2);
                        }
                    }
                });
            }
        }

        public b(Executor executor, InterfaceC12504d<T> interfaceC12504d) {
            this.f26537j = executor;
            this.f26538k = interfaceC12504d;
        }

        @Override // p630i0.InterfaceC12504d
        /* JADX INFO: renamed from: C */
        public void mo10697C(InterfaceC12527f<T> interfaceC12527f) {
            this.f26538k.mo10697C(new a(interfaceC12527f));
        }

        @Override // p630i0.InterfaceC12504d
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public InterfaceC12504d<T> clone() {
            return new b(this.f26537j, this.f26538k.clone());
        }

        @Override // p630i0.InterfaceC12504d
        /* JADX INFO: renamed from: c */
        public Request mo10699c() {
            return this.f26538k.mo10699c();
        }

        @Override // p630i0.InterfaceC12504d
        public void cancel() {
            this.f26538k.cancel();
        }

        @Override // p630i0.InterfaceC12504d
        /* JADX INFO: renamed from: d */
        public boolean mo10700d() {
            return this.f26538k.mo10700d();
        }

        @Override // p630i0.InterfaceC12504d
        public Response<T> execute() throws IOException {
            return this.f26538k.execute();
        }
    }

    public C12555i(Executor executor) {
        this.f26534a = executor;
    }

    @Override // p630i0.InterfaceC12512e.a
    /* JADX INFO: renamed from: a */
    public InterfaceC12512e<?, ?> mo10707a(Type type, Annotation[] annotationArr, C12571y c12571y) {
        if (C12503c0.m10686f(type) != InterfaceC12504d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(this, C12503c0.m10685e(0, (ParameterizedType) type), C12503c0.m10689i(annotationArr, InterfaceC12499a0.class) ? null : this.f26534a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
