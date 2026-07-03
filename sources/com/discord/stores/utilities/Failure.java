package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Failure<T> extends RestCallState<T> {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Failure(Error error) {
        super(null);
        C12238m.checkNotNullParameter(error, "error");
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
        C12238m.checkNotNullParameter(error, "error");
        return new Failure<>(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Failure) && C12238m.areEqual(this.error, ((Failure) other).error);
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
        StringBuilder sbM833U = C1643a.m833U("Failure(error=");
        sbM833U.append(this.error);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
