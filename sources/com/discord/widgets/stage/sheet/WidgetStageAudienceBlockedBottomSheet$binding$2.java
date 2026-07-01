package com.discord.widgets.stage.sheet;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageAudienceBlockedBottomSheet$binding$2 extends k implements Function1<View, WidgetStageAudienceBlockedBottomSheetBinding> {
    public static final WidgetStageAudienceBlockedBottomSheet$binding$2 INSTANCE = new WidgetStageAudienceBlockedBottomSheet$binding$2();

    public WidgetStageAudienceBlockedBottomSheet$binding$2() {
        super(1, WidgetStageAudienceBlockedBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageAudienceBlockedBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageAudienceBlockedBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.accept_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.accept_button);
        if (materialButton != null) {
            i = R$id.blocked_users;
            MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R$id.blocked_users);
            if (maxHeightRecyclerView != null) {
                i = 2131362294;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(2131362294);
                if (materialButton2 != null) {
                    return new WidgetStageAudienceBlockedBottomSheetBinding((ConstraintLayout) view, materialButton, maxHeightRecyclerView, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
