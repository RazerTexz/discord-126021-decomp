package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SingleTypePayload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SingleTypePayload<T> implements MGRecyclerDataPayload {
    private final T data;
    private final String key;
    private final int type;

    public SingleTypePayload(T t, String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "key");
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
        Intrinsics3.checkNotNullParameter(key, "key");
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
        return Intrinsics3.areEqual(this.data, singleTypePayload.data) && Intrinsics3.areEqual(getKey(), singleTypePayload.getKey()) && getType() == singleTypePayload.getType();
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
        StringBuilder sbU = outline.U("SingleTypePayload(data=");
        sbU.append(this.data);
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ SingleTypePayload(Object obj, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, (i2 & 4) != 0 ? 0 : i);
    }
}
