package com.discord.restapi;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import b.a.b.TypeAdapterRegistrar;
import b.d.b.a.outline;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.google.gson.Gson;
import d0.z.d.Intrinsics3;
import f0.CookieJar2;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.e0.Util7;
import i0.BuiltInConverters;
import i0.CompletableFutureCallAdapterFactory;
import i0.DefaultCallAdapterFactory;
import i0.OptionalConverterFactory;
import i0.Platform3;
import i0.Retrofit;
import i0.Retrofit2;
import i0.d0.a.RxJavaCallAdapterFactory;
import i0.e0.a.GsonConverterFactory;
import i0.e0.b.ScalarsConverterFactory;
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

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder {
    private static final int API_VERSION = 9;
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    private static final long DEFAULT_TIMEOUT_MILLIS = 10000;
    private final String baseApiUrl;
    private final CookieJar2 cookieJar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super String, ? super OkHttpClient, Unit> clientCallback = RestAPIBuilder2.INSTANCE;

    /* JADX INFO: compiled from: RestAPIBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getClientCallback$annotations() {
        }

        public final Function2<String, OkHttpClient, Unit> getClientCallback() {
            return RestAPIBuilder.clientCallback;
        }

        public final void setClientCallback(Function2<? super String, ? super OkHttpClient, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "<set-?>");
            RestAPIBuilder.clientCallback = function2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestAPIBuilder(String str, CookieJar2 cookieJar2) {
        Intrinsics3.checkNotNullParameter(str, "baseApiUrl");
        Intrinsics3.checkNotNullParameter(cookieJar2, "cookieJar");
        this.baseApiUrl = str;
        this.cookieJar = cookieJar2;
    }

    private final <T> T buildApi(OkHttpClient client, Class<T> api, String baseApiUrl, boolean serializeNulls, boolean addVersion, String contentType) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.c = FieldNamingPolicy.m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n        .s…ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.a(gsonBuilder);
        gsonBuilder.e.add(new Model.TypeAdapterFactory());
        gsonBuilder.e.add(UserExperimentDto.TypeAdapterFactory.INSTANCE);
        gsonBuilder.b(RestAPIParams.ChannelPosition.class, new RestAPIParams.ChannelPosition.Serializer());
        if (serializeNulls) {
            gsonBuilder.g = true;
        }
        Gson gsonA = gsonBuilder.a();
        String strW = outline.w(baseApiUrl, addVersion ? "v9/" : "");
        Platform3 platform3 = Platform3.a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(client, "client == null");
        arrayList2.add(new RxJavaCallAdapterFactory(null, false));
        arrayList.add(new ScalarsConverterFactory());
        Intrinsics3.checkNotNullExpressionValue(gsonA, "gson");
        arrayList.add(new PayloadJSON.ConverterFactory(gsonA));
        if (Intrinsics3.areEqual(contentType, CONTENT_TYPE_JSON)) {
            arrayList.add(new GsonConverterFactory(gsonA));
        }
        Objects.requireNonNull(strW, "baseUrl == null");
        Intrinsics3.checkParameterIsNotNull(strW, "$this$toHttpUrl");
        HttpUrl.a aVar = new HttpUrl.a();
        aVar.e(null, strW);
        HttpUrl httpUrlB = aVar.b();
        List<String> list = httpUrlB.i;
        if (!"".equals(list.get(list.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrlB);
        }
        Executor executorA = platform3.a();
        ArrayList arrayList3 = new ArrayList(arrayList2);
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executorA);
        arrayList3.addAll(platform3.f3758b ? Arrays.asList(CompletableFutureCallAdapterFactory.a, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory));
        ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (platform3.f3758b ? 1 : 0));
        arrayList4.add(new BuiltInConverters());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(platform3.f3758b ? Collections.singletonList(OptionalConverterFactory.a) : Collections.emptyList());
        Retrofit2 retrofit3 = new Retrofit2(client, httpUrlB, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), executorA, false);
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
        if (retrofit3.g) {
            Platform3 platform4 = Platform3.a;
            for (Method method : api.getDeclaredMethods()) {
                if (!(platform4.f3758b && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                    retrofit3.b(method);
                }
            }
        }
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new Retrofit(retrofit3, api));
    }

    private final OkHttpClient buildOkHttpClient(Long timeoutMillis, List<? extends Interceptor> interceptors) {
        OkHttpClient.a aVar = new OkHttpClient.a();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                Intrinsics3.checkParameterIsNotNull(interceptor, "interceptor");
                aVar.c.add(interceptor);
            }
        }
        if (timeoutMillis != null) {
            long jLongValue = timeoutMillis.longValue();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVar.a(jLongValue, timeUnit);
            long jLongValue2 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f3691z = Util7.b("timeout", jLongValue2, timeUnit);
            long jLongValue3 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f3689x = Util7.b("timeout", jLongValue3, timeUnit);
        }
        CookieJar2 cookieJar2 = this.cookieJar;
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "cookieJar");
        aVar.j = cookieJar2;
        return new OkHttpClient(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OkHttpClient buildOkHttpClient$default(RestAPIBuilder restAPIBuilder, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return restAPIBuilder.buildOkHttpClient(l, list);
    }

    public final <T> T build(Class<T> apiDefinition, boolean serializeNulls, long timeoutMillis, List<? extends Interceptor> interceptors, String clientName, boolean addVersion, String contentType) {
        Intrinsics3.checkNotNullParameter(apiDefinition, "apiDefinition");
        Intrinsics3.checkNotNullParameter(contentType, "contentType");
        OkHttpClient okHttpClientBuildOkHttpClient = buildOkHttpClient(Long.valueOf(timeoutMillis), interceptors);
        if (clientName != null) {
            clientCallback.invoke(clientName, okHttpClientBuildOkHttpClient);
        }
        return (T) buildApi(okHttpClientBuildOkHttpClient, apiDefinition, this.baseApiUrl, serializeNulls, addVersion, contentType);
    }
}
