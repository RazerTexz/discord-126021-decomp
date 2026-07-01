package b.a.y;

import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.discord.utilities.color.ColorCompat;
import com.discord.views.VoiceUserLimitView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceUserLimitView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends d0.z.d.o implements Function0<Drawable> {
    public final /* synthetic */ VoiceUserLimitView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(VoiceUserLimitView voiceUserLimitView) {
        super(0);
        this.this$0 = voiceUserLimitView;
    }

    @Override // kotlin.jvm.functions.Function0
    public Drawable invoke() {
        Drawable drawable = ContextCompat.getDrawable(this.this$0.getContext(), 2131232246);
        if (drawable != null) {
            drawable.setTint(ColorCompat.getThemedColor(this.this$0.getContext(), 2130969008));
        }
        return drawable;
    }
}
