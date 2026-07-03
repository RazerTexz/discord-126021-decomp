package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.C4906j;
import p007b.p225i.p408d.InterfaceC4904h;
import p007b.p225i.p408d.InterfaceC4905i;
import p007b.p225i.p408d.InterfaceC4908l;
import p007b.p225i.p408d.InterfaceC4909m;
import p007b.p225i.p408d.InterfaceC4911o;

/* JADX INFO: loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a */
    public final InterfaceC4909m<T> f21541a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC4905i<T> f21542b;

    /* JADX INFO: renamed from: c */
    public final Gson f21543c;

    /* JADX INFO: renamed from: d */
    public final TypeToken<T> f21544d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC4911o f21545e;

    /* JADX INFO: renamed from: f */
    public final TreeTypeAdapter<T>.C11113b f21546f = new C11113b(this, null);

    /* JADX INFO: renamed from: g */
    public TypeAdapter<T> f21547g;

    public static final class SingleTypeFactory implements InterfaceC4911o {

        /* JADX INFO: renamed from: j */
        public final TypeToken<?> f21548j;

        /* JADX INFO: renamed from: k */
        public final boolean f21549k;

        /* JADX INFO: renamed from: l */
        public final Class<?> f21550l;

        /* JADX INFO: renamed from: m */
        public final InterfaceC4909m<?> f21551m;

        /* JADX INFO: renamed from: n */
        public final InterfaceC4905i<?> f21552n;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
            InterfaceC4909m<?> interfaceC4909m = obj instanceof InterfaceC4909m ? (InterfaceC4909m) obj : null;
            this.f21551m = interfaceC4909m;
            InterfaceC4905i<?> interfaceC4905i = obj instanceof InterfaceC4905i ? (InterfaceC4905i) obj : null;
            this.f21552n = interfaceC4905i;
            C3404f.m4355w((interfaceC4909m == null && interfaceC4905i == null) ? false : true);
            this.f21548j = typeToken;
            this.f21549k = z2;
            this.f21550l = null;
        }

        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean zIsAssignableFrom;
            TypeToken<?> typeToken2 = this.f21548j;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.f21549k && this.f21548j.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.f21550l.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.f21551m, this.f21552n, gson, typeToken, this);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$b */
    public final class C11113b implements InterfaceC4908l, InterfaceC4904h {
        public C11113b(TreeTypeAdapter treeTypeAdapter, C11112a c11112a) {
        }
    }

    public TreeTypeAdapter(InterfaceC4909m<T> interfaceC4909m, InterfaceC4905i<T> interfaceC4905i, Gson gson, TypeToken<T> typeToken, InterfaceC4911o interfaceC4911o) {
        this.f21541a = interfaceC4909m;
        this.f21542b = interfaceC4905i;
        this.f21543c = gson;
        this.f21544d = typeToken;
        this.f21545e = interfaceC4911o;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        if (this.f21542b == null) {
            TypeAdapter<T> typeAdapterM9206j = this.f21547g;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21543c.m9206j(this.f21545e, this.f21544d);
                this.f21547g = typeAdapterM9206j;
            }
            return typeAdapterM9206j.read(jsonReader);
        }
        JsonElement jsonElementM4244S0 = C3404f.m4244S0(jsonReader);
        Objects.requireNonNull(jsonElementM4244S0);
        if (jsonElementM4244S0 instanceof C4906j) {
            return null;
        }
        return this.f21542b.m6856a(jsonElementM4244S0, this.f21544d.getType(), this.f21546f);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        InterfaceC4909m<T> interfaceC4909m = this.f21541a;
        if (interfaceC4909m == null) {
            TypeAdapter<T> typeAdapterM9206j = this.f21547g;
            if (typeAdapterM9206j == null) {
                typeAdapterM9206j = this.f21543c.m9206j(this.f21545e, this.f21544d);
                this.f21547g = typeAdapterM9206j;
            }
            typeAdapterM9206j.write(jsonWriter, t);
            return;
        }
        if (t == null) {
            jsonWriter.mo6905s();
        } else {
            TypeAdapters.f21579X.write(jsonWriter, interfaceC4909m.serialize(t, this.f21544d.getType(), this.f21546f));
        }
    }
}
