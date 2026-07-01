package b.a.y.j0;

import b.d.b.a.outline;
import org.webrtc.RendererCommon;
import rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: b.a.y.j0.e, reason: use source file name */
/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxRendererEvents implements RendererCommon.RendererEvents {
    public final BehaviorSubject<a> j = BehaviorSubject.k0();

    /* JADX INFO: renamed from: b.a.y.j0.e$a */
    /* JADX INFO: compiled from: RxRendererEvents.kt */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f312b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.f312b = i2;
            this.c = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f312b == aVar.f312b && this.c == aVar.c;
        }

        public int hashCode() {
            return (((this.a * 31) + this.f312b) * 31) + this.c;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Resolution(width=");
            sbU.append(this.a);
            sbU.append(", height=");
            sbU.append(this.f312b);
            sbU.append(", rotation=");
            return outline.B(sbU, this.c, ")");
        }
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.j.onNext(new a(i, i2, i3));
    }
}
