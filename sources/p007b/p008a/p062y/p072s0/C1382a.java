package p007b.p008a.p062y.p072s0;

import android.graphics.Bitmap;
import com.discord.views.user.UserAvatarPresenceView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p007b.p109f.p161j.p182q.AbstractC2025a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.s0.a */
/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1382a extends AbstractC2025a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ UserAvatarPresenceView.C7133c f2069a;

    public C1382a(UserAvatarPresenceView.C7133c c7133c) {
        this.f2069a = c7133c;
    }

    @Override // p007b.p109f.p161j.p182q.AbstractC2025a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            Function2<? super Bitmap, ? super String, Unit> function2 = UserAvatarPresenceView.this.onAvatarBitmapLoadedListener;
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            C12238m.checkNotNullExpressionValue(bitmapCopy, "bitmap.copy(Bitmap.Config.ARGB_8888, false)");
            function2.invoke(bitmapCopy, this.f2069a.$iconUrl);
        }
    }
}
