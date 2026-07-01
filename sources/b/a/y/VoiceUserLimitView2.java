package b.a.y;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.views.VoiceUserLimitView;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.y.f0, reason: use source file name */
/* JADX INFO: compiled from: VoiceUserLimitView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserLimitView2 extends Lambda implements Function0<Drawable> {
    public final /* synthetic */ VoiceUserLimitView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserLimitView2(VoiceUserLimitView voiceUserLimitView) {
        super(0);
        this.this$0 = voiceUserLimitView;
    }

    @Override // kotlin.jvm.functions.Function0
    public Drawable invoke() {
        Drawable drawable = ContextCompat.getDrawable(this.this$0.getContext(), R.drawable.ic_videocam_white_12dp);
        if (drawable != null) {
            drawable.setTint(ColorCompat.getThemedColor(this.this$0.getContext(), R.attr.colorInteractiveNormal));
        }
        return drawable;
    }
}
