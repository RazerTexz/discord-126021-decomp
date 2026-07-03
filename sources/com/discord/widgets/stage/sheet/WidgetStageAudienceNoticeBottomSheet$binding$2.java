package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageAudienceNoticeBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageAudienceNoticeBottomSheet$binding$2 extends C12236k implements Function1<View, WidgetStageAudienceNoticeBottomSheetBinding> {
    public static final WidgetStageAudienceNoticeBottomSheet$binding$2 INSTANCE = new WidgetStageAudienceNoticeBottomSheet$binding$2();

    public WidgetStageAudienceNoticeBottomSheet$binding$2() {
        super(1, WidgetStageAudienceNoticeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageAudienceNoticeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageAudienceNoticeBottomSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.bottom_of_bullets;
        Barrier barrier = (Barrier) view.findViewById(C5419R.id.bottom_of_bullets);
        if (barrier != null) {
            i = C5419R.id.bullet_1_icon;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.bullet_1_icon);
            if (imageView != null) {
                i = C5419R.id.bullet_1_label;
                TextView textView = (TextView) view.findViewById(C5419R.id.bullet_1_label);
                if (textView != null) {
                    i = C5419R.id.bullet_2_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.bullet_2_icon);
                    if (imageView2 != null) {
                        i = C5419R.id.bullet_2_label;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.bullet_2_label);
                        if (textView2 != null) {
                            i = C5419R.id.bullet_3_icon;
                            ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.bullet_3_icon);
                            if (imageView3 != null) {
                                i = C5419R.id.bullet_3_label;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.bullet_3_label);
                                if (textView3 != null) {
                                    i = C5419R.id.bullet_4_icon;
                                    ImageView imageView4 = (ImageView) view.findViewById(C5419R.id.bullet_4_icon);
                                    if (imageView4 != null) {
                                        i = C5419R.id.bullet_4_label;
                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.bullet_4_label);
                                        if (textView4 != null) {
                                            i = C5419R.id.button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.button);
                                            if (materialButton != null) {
                                                i = C5419R.id.sparkle;
                                                ImageView imageView5 = (ImageView) view.findViewById(C5419R.id.sparkle);
                                                if (imageView5 != null) {
                                                    i = C5419R.id.title;
                                                    TextView textView5 = (TextView) view.findViewById(C5419R.id.title);
                                                    if (textView5 != null) {
                                                        return new WidgetStageAudienceNoticeBottomSheetBinding((CoordinatorLayout) view, barrier, imageView, textView, imageView2, textView2, imageView3, textView3, imageView4, textView4, materialButton, imageView5, textView5);
                                                    }
                                                }
                                            }
                                        }
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
