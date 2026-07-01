package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public final class Data$Builder {
    private Map<String, Object> mValues = new HashMap();

    @NonNull
    public Data build() throws Throwable {
        Data data = new Data((Map<String, ?>) this.mValues);
        Data.toByteArrayInternal(data);
        return data;
    }

    @NonNull
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public Data$Builder put(@NonNull String str, @Nullable Object obj) {
        if (obj == null) {
            this.mValues.put(str, null);
        } else {
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                this.mValues.put(str, obj);
            } else if (cls == boolean[].class) {
                this.mValues.put(str, Data.convertPrimitiveBooleanArray((boolean[]) obj));
            } else if (cls == byte[].class) {
                this.mValues.put(str, Data.convertPrimitiveByteArray((byte[]) obj));
            } else if (cls == int[].class) {
                this.mValues.put(str, Data.convertPrimitiveIntArray((int[]) obj));
            } else if (cls == long[].class) {
                this.mValues.put(str, Data.convertPrimitiveLongArray((long[]) obj));
            } else if (cls == float[].class) {
                this.mValues.put(str, Data.convertPrimitiveFloatArray((float[]) obj));
            } else {
                if (cls != double[].class) {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
                this.mValues.put(str, Data.convertPrimitiveDoubleArray((double[]) obj));
            }
        }
        return this;
    }

    @NonNull
    public Data$Builder putAll(@NonNull Data data) {
        putAll(data.mValues);
        return this;
    }

    @NonNull
    public Data$Builder putBoolean(@NonNull String str, boolean z2) {
        this.mValues.put(str, Boolean.valueOf(z2));
        return this;
    }

    @NonNull
    public Data$Builder putBooleanArray(@NonNull String str, @NonNull boolean[] zArr) {
        this.mValues.put(str, Data.convertPrimitiveBooleanArray(zArr));
        return this;
    }

    @NonNull
    public Data$Builder putByte(@NonNull String str, byte b2) {
        this.mValues.put(str, Byte.valueOf(b2));
        return this;
    }

    @NonNull
    public Data$Builder putByteArray(@NonNull String str, @NonNull byte[] bArr) {
        this.mValues.put(str, Data.convertPrimitiveByteArray(bArr));
        return this;
    }

    @NonNull
    public Data$Builder putDouble(@NonNull String str, double d) {
        this.mValues.put(str, Double.valueOf(d));
        return this;
    }

    @NonNull
    public Data$Builder putDoubleArray(@NonNull String str, @NonNull double[] dArr) {
        this.mValues.put(str, Data.convertPrimitiveDoubleArray(dArr));
        return this;
    }

    @NonNull
    public Data$Builder putFloat(@NonNull String str, float f) {
        this.mValues.put(str, Float.valueOf(f));
        return this;
    }

    @NonNull
    public Data$Builder putFloatArray(@NonNull String str, @NonNull float[] fArr) {
        this.mValues.put(str, Data.convertPrimitiveFloatArray(fArr));
        return this;
    }

    @NonNull
    public Data$Builder putInt(@NonNull String str, int i) {
        this.mValues.put(str, Integer.valueOf(i));
        return this;
    }

    @NonNull
    public Data$Builder putIntArray(@NonNull String str, @NonNull int[] iArr) {
        this.mValues.put(str, Data.convertPrimitiveIntArray(iArr));
        return this;
    }

    @NonNull
    public Data$Builder putLong(@NonNull String str, long j) {
        this.mValues.put(str, Long.valueOf(j));
        return this;
    }

    @NonNull
    public Data$Builder putLongArray(@NonNull String str, @NonNull long[] jArr) {
        this.mValues.put(str, Data.convertPrimitiveLongArray(jArr));
        return this;
    }

    @NonNull
    public Data$Builder putString(@NonNull String str, @Nullable String str2) {
        this.mValues.put(str, str2);
        return this;
    }

    @NonNull
    public Data$Builder putStringArray(@NonNull String str, @NonNull String[] strArr) {
        this.mValues.put(str, strArr);
        return this;
    }

    @NonNull
    public Data$Builder putAll(@NonNull Map<String, Object> map) {
        for (Map$Entry<String, Object> map$Entry : map.entrySet()) {
            put(map$Entry.getKey(), map$Entry.getValue());
        }
        return this;
    }
}
