package kotlinx.coroutines;

import d0.z.d.Intrinsics3;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: kotlinx.coroutines.JobCancellationException, reason: use source file name */
/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Exceptions7 extends CancellationException {
    public final Job job;

    public Exceptions7(String str, Throwable th, Job job) {
        super(str);
        this.job = job;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object other) {
        if (other != this) {
            if (other instanceof Exceptions7) {
                Exceptions7 exceptions7 = (Exceptions7) other;
                if (!Intrinsics3.areEqual(exceptions7.getMessage(), getMessage()) || !Intrinsics3.areEqual(exceptions7.job, this.job) || !Intrinsics3.areEqual(exceptions7.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        Intrinsics3.checkNotNull(message);
        int iHashCode = (this.job.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
