package b.a.y;

import android.graphics.Bitmap;
import b.f.j.q.BasePostprocessor;
import com.discord.views.VoiceUserView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.y.i0, reason: use source file name */
/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView4 extends BasePostprocessor {
    public final /* synthetic */ VoiceUserView.c a;

    public VoiceUserView4(VoiceUserView.c cVar) {
        this.a = cVar;
    }

    @Override // b.f.j.q.BasePostprocessor
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = VoiceUserView.this.onBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$newAvatarUrl);
        }
    }
}
