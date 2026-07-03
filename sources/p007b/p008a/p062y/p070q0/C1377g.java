package p007b.p008a.p062y.p070q0;

import android.view.View;
import com.discord.rlottie.RLottieDrawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.q0.g */
/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1377g extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ C1378h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1377g(C1378h c1378h) {
        super(1);
        this.this$0 = c1378h;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        C12238m.checkNotNullParameter(view, "it");
        this.this$0.this$0.binding.f1178c.setPlaybackMode(RLottieDrawable.PlaybackMode.LOOP);
        this.this$0.this$0.binding.f1178c.m8449b();
        return Unit.f27425a;
    }
}
