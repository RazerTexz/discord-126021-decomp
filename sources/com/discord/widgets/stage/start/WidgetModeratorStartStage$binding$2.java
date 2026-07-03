package com.discord.widgets.stage.start;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.views.calls.CallEventsButtonView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetModeratorStartStage$binding$2 extends C12236k implements Function1<View, WidgetModeratorStartStageBinding> {
    public static final WidgetModeratorStartStage$binding$2 INSTANCE = new WidgetModeratorStartStage$binding$2();

    public WidgetModeratorStartStage$binding$2() {
        super(1, WidgetModeratorStartStageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetModeratorStartStageBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = C5419R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = C5419R.id.moderator_start_stage_exit_stage_button;
                Button button = (Button) view.findViewById(C5419R.id.moderator_start_stage_exit_stage_button);
                if (button != null) {
                    i = C5419R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
                    if (recyclerView != null) {
                        i = C5419R.id.toolbar_events_button;
                        CallEventsButtonView callEventsButtonView = (CallEventsButtonView) view.findViewById(C5419R.id.toolbar_events_button);
                        if (callEventsButtonView != null) {
                            return new WidgetModeratorStartStageBinding((ConstraintLayout) view, toolbar, appBarLayout, button, recyclerView, callEventsButtonView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
