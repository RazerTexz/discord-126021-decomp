package com.discord.widgets.forums;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumGuidelinesBottomSheet$binding$2 extends k implements Function1<View, WidgetForumGuidelinesBottomSheetBinding> {
    public static final WidgetForumGuidelinesBottomSheet$binding$2 INSTANCE = new WidgetForumGuidelinesBottomSheet$binding$2();

    public WidgetForumGuidelinesBottomSheet$binding$2() {
        super(1, WidgetForumGuidelinesBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumGuidelinesBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumGuidelinesBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.channel_topic;
        TextView textView = (TextView) view.findViewById(R$id.channel_topic);
        if (textView != null) {
            i = R$id.channel_topic_card;
            CardView cardView = (CardView) view.findViewById(R$id.channel_topic_card);
            if (cardView != null) {
                i = 2131362884;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(2131362884);
                if (constraintLayout != null) {
                    i = R$id.got_it;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.got_it);
                    if (materialButton != null) {
                        i = R$id.sparkle;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.sparkle);
                        if (appCompatImageView != null) {
                            i = R$id.subtitle;
                            TextView textView2 = (TextView) view.findViewById(R$id.subtitle);
                            if (textView2 != null) {
                                i = 2131365869;
                                TextView textView3 = (TextView) view.findViewById(2131365869);
                                if (textView3 != null) {
                                    return new WidgetForumGuidelinesBottomSheetBinding((NestedScrollView) view, textView, cardView, constraintLayout, materialButton, appCompatImageView, textView2, textView3);
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
