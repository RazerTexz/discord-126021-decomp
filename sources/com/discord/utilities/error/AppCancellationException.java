package com.discord.utilities.error;

import java.util.concurrent.CancellationException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppCancellationException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppCancellationException extends CancellationException {
    private final Throwable cause;
    private final Error error;
    private final String message;

    public AppCancellationException(String str, Throwable th, Error error) {
        C12238m.checkNotNullParameter(error, "error");
        this.message = str;
        this.cause = th;
        this.error = error;
    }

    public static /* synthetic */ AppCancellationException copy$default(AppCancellationException appCancellationException, String str, Throwable th, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appCancellationException.getMessage();
        }
        if ((i & 2) != 0) {
            th = appCancellationException.getCause();
        }
        if ((i & 4) != 0) {
            error = appCancellationException.error;
        }
        return appCancellationException.copy(str, th, error);
    }

    public final String component1() {
        return getMessage();
    }

    public final Throwable component2() {
        return getCause();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final AppCancellationException copy(String message, Throwable cause, Error error) {
        C12238m.checkNotNullParameter(error, "error");
        return new AppCancellationException(message, cause, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppCancellationException)) {
            return false;
        }
        AppCancellationException appCancellationException = (AppCancellationException) other;
        return C12238m.areEqual(getMessage(), appCancellationException.getMessage()) && C12238m.areEqual(getCause(), appCancellationException.getCause()) && C12238m.areEqual(this.error, appCancellationException.error);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public final Error getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String message = getMessage();
        int iHashCode = (message != null ? message.hashCode() : 0) * 31;
        Throwable cause = getCause();
        int iHashCode2 = (iHashCode + (cause != null ? cause.hashCode() : 0)) * 31;
        Error error = this.error;
        return iHashCode2 + (error != null ? error.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AppCancellationException(message=");
        sbM833U.append(getMessage());
        sbM833U.append(", cause=");
        sbM833U.append(getCause());
        sbM833U.append(", error=");
        sbM833U.append(this.error);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
