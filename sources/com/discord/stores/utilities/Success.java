package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Success<T> extends RestCallState<T> {
    private final T response;

    public Success(T t) {
        super(null);
        this.response = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Success copy$default(Success success, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = success.response;
        }
        return success.copy(obj);
    }

    public final T component1() {
        return this.response;
    }

    public final Success<T> copy(T response) {
        return new Success<>(response);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Success) && m.areEqual(this.response, ((Success) other).response);
        }
        return true;
    }

    public final T getResponse() {
        return this.response;
    }

    public int hashCode() {
        T t = this.response;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // com.discord.stores.utilities.RestCallState
    public T invoke() {
        return this.response;
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(response=");
        sbU.append(this.response);
        sbU.append(")");
        return sbU.toString();
    }
}
