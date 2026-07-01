package b.i.a.c.b3.n;

import android.text.Layout$Alignment;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: Cea708Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public final b.i.a.c.b3.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f853b;

    public d$a(CharSequence charSequence, Layout$Alignment layout$Alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z2, int i4, int i5) {
        boolean z3;
        int i6;
        if (z2) {
            i6 = i4;
            z3 = true;
        } else {
            z3 = false;
            i6 = ViewCompat.MEASURED_STATE_MASK;
        }
        this.a = new b.i.a.c.b3.b(charSequence, layout$Alignment, null, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z3, i6, Integer.MIN_VALUE, 0.0f, null);
        this.f853b = i5;
    }
}
