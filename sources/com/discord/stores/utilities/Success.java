package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            return (other instanceof Success) && C12238m.areEqual(this.response, ((Success) other).response);
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
        StringBuilder sbM833U = C1643a.m833U("Success(response=");
        sbM833U.append(this.response);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
