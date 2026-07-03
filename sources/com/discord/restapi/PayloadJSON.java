package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p630i0.C12571y;
import p630i0.InterfaceC12554h;
import p630i0.p633e0.p634a.C12513a;
import p630i0.p633e0.p634a.C12514b;

/* JADX INFO: compiled from: PayloadJSON.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    /* JADX INFO: compiled from: PayloadJSON.kt */
    public static final class ConverterFactory extends InterfaceC12554h.a {
        private final C12513a gsonConverterFactory;

        /* JADX INFO: compiled from: PayloadJSON.kt */
        public static final class RequestBodyConverter<T> implements InterfaceC12554h<PayloadJSON<T>, RequestBody> {
            private final InterfaceC12554h<T, RequestBody> gsonRequestBodyConverter;

            public RequestBodyConverter(InterfaceC12554h<T, RequestBody> interfaceC12554h) {
                C12238m.checkNotNullParameter(interfaceC12554h, "gsonRequestBodyConverter");
                this.gsonRequestBodyConverter = interfaceC12554h;
            }

            @Override // p630i0.InterfaceC12554h
            public RequestBody convert(PayloadJSON<T> value) {
                C12238m.checkNotNullParameter(value, "value");
                return this.gsonRequestBodyConverter.convert((T) ((PayloadJSON) value).data);
            }
        }

        public ConverterFactory(Gson gson) {
            C12238m.checkNotNullParameter(gson, "gson");
            Objects.requireNonNull(gson, "gson == null");
            this.gsonConverterFactory = new C12513a(gson);
        }

        @Override // p630i0.InterfaceC12554h.a
        public InterfaceC12554h<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, C12571y retrofit) {
            C12238m.checkNotNullParameter(type, "type");
            C12238m.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
            C12238m.checkNotNullParameter(methodAnnotations, "methodAnnotations");
            C12238m.checkNotNullParameter(retrofit, "retrofit");
            if (!(type instanceof ParameterizedType)) {
                type = null;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType == null || (!C12238m.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
                return null;
            }
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            C12513a c12513a = this.gsonConverterFactory;
            return new RequestBodyConverter(new C12514b(c12513a.f26510a, c12513a.f26510a.m9204h(TypeToken.get(type2))));
        }
    }

    public PayloadJSON(T t) {
        this.data = t;
    }

    private final T component1() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayloadJSON copy$default(PayloadJSON payloadJSON, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = payloadJSON.data;
        }
        return payloadJSON.copy(obj);
    }

    public final PayloadJSON<T> copy(T data) {
        return new PayloadJSON<>(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PayloadJSON) && C12238m.areEqual(this.data, ((PayloadJSON) other).data);
        }
        return true;
    }

    public int hashCode() {
        T t = this.data;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PayloadJSON(data=");
        sbM833U.append(this.data);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
