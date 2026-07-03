package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.TypedArrayKt;
import androidx.core.view.ViewGroupKt;
import com.discord.C5419R;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.C12083g;
import p507d0.p578f0.C12078q;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AcceptTermsStepCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcceptTermsStepCard extends ConstraintLayout {

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;

    @StringRes
    private int descriptionStringRes;

    @DrawableRes
    private int imageSrcRes;
    private int stepNumber;
    private String termsUrl;

    @StringRes
    private int titleStringRes;

    /* JADX WARN: Multi-variable type inference failed */
    public AcceptTermsStepCard(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AcceptTermsStepCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final ViewCreatorMonetizationAcceptTermsStepCardBinding getBinding() {
        return (ViewCreatorMonetizationAcceptTermsStepCardBinding) this.binding.getValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        List<View> list = C12078q.toList(ViewGroupKt.getChildren(this));
        TextView textView = getBinding().f15418e;
        C12238m.checkNotNullExpressionValue(textView, "binding.stepNumber");
        textView.setText(String.valueOf(this.stepNumber));
        getBinding().f15416c.setImageResource(this.imageSrcRes);
        TextView textView2 = getBinding().f15419f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.title");
        C1107b.m221m(textView2, this.titleStringRes, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        if (this.termsUrl != null) {
            TextView textView3 = getBinding().f15415b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.description");
            C1107b.m221m(textView3, this.descriptionStringRes, new Object[]{this.termsUrl}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            TextView textView4 = getBinding().f15415b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.description");
            C1107b.m221m(textView4, this.descriptionStringRes, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        TextView textView5 = getBinding().f15415b;
        C12238m.checkNotNullExpressionValue(textView5, "binding.description");
        int id2 = textView5.getId();
        for (View view : list) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(view.getLayoutParams());
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
            layoutParams.topToBottom = id2;
            Space space = getBinding().f15417d;
            C12238m.checkNotNullExpressionValue(space, "binding.imagePadding");
            layoutParams.startToEnd = space.getId();
            layoutParams.endToEnd = 0;
            view.setLayoutParams(layoutParams);
            id2 = view.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        this.binding = C12083g.lazy(new AcceptTermsStepCard$binding$2(this, context));
        int[] iArr = C5419R.a.AcceptTermsStepCard;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.AcceptTermsStepCard");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.stepNumber = TypedArrayKt.getIntOrThrow(typedArrayObtainStyledAttributes, 2);
        this.imageSrcRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 0);
        this.titleStringRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 3);
        this.descriptionStringRes = TypedArrayKt.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 1);
        this.termsUrl = typedArrayObtainStyledAttributes.getString(4);
        typedArrayObtainStyledAttributes.recycle();
    }
}
