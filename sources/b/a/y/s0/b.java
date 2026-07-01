package b.a.y.s0;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import com.discord.views.user.UserAvatarPresenceView$d;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends b.f.j.q.a {
    public final /* synthetic */ UserAvatarPresenceView$d a;

    public b(UserAvatarPresenceView$d userAvatarPresenceView$d) {
        this.a = userAvatarPresenceView$d;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = this.a.this$0.onAvatarBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap$Config.ARGB_8888, false);
            m.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.a.$iconUrl);
        }
    }
}
