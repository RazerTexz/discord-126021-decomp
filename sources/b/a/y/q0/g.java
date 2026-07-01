package b.a.y.q0;

import android.view.View;
import com.discord.rlottie.RLottieDrawable$PlaybackMode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends o implements Function1<View, Unit> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar) {
        super(1);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        m.checkNotNullParameter(view, "it");
        this.this$0.this$0.binding.c.setPlaybackMode(RLottieDrawable$PlaybackMode.LOOP);
        this.this$0.this$0.binding.c.b();
        return Unit.a;
    }
}
