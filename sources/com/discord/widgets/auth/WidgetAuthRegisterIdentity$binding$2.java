package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthRegisterIdentity$binding$2 extends k implements Function1<View, WidgetAuthRegisterIdentityBinding> {
    public static final WidgetAuthRegisterIdentity$binding$2 INSTANCE = new WidgetAuthRegisterIdentity$binding$2();

    public WidgetAuthRegisterIdentity$binding$2() {
        super(1, WidgetAuthRegisterIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthRegisterIdentityBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthRegisterIdentityBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.auth_register_identity_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.auth_register_identity_button);
        if (materialButton != null) {
            i = R$id.auth_register_identity_first_segment_card;
            CardSegment cardSegment = (CardSegment) view.findViewById(R$id.auth_register_identity_first_segment_card);
            if (cardSegment != null) {
                i = R$id.auth_register_identity_input;
                PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(R$id.auth_register_identity_input);
                if (phoneOrEmailInputView != null) {
                    i = R$id.auth_register_identity_policy_link;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.auth_register_identity_policy_link);
                    if (linkifiedTextView != null) {
                        i = R$id.auth_register_identity_second_segment_card;
                        CardSegment cardSegment2 = (CardSegment) view.findViewById(R$id.auth_register_identity_second_segment_card);
                        if (cardSegment2 != null) {
                            i = R$id.auth_register_identity_segmented_control;
                            SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(R$id.auth_register_identity_segmented_control);
                            if (segmentedControlContainer != null) {
                                i = 2131363051;
                                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                                if (dimmerView != null) {
                                    return new WidgetAuthRegisterIdentityBinding((CoordinatorLayout) view, materialButton, cardSegment, phoneOrEmailInputView, linkifiedTextView, cardSegment2, segmentedControlContainer, dimmerView);
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
