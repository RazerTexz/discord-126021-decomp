package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: AcceptTermsStepCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcceptTermsStepCard$binding$2 extends AbstractC12240o implements Function0<ViewCreatorMonetizationAcceptTermsStepCardBinding> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ AcceptTermsStepCard this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard$binding$2(AcceptTermsStepCard acceptTermsStepCard, Context context) {
        super(0);
        this.this$0 = acceptTermsStepCard;
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewCreatorMonetizationAcceptTermsStepCardBinding invoke() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.$context);
        AcceptTermsStepCard acceptTermsStepCard = this.this$0;
        Objects.requireNonNull(acceptTermsStepCard, "parent");
        layoutInflaterFrom.inflate(C5419R.layout.view_creator_monetization_accept_terms_step_card, acceptTermsStepCard);
        int i = C5419R.id.description;
        TextView textView = (TextView) acceptTermsStepCard.findViewById(C5419R.id.description);
        if (textView != null) {
            i = C5419R.id.image;
            ImageView imageView = (ImageView) acceptTermsStepCard.findViewById(C5419R.id.image);
            if (imageView != null) {
                i = C5419R.id.image_padding;
                Space space = (Space) acceptTermsStepCard.findViewById(C5419R.id.image_padding);
                if (space != null) {
                    i = C5419R.id.step_number;
                    TextView textView2 = (TextView) acceptTermsStepCard.findViewById(C5419R.id.step_number);
                    if (textView2 != null) {
                        i = C5419R.id.title;
                        TextView textView3 = (TextView) acceptTermsStepCard.findViewById(C5419R.id.title);
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
