package b.a.y.j0;

import org.webrtc.RendererCommon$RendererEvents;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements RendererCommon$RendererEvents {
    public final BehaviorSubject<e$a> j = BehaviorSubject.k0();

    @Override // org.webrtc.RendererCommon$RendererEvents
    public void onFirstFrameRendered() {
    }

    @Override // org.webrtc.RendererCommon$RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        this.j.onNext(new e$a(i, i2, i3));
    }
}
