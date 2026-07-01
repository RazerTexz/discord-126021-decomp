package b.a.y;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import com.discord.views.VoiceUserView$c;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends b.f.j.q.a {
    public final /* synthetic */ VoiceUserView$c a;

    public i0(VoiceUserView$c voiceUserView$c) {
        this.a = voiceUserView$c;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = this.a.this$0.onBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap$Config.ARGB_8888, false);
            d0.z.d.m.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$newAvatarUrl);
        }
    }
}
