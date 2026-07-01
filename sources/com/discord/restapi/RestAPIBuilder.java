package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import b.a.b.a;
import b.i.d.c;
import b.i.d.e;
import com.discord.models.domain.Model$TypeAdapterFactory;
import com.discord.models.experiments.dto.UserExperimentDto$TypeAdapterFactory;
import com.google.gson.Gson;
import d0.z.d.m;
import f0.p;
import f0.w;
import f0.w$a;
import f0.x;
import f0.x$a;
import i0.d0.a.g;
import i0.e0.b.k;
import i0.i;
import i0.q;
import i0.u;
import i0.y;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder {
    private static final int API_VERSION = 9;
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    private static final long DEFAULT_TIMEOUT_MILLIS = 10000;
    private final String baseApiUrl;
    private final p cookieJar;
    public static final RestAPIBuilder$Companion Companion = new RestAPIBuilder$Companion(null);
    private static Function2<? super String, ? super x, Unit> clientCallback = RestAPIBuilder$Companion$clientCallback$1.INSTANCE;

    public RestAPIBuilder(String str, p pVar) {
        m.checkNotNullParameter(str, "baseApiUrl");
        m.checkNotNullParameter(pVar, "cookieJar");
        this.baseApiUrl = str;
        this.cookieJar = pVar;
    }

    public static final /* synthetic */ Function2 access$getClientCallback$cp() {
        return clientCallback;
    }

    public static final /* synthetic */ void access$setClientCallback$cp(Function2 function2) {
        clientCallback = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object build$default(RestAPIBuilder restAPIBuilder, Class cls, boolean z2, long j, List list, String str, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.build(cls, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 10000L : j, (i & 8) != 0 ? null : list, (i & 16) == 0 ? str : null, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? CONTENT_TYPE_JSON : str2);
    }

    private final <T> T buildApi(x client, Class<T> api, String baseApiUrl, boolean serializeNulls, boolean addVersion, String contentType) {
        e eVar = new e();
        eVar.c = c.m;
        m.checkNotNullExpressionValue(eVar, "GsonBuilder()\n        .s…ER_CASE_WITH_UNDERSCORES)");
        a.a(eVar);
        eVar.e.add(new Model$TypeAdapterFactory());
        eVar.e.add(UserExperimentDto$TypeAdapterFactory.INSTANCE);
        eVar.b(RestAPIParams$ChannelPosition.class, new RestAPIParams$ChannelPosition$Serializer());
        if (serializeNulls) {
            eVar.g = true;
        }
        Gson gsonA = eVar.a();
        String strW = b.d.b.a.a.w(baseApiUrl, addVersion ? "v9/" : "");
        u uVar = u.a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(client, "client == null");
        arrayList2.add(new g(null, false));
        arrayList.add(new k());
        m.checkNotNullExpressionValue(gsonA, "gson");
        arrayList.add(new PayloadJSON$ConverterFactory(gsonA));
        if (m.areEqual(contentType, CONTENT_TYPE_JSON)) {
            arrayList.add(new i0.e0.a.a(gsonA));
        }
        Objects.requireNonNull(strW, "baseUrl == null");
        m.checkParameterIsNotNull(strW, "$this$toHttpUrl");
        w$a w_a = new w$a();
        w_a.e(null, strW);
        w wVarB = w_a.b();
        List<String> list = wVarB.i;
        if (!"".equals(list.get(list.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + wVarB);
        }
        Executor executorA = uVar.a();
        ArrayList arrayList3 = new ArrayList(arrayList2);
        i iVar = new i(executorA);
        arrayList3.addAll(uVar.f3758b ? Arrays.asList(i0.g.a, iVar) : Collections.singletonList(iVar));
        ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (uVar.f3758b ? 1 : 0));
        arrayList4.add(new i0.c());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(uVar.f3758b ? Collections.singletonList(q.a) : Collections.emptyList());
        y yVar = new y(client, wVarB, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), executorA, false);
        if (!api.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(api);
        while (!arrayDeque.isEmpty()) {
            Class<T> cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls.getName());
                if (cls != api) {
                    sb.append(" which is an interface of ");
                    sb.append(api.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        if (yVar.g) {
            u uVar2 = u.a;
            for (Method method : api.getDeclaredMethods()) {
                if (!(uVar2.f3758b && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                    yVar.b(method);
                }
            }
        }
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new i0.x(yVar, api));
    }

    public static /* synthetic */ Object buildApi$default(RestAPIBuilder restAPIBuilder, x xVar, Class cls, String str, boolean z2, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.buildApi(xVar, cls, str, (i & 8) != 0 ? false : z2, z3, str2);
    }

    private final x buildOkHttpClient(Long timeoutMillis, List<? extends Interceptor> interceptors) {
        x$a x_a = new x$a();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                m.checkParameterIsNotNull(interceptor, "interceptor");
                x_a.c.add(interceptor);
            }
        }
        if (timeoutMillis != null) {
            long jLongValue = timeoutMillis.longValue();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            x_a.a(jLongValue, timeUnit);
            long jLongValue2 = timeoutMillis.longValue();
            m.checkParameterIsNotNull(timeUnit, "unit");
            x_a.f3691z = f0.e0.c.b("timeout", jLongValue2, timeUnit);
            long jLongValue3 = timeoutMillis.longValue();
            m.checkParameterIsNotNull(timeUnit, "unit");
            x_a.f3689x = f0.e0.c.b("timeout", jLongValue3, timeUnit);
        }
        p pVar = this.cookieJar;
        m.checkParameterIsNotNull(pVar, "cookieJar");
        x_a.j = pVar;
        return new x(x_a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ x buildOkHttpClient$default(RestAPIBuilder restAPIBuilder, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return restAPIBuilder.buildOkHttpClient(l, list);
    }

    public final <T> T build(Class<T> apiDefinition, boolean serializeNulls, long timeoutMillis, List<? extends Interceptor> interceptors, String clientName, boolean addVersion, String contentType) {
        m.checkNotNullParameter(apiDefinition, "apiDefinition");
        m.checkNotNullParameter(contentType, "contentType");
        x xVarBuildOkHttpClient = buildOkHttpClient(Long.valueOf(timeoutMillis), interceptors);
        if (clientName != null) {
            clientCallback.invoke(clientName, xVarBuildOkHttpClient);
        }
        return (T) buildApi(xVarBuildOkHttpClient, apiDefinition, this.baseApiUrl, serializeNulls, addVersion, contentType);
    }
}
