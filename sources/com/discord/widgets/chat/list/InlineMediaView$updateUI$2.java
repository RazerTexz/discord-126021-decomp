package com.discord.widgets.chat.list;

import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import b.a.k.b;
import com.discord.player.AppMediaPlayer;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView$updateUI$2 extends o implements Function1<Float, Unit> {
    public final /* synthetic */ AppMediaPlayer $player;
    public final /* synthetic */ InlineMediaView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView$updateUI$2(InlineMediaView inlineMediaView, AppMediaPlayer appMediaPlayer) {
        super(1);
        this.this$0 = inlineMediaView;
        this.$player = appMediaPlayer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.a;
    }

    public final void invoke(float f) {
        boolean z2 = f > ((float) 0);
        InlineMediaView.access$getBinding$p(this.this$0).g.setImageDrawable(ContextCompat.getDrawable(this.this$0.getContext(), z2 ? 2131232262 : 2131232260));
        InlineMediaView.access$getBinding$p(this.this$0).g.setOnClickListener(new InlineMediaView$updateUI$2$1(this, z2));
        int i = z2 ? 2131897115 : 2131897116;
        ImageView imageView = InlineMediaView.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
        imageView.setContentDescription(b.j(this.this$0, i, new Object[0], null, 4));
    }
}
