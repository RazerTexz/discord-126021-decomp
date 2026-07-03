package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SingleTypePayload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SingleTypePayload<T> implements MGRecyclerDataPayload {
    private final T data;
    private final String key;
    private final int type;

    public SingleTypePayload(T t, String str, int i) {
        C12238m.checkNotNullParameter(str, "key");
        this.data = t;
        this.key = str;
        this.type = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleTypePayload copy$default(SingleTypePayload singleTypePayload, Object obj, String str, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = singleTypePayload.data;
        }
        if ((i2 & 2) != 0) {
            str = singleTypePayload.getKey();
        }
        if ((i2 & 4) != 0) {
            i = singleTypePayload.getType();
        }
        return singleTypePayload.copy(obj, str, i);
    }

    public final T component1() {
        return this.data;
    }

    public final String component2() {
        return getKey();
    }

    public final int component3() {
        return getType();
    }

    public final SingleTypePayload<T> copy(T data, String key, int type) {
        C12238m.checkNotNullParameter(key, "key");
        return new SingleTypePayload<>(data, key, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SingleTypePayload)) {
            return false;
        }
        SingleTypePayload singleTypePayload = (SingleTypePayload) other;
        return C12238m.areEqual(this.data, singleTypePayload.data) && C12238m.areEqual(getKey(), singleTypePayload.getKey()) && getType() == singleTypePayload.getType();
    }

    public final T getData() {
        return this.data;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        T t = this.data;
        int iHashCode = (t != null ? t.hashCode() : 0) * 31;
        String key = getKey();
        return getType() + ((iHashCode + (key != null ? key.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SingleTypePayload(data=");
        sbM833U.append(this.data);
        sbM833U.append(", key=");
        sbM833U.append(getKey());
        sbM833U.append(", type=");
        sbM833U.append(getType());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ SingleTypePayload(Object obj, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, (i2 & 4) != 0 ? 0 : i);
    }
}
