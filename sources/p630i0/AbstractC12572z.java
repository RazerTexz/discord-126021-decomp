package p630i0;

import androidx.browser.trusted.sharing.ShareTarget;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.util.Map;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p600f0.C12379w;
import p600f0.InterfaceC12269e;
import p630i0.p636f0.InterfaceC12528a;
import p630i0.p636f0.InterfaceC12529b;
import p630i0.p636f0.InterfaceC12530c;
import p630i0.p636f0.InterfaceC12531d;
import p630i0.p636f0.InterfaceC12532e;
import p630i0.p636f0.InterfaceC12533f;
import p630i0.p636f0.InterfaceC12534g;
import p630i0.p636f0.InterfaceC12535h;
import p630i0.p636f0.InterfaceC12536i;
import p630i0.p636f0.InterfaceC12537j;
import p630i0.p636f0.InterfaceC12538k;
import p630i0.p636f0.InterfaceC12539l;
import p630i0.p636f0.InterfaceC12540m;
import p630i0.p636f0.InterfaceC12541n;
import p630i0.p636f0.InterfaceC12542o;
import p630i0.p636f0.InterfaceC12543p;
import p630i0.p636f0.InterfaceC12544q;
import p630i0.p636f0.InterfaceC12545r;
import p630i0.p636f0.InterfaceC12546s;
import p630i0.p636f0.InterfaceC12547t;
import p630i0.p636f0.InterfaceC12548u;
import p630i0.p636f0.InterfaceC12549v;
import p630i0.p636f0.InterfaceC12551x;
import p630i0.p636f0.InterfaceC12552y;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.z */
/* JADX INFO: compiled from: ServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12572z<T> {
    /* JADX INFO: renamed from: b */
    public static <T> AbstractC12572z<T> m10730b(C12571y c12571y, Method method) {
        Type genericReturnType;
        boolean z2;
        int i;
        int i2;
        AbstractC12566t<?> abstractC12566t;
        int i3;
        int i4;
        int i5;
        int i6;
        AbstractC12566t<?> oVar;
        AbstractC12566t<?> gVar;
        AbstractC12566t<?> c12565s;
        AbstractC12566t<?> cVar;
        AbstractC12566t<?> bVar;
        C12569w.a aVar = new C12569w.a(c12571y, method);
        for (Annotation annotation : aVar.f26648e) {
            if (annotation instanceof InterfaceC12529b) {
                aVar.m10723b("DELETE", ((InterfaceC12529b) annotation).value(), false);
            } else if (annotation instanceof InterfaceC12533f) {
                aVar.m10723b(ShareTarget.METHOD_GET, ((InterfaceC12533f) annotation).value(), false);
            } else if (annotation instanceof InterfaceC12534g) {
                aVar.m10723b("HEAD", ((InterfaceC12534g) annotation).value(), false);
            } else if (annotation instanceof InterfaceC12541n) {
                aVar.m10723b("PATCH", ((InterfaceC12541n) annotation).value(), true);
            } else if (annotation instanceof InterfaceC12542o) {
                aVar.m10723b(ShareTarget.METHOD_POST, ((InterfaceC12542o) annotation).value(), true);
            } else if (annotation instanceof InterfaceC12543p) {
                aVar.m10723b("PUT", ((InterfaceC12543p) annotation).value(), true);
            } else if (annotation instanceof InterfaceC12540m) {
                aVar.m10723b("OPTIONS", ((InterfaceC12540m) annotation).value(), false);
            } else if (annotation instanceof InterfaceC12535h) {
                InterfaceC12535h interfaceC12535h = (InterfaceC12535h) annotation;
                aVar.m10723b(interfaceC12535h.method(), interfaceC12535h.path(), interfaceC12535h.hasBody());
            } else if (annotation instanceof InterfaceC12538k) {
                String[] strArrValue = ((InterfaceC12538k) annotation).value();
                if (strArrValue.length == 0) {
                    throw C12503c0.m10690j(aVar.f26647d, "@Headers annotation is empty.", new Object[0]);
                }
                Headers.C12930a c12930a = new Headers.C12930a();
                for (String str : strArrValue) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                        throw C12503c0.m10690j(aVar.f26647d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                    }
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        try {
                            aVar.f26665v = MediaType.m10965b(strTrim);
                        } catch (IllegalArgumentException e) {
                            throw C12503c0.m10691k(aVar.f26647d, e, "Malformed content type: %s", strTrim);
                        }
                    } else {
                        c12930a.m10958a(strSubstring, strTrim);
                    }
                }
                aVar.f26664u = c12930a.m10960c();
            } else if (annotation instanceof InterfaceC12539l) {
                if (aVar.f26661r) {
                    throw C12503c0.m10690j(aVar.f26647d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f26662s = true;
            } else if (!(annotation instanceof InterfaceC12532e)) {
                continue;
            } else {
                if (aVar.f26662s) {
                    throw C12503c0.m10690j(aVar.f26647d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f26661r = true;
            }
        }
        if (aVar.f26659p == null) {
            throw C12503c0.m10690j(aVar.f26647d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!aVar.f26660q) {
            if (aVar.f26662s) {
                throw C12503c0.m10690j(aVar.f26647d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            if (aVar.f26661r) {
                throw C12503c0.m10690j(aVar.f26647d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = aVar.f26649f.length;
        aVar.f26667x = new AbstractC12566t[length];
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < length) {
            AbstractC12566t<?>[] abstractC12566tArr = aVar.f26667x;
            Type type = aVar.f26650g[i8];
            Annotation[] annotationArr = aVar.f26649f[i8];
            boolean z3 = i8 == i7;
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                abstractC12566t = null;
                int i9 = 0;
                while (i9 < length2) {
                    Annotation annotation2 = annotationArr[i9];
                    int i10 = length;
                    if (annotation2 instanceof InterfaceC12552y) {
                        aVar.m10724c(i8, type);
                        if (aVar.f26658o) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "Multiple @Url method annotations found.", new Object[0]);
                        }
                        if (aVar.f26654k) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        if (aVar.f26655l) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @Query.", new Object[0]);
                        }
                        if (aVar.f26656m) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        if (aVar.f26657n) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                        }
                        if (aVar.f26663t != null) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "@Url cannot be used with @%s URL", aVar.f26659p);
                        }
                        aVar.f26658o = true;
                        if (type != C12379w.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                        }
                        oVar = new AbstractC12566t.n(aVar.f26647d, i8);
                        i3 = i7;
                        i4 = i9;
                        i6 = length2;
                    } else {
                        i3 = i7;
                        if (annotation2 instanceof InterfaceC12546s) {
                            aVar.m10724c(i8, type);
                            if (aVar.f26655l) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @Query.", new Object[0]);
                            }
                            if (aVar.f26656m) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                            }
                            if (aVar.f26657n) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            if (aVar.f26658o) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                            }
                            if (aVar.f26663t == null) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Path can only be used with relative url on @%s", aVar.f26659p);
                            }
                            aVar.f26654k = true;
                            InterfaceC12546s interfaceC12546s = (InterfaceC12546s) annotation2;
                            String strValue = interfaceC12546s.value();
                            if (!C12569w.a.f26645b.matcher(strValue).matches()) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Path parameter name must match %s. Found: %s", C12569w.a.f26644a.pattern(), strValue);
                            }
                            if (!aVar.f26666w.contains(strValue)) {
                                throw C12503c0.m10692l(aVar.f26647d, i8, "URL \"%s\" does not contain \"{%s}\".", aVar.f26663t, strValue);
                            }
                            i4 = i9;
                            i5 = length2;
                            gVar = new AbstractC12566t.i<>(aVar.f26647d, i8, strValue, aVar.f26646c.m10729e(type, annotationArr), interfaceC12546s.encoded());
                        } else {
                            i4 = i9;
                            i5 = length2;
                            if (annotation2 instanceof InterfaceC12547t) {
                                aVar.m10724c(i8, type);
                                InterfaceC12547t interfaceC12547t = (InterfaceC12547t) annotation2;
                                String strValue2 = interfaceC12547t.value();
                                boolean zEncoded = interfaceC12547t.encoded();
                                Class<?> clsM10686f = C12503c0.m10686f(type);
                                aVar.f26655l = true;
                                if (Iterable.class.isAssignableFrom(clsM10686f)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new C12564r<>(new AbstractC12566t.j(strValue2, aVar.f26646c.m10729e(C12503c0.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded));
                                } else if (clsM10686f.isArray()) {
                                    gVar = new C12565s(new AbstractC12566t.j(strValue2, aVar.f26646c.m10729e(C12569w.a.m10722a(clsM10686f.getComponentType()), annotationArr), zEncoded));
                                } else {
                                    bVar = new AbstractC12566t.j<>(strValue2, aVar.f26646c.m10729e(type, annotationArr), zEncoded);
                                    i6 = i5;
                                    oVar = bVar;
                                }
                            } else if (annotation2 instanceof InterfaceC12549v) {
                                aVar.m10724c(i8, type);
                                boolean zEncoded2 = ((InterfaceC12549v) annotation2).encoded();
                                Class<?> clsM10686f2 = C12503c0.m10686f(type);
                                aVar.f26656m = true;
                                if (Iterable.class.isAssignableFrom(clsM10686f2)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f2, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new C12564r<>(new AbstractC12566t.l(aVar.f26646c.m10729e(C12503c0.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded2));
                                } else if (clsM10686f2.isArray()) {
                                    gVar = new C12565s(new AbstractC12566t.l(aVar.f26646c.m10729e(C12569w.a.m10722a(clsM10686f2.getComponentType()), annotationArr), zEncoded2));
                                } else {
                                    cVar = new AbstractC12566t.l<>(aVar.f26646c.m10729e(type, annotationArr), zEncoded2);
                                    i6 = i5;
                                    oVar = cVar;
                                }
                            } else {
                                if (annotation2 instanceof InterfaceC12548u) {
                                    aVar.m10724c(i8, type);
                                    Class<?> clsM10686f3 = C12503c0.m10686f(type);
                                    aVar.f26657n = true;
                                    if (!Map.class.isAssignableFrom(clsM10686f3)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "@QueryMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeM10687g = C12503c0.m10687g(type, clsM10686f3, Map.class);
                                    if (!(typeM10687g instanceof ParameterizedType)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType = (ParameterizedType) typeM10687g;
                                    Type typeM10685e = C12503c0.m10685e(0, parameterizedType);
                                    if (String.class != typeM10685e) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m887z("@QueryMap keys must be of type String: ", typeM10685e), new Object[0]);
                                    }
                                    cVar = new AbstractC12566t.k<>(aVar.f26647d, i8, aVar.f26646c.m10729e(C12503c0.m10685e(1, parameterizedType), annotationArr), ((InterfaceC12548u) annotation2).encoded());
                                } else if (annotation2 instanceof InterfaceC12536i) {
                                    aVar.m10724c(i8, type);
                                    String strValue3 = ((InterfaceC12536i) annotation2).value();
                                    Class<?> clsM10686f4 = C12503c0.m10686f(type);
                                    if (Iterable.class.isAssignableFrom(clsM10686f4)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f4, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new C12564r<>(new AbstractC12566t.d(strValue3, aVar.f26646c.m10729e(C12503c0.m10685e(0, (ParameterizedType) type), annotationArr)));
                                    } else if (clsM10686f4.isArray()) {
                                        gVar = new C12565s(new AbstractC12566t.d(strValue3, aVar.f26646c.m10729e(C12569w.a.m10722a(clsM10686f4.getComponentType()), annotationArr)));
                                    } else {
                                        cVar = new AbstractC12566t.d<>(strValue3, aVar.f26646c.m10729e(type, annotationArr));
                                    }
                                } else if (annotation2 instanceof InterfaceC12537j) {
                                    if (type == Headers.class) {
                                        gVar = new AbstractC12566t.f(aVar.f26647d, i8);
                                    } else {
                                        aVar.m10724c(i8, type);
                                        Class<?> clsM10686f5 = C12503c0.m10686f(type);
                                        if (!Map.class.isAssignableFrom(clsM10686f5)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "@HeaderMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeM10687g2 = C12503c0.m10687g(type, clsM10686f5, Map.class);
                                        if (!(typeM10687g2 instanceof ParameterizedType)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType2 = (ParameterizedType) typeM10687g2;
                                        Type typeM10685e2 = C12503c0.m10685e(0, parameterizedType2);
                                        if (String.class != typeM10685e2) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m887z("@HeaderMap keys must be of type String: ", typeM10685e2), new Object[0]);
                                        }
                                        c12565s = new AbstractC12566t.e<>(aVar.f26647d, i8, aVar.f26646c.m10729e(C12503c0.m10685e(1, parameterizedType2), annotationArr));
                                        i6 = i5;
                                        oVar = c12565s;
                                    }
                                } else if (annotation2 instanceof InterfaceC12530c) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26661r) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "@Field parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    InterfaceC12530c interfaceC12530c = (InterfaceC12530c) annotation2;
                                    String strValue4 = interfaceC12530c.value();
                                    boolean zEncoded3 = interfaceC12530c.encoded();
                                    aVar.f26651h = true;
                                    Class<?> clsM10686f6 = C12503c0.m10686f(type);
                                    if (Iterable.class.isAssignableFrom(clsM10686f6)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f6, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new C12564r<>(new AbstractC12566t.b(strValue4, aVar.f26646c.m10729e(C12503c0.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded3));
                                    } else if (clsM10686f6.isArray()) {
                                        gVar = new C12565s(new AbstractC12566t.b(strValue4, aVar.f26646c.m10729e(C12569w.a.m10722a(clsM10686f6.getComponentType()), annotationArr), zEncoded3));
                                    } else {
                                        bVar = new AbstractC12566t.b<>(strValue4, aVar.f26646c.m10729e(type, annotationArr), zEncoded3);
                                        i6 = i5;
                                        oVar = bVar;
                                    }
                                } else if (annotation2 instanceof InterfaceC12531d) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26661r) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Class<?> clsM10686f7 = C12503c0.m10686f(type);
                                    if (!Map.class.isAssignableFrom(clsM10686f7)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "@FieldMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeM10687g3 = C12503c0.m10687g(type, clsM10686f7, Map.class);
                                    if (!(typeM10687g3 instanceof ParameterizedType)) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType3 = (ParameterizedType) typeM10687g3;
                                    Type typeM10685e3 = C12503c0.m10685e(0, parameterizedType3);
                                    if (String.class != typeM10685e3) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m887z("@FieldMap keys must be of type String: ", typeM10685e3), new Object[0]);
                                    }
                                    InterfaceC12554h<T, String> interfaceC12554hM10729e = aVar.f26646c.m10729e(C12503c0.m10685e(1, parameterizedType3), annotationArr);
                                    aVar.f26651h = true;
                                    cVar = new AbstractC12566t.c<>(aVar.f26647d, i8, interfaceC12554hM10729e, ((InterfaceC12531d) annotation2).encoded());
                                } else if (annotation2 instanceof InterfaceC12544q) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26662s) {
                                        throw C12503c0.m10692l(aVar.f26647d, i8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                    }
                                    InterfaceC12544q interfaceC12544q = (InterfaceC12544q) annotation2;
                                    aVar.f26652i = true;
                                    String strValue5 = interfaceC12544q.value();
                                    Class<?> clsM10686f8 = C12503c0.m10686f(type);
                                    if (strValue5.isEmpty()) {
                                        if (Iterable.class.isAssignableFrom(clsM10686f8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            if (!MultipartBody.Part.class.isAssignableFrom(C12503c0.m10686f(C12503c0.m10685e(0, (ParameterizedType) type)))) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            c12565s = new C12564r<>(AbstractC12566t.m.f26610a);
                                        } else if (clsM10686f8.isArray()) {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsM10686f8.getComponentType())) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            c12565s = new C12565s(AbstractC12566t.m.f26610a);
                                        } else {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsM10686f8)) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            gVar = AbstractC12566t.m.f26610a;
                                        }
                                        i6 = i5;
                                        oVar = c12565s;
                                    } else {
                                        i6 = i5;
                                        Headers headersM10964c = Headers.INSTANCE.m10964c("Content-Disposition", C1643a.m886y("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", interfaceC12544q.encoding());
                                        if (Iterable.class.isAssignableFrom(clsM10686f8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m869p(clsM10686f8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            Type typeM10685e4 = C12503c0.m10685e(0, (ParameterizedType) type);
                                            if (MultipartBody.Part.class.isAssignableFrom(C12503c0.m10686f(typeM10685e4))) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new C12564r<>(new AbstractC12566t.g(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(typeM10685e4, annotationArr, aVar.f26648e)));
                                        } else if (clsM10686f8.isArray()) {
                                            Class<?> clsM10722a = C12569w.a.m10722a(clsM10686f8.getComponentType());
                                            if (MultipartBody.Part.class.isAssignableFrom(clsM10722a)) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new C12565s(new AbstractC12566t.g(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(clsM10722a, annotationArr, aVar.f26648e)));
                                        } else {
                                            if (MultipartBody.Part.class.isAssignableFrom(clsM10686f8)) {
                                                throw C12503c0.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            gVar = new AbstractC12566t.g<>(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(type, annotationArr, aVar.f26648e));
                                            oVar = gVar;
                                        }
                                    }
                                } else {
                                    i6 = i5;
                                    if (annotation2 instanceof InterfaceC12545r) {
                                        aVar.m10724c(i8, type);
                                        if (!aVar.f26662s) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                        }
                                        aVar.f26652i = true;
                                        Class<?> clsM10686f9 = C12503c0.m10686f(type);
                                        if (!Map.class.isAssignableFrom(clsM10686f9)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "@PartMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeM10687g4 = C12503c0.m10687g(type, clsM10686f9, Map.class);
                                        if (!(typeM10687g4 instanceof ParameterizedType)) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType4 = (ParameterizedType) typeM10687g4;
                                        Type typeM10685e5 = C12503c0.m10685e(0, parameterizedType4);
                                        if (String.class != typeM10685e5) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, C1643a.m887z("@PartMap keys must be of type String: ", typeM10685e5), new Object[0]);
                                        }
                                        Type typeM10685e6 = C12503c0.m10685e(1, parameterizedType4);
                                        if (MultipartBody.Part.class.isAssignableFrom(C12503c0.m10686f(typeM10685e6))) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                        }
                                        oVar = new AbstractC12566t.h<>(aVar.f26647d, i8, aVar.f26646c.m10727c(typeM10685e6, annotationArr, aVar.f26648e), ((InterfaceC12545r) annotation2).encoding());
                                    } else if (annotation2 instanceof InterfaceC12528a) {
                                        aVar.m10724c(i8, type);
                                        if (aVar.f26661r || aVar.f26662s) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                        }
                                        if (aVar.f26653j) {
                                            throw C12503c0.m10692l(aVar.f26647d, i8, "Multiple @Body method annotations found.", new Object[0]);
                                        }
                                        try {
                                            InterfaceC12554h<T, RequestBody> interfaceC12554hM10727c = aVar.f26646c.m10727c(type, annotationArr, aVar.f26648e);
                                            aVar.f26653j = true;
                                            oVar = new AbstractC12566t.a<>(aVar.f26647d, i8, interfaceC12554hM10727c);
                                        } catch (RuntimeException e2) {
                                            throw C12503c0.m10693m(aVar.f26647d, e2, i8, "Unable to create @Body converter for %s", type);
                                        }
                                    } else if (annotation2 instanceof InterfaceC12551x) {
                                        aVar.m10724c(i8, type);
                                        Class<?> clsM10686f10 = C12503c0.m10686f(type);
                                        for (int i11 = i8 - 1; i11 >= 0; i11--) {
                                            AbstractC12566t<?> abstractC12566t2 = aVar.f26667x[i11];
                                            if ((abstractC12566t2 instanceof AbstractC12566t.o) && ((AbstractC12566t.o) abstractC12566t2).f26613a.equals(clsM10686f10)) {
                                                Method method2 = aVar.f26647d;
                                                StringBuilder sbM833U = C1643a.m833U("@Tag type ");
                                                sbM833U.append(clsM10686f10.getName());
                                                sbM833U.append(" is duplicate of parameter #");
                                                sbM833U.append(i11 + 1);
                                                sbM833U.append(" and would always overwrite its value.");
                                                throw C12503c0.m10692l(method2, i8, sbM833U.toString(), new Object[0]);
                                            }
                                        }
                                        oVar = new AbstractC12566t.o<>(clsM10686f10);
                                    } else {
                                        oVar = null;
                                    }
                                }
                                i6 = i5;
                                oVar = cVar;
                            }
                        }
                        i6 = i5;
                        oVar = gVar;
                    }
                    if (oVar != null) {
                        if (abstractC12566t != null) {
                            throw C12503c0.m10692l(aVar.f26647d, i8, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        abstractC12566t = oVar;
                    }
                    i9 = i4 + 1;
                    length = i10;
                    i7 = i3;
                    length2 = i6;
                }
                i = length;
                i2 = i7;
            } else {
                i = length;
                i2 = i7;
                abstractC12566t = null;
            }
            if (abstractC12566t == null) {
                if (z3) {
                    try {
                        if (C12503c0.m10686f(type) == Continuation.class) {
                            aVar.f26668y = true;
                            abstractC12566t = null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw C12503c0.m10692l(aVar.f26647d, i8, "No Retrofit annotation found.", new Object[0]);
            }
            abstractC12566tArr[i8] = abstractC12566t;
            i8++;
            length = i;
            i7 = i2;
        }
        if (aVar.f26663t == null && !aVar.f26658o) {
            throw C12503c0.m10690j(aVar.f26647d, "Missing either @%s URL or @Url parameter.", aVar.f26659p);
        }
        boolean z4 = aVar.f26661r;
        if (!z4 && !aVar.f26662s && !aVar.f26660q && aVar.f26653j) {
            throw C12503c0.m10690j(aVar.f26647d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if (z4 && !aVar.f26651h) {
            throw C12503c0.m10690j(aVar.f26647d, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if (aVar.f26662s && !aVar.f26652i) {
            throw C12503c0.m10690j(aVar.f26647d, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        C12569w c12569w = new C12569w(aVar);
        Type genericReturnType2 = method.getGenericReturnType();
        if (C12503c0.m10688h(genericReturnType2)) {
            throw C12503c0.m10690j(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
        }
        if (genericReturnType2 == Void.TYPE) {
            throw C12503c0.m10690j(method, "Service methods cannot return void.", new Object[0]);
        }
        boolean z5 = c12569w.f26643k;
        Annotation[] annotations = method.getAnnotations();
        if (z5) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeM10685e7 = ((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]).getActualTypeArguments()[0];
            if (typeM10685e7 instanceof WildcardType) {
                typeM10685e7 = ((WildcardType) typeM10685e7).getLowerBounds()[0];
            }
            if (C12503c0.m10686f(typeM10685e7) == Response.class && (typeM10685e7 instanceof ParameterizedType)) {
                typeM10685e7 = C12503c0.m10685e(0, (ParameterizedType) typeM10685e7);
                z2 = true;
            } else {
                z2 = false;
            }
            genericReturnType = new C12503c0.b(null, InterfaceC12504d.class, typeM10685e7);
            if (!C12503c0.m10689i(annotations, InterfaceC12499a0.class)) {
                Annotation[] annotationArr2 = new Annotation[annotations.length + 1];
                annotationArr2[0] = C12501b0.f26482a;
                System.arraycopy(annotations, 0, annotationArr2, 1, annotations.length);
                annotations = annotationArr2;
            }
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
        }
        try {
            InterfaceC12512e<?, ?> interfaceC12512eM10725a = c12571y.m10725a(genericReturnType, annotations);
            Type typeMo10705a = interfaceC12512eM10725a.mo10705a();
            if (typeMo10705a == okhttp3.Response.class) {
                StringBuilder sbM833U2 = C1643a.m833U("'");
                sbM833U2.append(C12503c0.m10686f(typeMo10705a).getName());
                sbM833U2.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw C12503c0.m10690j(method, sbM833U2.toString(), new Object[0]);
            }
            if (typeMo10705a == Response.class) {
                throw C12503c0.m10690j(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
            }
            if (c12569w.f26635c.equals("HEAD") && !Void.class.equals(typeMo10705a)) {
                throw C12503c0.m10690j(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            try {
                InterfaceC12554h<ResponseBody, T> interfaceC12554hM10728d = c12571y.m10728d(typeMo10705a, method.getAnnotations());
                InterfaceC12269e.a aVar2 = c12571y.f26674b;
                if (z5) {
                    return z2 ? new AbstractC12556j.c(c12569w, aVar2, interfaceC12554hM10728d, interfaceC12512eM10725a) : new AbstractC12556j.b(c12569w, aVar2, interfaceC12554hM10728d, interfaceC12512eM10725a, false);
                }
                return new AbstractC12556j.a(c12569w, aVar2, interfaceC12554hM10728d, interfaceC12512eM10725a);
            } catch (RuntimeException e3) {
                throw C12503c0.m10691k(method, e3, "Unable to create converter for %s", typeMo10705a);
            }
        } catch (RuntimeException e4) {
            throw C12503c0.m10691k(method, e4, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract T mo10710a(Object[] objArr);
}
