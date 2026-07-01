package com.discord.widgets.stage.start;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.views.calls.CallEventsButtonView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetModeratorStartStage2 extends FunctionReferenceImpl implements Function1<View, WidgetModeratorStartStageBinding> {
    public static final WidgetModeratorStartStage2 INSTANCE = new WidgetModeratorStartStage2();

    public WidgetModeratorStartStage2() {
        super(1, WidgetModeratorStartStageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetModeratorStartStageBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = R.id.moderator_start_stage_exit_stage_button;
                Button button = (Button) view.findViewById(R.id.moderator_start_stage_exit_stage_button);
                if (button != null) {
                    i = R.id.recycler_view;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                    if (recyclerView != null) {
                        i = R.id.toolbar_events_button;
                        CallEventsButtonView callEventsButtonView = (CallEventsButtonView) view.findViewById(R.id.toolbar_events_button);
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
