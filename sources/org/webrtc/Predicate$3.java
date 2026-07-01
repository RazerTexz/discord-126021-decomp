package org.webrtc;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
public class Predicate$3<T> implements Predicate<T> {
    public final /* synthetic */ Predicate this$0;

    public Predicate$3(Predicate predicate) {
        this.this$0 = predicate;
    }

    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate$CC.a(this, predicate);
    }

    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate negate() {
        return Predicate$CC.b(this);
    }

    @Override // org.webrtc.Predicate
    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate$CC.c(this, predicate);
    }

    @Override // org.webrtc.Predicate
    public boolean test(T t) {
        return !this.this$0.test(t);
    }
}
