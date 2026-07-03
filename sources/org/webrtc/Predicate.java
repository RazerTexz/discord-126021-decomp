package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface Predicate<T> {

    /* JADX INFO: renamed from: org.webrtc.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: a */
        public static Predicate m11035a(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.2
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.m11035a(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.m11036b(this);
                }

                @Override // org.webrtc.Predicate
                /* JADX INFO: renamed from: or */
                public /* synthetic */ Predicate mo11025or(Predicate predicate2) {
                    return CC.m11037c(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t) {
                    return Predicate.this.test(t) && predicate.test(t);
                }
            };
        }

        /* JADX INFO: renamed from: b */
        public static Predicate m11036b(final Predicate _this) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.3
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return CC.m11035a(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.m11036b(this);
                }

                @Override // org.webrtc.Predicate
                /* JADX INFO: renamed from: or */
                public /* synthetic */ Predicate mo11025or(Predicate predicate) {
                    return CC.m11037c(this, predicate);
                }

                @Override // org.webrtc.Predicate
                public boolean test(T t) {
                    return !Predicate.this.test(t);
                }
            };
        }

        /* JADX INFO: renamed from: c */
        public static Predicate m11037c(final Predicate _this, final Predicate predicate) {
            return new Predicate<T>() { // from class: org.webrtc.Predicate.1
                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return CC.m11035a(this, predicate2);
                }

                @Override // org.webrtc.Predicate
                public /* synthetic */ Predicate negate() {
                    return CC.m11036b(this);
                }

                @Override // org.webrtc.Predicate
                /* JADX INFO: renamed from: or */
                public /* synthetic */ Predicate mo11025or(Predicate predicate2) {
                    return CC.m11037c(this, predicate2);
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

    /* JADX INFO: renamed from: or */
    Predicate<T> mo11025or(Predicate<? super T> predicate);

    boolean test(T t);
}
