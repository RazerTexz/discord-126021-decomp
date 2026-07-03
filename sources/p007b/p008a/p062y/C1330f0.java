package p007b.p008a.p062y;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.views.VoiceUserLimitView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.y.f0 */
/* JADX INFO: compiled from: VoiceUserLimitView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1330f0 extends AbstractC12240o implements Function0<Drawable> {
    public final /* synthetic */ VoiceUserLimitView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1330f0(VoiceUserLimitView voiceUserLimitView) {
        super(0);
        this.this$0 = voiceUserLimitView;
    }

    @Override // kotlin.jvm.functions.Function0
    public Drawable invoke() {
        Drawable drawable = ContextCompat.getDrawable(this.this$0.getContext(), C5419R.drawable.ic_videocam_white_12dp);
        if (drawable != null) {
            drawable.setTint(ColorCompat.getThemedColor(this.this$0.getContext(), C5419R.attr.colorInteractiveNormal));
        }
        return drawable;
    }
}
