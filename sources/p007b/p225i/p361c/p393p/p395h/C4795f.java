package p007b.p225i.p361c.p393p.p395h;

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
import p007b.p225i.p361c.p393p.InterfaceC4784c;
import p007b.p225i.p361c.p393p.InterfaceC4785d;
import p007b.p225i.p361c.p393p.InterfaceC4786e;
import p007b.p225i.p361c.p393p.InterfaceC4787f;

/* JADX INFO: renamed from: b.i.c.p.h.f */
/* JADX INFO: compiled from: JsonValueObjectEncoderContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4795f implements InterfaceC4785d, InterfaceC4787f {

    /* JADX INFO: renamed from: a */
    public boolean f12827a = true;

    /* JADX INFO: renamed from: b */
    public final JsonWriter f12828b;

    /* JADX INFO: renamed from: c */
    public final Map<Class<?>, InterfaceC4784c<?>> f12829c;

    /* JADX INFO: renamed from: d */
    public final Map<Class<?>, InterfaceC4786e<?>> f12830d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC4784c<Object> f12831e;

    /* JADX INFO: renamed from: f */
    public final boolean f12832f;

    public C4795f(@NonNull Writer writer, @NonNull Map<Class<?>, InterfaceC4784c<?>> map, @NonNull Map<Class<?>, InterfaceC4786e<?>> map2, InterfaceC4784c<Object> interfaceC4784c, boolean z2) {
        this.f12828b = new JsonWriter(writer);
        this.f12829c = map;
        this.f12830d = map2;
        this.f12831e = interfaceC4784c;
        this.f12832f = z2;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4785d
    @NonNull
    /* JADX INFO: renamed from: a */
    public InterfaceC4785d mo6705a(@NonNull String str, boolean z2) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(z2);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4785d
    @NonNull
    /* JADX INFO: renamed from: b */
    public InterfaceC4785d mo6706b(@NonNull String str, long j) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(j);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4785d
    @NonNull
    /* JADX INFO: renamed from: c */
    public InterfaceC4785d mo6707c(@NonNull String str, int i) throws IOException {
        m6715i();
        this.f12828b.name(str);
        m6715i();
        this.f12828b.value(i);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4787f
    @NonNull
    /* JADX INFO: renamed from: d */
    public InterfaceC4787f mo6709d(@Nullable String str) throws IOException {
        m6715i();
        this.f12828b.value(str);
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4787f
    @NonNull
    /* JADX INFO: renamed from: e */
    public InterfaceC4787f mo6710e(boolean z2) throws IOException {
        m6715i();
        this.f12828b.value(z2);
        return this;
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public C4795f m6713g(@Nullable Object obj, boolean z2) throws IOException {
        int i = 0;
        if (z2) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                objArr[0] = obj == null ? null : obj.getClass();
                throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.f12828b.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f12828b.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f12828b.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m6713g(it.next(), false);
                }
                this.f12828b.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f12828b.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        mo6708f((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.f12828b.endObject();
                return this;
            }
            InterfaceC4784c<?> interfaceC4784c = this.f12829c.get(obj.getClass());
            if (interfaceC4784c != null) {
                if (!z2) {
                    this.f12828b.beginObject();
                }
                interfaceC4784c.mo2312a(obj, this);
                if (!z2) {
                    this.f12828b.endObject();
                }
                return this;
            }
            InterfaceC4786e<?> interfaceC4786e = this.f12830d.get(obj.getClass());
            if (interfaceC4786e != null) {
                interfaceC4786e.mo2312a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                m6715i();
                this.f12828b.value(strName);
                return this;
            }
            InterfaceC4784c<Object> interfaceC4784c2 = this.f12831e;
            if (!z2) {
                this.f12828b.beginObject();
            }
            interfaceC4784c2.mo2312a(obj, this);
            if (!z2) {
                this.f12828b.endObject();
            }
            return this;
        }
        if (obj instanceof byte[]) {
            m6715i();
            this.f12828b.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        this.f12828b.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i < length) {
                this.f12828b.value(iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                m6715i();
                this.f12828b.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.f12828b.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.f12828b.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                m6713g(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                m6713g(obj2, false);
            }
        }
        this.f12828b.endArray();
        return this;
    }

    @Override // p007b.p225i.p361c.p393p.InterfaceC4785d
    @NonNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C4795f mo6708f(@NonNull String str, @Nullable Object obj) throws IOException {
        if (this.f12832f) {
            if (obj == null) {
                return this;
            }
            m6715i();
            this.f12828b.name(str);
            return m6713g(obj, false);
        }
        m6715i();
        this.f12828b.name(str);
        if (obj != null) {
            return m6713g(obj, false);
        }
        this.f12828b.nullValue();
        return this;
    }

    /* JADX INFO: renamed from: i */
    public final void m6715i() throws IOException {
        if (!this.f12827a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
