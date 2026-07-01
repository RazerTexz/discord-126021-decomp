package b.i.a.c.g3.z;

import com.google.android.exoplayer2.util.GlUtil;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: ProjectionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatBuffer f1003b;
    public final FloatBuffer c;
    public final int d;

    public i$a(h$b h_b) {
        float[] fArr = h_b.c;
        this.a = fArr.length / 3;
        this.f1003b = GlUtil.b(fArr);
        this.c = GlUtil.b(h_b.d);
        int i = h_b.f1001b;
        if (i == 1) {
            this.d = 5;
        } else if (i != 2) {
            this.d = 4;
        } else {
            this.d = 6;
        }
    }
}
