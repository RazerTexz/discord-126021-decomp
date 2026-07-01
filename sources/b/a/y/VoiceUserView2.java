package b.a.y;

import android.graphics.Bitmap;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.y.g0, reason: use source file name */
/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView2 extends Lambda implements Function2<Bitmap, String, Unit> {
    public static final VoiceUserView2 j = new VoiceUserView2();

    public VoiceUserView2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Bitmap bitmap, String str) {
        Intrinsics3.checkNotNullParameter(bitmap, "<anonymous parameter 0>");
        return Unit.a;
    }
}
