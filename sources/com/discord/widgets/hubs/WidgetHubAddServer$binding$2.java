package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubAddServerBinding;
import com.discord.views.ScreenTitleView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddServer$binding$2 extends C12236k implements Function1<View, WidgetHubAddServerBinding> {
    public static final WidgetHubAddServer$binding$2 INSTANCE = new WidgetHubAddServer$binding$2();

    public WidgetHubAddServer$binding$2() {
        super(1, WidgetHubAddServerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAddServerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubAddServerBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.discord_u_add_server_create_server;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.discord_u_add_server_create_server);
        if (materialButton != null) {
            i = C5419R.id.header;
            ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.header);
            if (screenTitleView != null) {
                i = C5419R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
                if (recyclerView != null) {
                    i = C5419R.id.segmented_control;
                    SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(C5419R.id.segmented_control);
                    if (segmentedControlContainer != null) {
                        i = C5419R.id.segmented_control_guilds_added;
                        CardSegment cardSegment = (CardSegment) view.findViewById(C5419R.id.segmented_control_guilds_added);
                        if (cardSegment != null) {
                            i = C5419R.id.segmented_control_guilds_not_added;
                            CardSegment cardSegment2 = (CardSegment) view.findViewById(C5419R.id.segmented_control_guilds_not_added);
                            if (cardSegment2 != null) {
                                return new WidgetHubAddServerBinding((LinearLayout) view, materialButton, screenTitleView, recyclerView, segmentedControlContainer, cardSegment, cardSegment2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
