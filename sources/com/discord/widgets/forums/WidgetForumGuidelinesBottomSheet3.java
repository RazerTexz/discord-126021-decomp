package com.discord.widgets.forums;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumGuidelinesBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetForumGuidelinesBottomSheetBinding> {
    public static final WidgetForumGuidelinesBottomSheet3 INSTANCE = new WidgetForumGuidelinesBottomSheet3();

    public WidgetForumGuidelinesBottomSheet3() {
        super(1, WidgetForumGuidelinesBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetForumGuidelinesBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_topic;
        TextView textView = (TextView) view.findViewById(R.id.channel_topic);
        if (textView != null) {
            i = R.id.channel_topic_card;
            CardView cardView = (CardView) view.findViewById(R.id.channel_topic_card);
            if (cardView != null) {
                i = R.id.content;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.content);
                if (constraintLayout != null) {
                    i = R.id.got_it;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.got_it);
                    if (materialButton != null) {
                        i = R.id.sparkle;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.sparkle);
                        if (appCompatImageView != null) {
                            i = R.id.subtitle;
                            TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                            if (textView2 != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) view.findViewById(R.id.title);
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
