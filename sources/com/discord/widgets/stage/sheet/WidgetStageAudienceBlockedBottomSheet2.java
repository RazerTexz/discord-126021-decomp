package com.discord.widgets.stage.sheet;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageAudienceBlockedBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageAudienceBlockedBottomSheetBinding> {
    public static final WidgetStageAudienceBlockedBottomSheet2 INSTANCE = new WidgetStageAudienceBlockedBottomSheet2();

    public WidgetStageAudienceBlockedBottomSheet2() {
        super(1, WidgetStageAudienceBlockedBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetStageAudienceBlockedBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.accept_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.accept_button);
        if (materialButton != null) {
            i = R.id.blocked_users;
            MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.blocked_users);
            if (maxHeightRecyclerView != null) {
                i = R.id.cancel_button;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.cancel_button);
                if (materialButton2 != null) {
                    return new WidgetStageAudienceBlockedBottomSheetBinding((ConstraintLayout) view, materialButton, maxHeightRecyclerView, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
