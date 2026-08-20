package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p600f0.C12379w;
import p600f0.InterfaceC12269e;

/* JADX INFO: renamed from: i0.y */
/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12571y {

    /* JADX INFO: renamed from: a */
    public final Map<Method, AbstractC12572z<?>> f26673a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public final InterfaceC12269e.a f26674b;

    /* JADX INFO: renamed from: c */
    public final C12379w f26675c;

    /* JADX INFO: renamed from: d */
    public final List<InterfaceC12554h.a> f26676d;

    /* JADX INFO: renamed from: e */
    public final List<InterfaceC12512e.a> f26677e;

    /* JADX INFO: renamed from: f */
    public final Executor f26678f;

    /* JADX INFO: renamed from: g */
    public final boolean f26679g;

    public C12571y(InterfaceC12269e.a aVar, C12379w c12379w, List<InterfaceC12554h.a> list, List<InterfaceC12512e.a> list2, Executor executor, boolean z2) {
        this.f26674b = aVar;
        this.f26675c = c12379w;
        this.f26676d = list;
        this.f26677e = list2;
        this.f26678f = executor;
        this.f26679g = z2;
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC12512e<?, ?> m10725a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f26677e.indexOf(null) + 1;
        int size = this.f26677e.size();
        for (int i = iIndexOf; i < size; i++) {
            InterfaceC12512e<?, ?> interfaceC12512eMo10707a = this.f26677e.get(i).mo10707a(type, annotationArr, this);
            if (interfaceC12512eMo10707a != null) {
                return interfaceC12512eMo10707a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26677e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26677e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: b */
    public AbstractC12572z<?> m10726b(Method method) {
        AbstractC12572z<?> abstractC12572zM10730b;
        AbstractC12572z<?> abstractC12572z = this.f26673a.get(method);
        if (abstractC12572z != null) {
            return abstractC12572z;
        }
        synchronized (this.f26673a) {
            abstractC12572zM10730b = this.f26673a.get(method);
            if (abstractC12572zM10730b == null) {
                abstractC12572zM10730b = AbstractC12572z.m10730b(this, method);
                this.f26673a.put(method, abstractC12572zM10730b);
            }
        }
        return abstractC12572zM10730b;
    }

    /* JADX INFO: renamed from: c */
    public <T> InterfaceC12554h<T, RequestBody> m10727c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f26676d.indexOf(null) + 1;
        int size = this.f26676d.size();
        for (int i = iIndexOf; i < size; i++) {
            InterfaceC12554h<T, RequestBody> interfaceC12554h = (InterfaceC12554h<T, RequestBody>) this.f26676d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (interfaceC12554h != null) {
                return interfaceC12554h;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26676d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26676d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: d */
    public <T> InterfaceC12554h<ResponseBody, T> m10728d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f26676d.indexOf(null) + 1;
        int size = this.f26676d.size();
        for (int i = iIndexOf; i < size; i++) {
            InterfaceC12554h<ResponseBody, T> interfaceC12554h = (InterfaceC12554h<ResponseBody, T>) this.f26676d.get(i).responseBodyConverter(type, annotationArr, this);
            if (interfaceC12554h != null) {
                return interfaceC12554h;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26676d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26676d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: e */
    public <T> InterfaceC12554h<T, String> m10729e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f26676d.size();
        for (int i = 0; i < size; i++) {
            InterfaceC12554h<T, String> interfaceC12554h = (InterfaceC12554h<T, String>) this.f26676d.get(i).stringConverter(type, annotationArr, this);
            if (interfaceC12554h != null) {
                return interfaceC12554h;
            }
        }
        return C12502c.d.f26487a;
    }
}
