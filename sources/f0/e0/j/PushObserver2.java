package f0.e0.j;

import g0.BufferedSource;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: f0.e0.j.r, reason: use source file name */
/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface PushObserver2 {
    public static final PushObserver2 a = new PushObserver();

    boolean a(int i, List<Header2> list);

    boolean b(int i, List<Header2> list, boolean z2);

    void c(int i, ErrorCode2 errorCode2);

    boolean d(int i, BufferedSource bufferedSource, int i2, boolean z2) throws IOException;
}
