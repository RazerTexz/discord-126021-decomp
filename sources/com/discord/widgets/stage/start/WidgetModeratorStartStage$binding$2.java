package com.discord.widgets.stage.start;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.views.calls.CallEventsButtonView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetModeratorStartStage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetModeratorStartStage$binding$2 extends k implements Function1<View, WidgetModeratorStartStageBinding> {
    public static final WidgetModeratorStartStage$binding$2 INSTANCE = new WidgetModeratorStartStage$binding$2();

    public WidgetModeratorStartStage$binding$2() {
        super(1, WidgetModeratorStartStageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetModeratorStartStageBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetModeratorStartStageBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131361878;
        Toolbar toolbar = (Toolbar) view.findViewById(2131361878);
        if (toolbar != null) {
            i = 2131361879;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(2131361879);
            if (appBarLayout != null) {
                i = R$id.moderator_start_stage_exit_stage_button;
                Button button = (Button) view.findViewById(R$id.moderator_start_stage_exit_stage_button);
                if (button != null) {
                    i = 2131364898;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(2131364898);
                    if (recyclerView != null) {
                        i = R$id.toolbar_events_button;
                        CallEventsButtonView callEventsButtonView = (CallEventsButtonView) view.findViewById(R$id.toolbar_events_button);
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
