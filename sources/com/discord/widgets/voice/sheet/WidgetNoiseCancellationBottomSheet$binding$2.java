package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetNoiseCancellationBottomSheet$binding$2 extends k implements Function1<View, WidgetVoiceNoiseCancellationBottomSheetBinding> {
    public static final WidgetNoiseCancellationBottomSheet$binding$2 INSTANCE = new WidgetNoiseCancellationBottomSheet$binding$2();

    public WidgetNoiseCancellationBottomSheet$binding$2() {
        super(1, WidgetVoiceNoiseCancellationBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceNoiseCancellationBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceNoiseCancellationBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.noise_cancellation_enable_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.noise_cancellation_enable_button);
        if (materialButton != null) {
            i = R$id.noise_cancellation_learn_more;
            TextView textView = (TextView) view.findViewById(R$id.noise_cancellation_learn_more);
            if (textView != null) {
                return new WidgetVoiceNoiseCancellationBottomSheetBinding((LinearLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
