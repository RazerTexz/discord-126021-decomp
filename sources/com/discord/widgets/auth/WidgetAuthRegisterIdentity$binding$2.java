package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthRegisterIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthRegisterIdentity$binding$2 extends C12236k implements Function1<View, WidgetAuthRegisterIdentityBinding> {
    public static final WidgetAuthRegisterIdentity$binding$2 INSTANCE = new WidgetAuthRegisterIdentity$binding$2();

    public WidgetAuthRegisterIdentity$binding$2() {
        super(1, WidgetAuthRegisterIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthRegisterIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetAuthRegisterIdentityBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_register_identity_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_register_identity_button);
        if (materialButton != null) {
            i = C5419R.id.auth_register_identity_first_segment_card;
            CardSegment cardSegment = (CardSegment) view.findViewById(C5419R.id.auth_register_identity_first_segment_card);
            if (cardSegment != null) {
                i = C5419R.id.auth_register_identity_input;
                PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(C5419R.id.auth_register_identity_input);
                if (phoneOrEmailInputView != null) {
                    i = C5419R.id.auth_register_identity_policy_link;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.auth_register_identity_policy_link);
                    if (linkifiedTextView != null) {
                        i = C5419R.id.auth_register_identity_second_segment_card;
                        CardSegment cardSegment2 = (CardSegment) view.findViewById(C5419R.id.auth_register_identity_second_segment_card);
                        if (cardSegment2 != null) {
                            i = C5419R.id.auth_register_identity_segmented_control;
                            SegmentedControlContainer segmentedControlContainer = (SegmentedControlContainer) view.findViewById(C5419R.id.auth_register_identity_segmented_control);
                            if (segmentedControlContainer != null) {
                                i = C5419R.id.dimmer_view;
                                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
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
