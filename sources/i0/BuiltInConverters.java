package i0;

import i0.Converter2;
import i0.f0.Streaming;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.c, reason: use source file name */
/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInConverters extends Converter2.a {
    public boolean a = true;

    /* JADX INFO: renamed from: i0.c$a */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class a implements Converter2<ResponseBody, ResponseBody> {
        public static final a a = new a();

        @Override // i0.Converter2
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            ResponseBody responseBody2 = responseBody;
            try {
                return Utils8.a(responseBody2);
            } finally {
                responseBody2.close();
            }
        }
    }

    /* JADX INFO: renamed from: i0.c$b */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class b implements Converter2<RequestBody, RequestBody> {
        public static final b a = new b();

        @Override // i0.Converter2
        public RequestBody convert(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    /* JADX INFO: renamed from: i0.c$c */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class c implements Converter2<ResponseBody, ResponseBody> {
        public static final c a = new c();

        @Override // i0.Converter2
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    /* JADX INFO: renamed from: i0.c$d */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class d implements Converter2<Object, String> {
        public static final d a = new d();

        @Override // i0.Converter2
        public String convert(Object obj) throws IOException {
            return obj.toString();
        }
    }

    /* JADX INFO: renamed from: i0.c$e */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class e implements Converter2<ResponseBody, Unit> {
        public static final e a = new e();

        @Override // i0.Converter2
        public Unit convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: i0.c$f */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class f implements Converter2<ResponseBody, Void> {
        public static final f a = new f();

        @Override // i0.Converter2
        public Void convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    @Override // i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit3) {
        if (RequestBody.class.isAssignableFrom(Utils8.f(type))) {
            return b.a;
        }
        return null;
    }

    @Override // i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        if (type == ResponseBody.class) {
            return Utils8.i(annotationArr, Streaming.class) ? c.a : a.a;
        }
        if (type == Void.class) {
            return f.a;
        }
        if (!this.a || type != Unit.class) {
            return null;
        }
        try {
            return e.a;
        } catch (NoClassDefFoundError unused) {
            this.a = false;
            return null;
        }
    }
}
