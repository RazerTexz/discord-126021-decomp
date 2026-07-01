package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import i0.Converter2;
import i0.Retrofit2;
import i0.e0.a.GsonConverterFactory;
import i0.e0.a.GsonRequestBodyConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: PayloadJSON.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    /* JADX INFO: compiled from: PayloadJSON.kt */
    public static final class ConverterFactory extends Converter2.a {
        private final GsonConverterFactory gsonConverterFactory;

        /* JADX INFO: compiled from: PayloadJSON.kt */
        public static final class RequestBodyConverter<T> implements Converter2<PayloadJSON<T>, RequestBody> {
            private final Converter2<T, RequestBody> gsonRequestBodyConverter;

            public RequestBodyConverter(Converter2<T, RequestBody> converter2) {
                Intrinsics3.checkNotNullParameter(converter2, "gsonRequestBodyConverter");
                this.gsonRequestBodyConverter = converter2;
            }

            @Override // i0.Converter2
            public RequestBody convert(PayloadJSON<T> value) {
                Intrinsics3.checkNotNullParameter(value, "value");
                return this.gsonRequestBodyConverter.convert((T) ((PayloadJSON) value).data);
            }
        }

        public ConverterFactory(Gson gson) {
            Intrinsics3.checkNotNullParameter(gson, "gson");
            Objects.requireNonNull(gson, "gson == null");
            this.gsonConverterFactory = new GsonConverterFactory(gson);
        }

        @Override // i0.Converter2.a
        public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit2 retrofit) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
            Intrinsics3.checkNotNullParameter(methodAnnotations, "methodAnnotations");
            Intrinsics3.checkNotNullParameter(retrofit, "retrofit");
            if (!(type instanceof ParameterizedType)) {
                type = null;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType == null || (!Intrinsics3.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
                return null;
            }
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            GsonConverterFactory gsonConverterFactory = this.gsonConverterFactory;
            return new RequestBodyConverter(new GsonRequestBodyConverter(gsonConverterFactory.a, gsonConverterFactory.a.h(TypeToken.get(type2))));
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
            return (other instanceof PayloadJSON) && Intrinsics3.areEqual(this.data, ((PayloadJSON) other).data);
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
        StringBuilder sbU = outline.U("PayloadJSON(data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
