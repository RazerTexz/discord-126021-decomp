package com.discord.widgets.status;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.views.ReactionView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumPostStatus$binding$2 extends k implements Function1<View, WidgetForumPostStatusBinding> {
    public static final WidgetForumPostStatus$binding$2 INSTANCE = new WidgetForumPostStatus$binding$2();

    public WidgetForumPostStatus$binding$2() {
        super(1, WidgetForumPostStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumPostStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumPostStatusBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.follow_loading_indicator;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.follow_loading_indicator);
        if (progressBar != null) {
            i = R$id.following;
            TextView textView = (TextView) view.findViewById(R$id.following);
            if (textView != null) {
                i = R$id.following_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.following_container);
                if (linearLayout != null) {
                    i = R$id.message_count;
                    TextView textView2 = (TextView) view.findViewById(R$id.message_count);
                    if (textView2 != null) {
                        i = R$id.message_count_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.message_count_container);
                        if (linearLayout2 != null) {
                            i = R$id.reaction;
                            ReactionView reactionView = (ReactionView) view.findViewById(R$id.reaction);
                            if (reactionView != null) {
                                i = R$id.separator_one;
                                View viewFindViewById = view.findViewById(R$id.separator_one);
                                if (viewFindViewById != null) {
                                    i = R$id.separator_two;
                                    View viewFindViewById2 = view.findViewById(R$id.separator_two);
                                    if (viewFindViewById2 != null) {
                                        return new WidgetForumPostStatusBinding((ConstraintLayout) view, progressBar, textView, linearLayout, textView2, linearLayout2, reactionView, viewFindViewById, viewFindViewById2);
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
