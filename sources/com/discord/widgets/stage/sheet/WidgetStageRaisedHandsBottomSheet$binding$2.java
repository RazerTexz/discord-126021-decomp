package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageRaisedHandsBottomSheet$binding$2 extends k implements Function1<View, WidgetStageRaisedHandsBottomSheetBinding> {
    public static final WidgetStageRaisedHandsBottomSheet$binding$2 INSTANCE = new WidgetStageRaisedHandsBottomSheet$binding$2();

    public WidgetStageRaisedHandsBottomSheet$binding$2() {
        super(1, WidgetStageRaisedHandsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageRaisedHandsBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.header;
        View viewFindViewById = view.findViewById(R$id.header);
        if (viewFindViewById != null) {
            i = R$id.raised_hands_count_label;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R$id.raised_hands_count_label);
            if (materialTextView != null) {
                i = R$id.raised_hands_empty_group;
                Group group = (Group) view.findViewById(R$id.raised_hands_empty_group);
                if (group != null) {
                    i = R$id.raised_hands_empty_sparkle;
                    ImageView imageView = (ImageView) view.findViewById(R$id.raised_hands_empty_sparkle);
                    if (imageView != null) {
                        i = R$id.raised_hands_empty_subtitle;
                        MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R$id.raised_hands_empty_subtitle);
                        if (materialTextView2 != null) {
                            i = R$id.raised_hands_empty_title;
                            MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(R$id.raised_hands_empty_title);
                            if (materialTextView3 != null) {
                                i = R$id.stage_raise_hands_enabled_toggle;
                                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R$id.stage_raise_hands_enabled_toggle);
                                if (switchMaterial != null) {
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                    i = R$id.stage_raised_hands_recycler;
                                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R$id.stage_raised_hands_recycler);
                                    if (maxHeightRecyclerView != null) {
                                        i = R$id.subtitle;
                                        MaterialTextView materialTextView4 = (MaterialTextView) view.findViewById(R$id.subtitle);
                                        if (materialTextView4 != null) {
                                            i = 2131365869;
                                            MaterialTextView materialTextView5 = (MaterialTextView) view.findViewById(2131365869);
                                            if (materialTextView5 != null) {
                                                i = R$id.toggle_speaker_state_button;
                                                MaterialTextView materialTextView6 = (MaterialTextView) view.findViewById(R$id.toggle_speaker_state_button);
                                                if (materialTextView6 != null) {
                                                    i = R$id.toggle_speaker_state_group;
                                                    Group group2 = (Group) view.findViewById(R$id.toggle_speaker_state_group);
                                                    if (group2 != null) {
                                                        i = R$id.toggle_speaker_state_icon;
                                                        ImageView imageView2 = (ImageView) view.findViewById(R$id.toggle_speaker_state_icon);
                                                        if (imageView2 != null) {
                                                            return new WidgetStageRaisedHandsBottomSheetBinding(coordinatorLayout, viewFindViewById, materialTextView, group, imageView, materialTextView2, materialTextView3, switchMaterial, coordinatorLayout, maxHeightRecyclerView, materialTextView4, materialTextView5, materialTextView6, group2, imageView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
