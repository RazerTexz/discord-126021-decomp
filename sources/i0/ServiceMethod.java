package i0;

import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import f0.Call2;
import f0.HttpUrl;
import i0.HttpServiceMethod;
import i0.ParameterHandler3;
import i0.RequestFactory;
import i0.Utils8;
import i0.f0.Body;
import i0.f0.DELETE;
import i0.f0.Field;
import i0.f0.FieldMap;
import i0.f0.FormUrlEncoded;
import i0.f0.GET;
import i0.f0.HEAD;
import i0.f0.HTTP;
import i0.f0.Header3;
import i0.f0.HeaderMap;
import i0.f0.Headers2;
import i0.f0.Multipart;
import i0.f0.OPTIONS;
import i0.f0.PATCH;
import i0.f0.POST;
import i0.f0.PUT;
import i0.f0.Part2;
import i0.f0.PartMap;
import i0.f0.Path2;
import i0.f0.Query2;
import i0.f0.QueryMap;
import i0.f0.QueryName;
import i0.f0.Tag2;
import i0.f0.Url;
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
import retrofit2.Response;

/* JADX INFO: renamed from: i0.z, reason: use source file name */
/* JADX INFO: compiled from: ServiceMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ServiceMethod<T> {
    public static <T> ServiceMethod<T> b(Retrofit2 retrofit3, Method method) {
        Type genericReturnType;
        boolean z2;
        int i;
        int i2;
        ParameterHandler3<?> parameterHandler3;
        int i3;
        int i4;
        int i5;
        int i6;
        ParameterHandler3<?> oVar;
        ParameterHandler3<?> gVar;
        ParameterHandler3<?> parameterHandler2;
        ParameterHandler3<?> cVar;
        ParameterHandler3<?> bVar;
        RequestFactory.a aVar = new RequestFactory.a(retrofit3, method);
        for (Annotation annotation : aVar.e) {
            if (annotation instanceof DELETE) {
                aVar.b("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                aVar.b(ShareTarget.METHOD_GET, ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                aVar.b("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                aVar.b("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                aVar.b(ShareTarget.METHOD_POST, ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                aVar.b("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                aVar.b("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                aVar.b(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof Headers2) {
                String[] strArrValue = ((Headers2) annotation).value();
                if (strArrValue.length == 0) {
                    throw Utils8.j(aVar.d, "@Headers annotation is empty.", new Object[0]);
                }
                Headers.a aVar2 = new Headers.a();
                for (String str : strArrValue) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                        throw Utils8.j(aVar.d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                    }
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        try {
                            aVar.v = MediaType.b(strTrim);
                        } catch (IllegalArgumentException e) {
                            throw Utils8.k(aVar.d, e, "Malformed content type: %s", strTrim);
                        }
                    } else {
                        aVar2.a(strSubstring, strTrim);
                    }
                }
                aVar.u = aVar2.c();
            } else if (annotation instanceof Multipart) {
                if (aVar.r) {
                    throw Utils8.j(aVar.d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f3763s = true;
            } else if (!(annotation instanceof FormUrlEncoded)) {
                continue;
            } else {
                if (aVar.f3763s) {
                    throw Utils8.j(aVar.d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.r = true;
            }
        }
        if (aVar.p == null) {
            throw Utils8.j(aVar.d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!aVar.q) {
            if (aVar.f3763s) {
                throw Utils8.j(aVar.d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            if (aVar.r) {
                throw Utils8.j(aVar.d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = aVar.f.length;
        aVar.f3764x = new ParameterHandler3[length];
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < length) {
            ParameterHandler3<?>[] parameterHandler3Arr = aVar.f3764x;
            Type type = aVar.g[i8];
            Annotation[] annotationArr = aVar.f[i8];
            boolean z3 = i8 == i7;
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                parameterHandler3 = null;
                int i9 = 0;
                while (i9 < length2) {
                    Annotation annotation2 = annotationArr[i9];
                    int i10 = length;
                    if (annotation2 instanceof Url) {
                        aVar.c(i8, type);
                        if (aVar.o) {
                            throw Utils8.l(aVar.d, i8, "Multiple @Url method annotations found.", new Object[0]);
                        }
                        if (aVar.k) {
                            throw Utils8.l(aVar.d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        if (aVar.l) {
                            throw Utils8.l(aVar.d, i8, "A @Url parameter must not come after a @Query.", new Object[0]);
                        }
                        if (aVar.m) {
                            throw Utils8.l(aVar.d, i8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        if (aVar.n) {
                            throw Utils8.l(aVar.d, i8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                        }
                        if (aVar.t != null) {
                            throw Utils8.l(aVar.d, i8, "@Url cannot be used with @%s URL", aVar.p);
                        }
                        aVar.o = true;
                        if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                            throw Utils8.l(aVar.d, i8, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                        }
                        oVar = new ParameterHandler3.n(aVar.d, i8);
                        i3 = i7;
                        i4 = i9;
                        i6 = length2;
                    } else {
                        i3 = i7;
                        if (annotation2 instanceof Path2) {
                            aVar.c(i8, type);
                            if (aVar.l) {
                                throw Utils8.l(aVar.d, i8, "A @Path parameter must not come after a @Query.", new Object[0]);
                            }
                            if (aVar.m) {
                                throw Utils8.l(aVar.d, i8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                            }
                            if (aVar.n) {
                                throw Utils8.l(aVar.d, i8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            if (aVar.o) {
                                throw Utils8.l(aVar.d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                            }
                            if (aVar.t == null) {
                                throw Utils8.l(aVar.d, i8, "@Path can only be used with relative url on @%s", aVar.p);
                            }
                            aVar.k = true;
                            Path2 path2 = (Path2) annotation2;
                            String strValue = path2.value();
                            if (!RequestFactory.a.f3762b.matcher(strValue).matches()) {
                                throw Utils8.l(aVar.d, i8, "@Path parameter name must match %s. Found: %s", RequestFactory.a.a.pattern(), strValue);
                            }
                            if (!aVar.w.contains(strValue)) {
                                throw Utils8.l(aVar.d, i8, "URL \"%s\" does not contain \"{%s}\".", aVar.t, strValue);
                            }
                            i4 = i9;
                            i5 = length2;
                            gVar = new ParameterHandler3.i<>(aVar.d, i8, strValue, aVar.c.e(type, annotationArr), path2.encoded());
                        } else {
                            i4 = i9;
                            i5 = length2;
                            if (annotation2 instanceof Query2) {
                                aVar.c(i8, type);
                                Query2 query2 = (Query2) annotation2;
                                String strValue2 = query2.value();
                                boolean zEncoded = query2.encoded();
                                Class<?> clsF = Utils8.f(type);
                                aVar.l = true;
                                if (Iterable.class.isAssignableFrom(clsF)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw Utils8.l(aVar.d, i8, outline.p(clsF, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new ParameterHandler<>(new ParameterHandler3.j(strValue2, aVar.c.e(Utils8.e(0, (ParameterizedType) type), annotationArr), zEncoded));
                                } else if (clsF.isArray()) {
                                    gVar = new ParameterHandler2(new ParameterHandler3.j(strValue2, aVar.c.e(RequestFactory.a.a(clsF.getComponentType()), annotationArr), zEncoded));
                                } else {
                                    bVar = new ParameterHandler3.j<>(strValue2, aVar.c.e(type, annotationArr), zEncoded);
                                    i6 = i5;
                                    oVar = bVar;
                                }
                            } else if (annotation2 instanceof QueryName) {
                                aVar.c(i8, type);
                                boolean zEncoded2 = ((QueryName) annotation2).encoded();
                                Class<?> clsF2 = Utils8.f(type);
                                aVar.m = true;
                                if (Iterable.class.isAssignableFrom(clsF2)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw Utils8.l(aVar.d, i8, outline.p(clsF2, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new ParameterHandler<>(new ParameterHandler3.l(aVar.c.e(Utils8.e(0, (ParameterizedType) type), annotationArr), zEncoded2));
                                } else if (clsF2.isArray()) {
                                    gVar = new ParameterHandler2(new ParameterHandler3.l(aVar.c.e(RequestFactory.a.a(clsF2.getComponentType()), annotationArr), zEncoded2));
                                } else {
                                    cVar = new ParameterHandler3.l<>(aVar.c.e(type, annotationArr), zEncoded2);
                                    i6 = i5;
                                    oVar = cVar;
                                }
                            } else {
                                if (annotation2 instanceof QueryMap) {
                                    aVar.c(i8, type);
                                    Class<?> clsF3 = Utils8.f(type);
                                    aVar.n = true;
                                    if (!Map.class.isAssignableFrom(clsF3)) {
                                        throw Utils8.l(aVar.d, i8, "@QueryMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeG = Utils8.g(type, clsF3, Map.class);
                                    if (!(typeG instanceof ParameterizedType)) {
                                        throw Utils8.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType = (ParameterizedType) typeG;
                                    Type typeE = Utils8.e(0, parameterizedType);
                                    if (String.class != typeE) {
                                        throw Utils8.l(aVar.d, i8, outline.z("@QueryMap keys must be of type String: ", typeE), new Object[0]);
                                    }
                                    cVar = new ParameterHandler3.k<>(aVar.d, i8, aVar.c.e(Utils8.e(1, parameterizedType), annotationArr), ((QueryMap) annotation2).encoded());
                                } else if (annotation2 instanceof Header3) {
                                    aVar.c(i8, type);
                                    String strValue3 = ((Header3) annotation2).value();
                                    Class<?> clsF4 = Utils8.f(type);
                                    if (Iterable.class.isAssignableFrom(clsF4)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw Utils8.l(aVar.d, i8, outline.p(clsF4, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new ParameterHandler<>(new ParameterHandler3.d(strValue3, aVar.c.e(Utils8.e(0, (ParameterizedType) type), annotationArr)));
                                    } else if (clsF4.isArray()) {
                                        gVar = new ParameterHandler2(new ParameterHandler3.d(strValue3, aVar.c.e(RequestFactory.a.a(clsF4.getComponentType()), annotationArr)));
                                    } else {
                                        cVar = new ParameterHandler3.d<>(strValue3, aVar.c.e(type, annotationArr));
                                    }
                                } else if (annotation2 instanceof HeaderMap) {
                                    if (type == Headers.class) {
                                        gVar = new ParameterHandler3.f(aVar.d, i8);
                                    } else {
                                        aVar.c(i8, type);
                                        Class<?> clsF5 = Utils8.f(type);
                                        if (!Map.class.isAssignableFrom(clsF5)) {
                                            throw Utils8.l(aVar.d, i8, "@HeaderMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeG2 = Utils8.g(type, clsF5, Map.class);
                                        if (!(typeG2 instanceof ParameterizedType)) {
                                            throw Utils8.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType2 = (ParameterizedType) typeG2;
                                        Type typeE2 = Utils8.e(0, parameterizedType2);
                                        if (String.class != typeE2) {
                                            throw Utils8.l(aVar.d, i8, outline.z("@HeaderMap keys must be of type String: ", typeE2), new Object[0]);
                                        }
                                        parameterHandler2 = new ParameterHandler3.e<>(aVar.d, i8, aVar.c.e(Utils8.e(1, parameterizedType2), annotationArr));
                                        i6 = i5;
                                        oVar = parameterHandler2;
                                    }
                                } else if (annotation2 instanceof Field) {
                                    aVar.c(i8, type);
                                    if (!aVar.r) {
                                        throw Utils8.l(aVar.d, i8, "@Field parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Field field = (Field) annotation2;
                                    String strValue4 = field.value();
                                    boolean zEncoded3 = field.encoded();
                                    aVar.h = true;
                                    Class<?> clsF6 = Utils8.f(type);
                                    if (Iterable.class.isAssignableFrom(clsF6)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw Utils8.l(aVar.d, i8, outline.p(clsF6, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new ParameterHandler<>(new ParameterHandler3.b(strValue4, aVar.c.e(Utils8.e(0, (ParameterizedType) type), annotationArr), zEncoded3));
                                    } else if (clsF6.isArray()) {
                                        gVar = new ParameterHandler2(new ParameterHandler3.b(strValue4, aVar.c.e(RequestFactory.a.a(clsF6.getComponentType()), annotationArr), zEncoded3));
                                    } else {
                                        bVar = new ParameterHandler3.b<>(strValue4, aVar.c.e(type, annotationArr), zEncoded3);
                                        i6 = i5;
                                        oVar = bVar;
                                    }
                                } else if (annotation2 instanceof FieldMap) {
                                    aVar.c(i8, type);
                                    if (!aVar.r) {
                                        throw Utils8.l(aVar.d, i8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Class<?> clsF7 = Utils8.f(type);
                                    if (!Map.class.isAssignableFrom(clsF7)) {
                                        throw Utils8.l(aVar.d, i8, "@FieldMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeG3 = Utils8.g(type, clsF7, Map.class);
                                    if (!(typeG3 instanceof ParameterizedType)) {
                                        throw Utils8.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType3 = (ParameterizedType) typeG3;
                                    Type typeE3 = Utils8.e(0, parameterizedType3);
                                    if (String.class != typeE3) {
                                        throw Utils8.l(aVar.d, i8, outline.z("@FieldMap keys must be of type String: ", typeE3), new Object[0]);
                                    }
                                    Converter2<T, String> converter2E = aVar.c.e(Utils8.e(1, parameterizedType3), annotationArr);
                                    aVar.h = true;
                                    cVar = new ParameterHandler3.c<>(aVar.d, i8, converter2E, ((FieldMap) annotation2).encoded());
                                } else if (annotation2 instanceof Part2) {
                                    aVar.c(i8, type);
                                    if (!aVar.f3763s) {
                                        throw Utils8.l(aVar.d, i8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                    }
                                    Part2 part2 = (Part2) annotation2;
                                    aVar.i = true;
                                    String strValue5 = part2.value();
                                    Class<?> clsF8 = Utils8.f(type);
                                    if (strValue5.isEmpty()) {
                                        if (Iterable.class.isAssignableFrom(clsF8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw Utils8.l(aVar.d, i8, outline.p(clsF8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            if (!MultipartBody.Part.class.isAssignableFrom(Utils8.f(Utils8.e(0, (ParameterizedType) type)))) {
                                                throw Utils8.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            parameterHandler2 = new ParameterHandler<>(ParameterHandler3.m.a);
                                        } else if (clsF8.isArray()) {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsF8.getComponentType())) {
                                                throw Utils8.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            parameterHandler2 = new ParameterHandler2(ParameterHandler3.m.a);
                                        } else {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsF8)) {
                                                throw Utils8.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            gVar = ParameterHandler3.m.a;
                                        }
                                        i6 = i5;
                                        oVar = parameterHandler2;
                                    } else {
                                        i6 = i5;
                                        Headers headersC = Headers.INSTANCE.c("Content-Disposition", outline.y("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", part2.encoding());
                                        if (Iterable.class.isAssignableFrom(clsF8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw Utils8.l(aVar.d, i8, outline.p(clsF8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            Type typeE4 = Utils8.e(0, (ParameterizedType) type);
                                            if (MultipartBody.Part.class.isAssignableFrom(Utils8.f(typeE4))) {
                                                throw Utils8.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new ParameterHandler<>(new ParameterHandler3.g(aVar.d, i8, headersC, aVar.c.c(typeE4, annotationArr, aVar.e)));
                                        } else if (clsF8.isArray()) {
                                            Class<?> clsA = RequestFactory.a.a(clsF8.getComponentType());
                                            if (MultipartBody.Part.class.isAssignableFrom(clsA)) {
                                                throw Utils8.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new ParameterHandler2(new ParameterHandler3.g(aVar.d, i8, headersC, aVar.c.c(clsA, annotationArr, aVar.e)));
                                        } else {
                                            if (MultipartBody.Part.class.isAssignableFrom(clsF8)) {
                                                throw Utils8.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            gVar = new ParameterHandler3.g<>(aVar.d, i8, headersC, aVar.c.c(type, annotationArr, aVar.e));
                                            oVar = gVar;
                                        }
                                    }
                                } else {
                                    i6 = i5;
                                    if (annotation2 instanceof PartMap) {
                                        aVar.c(i8, type);
                                        if (!aVar.f3763s) {
                                            throw Utils8.l(aVar.d, i8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                        }
                                        aVar.i = true;
                                        Class<?> clsF9 = Utils8.f(type);
                                        if (!Map.class.isAssignableFrom(clsF9)) {
                                            throw Utils8.l(aVar.d, i8, "@PartMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeG4 = Utils8.g(type, clsF9, Map.class);
                                        if (!(typeG4 instanceof ParameterizedType)) {
                                            throw Utils8.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType4 = (ParameterizedType) typeG4;
                                        Type typeE5 = Utils8.e(0, parameterizedType4);
                                        if (String.class != typeE5) {
                                            throw Utils8.l(aVar.d, i8, outline.z("@PartMap keys must be of type String: ", typeE5), new Object[0]);
                                        }
                                        Type typeE6 = Utils8.e(1, parameterizedType4);
                                        if (MultipartBody.Part.class.isAssignableFrom(Utils8.f(typeE6))) {
                                            throw Utils8.l(aVar.d, i8, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                        }
                                        oVar = new ParameterHandler3.h<>(aVar.d, i8, aVar.c.c(typeE6, annotationArr, aVar.e), ((PartMap) annotation2).encoding());
                                    } else if (annotation2 instanceof Body) {
                                        aVar.c(i8, type);
                                        if (aVar.r || aVar.f3763s) {
                                            throw Utils8.l(aVar.d, i8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                        }
                                        if (aVar.j) {
                                            throw Utils8.l(aVar.d, i8, "Multiple @Body method annotations found.", new Object[0]);
                                        }
                                        try {
                                            Converter2<T, RequestBody> converter2C = aVar.c.c(type, annotationArr, aVar.e);
                                            aVar.j = true;
                                            oVar = new ParameterHandler3.a<>(aVar.d, i8, converter2C);
                                        } catch (RuntimeException e2) {
                                            throw Utils8.m(aVar.d, e2, i8, "Unable to create @Body converter for %s", type);
                                        }
                                    } else if (annotation2 instanceof Tag2) {
                                        aVar.c(i8, type);
                                        Class<?> clsF10 = Utils8.f(type);
                                        for (int i11 = i8 - 1; i11 >= 0; i11--) {
                                            ParameterHandler3<?> parameterHandler4 = aVar.f3764x[i11];
                                            if ((parameterHandler4 instanceof ParameterHandler3.o) && ((ParameterHandler3.o) parameterHandler4).a.equals(clsF10)) {
                                                Method method2 = aVar.d;
                                                StringBuilder sbU = outline.U("@Tag type ");
                                                sbU.append(clsF10.getName());
                                                sbU.append(" is duplicate of parameter #");
                                                sbU.append(i11 + 1);
                                                sbU.append(" and would always overwrite its value.");
                                                throw Utils8.l(method2, i8, sbU.toString(), new Object[0]);
                                            }
                                        }
                                        oVar = new ParameterHandler3.o<>(clsF10);
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
                        if (parameterHandler3 != null) {
                            throw Utils8.l(aVar.d, i8, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        parameterHandler3 = oVar;
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
                parameterHandler3 = null;
            }
            if (parameterHandler3 == null) {
                if (z3) {
                    try {
                        if (Utils8.f(type) == Continuation.class) {
                            aVar.f3765y = true;
                            parameterHandler3 = null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw Utils8.l(aVar.d, i8, "No Retrofit annotation found.", new Object[0]);
            }
            parameterHandler3Arr[i8] = parameterHandler3;
            i8++;
            length = i;
            i7 = i2;
        }
        if (aVar.t == null && !aVar.o) {
            throw Utils8.j(aVar.d, "Missing either @%s URL or @Url parameter.", aVar.p);
        }
        boolean z4 = aVar.r;
        if (!z4 && !aVar.f3763s && !aVar.q && aVar.j) {
            throw Utils8.j(aVar.d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if (z4 && !aVar.h) {
            throw Utils8.j(aVar.d, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if (aVar.f3763s && !aVar.i) {
            throw Utils8.j(aVar.d, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        RequestFactory requestFactory = new RequestFactory(aVar);
        Type genericReturnType2 = method.getGenericReturnType();
        if (Utils8.h(genericReturnType2)) {
            throw Utils8.j(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
        }
        if (genericReturnType2 == Void.TYPE) {
            throw Utils8.j(method, "Service methods cannot return void.", new Object[0]);
        }
        boolean z5 = requestFactory.k;
        Annotation[] annotations = method.getAnnotations();
        if (z5) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeE7 = ((ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]).getActualTypeArguments()[0];
            if (typeE7 instanceof WildcardType) {
                typeE7 = ((WildcardType) typeE7).getLowerBounds()[0];
            }
            if (Utils8.f(typeE7) == Response.class && (typeE7 instanceof ParameterizedType)) {
                typeE7 = Utils8.e(0, (ParameterizedType) typeE7);
                z2 = true;
            } else {
                z2 = false;
            }
            genericReturnType = new Utils8.b(null, Call3.class, typeE7);
            if (!Utils8.i(annotations, SkipCallbackExecutor.class)) {
                Annotation[] annotationArr2 = new Annotation[annotations.length + 1];
                annotationArr2[0] = SkipCallbackExecutorImpl.a;
                System.arraycopy(annotations, 0, annotationArr2, 1, annotations.length);
                annotations = annotationArr2;
            }
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
        }
        try {
            CallAdapter<?, ?> callAdapterA = retrofit3.a(genericReturnType, annotations);
            Type typeA = callAdapterA.a();
            if (typeA == okhttp3.Response.class) {
                StringBuilder sbU2 = outline.U("'");
                sbU2.append(Utils8.f(typeA).getName());
                sbU2.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw Utils8.j(method, sbU2.toString(), new Object[0]);
            }
            if (typeA == Response.class) {
                throw Utils8.j(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
            }
            if (requestFactory.c.equals("HEAD") && !Void.class.equals(typeA)) {
                throw Utils8.j(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            try {
                Converter2<ResponseBody, T> converter2D = retrofit3.d(typeA, method.getAnnotations());
                Call2.a aVar3 = retrofit3.f3767b;
                if (z5) {
                    return z2 ? new HttpServiceMethod.c(requestFactory, aVar3, converter2D, callAdapterA) : new HttpServiceMethod.b(requestFactory, aVar3, converter2D, callAdapterA, false);
                }
                return new HttpServiceMethod.a(requestFactory, aVar3, converter2D, callAdapterA);
            } catch (RuntimeException e3) {
                throw Utils8.k(method, e3, "Unable to create converter for %s", typeA);
            }
        } catch (RuntimeException e4) {
            throw Utils8.k(method, e4, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    public abstract T a(Object[] objArr);
}
