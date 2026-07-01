package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageModeratorJoinBottomSheet$binding$2 extends k implements Function1<View, WidgetStageModeratorJoinBottomSheetBinding> {
    public static final WidgetStageModeratorJoinBottomSheet$binding$2 INSTANCE = new WidgetStageModeratorJoinBottomSheet$binding$2();

    public WidgetStageModeratorJoinBottomSheet$binding$2() {
        super(1, WidgetStageModeratorJoinBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageModeratorJoinBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageModeratorJoinBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.join_audience;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.join_audience);
        if (materialButton != null) {
            i = R$id.join_speaker;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.join_speaker);
            if (materialButton2 != null) {
                i = R$id.sparkle;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.sparkle);
                if (appCompatImageView != null) {
                    i = R$id.subtitle;
                    TextView textView = (TextView) view.findViewById(R$id.subtitle);
                    if (textView != null) {
                        i = 2131365869;
                        TextView textView2 = (TextView) view.findViewById(2131365869);
                        if (textView2 != null) {
                            return new WidgetStageModeratorJoinBottomSheetBinding((CoordinatorLayout) view, materialButton, materialButton2, appCompatImageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
