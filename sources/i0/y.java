package i0;

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

/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public final Map<Method, z<?>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0.e$a f3767b;
    public final f0.w c;
    public final List<h$a> d;
    public final List<e$a> e;
    public final Executor f;
    public final boolean g;

    public y(f0.e$a e_a, f0.w wVar, List<h$a> list, List<e$a> list2, Executor executor, boolean z2) {
        this.f3767b = e_a;
        this.c = wVar;
        this.d = list;
        this.e = list2;
        this.f = executor;
        this.g = z2;
    }

    public e<?, ?> a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.e.indexOf(null) + 1;
        int size = this.e.size();
        for (int i = iIndexOf; i < size; i++) {
            e<?, ?> eVarA = this.e.get(i).a(type, annotationArr, this);
            if (eVarA != null) {
                return eVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public z<?> b(Method method) {
        z<?> zVarB;
        z<?> zVar = this.a.get(method);
        if (zVar != null) {
            return zVar;
        }
        synchronized (this.a) {
            zVarB = this.a.get(method);
            if (zVarB == null) {
                zVarB = z.b(this, method);
                this.a.put(method, zVarB);
            }
        }
        return zVarB;
    }

    public <T> h<T, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.d.indexOf(null) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            h<T, RequestBody> hVar = (h<T, RequestBody>) this.d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<ResponseBody, T> d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.d.indexOf(null) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            h<ResponseBody, T> hVar = (h<ResponseBody, T>) this.d.get(i).responseBodyConverter(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> h<T, String> e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            h<T, String> hVar = (h<T, String>) this.d.get(i).stringConverter(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return c$d.a;
    }
}
