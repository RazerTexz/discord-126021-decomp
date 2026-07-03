package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetNoiseCancellationBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetVoiceNoiseCancellationBottomSheetBinding> {
    public static final WidgetNoiseCancellationBottomSheet$binding$2 INSTANCE = new WidgetNoiseCancellationBottomSheet$binding$2();

    public WidgetNoiseCancellationBottomSheet$binding$2() {
        super(1, WidgetVoiceNoiseCancellationBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetVoiceNoiseCancellationBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.noise_cancellation_enable_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.noise_cancellation_enable_button);
        if (materialButton != null) {
            i = C5419R.id.noise_cancellation_learn_more;
            TextView textView = (TextView) view.findViewById(C5419R.id.noise_cancellation_learn_more);
            if (textView != null) {
                return new WidgetVoiceNoiseCancellationBottomSheetBinding((LinearLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
