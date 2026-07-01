package i0;

import f0.Call2;
import f0.HttpUrl;
import i0.BuiltInConverters;
import i0.CallAdapter;
import i0.Converter2;
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

/* JADX INFO: renamed from: i0.y, reason: use source file name */
/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Retrofit2 {
    public final Map<Method, ServiceMethod<?>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Call2.a f3767b;
    public final HttpUrl c;
    public final List<Converter2.a> d;
    public final List<CallAdapter.a> e;
    public final Executor f;
    public final boolean g;

    public Retrofit2(Call2.a aVar, HttpUrl httpUrl, List<Converter2.a> list, List<CallAdapter.a> list2, Executor executor, boolean z2) {
        this.f3767b = aVar;
        this.c = httpUrl;
        this.d = list;
        this.e = list2;
        this.f = executor;
        this.g = z2;
    }

    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.e.indexOf(null) + 1;
        int size = this.e.size();
        for (int i = iIndexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapterA = this.e.get(i).a(type, annotationArr, this);
            if (callAdapterA != null) {
                return callAdapterA;
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

    public ServiceMethod<?> b(Method method) {
        ServiceMethod<?> serviceMethodB;
        ServiceMethod<?> serviceMethod = this.a.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        synchronized (this.a) {
            serviceMethodB = this.a.get(method);
            if (serviceMethodB == null) {
                serviceMethodB = ServiceMethod.b(this, method);
                this.a.put(method, serviceMethodB);
            }
        }
        return serviceMethodB;
    }

    public <T> Converter2<T, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.d.indexOf(null) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter2<T, RequestBody> converter2 = (Converter2<T, RequestBody>) this.d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter2 != null) {
                return converter2;
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

    public <T> Converter2<ResponseBody, T> d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.d.indexOf(null) + 1;
        int size = this.d.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter2<ResponseBody, T> converter2 = (Converter2<ResponseBody, T>) this.d.get(i).responseBodyConverter(type, annotationArr, this);
            if (converter2 != null) {
                return converter2;
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

    public <T> Converter2<T, String> e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            Converter2<T, String> converter2 = (Converter2<T, String>) this.d.get(i).stringConverter(type, annotationArr, this);
            if (converter2 != null) {
                return converter2;
            }
        }
        return BuiltInConverters.d.a;
    }
}
