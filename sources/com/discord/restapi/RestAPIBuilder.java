package com.discord.restapi;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.google.gson.Gson;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import p007b.p008a.p017b.C0850a;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.C4901e;
import p007b.p225i.p408d.EnumC4899c;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.InterfaceC12372p;
import p600f0.p601e0.C12272c;
import p630i0.C12502c;
import p630i0.C12553g;
import p630i0.C12555i;
import p630i0.C12563q;
import p630i0.C12567u;
import p630i0.C12570x;
import p630i0.C12571y;
import p630i0.p631d0.p632a.C12511g;
import p630i0.p633e0.p634a.C12513a;
import p630i0.p633e0.p635b.C12526k;

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder {
    private static final int API_VERSION = 9;
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    private static final long DEFAULT_TIMEOUT_MILLIS = 10000;
    private final String baseApiUrl;
    private final InterfaceC12372p cookieJar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super String, ? super C12380x, Unit> clientCallback = RestAPIBuilder$Companion$clientCallback$1.INSTANCE;

    /* JADX INFO: compiled from: RestAPIBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getClientCallback$annotations() {
        }

        public final Function2<String, C12380x, Unit> getClientCallback() {
            return RestAPIBuilder.clientCallback;
        }

        public final void setClientCallback(Function2<? super String, ? super C12380x, Unit> function2) {
            C12238m.checkNotNullParameter(function2, "<set-?>");
            RestAPIBuilder.clientCallback = function2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestAPIBuilder(String str, InterfaceC12372p interfaceC12372p) {
        C12238m.checkNotNullParameter(str, "baseApiUrl");
        C12238m.checkNotNullParameter(interfaceC12372p, "cookieJar");
        this.baseApiUrl = str;
        this.cookieJar = interfaceC12372p;
    }

    private final <T> T buildApi(C12380x client, Class<T> api, String baseApiUrl, boolean serializeNulls, boolean addVersion, String contentType) {
        C4901e c4901e = new C4901e();
        c4901e.f13097c = EnumC4899c.f13091m;
        C12238m.checkNotNullExpressionValue(c4901e, "GsonBuilder()\n        .s…ER_CASE_WITH_UNDERSCORES)");
        C0850a.m147a(c4901e);
        c4901e.f13099e.add(new Model.TypeAdapterFactory());
        c4901e.f13099e.add(UserExperimentDto.TypeAdapterFactory.INSTANCE);
        c4901e.m6852b(RestAPIParams.ChannelPosition.class, new RestAPIParams.ChannelPosition.Serializer());
        if (serializeNulls) {
            c4901e.f13101g = true;
        }
        Gson gsonM6851a = c4901e.m6851a();
        String strM883w = C1643a.m883w(baseApiUrl, addVersion ? "v9/" : "");
        C12567u c12567u = C12567u.f26614a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(client, "client == null");
        arrayList2.add(new C12511g(null, false));
        arrayList.add(new C12526k());
        C12238m.checkNotNullExpressionValue(gsonM6851a, "gson");
        arrayList.add(new PayloadJSON.ConverterFactory(gsonM6851a));
        if (C12238m.areEqual(contentType, CONTENT_TYPE_JSON)) {
            arrayList.add(new C12513a(gsonM6851a));
        }
        Objects.requireNonNull(strM883w, "baseUrl == null");
        C12238m.checkParameterIsNotNull(strM883w, "$this$toHttpUrl");
        C12379w.a aVar = new C12379w.a();
        aVar.m10412e(null, strM883w);
        C12379w c12379wM10409b = aVar.m10409b();
        List<String> list = c12379wM10409b.f25981i;
        if (!"".equals(list.get(list.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + c12379wM10409b);
        }
        Executor executorMo10716a = c12567u.mo10716a();
        ArrayList arrayList3 = new ArrayList(arrayList2);
        C12555i c12555i = new C12555i(executorMo10716a);
        arrayList3.addAll(c12567u.f26615b ? Arrays.asList(C12553g.f26528a, c12555i) : Collections.singletonList(c12555i));
        ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (c12567u.f26615b ? 1 : 0));
        arrayList4.add(new C12502c());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(c12567u.f26615b ? Collections.singletonList(C12563q.f26567a) : Collections.emptyList());
        C12571y c12571y = new C12571y(client, c12379wM10409b, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), executorMo10716a, false);
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
        if (c12571y.f26679g) {
            C12567u c12567u2 = C12567u.f26614a;
            for (Method method : api.getDeclaredMethods()) {
                if (!(c12567u2.f26615b && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                    c12571y.m10726b(method);
                }
            }
        }
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new C12570x(c12571y, api));
    }

    private final C12380x buildOkHttpClient(Long timeoutMillis, List<? extends Interceptor> interceptors) {
        C12380x.a aVar = new C12380x.a();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                C12238m.checkParameterIsNotNull(interceptor, "interceptor");
                aVar.f26031c.add(interceptor);
            }
        }
        if (timeoutMillis != null) {
            long jLongValue = timeoutMillis.longValue();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVar.m10420a(jLongValue, timeUnit);
            long jLongValue2 = timeoutMillis.longValue();
            C12238m.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f26054z = C12272c.m10121b("timeout", jLongValue2, timeUnit);
            long jLongValue3 = timeoutMillis.longValue();
            C12238m.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f26052x = C12272c.m10121b("timeout", jLongValue3, timeUnit);
        }
        InterfaceC12372p interfaceC12372p = this.cookieJar;
        C12238m.checkParameterIsNotNull(interfaceC12372p, "cookieJar");
        aVar.f26038j = interfaceC12372p;
        return new C12380x(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C12380x buildOkHttpClient$default(RestAPIBuilder restAPIBuilder, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return restAPIBuilder.buildOkHttpClient(l, list);
    }

    public final <T> T build(Class<T> apiDefinition, boolean serializeNulls, long timeoutMillis, List<? extends Interceptor> interceptors, String clientName, boolean addVersion, String contentType) {
        C12238m.checkNotNullParameter(apiDefinition, "apiDefinition");
        C12238m.checkNotNullParameter(contentType, "contentType");
        C12380x c12380xBuildOkHttpClient = buildOkHttpClient(Long.valueOf(timeoutMillis), interceptors);
        if (clientName != null) {
            clientCallback.invoke(clientName, c12380xBuildOkHttpClient);
        }
        return (T) buildApi(c12380xBuildOkHttpClient, apiDefinition, this.baseApiUrl, serializeNulls, addVersion, contentType);
    }
}
