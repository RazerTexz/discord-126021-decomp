package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: PayloadJSON.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    public PayloadJSON(T t) {
        this.data = t;
    }

    public static final /* synthetic */ Object access$getData$p(PayloadJSON payloadJSON) {
        return payloadJSON.data;
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
            return (other instanceof PayloadJSON) && m.areEqual(this.data, ((PayloadJSON) other).data);
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
        StringBuilder sbU = a.U("PayloadJSON(data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
