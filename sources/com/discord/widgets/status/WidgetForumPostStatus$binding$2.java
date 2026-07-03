package com.discord.widgets.status;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetForumPostStatusBinding;
import com.discord.views.ReactionView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetForumPostStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumPostStatus$binding$2 extends C12236k implements Function1<View, WidgetForumPostStatusBinding> {
    public static final WidgetForumPostStatus$binding$2 INSTANCE = new WidgetForumPostStatus$binding$2();

    public WidgetForumPostStatus$binding$2() {
        super(1, WidgetForumPostStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumPostStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetForumPostStatusBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.follow_loading_indicator;
        ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.follow_loading_indicator);
        if (progressBar != null) {
            i = C5419R.id.following;
            TextView textView = (TextView) view.findViewById(C5419R.id.following);
            if (textView != null) {
                i = C5419R.id.following_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.following_container);
                if (linearLayout != null) {
                    i = C5419R.id.message_count;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.message_count);
                    if (textView2 != null) {
                        i = C5419R.id.message_count_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.message_count_container);
                        if (linearLayout2 != null) {
                            i = C5419R.id.reaction;
                            ReactionView reactionView = (ReactionView) view.findViewById(C5419R.id.reaction);
                            if (reactionView != null) {
                                i = C5419R.id.separator_one;
                                View viewFindViewById = view.findViewById(C5419R.id.separator_one);
                                if (viewFindViewById != null) {
                                    i = C5419R.id.separator_two;
                                    View viewFindViewById2 = view.findViewById(C5419R.id.separator_two);
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
