package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageStartEventBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageStartEventBottomSheetBinding> {
    public static final WidgetStageStartEventBottomSheet2 INSTANCE = new WidgetStageStartEventBottomSheet2();

    public WidgetStageStartEventBottomSheet2() {
        super(1, WidgetStageStartEventBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageStartEventBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.sparkle;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.sparkle);
        if (appCompatImageView != null) {
            i = R.id.speaker_hint;
            TextView textView = (TextView) view.findViewById(R.id.speaker_hint);
            if (textView != null) {
                i = R.id.start_stage_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.start_stage_button);
                if (materialButton != null) {
                    i = R.id.subtitle;
                    TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                    if (textView2 != null) {
                        i = R.id.title;
                        TextView textView3 = (TextView) view.findViewById(R.id.title);
                        if (textView3 != null) {
                            i = R.id.topic_input;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R.id.topic_input);
                            if (textInputEditText != null) {
                                i = R.id.topic_label;
                                TextView textView4 = (TextView) view.findViewById(R.id.topic_label);
                                if (textView4 != null) {
                                    i = R.id.topic_layout;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.topic_layout);
                                    if (textInputLayout != null) {
                                        return new WidgetStageStartEventBottomSheetBinding((CoordinatorLayout) view, appCompatImageView, textView, materialButton, textView2, textView3, textInputEditText, textView4, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
