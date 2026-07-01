package com.discord.utilities.error;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: AppCancellationException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppCancellationException extends CancellationException {
    private final Throwable cause;
    private final Error error;
    private final String message;

    public AppCancellationException(String str, Throwable th, Error error) {
        m.checkNotNullParameter(error, "error");
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
        m.checkNotNullParameter(error, "error");
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
        return m.areEqual(getMessage(), appCancellationException.getMessage()) && m.areEqual(getCause(), appCancellationException.getCause()) && m.areEqual(this.error, appCancellationException.error);
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
        StringBuilder sbU = a.U("AppCancellationException(message=");
        sbU.append(getMessage());
        sbU.append(", cause=");
        sbU.append(getCause());
        sbU.append(", error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
