package p507d0.p512d0;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p588x.C12197c;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.d0.c */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11223c implements Iterable<Long>, InterfaceC12228a {

    /* JADX INFO: renamed from: j */
    public final long f22283j;

    /* JADX INFO: renamed from: k */
    public final long f22284k;

    /* JADX INFO: renamed from: l */
    public final long f22285l;

    /* JADX INFO: renamed from: d0.d0.c$a */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public C11223c(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f22283j = j;
        this.f22284k = C12197c.getProgressionLastElement(j, j2, j3);
        this.f22285l = j3;
    }

    public final long getFirst() {
        return this.f22283j;
    }

    public final long getLast() {
        return this.f22284k;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new C11224d(this.f22283j, this.f22284k, this.f22285l);
    }
}
