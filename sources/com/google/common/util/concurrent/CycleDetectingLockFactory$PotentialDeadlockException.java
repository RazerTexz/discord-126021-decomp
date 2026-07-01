package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public final class CycleDetectingLockFactory$PotentialDeadlockException extends CycleDetectingLockFactory$b {
    private final CycleDetectingLockFactory$b conflictingStackTrace;

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
            sb.append(", ");
            sb.append(cause.getMessage());
        }
        return sb.toString();
    }
}
