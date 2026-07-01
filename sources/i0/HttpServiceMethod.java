package i0;

import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import f0.Call2;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import s.a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: i0.j, reason: use source file name */
/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    public final RequestFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call2.a f3742b;
    public final Converter2<ResponseBody, ResponseT> c;

    /* JADX INFO: renamed from: i0.j$a */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class a<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        public final CallAdapter<ResponseT, ReturnT> d;

        public a(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, ReturnT> callAdapter) {
            super(requestFactory, aVar, converter2);
            this.d = callAdapter;
        }

        @Override // i0.HttpServiceMethod
        public ReturnT c(Call3<ResponseT> call3, Object[] objArr) {
            return this.d.b(call3);
        }
    }

    /* JADX INFO: renamed from: i0.j$b */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class b<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call3<ResponseT>> d;

        public b(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, Call3<ResponseT>> callAdapter, boolean z2) {
            super(requestFactory, aVar, converter2);
            this.d = callAdapter;
        }

        @Override // i0.HttpServiceMethod
        public Object c(Call3<ResponseT> call3, Object[] objArr) {
            Call3<ResponseT> call3B = this.d.b(call3);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
                cancellableContinuationImpl5.f(new KotlinExtensions2(call3B));
                call3B.C(new KotlinExtensions3(cancellableContinuationImpl5));
                Object objU = cancellableContinuationImpl5.u();
                if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return objU;
            } catch (Exception e) {
                return b.i.a.f.e.o.f.i1(e, continuation);
            }
        }
    }

    /* JADX INFO: renamed from: i0.j$c */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class c<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        public final CallAdapter<ResponseT, Call3<ResponseT>> d;

        public c(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2, CallAdapter<ResponseT, Call3<ResponseT>> callAdapter) {
            super(requestFactory, aVar, converter2);
            this.d = callAdapter;
        }

        @Override // i0.HttpServiceMethod
        public Object c(Call3<ResponseT> call3, Object[] objArr) {
            Call3<ResponseT> call3B = this.d.b(call3);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
                cancellableContinuationImpl5.f(new KotlinExtensions4(call3B));
                call3B.C(new KotlinExtensions5(cancellableContinuationImpl5));
                Object objU = cancellableContinuationImpl5.u();
                if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return objU;
            } catch (Exception e) {
                return b.i.a.f.e.o.f.i1(e, continuation);
            }
        }
    }

    public HttpServiceMethod(RequestFactory requestFactory, Call2.a aVar, Converter2<ResponseBody, ResponseT> converter2) {
        this.a = requestFactory;
        this.f3742b = aVar;
        this.c = converter2;
    }

    @Override // i0.ServiceMethod
    public final ReturnT a(Object[] objArr) {
        return c(new OkHttpCall(this.a, objArr, this.f3742b, this.c), objArr);
    }

    public abstract ReturnT c(Call3<ResponseT> call3, Object[] objArr);
}
