package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.logging.Logger;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractC4527r;
import p007b.p225i.p355b.p357b.C4532u;
import p007b.p225i.p355b.p357b.ConcurrentMapC4533v;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
public class CycleDetectingLockFactory {

    public static final class PotentialDeadlockException extends C11066b {
        private final C11066b conflictingStackTrace;

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

    /* JADX INFO: renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$a */
    public static class C11065a extends ThreadLocal<ArrayList<C11067c>> {
        @Override // java.lang.ThreadLocal
        public ArrayList<C11067c> initialValue() {
            C3404f.m4189A(3, "initialArraySize");
            return new ArrayList<>(3);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$b */
    public static class C11066b extends IllegalStateException {
        static {
            AbstractC4527r.m6283r(CycleDetectingLockFactory.class.getName(), C11066b.class.getName(), C11067c.class.getName());
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.CycleDetectingLockFactory$c */
    public static class C11067c {
    }

    static {
        C4532u c4532u = new C4532u();
        c4532u.m6287d(ConcurrentMapC4533v.p.f12100k);
        c4532u.m6286c();
        Logger.getLogger(CycleDetectingLockFactory.class.getName());
        new C11065a();
    }
}
