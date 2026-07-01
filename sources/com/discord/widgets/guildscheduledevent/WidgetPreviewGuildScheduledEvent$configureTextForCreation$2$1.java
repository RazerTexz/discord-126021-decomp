package com.discord.widgets.guildscheduledevent;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.content.ContextCompat;
import b.d.b.a.a;
import com.discord.i18n.Hook;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$configureTextForCreation$2$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent$configureTextForCreation$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent$configureTextForCreation$2$1(WidgetPreviewGuildScheduledEvent$configureTextForCreation$2 widgetPreviewGuildScheduledEvent$configureTextForCreation$2) {
        super(1);
        this.this$0 = widgetPreviewGuildScheduledEvent$configureTextForCreation$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        StringBuilder sbU = a.U(". ");
        sbU.append(this.this$0.$channelName);
        SpannableString spannableString = new SpannableString(sbU.toString());
        int iDpToPixels = DimenUtils.dpToPixels(20);
        Drawable drawable = ContextCompat.getDrawable(this.this$0.this$0.requireContext(), this.this$0.$viewState.getLocationInfo().getLocationIcon());
        m.checkNotNull(drawable);
        drawable.setBounds(0, 0, iDpToPixels, iDpToPixels);
        m.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…ze)\n                    }");
        spannableString.setSpan(new ImageSpan(drawable), 0, 1, 17);
        hook.replacementText = spannableString;
    }
}
