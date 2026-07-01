package org.webrtc;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes3.dex */
public class Predicate$1<T> implements Predicate<T> {
    public final /* synthetic */ Predicate this$0;
    public final /* synthetic */ Predicate val$other;

    public Predicate$1(Predicate predicate, Predicate predicate2) {
        this.this$0 = predicate;
        this.val$other = predicate2;
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
        return this.this$0.test(t) || this.val$other.test(t);
    }
}
