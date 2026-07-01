package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AcceptTermsStepCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcceptTermsStepCard$binding$2 extends o implements Function0<ViewCreatorMonetizationAcceptTermsStepCardBinding> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ AcceptTermsStepCard this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard$binding$2(AcceptTermsStepCard acceptTermsStepCard, Context context) {
        super(0);
        this.this$0 = acceptTermsStepCard;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewCreatorMonetizationAcceptTermsStepCardBinding invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewCreatorMonetizationAcceptTermsStepCardBinding invoke() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.$context);
        AcceptTermsStepCard acceptTermsStepCard = this.this$0;
        Objects.requireNonNull(acceptTermsStepCard, "parent");
        layoutInflaterFrom.inflate(R$layout.view_creator_monetization_accept_terms_step_card, acceptTermsStepCard);
        int i = R$id.description;
        TextView textView = (TextView) acceptTermsStepCard.findViewById(R$id.description);
        if (textView != null) {
            i = 2131364034;
            ImageView imageView = (ImageView) acceptTermsStepCard.findViewById(2131364034);
            if (imageView != null) {
                i = R$id.image_padding;
                Space space = (Space) acceptTermsStepCard.findViewById(R$id.image_padding);
                if (space != null) {
                    i = R$id.step_number;
                    TextView textView2 = (TextView) acceptTermsStepCard.findViewById(R$id.step_number);
                    if (textView2 != null) {
                        i = 2131365869;
                        TextView textView3 = (TextView) acceptTermsStepCard.findViewById(2131365869);
                        if (textView3 != null) {
                            return new ViewCreatorMonetizationAcceptTermsStepCardBinding(acceptTermsStepCard, textView, imageView, space, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(acceptTermsStepCard.getResources().getResourceName(i)));
    }
}
