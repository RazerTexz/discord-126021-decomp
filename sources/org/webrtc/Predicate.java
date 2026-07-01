package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface Predicate<T> {

    /* JADX INFO: renamed from: org.webrtc.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate a(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.2
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.a(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.c(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t) {
                    return Predicate.this.test(t) && predicate.test(t);
                }
            };
        }

        public static Predicate b(final Predicate _this) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.3
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return CC.a(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return CC.c(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t) {
                    return !Predicate.this.test(t);
                }
            };
        }

        public static Predicate c(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.1
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.a(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.b(this);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return CC.c(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t) {
                    return Predicate.this.test(t) || predicate.test(t);
                }
            };
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);
}
