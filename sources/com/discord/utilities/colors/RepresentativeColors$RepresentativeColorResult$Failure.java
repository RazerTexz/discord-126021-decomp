package com.discord.utilities.colors;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RepresentativeColors$RepresentativeColorResult$Failure extends RepresentativeColors$RepresentativeColorResult {
    private final Exception exception;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepresentativeColors$RepresentativeColorResult$Failure(Exception exc) {
        super(null);
        m.checkNotNullParameter(exc, "exception");
        this.exception = exc;
    }

    public static /* synthetic */ RepresentativeColors$RepresentativeColorResult$Failure copy$default(RepresentativeColors$RepresentativeColorResult$Failure representativeColors$RepresentativeColorResult$Failure, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = representativeColors$RepresentativeColorResult$Failure.exception;
        }
        return representativeColors$RepresentativeColorResult$Failure.copy(exc);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Exception getException() {
        return this.exception;
    }

    public final RepresentativeColors$RepresentativeColorResult$Failure copy(Exception exception) {
        m.checkNotNullParameter(exception, "exception");
        return new RepresentativeColors$RepresentativeColorResult$Failure(exception);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RepresentativeColors$RepresentativeColorResult$Failure) && m.areEqual(this.exception, ((RepresentativeColors$RepresentativeColorResult$Failure) other).exception);
        }
        return true;
    }

    public final Exception getException() {
        return this.exception;
    }

    public int hashCode() {
        Exception exc = this.exception;
        if (exc != null) {
            return exc.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Failure(exception=");
        sbU.append(this.exception);
        sbU.append(")");
        return sbU.toString();
    }
}
