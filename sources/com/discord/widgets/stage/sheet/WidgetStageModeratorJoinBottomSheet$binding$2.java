package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageModeratorJoinBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetStageModeratorJoinBottomSheetBinding> {
    public static final WidgetStageModeratorJoinBottomSheet$binding$2 INSTANCE = new WidgetStageModeratorJoinBottomSheet$binding$2();

    public WidgetStageModeratorJoinBottomSheet$binding$2() {
        super(1, WidgetStageModeratorJoinBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageModeratorJoinBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.join_audience;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.join_audience);
        if (materialButton != null) {
            i = C5419R.id.join_speaker;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.join_speaker);
            if (materialButton2 != null) {
                i = C5419R.id.sparkle;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.sparkle);
                if (appCompatImageView != null) {
                    i = C5419R.id.subtitle;
                    TextView textView = (TextView) view.findViewById(C5419R.id.subtitle);
                    if (textView != null) {
                        i = C5419R.id.title;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.title);
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
