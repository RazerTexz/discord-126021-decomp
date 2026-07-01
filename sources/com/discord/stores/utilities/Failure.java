package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Failure<T> extends RestCallState<T> {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Failure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ Failure copy$default(Failure failure, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = failure.error;
        }
        return failure.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final Failure<T> copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new Failure<>(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Failure) && m.areEqual(this.error, ((Failure) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Failure(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
