package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetNoiseCancellationBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceNoiseCancellationBottomSheetBinding> {
    public static final WidgetNoiseCancellationBottomSheet2 INSTANCE = new WidgetNoiseCancellationBottomSheet2();

    public WidgetNoiseCancellationBottomSheet2() {
        super(1, WidgetVoiceNoiseCancellationBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetVoiceNoiseCancellationBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.noise_cancellation_enable_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.noise_cancellation_enable_button);
        if (materialButton != null) {
            i = R.id.noise_cancellation_learn_more;
            TextView textView = (TextView) view.findViewById(R.id.noise_cancellation_learn_more);
            if (textView != null) {
                return new WidgetVoiceNoiseCancellationBottomSheetBinding((LinearLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
