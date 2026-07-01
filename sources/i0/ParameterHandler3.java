package i0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: renamed from: i0.t, reason: use source file name */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ParameterHandler3<T> {

    /* JADX INFO: renamed from: i0.t$a */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class a<T> extends ParameterHandler3<T> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3745b;
        public final Converter2<T, RequestBody> c;

        public a(Method method, int i, Converter2<T, RequestBody> converter2) {
            this.a = method;
            this.f3745b = i;
            this.c = converter2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                throw Utils8.l(this.a, this.f3745b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.m = this.c.convert(t);
            } catch (IOException e) {
                throw Utils8.m(this.a, e, this.f3745b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$b */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class b<T> extends ParameterHandler3<T> {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter2<T, String> f3746b;
        public final boolean c;

        public b(String str, Converter2<T, String> converter2, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3746b = converter2;
            this.c = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3746b.convert(t)) == null) {
                return;
            }
            requestBuilder.a(this.a, strConvert, this.c);
        }
    }

    /* JADX INFO: renamed from: i0.t$c */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class c<T> extends ParameterHandler3<Map<String, T>> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3747b;
        public final Converter2<T, String> c;
        public final boolean d;

        public c(Method method, int i, Converter2<T, String> converter2, boolean z2) {
            this.a = method;
            this.f3747b = i;
            this.c = converter2;
            this.d = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.l(this.a, this.f3747b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.l(this.a, this.f3747b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.l(this.a, this.f3747b, outline.y("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                String strConvert = this.c.convert((T) value);
                if (strConvert == null) {
                    throw Utils8.l(this.a, this.f3747b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.a(str, strConvert, this.d);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$d */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class d<T> extends ParameterHandler3<T> {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter2<T, String> f3748b;

        public d(String str, Converter2<T, String> converter2) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3748b = converter2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3748b.convert(t)) == null) {
                return;
            }
            requestBuilder.b(this.a, strConvert);
        }
    }

    /* JADX INFO: renamed from: i0.t$e */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class e<T> extends ParameterHandler3<Map<String, T>> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3749b;
        public final Converter2<T, String> c;

        public e(Method method, int i, Converter2<T, String> converter2) {
            this.a = method;
            this.f3749b = i;
            this.c = converter2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.l(this.a, this.f3749b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.l(this.a, this.f3749b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.l(this.a, this.f3749b, outline.y("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                requestBuilder.b(str, this.c.convert((T) value));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$f */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class f extends ParameterHandler3<Headers> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3750b;

        public f(Method method, int i) {
            this.a = method;
            this.f3750b = i;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Headers headers) throws IOException {
            Headers headers2 = headers;
            if (headers2 == null) {
                throw Utils8.l(this.a, this.f3750b, "Headers parameter must not be null.", new Object[0]);
            }
            Headers.a aVar = requestBuilder.h;
            Objects.requireNonNull(aVar);
            Intrinsics3.checkParameterIsNotNull(headers2, "headers");
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                aVar.b(headers2.d(i), headers2.g(i));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$g */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class g<T> extends ParameterHandler3<T> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3751b;
        public final Headers c;
        public final Converter2<T, RequestBody> d;

        public g(Method method, int i, Headers headers, Converter2<T, RequestBody> converter2) {
            this.a = method;
            this.f3751b = i;
            this.c = headers;
            this.d = converter2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.c(this.c, this.d.convert(t));
            } catch (IOException e) {
                throw Utils8.l(this.a, this.f3751b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$h */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class h<T> extends ParameterHandler3<Map<String, T>> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3752b;
        public final Converter2<T, RequestBody> c;
        public final String d;

        public h(Method method, int i, Converter2<T, RequestBody> converter2, String str) {
            this.a = method;
            this.f3752b = i;
            this.c = converter2;
            this.d = str;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.l(this.a, this.f3752b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.l(this.a, this.f3752b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.l(this.a, this.f3752b, outline.y("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                requestBuilder.c(Headers.INSTANCE.c("Content-Disposition", outline.y("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.d), this.c.convert((T) value));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$i */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class i<T> extends ParameterHandler3<T> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3753b;
        public final String c;
        public final Converter2<T, String> d;
        public final boolean e;

        public i(Method method, int i, String str, Converter2<T, String> converter2, boolean z2) {
            this.a = method;
            this.f3753b = i;
            Objects.requireNonNull(str, "name == null");
            this.c = str;
            this.d = converter2;
            this.e = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) throws IOException {
            String strD;
            if (t == null) {
                throw Utils8.l(this.a, this.f3753b, outline.J(outline.U("Path parameter \""), this.c, "\" value must not be null."), new Object[0]);
            }
            String str = this.c;
            String strConvert = this.d.convert(t);
            boolean z2 = this.e;
            if (requestBuilder.e == null) {
                throw new AssertionError();
            }
            int length = strConvert.length();
            int iCharCount = 0;
            while (true) {
                if (iCharCount >= length) {
                    strD = strConvert;
                    break;
                }
                int iCodePointAt = strConvert.codePointAt(iCharCount);
                int i = 47;
                int i2 = -1;
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.c0(strConvert, 0, iCharCount);
                    Buffer3 buffer4 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = strConvert.codePointAt(iCharCount);
                        if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i2 || (!z2 && (iCodePointAt2 == i || iCodePointAt2 == 37))) {
                                if (buffer4 == null) {
                                    buffer4 = new Buffer3();
                                }
                                buffer4.d0(iCodePointAt2);
                                while (!buffer4.w()) {
                                    int i3 = buffer4.readByte() & 255;
                                    buffer3.T(37);
                                    char[] cArr = RequestBuilder.a;
                                    buffer3.T(cArr[(i3 >> 4) & 15]);
                                    buffer3.T(cArr[i3 & 15]);
                                }
                            } else {
                                buffer3.d0(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i = 47;
                        i2 = -1;
                    }
                    strD = buffer3.D();
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strReplace = requestBuilder.e.replace("{" + str + "}", strD);
            if (RequestBuilder.f3759b.matcher(strReplace).matches()) {
                throw new IllegalArgumentException(outline.w("@Path parameters shouldn't perform path traversal ('.' or '..'): ", strConvert));
            }
            requestBuilder.e = strReplace;
        }
    }

    /* JADX INFO: renamed from: i0.t$j */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class j<T> extends ParameterHandler3<T> {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter2<T, String> f3754b;
        public final boolean c;

        public j(String str, Converter2<T, String> converter2, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3754b = converter2;
            this.c = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3754b.convert(t)) == null) {
                return;
            }
            requestBuilder.d(this.a, strConvert, this.c);
        }
    }

    /* JADX INFO: renamed from: i0.t$k */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class k<T> extends ParameterHandler3<Map<String, T>> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3755b;
        public final Converter2<T, String> c;
        public final boolean d;

        public k(Method method, int i, Converter2<T, String> converter2, boolean z2) {
            this.a = method;
            this.f3755b = i;
            this.c = converter2;
            this.d = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.l(this.a, this.f3755b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.l(this.a, this.f3755b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.l(this.a, this.f3755b, outline.y("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                String strConvert = this.c.convert((T) value);
                if (strConvert == null) {
                    throw Utils8.l(this.a, this.f3755b, "Query map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.d(str, strConvert, this.d);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$l */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class l<T> extends ParameterHandler3<T> {
        public final Converter2<T, String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3756b;

        public l(Converter2<T, String> converter2, boolean z2) {
            this.a = converter2;
            this.f3756b = z2;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.d(this.a.convert(t), null, this.f3756b);
        }
    }

    /* JADX INFO: renamed from: i0.t$m */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class m extends ParameterHandler3<MultipartBody.Part> {
        public static final m a = new m();

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                requestBuilder.k.a(part2);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$n */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class n extends ParameterHandler3<Object> {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3757b;

        public n(Method method, int i) {
            this.a = method;
            this.f3757b = i;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils8.l(this.a, this.f3757b, "@Url parameter is null.", new Object[0]);
            }
            Objects.requireNonNull(requestBuilder);
            requestBuilder.e = obj.toString();
        }
    }

    /* JADX INFO: renamed from: i0.t$o */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class o<T> extends ParameterHandler3<T> {
        public final Class<T> a;

        public o(Class<T> cls) {
            this.a = cls;
        }

        @Override // i0.ParameterHandler3
        public void a(RequestBuilder requestBuilder, T t) {
            requestBuilder.g.e(this.a, t);
        }
    }

    public abstract void a(RequestBuilder requestBuilder, T t) throws IOException;
}
