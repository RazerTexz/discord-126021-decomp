package b.i.c.p.h;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: JsonValueObjectEncoderContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements b.i.c.p.d, b.i.c.p.f {
    public boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonWriter f1762b;
    public final Map<Class<?>, b.i.c.p.c<?>> c;
    public final Map<Class<?>, b.i.c.p.e<?>> d;
    public final b.i.c.p.c<Object> e;
    public final boolean f;

    public f(@NonNull Writer writer, @NonNull Map<Class<?>, b.i.c.p.c<?>> map, @NonNull Map<Class<?>, b.i.c.p.e<?>> map2, b.i.c.p.c<Object> cVar, boolean z2) {
        this.f1762b = new JsonWriter(writer);
        this.c = map;
        this.d = map2;
        this.e = cVar;
        this.f = z2;
    }

    @Override // b.i.c.p.d
    @NonNull
    public b.i.c.p.d a(@NonNull String str, boolean z2) throws IOException {
        i();
        this.f1762b.name(str);
        i();
        this.f1762b.value(z2);
        return this;
    }

    @Override // b.i.c.p.d
    @NonNull
    public b.i.c.p.d b(@NonNull String str, long j) throws IOException {
        i();
        this.f1762b.name(str);
        i();
        this.f1762b.value(j);
        return this;
    }

    @Override // b.i.c.p.d
    @NonNull
    public b.i.c.p.d c(@NonNull String str, int i) throws IOException {
        i();
        this.f1762b.name(str);
        i();
        this.f1762b.value(i);
        return this;
    }

    @Override // b.i.c.p.f
    @NonNull
    public b.i.c.p.f d(@Nullable String str) throws IOException {
        i();
        this.f1762b.value(str);
        return this;
    }

    @Override // b.i.c.p.f
    @NonNull
    public b.i.c.p.f e(boolean z2) throws IOException {
        i();
        this.f1762b.value(z2);
        return this;
    }

    @Override // b.i.c.p.d
    @NonNull
    public /* bridge */ /* synthetic */ b.i.c.p.d f(@NonNull String str, @Nullable Object obj) throws IOException {
        return h(str, obj);
    }

    @NonNull
    public f g(@Nullable Object obj, boolean z2) throws IOException {
        int i = 0;
        if (z2) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                objArr[0] = obj == null ? null : obj.getClass();
                throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.f1762b.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f1762b.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f1762b.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    g(it.next(), false);
                }
                this.f1762b.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f1762b.beginObject();
                for (Map$Entry map$Entry : ((Map) obj).entrySet()) {
                    Object key = map$Entry.getKey();
                    try {
                        h((String) key, map$Entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.f1762b.endObject();
                return this;
            }
            b.i.c.p.c<?> cVar = this.c.get(obj.getClass());
            if (cVar != null) {
                if (!z2) {
                    this.f1762b.beginObject();
                }
                cVar.a(obj, this);
                if (!z2) {
                    this.f1762b.endObject();
                }
                return this;
            }
            b.i.c.p.e<?> eVar = this.d.get(obj.getClass());
            if (eVar != null) {
                eVar.a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                i();
                this.f1762b.value(strName);
                return this;
            }
            b.i.c.p.c<Object> cVar2 = this.e;
            if (!z2) {
                this.f1762b.beginObject();
            }
            cVar2.a(obj, this);
            if (!z2) {
                this.f1762b.endObject();
            }
            return this;
        }
        if (obj instanceof byte[]) {
            i();
            this.f1762b.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        this.f1762b.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i < length) {
                this.f1762b.value(iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                i();
                this.f1762b.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.f1762b.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.f1762b.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                g(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                g(obj2, false);
            }
        }
        this.f1762b.endArray();
        return this;
    }

    @NonNull
    public f h(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f) {
            if (obj == null) {
                return this;
            }
            i();
            this.f1762b.name(str);
            return g(obj, false);
        }
        i();
        this.f1762b.name(str);
        if (obj != null) {
            return g(obj, false);
        }
        this.f1762b.nullValue();
        return this;
    }

    public final void i() throws IOException {
        if (!this.a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
