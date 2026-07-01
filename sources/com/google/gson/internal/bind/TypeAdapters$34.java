package com.google.gson.internal.bind;

import b.d.b.a.a;
import b.i.d.o;
import com.google.android.material.badge.BadgeDrawable;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$34 implements o {
    public final /* synthetic */ Class j;
    public final /* synthetic */ Class k;
    public final /* synthetic */ TypeAdapter l;

    public TypeAdapters$34(Class cls, Class cls2, TypeAdapter typeAdapter) {
        this.j = cls;
        this.k = cls2;
        this.l = typeAdapter;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (rawType == this.j || rawType == this.k) {
            return this.l;
        }
        return null;
    }

    public String toString() {
        StringBuilder sbU = a.U("Factory[type=");
        a.k0(this.j, sbU, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        a.k0(this.k, sbU, ",adapter=");
        sbU.append(this.l);
        sbU.append("]");
        return sbU.toString();
    }
}
