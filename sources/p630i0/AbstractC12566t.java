package p630i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12388e;

/* JADX INFO: renamed from: i0.t */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12566t<T> {

    /* JADX INFO: renamed from: i0.t$a */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class a<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final Method f26571a;

        /* JADX INFO: renamed from: b */
        public final int f26572b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC12554h<T, RequestBody> f26573c;

        public a(Method method, int i, InterfaceC12554h<T, RequestBody> interfaceC12554h) {
            this.f26571a = method;
            this.f26572b = i;
            this.f26573c = interfaceC12554h;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) {
            if (t == null) {
                throw C12503c0.m10692l(this.f26571a, this.f26572b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                c12568v.f26630m = this.f26573c.convert(t);
            } catch (IOException e) {
                throw C12503c0.m10693m(this.f26571a, e, this.f26572b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$b */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class b<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final String f26574a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC12554h<T, String> f26575b;

        /* JADX INFO: renamed from: c */
        public final boolean f26576c;

        public b(String str, InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f26574a = str;
            this.f26575b = interfaceC12554h;
            this.f26576c = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26575b.convert(t)) == null) {
                return;
            }
            c12568v.m10718a(this.f26574a, strConvert, this.f26576c);
        }
    }

    /* JADX INFO: renamed from: i0.t$c */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class c<T> extends AbstractC12566t<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        public final Method f26577a;

        /* JADX INFO: renamed from: b */
        public final int f26578b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC12554h<T, String> f26579c;

        /* JADX INFO: renamed from: d */
        public final boolean f26580d;

        public c(Method method, int i, InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            this.f26577a = method;
            this.f26578b = i;
            this.f26579c = interfaceC12554h;
            this.f26580d = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw C12503c0.m10692l(this.f26577a, this.f26578b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw C12503c0.m10692l(this.f26577a, this.f26578b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw C12503c0.m10692l(this.f26577a, this.f26578b, C1643a.m886y("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                String strConvert = this.f26579c.convert((T) value);
                if (strConvert == null) {
                    throw C12503c0.m10692l(this.f26577a, this.f26578b, "Field map value '" + value + "' converted to null by " + this.f26579c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                c12568v.m10718a(str, strConvert, this.f26580d);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$d */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class d<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final String f26581a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC12554h<T, String> f26582b;

        public d(String str, InterfaceC12554h<T, String> interfaceC12554h) {
            Objects.requireNonNull(str, "name == null");
            this.f26581a = str;
            this.f26582b = interfaceC12554h;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26582b.convert(t)) == null) {
                return;
            }
            c12568v.m10719b(this.f26581a, strConvert);
        }
    }

    /* JADX INFO: renamed from: i0.t$e */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class e<T> extends AbstractC12566t<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        public final Method f26583a;

        /* JADX INFO: renamed from: b */
        public final int f26584b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC12554h<T, String> f26585c;

        public e(Method method, int i, InterfaceC12554h<T, String> interfaceC12554h) {
            this.f26583a = method;
            this.f26584b = i;
            this.f26585c = interfaceC12554h;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw C12503c0.m10692l(this.f26583a, this.f26584b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw C12503c0.m10692l(this.f26583a, this.f26584b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw C12503c0.m10692l(this.f26583a, this.f26584b, C1643a.m886y("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                c12568v.m10719b(str, this.f26585c.convert((T) value));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$f */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class f extends AbstractC12566t<Headers> {

        /* JADX INFO: renamed from: a */
        public final Method f26586a;

        /* JADX INFO: renamed from: b */
        public final int f26587b;

        public f(Method method, int i) {
            this.f26586a = method;
            this.f26587b = i;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Headers headers) throws IOException {
            Headers headers2 = headers;
            if (headers2 == null) {
                throw C12503c0.m10692l(this.f26586a, this.f26587b, "Headers parameter must not be null.", new Object[0]);
            }
            Headers.C12930a c12930a = c12568v.f26625h;
            Objects.requireNonNull(c12930a);
            C12238m.checkParameterIsNotNull(headers2, "headers");
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                c12930a.m10959b(headers2.m10955d(i), headers2.m10957g(i));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$g */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class g<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final Method f26588a;

        /* JADX INFO: renamed from: b */
        public final int f26589b;

        /* JADX INFO: renamed from: c */
        public final Headers f26590c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC12554h<T, RequestBody> f26591d;

        public g(Method method, int i, Headers headers, InterfaceC12554h<T, RequestBody> interfaceC12554h) {
            this.f26588a = method;
            this.f26589b = i;
            this.f26590c = headers;
            this.f26591d = interfaceC12554h;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) {
            if (t == null) {
                return;
            }
            try {
                c12568v.m10720c(this.f26590c, this.f26591d.convert(t));
            } catch (IOException e) {
                throw C12503c0.m10692l(this.f26588a, this.f26589b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$h */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class h<T> extends AbstractC12566t<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        public final Method f26592a;

        /* JADX INFO: renamed from: b */
        public final int f26593b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC12554h<T, RequestBody> f26594c;

        /* JADX INFO: renamed from: d */
        public final String f26595d;

        public h(Method method, int i, InterfaceC12554h<T, RequestBody> interfaceC12554h, String str) {
            this.f26592a = method;
            this.f26593b = i;
            this.f26594c = interfaceC12554h;
            this.f26595d = str;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw C12503c0.m10692l(this.f26592a, this.f26593b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw C12503c0.m10692l(this.f26592a, this.f26593b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw C12503c0.m10692l(this.f26592a, this.f26593b, C1643a.m886y("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                c12568v.m10720c(Headers.INSTANCE.m10964c("Content-Disposition", C1643a.m886y("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.f26595d), this.f26594c.convert((T) value));
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$i */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class i<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final Method f26596a;

        /* JADX INFO: renamed from: b */
        public final int f26597b;

        /* JADX INFO: renamed from: c */
        public final String f26598c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC12554h<T, String> f26599d;

        /* JADX INFO: renamed from: e */
        public final boolean f26600e;

        public i(Method method, int i, String str, InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            this.f26596a = method;
            this.f26597b = i;
            Objects.requireNonNull(str, "name == null");
            this.f26598c = str;
            this.f26599d = interfaceC12554h;
            this.f26600e = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) throws IOException {
            String strM10429D;
            if (t == null) {
                throw C12503c0.m10692l(this.f26596a, this.f26597b, C1643a.m822J(C1643a.m833U("Path parameter \""), this.f26598c, "\" value must not be null."), new Object[0]);
            }
            String str = this.f26598c;
            String strConvert = this.f26599d.convert(t);
            boolean z2 = this.f26600e;
            if (c12568v.f26622e == null) {
                throw new AssertionError();
            }
            int length = strConvert.length();
            int iCharCount = 0;
            while (true) {
                if (iCharCount >= length) {
                    strM10429D = strConvert;
                    break;
                }
                int iCodePointAt = strConvert.codePointAt(iCharCount);
                int i = 47;
                int i2 = -1;
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    C12388e c12388e = new C12388e();
                    c12388e.m10453c0(strConvert, 0, iCharCount);
                    C12388e c12388e2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = strConvert.codePointAt(iCharCount);
                        if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i2 || (!z2 && (iCodePointAt2 == i || iCodePointAt2 == 37))) {
                                if (c12388e2 == null) {
                                    c12388e2 = new C12388e();
                                }
                                c12388e2.m10454d0(iCodePointAt2);
                                while (!c12388e2.mo10472w()) {
                                    int i3 = c12388e2.readByte() & 255;
                                    c12388e.m10444T(37);
                                    char[] cArr = C12568v.f26618a;
                                    c12388e.m10444T(cArr[(i3 >> 4) & 15]);
                                    c12388e.m10444T(cArr[i3 & 15]);
                                }
                            } else {
                                c12388e.m10454d0(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i = 47;
                        i2 = -1;
                    }
                    strM10429D = c12388e.m10429D();
                    break;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strReplace = c12568v.f26622e.replace("{" + str + "}", strM10429D);
            if (C12568v.f26619b.matcher(strReplace).matches()) {
                throw new IllegalArgumentException(C1643a.m883w("@Path parameters shouldn't perform path traversal ('.' or '..'): ", strConvert));
            }
            c12568v.f26622e = strReplace;
        }
    }

    /* JADX INFO: renamed from: i0.t$j */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class j<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final String f26601a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC12554h<T, String> f26602b;

        /* JADX INFO: renamed from: c */
        public final boolean f26603c;

        public j(String str, InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f26601a = str;
            this.f26602b = interfaceC12554h;
            this.f26603c = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26602b.convert(t)) == null) {
                return;
            }
            c12568v.m10721d(this.f26601a, strConvert, this.f26603c);
        }
    }

    /* JADX INFO: renamed from: i0.t$k */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class k<T> extends AbstractC12566t<Map<String, T>> {

        /* JADX INFO: renamed from: a */
        public final Method f26604a;

        /* JADX INFO: renamed from: b */
        public final int f26605b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC12554h<T, String> f26606c;

        /* JADX INFO: renamed from: d */
        public final boolean f26607d;

        public k(Method method, int i, InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            this.f26604a = method;
            this.f26605b = i;
            this.f26606c = interfaceC12554h;
            this.f26607d = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw C12503c0.m10692l(this.f26604a, this.f26605b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw C12503c0.m10692l(this.f26604a, this.f26605b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw C12503c0.m10692l(this.f26604a, this.f26605b, C1643a.m886y("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                String strConvert = this.f26606c.convert((T) value);
                if (strConvert == null) {
                    throw C12503c0.m10692l(this.f26604a, this.f26605b, "Query map value '" + value + "' converted to null by " + this.f26606c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                c12568v.m10721d(str, strConvert, this.f26607d);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$l */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class l<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final InterfaceC12554h<T, String> f26608a;

        /* JADX INFO: renamed from: b */
        public final boolean f26609b;

        public l(InterfaceC12554h<T, String> interfaceC12554h, boolean z2) {
            this.f26608a = interfaceC12554h;
            this.f26609b = z2;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) throws IOException {
            if (t == null) {
                return;
            }
            c12568v.m10721d(this.f26608a.convert(t), null, this.f26609b);
        }
    }

    /* JADX INFO: renamed from: i0.t$m */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class m extends AbstractC12566t<MultipartBody.Part> {

        /* JADX INFO: renamed from: a */
        public static final m f26610a = new m();

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                c12568v.f26628k.m10972a(part2);
            }
        }
    }

    /* JADX INFO: renamed from: i0.t$n */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class n extends AbstractC12566t<Object> {

        /* JADX INFO: renamed from: a */
        public final Method f26611a;

        /* JADX INFO: renamed from: b */
        public final int f26612b;

        public n(Method method, int i) {
            this.f26611a = method;
            this.f26612b = i;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, Object obj) {
            if (obj == null) {
                throw C12503c0.m10692l(this.f26611a, this.f26612b, "@Url parameter is null.", new Object[0]);
            }
            Objects.requireNonNull(c12568v);
            c12568v.f26622e = obj.toString();
        }
    }

    /* JADX INFO: renamed from: i0.t$o */
    /* JADX INFO: compiled from: ParameterHandler.java */
    public static final class o<T> extends AbstractC12566t<T> {

        /* JADX INFO: renamed from: a */
        public final Class<T> f26613a;

        public o(Class<T> cls) {
            this.f26613a = cls;
        }

        @Override // p630i0.AbstractC12566t
        /* JADX INFO: renamed from: a */
        public void mo10715a(C12568v c12568v, T t) {
            c12568v.f26624g.m10982e(this.f26613a, t);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo10715a(C12568v c12568v, T t) throws IOException;
}
