package p630i0;

import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.C12190g;
import p600f0.InterfaceC12269e;
import p659s.p660a.C13126l;

/* JADX INFO: renamed from: i0.j */
/* JADX INFO: compiled from: HttpServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12556j<ResponseT, ReturnT> extends AbstractC12572z<ReturnT> {

    /* JADX INFO: renamed from: a */
    public final C12569w f26541a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC12269e.a f26542b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC12554h<ResponseBody, ResponseT> f26543c;

    /* JADX INFO: renamed from: i0.j$a */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class a<ResponseT, ReturnT> extends AbstractC12556j<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d */
        public final InterfaceC12512e<ResponseT, ReturnT> f26544d;

        public a(C12569w c12569w, InterfaceC12269e.a aVar, InterfaceC12554h<ResponseBody, ResponseT> interfaceC12554h, InterfaceC12512e<ResponseT, ReturnT> interfaceC12512e) {
            super(c12569w, aVar, interfaceC12554h);
            this.f26544d = interfaceC12512e;
        }

        @Override // p630i0.AbstractC12556j
        /* JADX INFO: renamed from: c */
        public ReturnT mo10711c(InterfaceC12504d<ResponseT> interfaceC12504d, Object[] objArr) {
            return this.f26544d.mo10706b(interfaceC12504d);
        }
    }

    /* JADX INFO: renamed from: i0.j$b */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class b<ResponseT> extends AbstractC12556j<ResponseT, Object> {

        /* JADX INFO: renamed from: d */
        public final InterfaceC12512e<ResponseT, InterfaceC12504d<ResponseT>> f26545d;

        public b(C12569w c12569w, InterfaceC12269e.a aVar, InterfaceC12554h<ResponseBody, ResponseT> interfaceC12554h, InterfaceC12512e<ResponseT, InterfaceC12504d<ResponseT>> interfaceC12512e, boolean z2) {
            super(c12569w, aVar, interfaceC12554h);
            this.f26545d = interfaceC12512e;
        }

        @Override // p630i0.AbstractC12556j
        /* JADX INFO: renamed from: c */
        public Object mo10711c(InterfaceC12504d<ResponseT> interfaceC12504d, Object[] objArr) {
            InterfaceC12504d<ResponseT> interfaceC12504dMo10706b = this.f26545d.mo10706b(interfaceC12504d);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
                c13126l.mo10902f(new C12558l(interfaceC12504dMo10706b));
                interfaceC12504dMo10706b.mo10697C(new C12559m(c13126l));
                Object objM11326u = c13126l.m11326u();
                if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                    C12190g.probeCoroutineSuspended(continuation);
                }
                return objM11326u;
            } catch (Exception e) {
                return C3404f.m4301i1(e, continuation);
            }
        }
    }

    /* JADX INFO: renamed from: i0.j$c */
    /* JADX INFO: compiled from: HttpServiceMethod.java */
    public static final class c<ResponseT> extends AbstractC12556j<ResponseT, Object> {

        /* JADX INFO: renamed from: d */
        public final InterfaceC12512e<ResponseT, InterfaceC12504d<ResponseT>> f26546d;

        public c(C12569w c12569w, InterfaceC12269e.a aVar, InterfaceC12554h<ResponseBody, ResponseT> interfaceC12554h, InterfaceC12512e<ResponseT, InterfaceC12504d<ResponseT>> interfaceC12512e) {
            super(c12569w, aVar, interfaceC12554h);
            this.f26546d = interfaceC12512e;
        }

        @Override // p630i0.AbstractC12556j
        /* JADX INFO: renamed from: c */
        public Object mo10711c(InterfaceC12504d<ResponseT> interfaceC12504d, Object[] objArr) {
            InterfaceC12504d<ResponseT> interfaceC12504dMo10706b = this.f26546d.mo10706b(interfaceC12504d);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
                c13126l.mo10902f(new C12560n(interfaceC12504dMo10706b));
                interfaceC12504dMo10706b.mo10697C(new C12561o(c13126l));
                Object objM11326u = c13126l.m11326u();
                if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
                    C12190g.probeCoroutineSuspended(continuation);
                }
                return objM11326u;
            } catch (Exception e) {
                return C3404f.m4301i1(e, continuation);
            }
        }
    }

    public AbstractC12556j(C12569w c12569w, InterfaceC12269e.a aVar, InterfaceC12554h<ResponseBody, ResponseT> interfaceC12554h) {
        this.f26541a = c12569w;
        this.f26542b = aVar;
        this.f26543c = interfaceC12554h;
    }

    @Override // p630i0.AbstractC12572z
    /* JADX INFO: renamed from: a */
    public final ReturnT mo10710a(Object[] objArr) {
        return mo10711c(new C12562p(this.f26541a, objArr, this.f26542b, this.f26543c), objArr);
    }

    /* JADX INFO: renamed from: c */
    public abstract ReturnT mo10711c(InterfaceC12504d<ResponseT> interfaceC12504d, Object[] objArr);
}
