package b.i.c.m.d.q.d;

import b.i.c.m.d.q.c.CreateReportRequest;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.a, reason: use source file name */
/* JADX INFO: compiled from: CompositeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    public final DefaultCreateReportSpiCall a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NativeCreateReportSpiCall f1744b;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.a = defaultCreateReportSpiCall;
        this.f1744b = nativeCreateReportSpiCall;
    }

    @Override // b.i.c.m.d.q.d.CreateReportSpiCall
    public boolean a(CreateReportRequest createReportRequest, boolean z2) {
        int iH = b.c.a.y.b.h(createReportRequest.c.d());
        if (iH == 0) {
            this.a.a(createReportRequest, z2);
            return true;
        }
        if (iH != 1) {
            return false;
        }
        this.f1744b.a(createReportRequest, z2);
        return true;
    }
}
