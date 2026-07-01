package com.discord.widgets.servers.creator_monetization_eligibility;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.h2;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EligibilityChecklistView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EligibilityChecklistView extends LinearLayout {
    private List<EligibilityChecklistView$Requirement> lastRequirements;

    public EligibilityChecklistView(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ EligibilityChecklistView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bind(List<EligibilityChecklistView$Requirement> requirements) {
        m.checkNotNullParameter(requirements, "requirements");
        if (m.areEqual(requirements, this.lastRequirements)) {
            return;
        }
        removeAllViews();
        Drawable colorDrawable = new ColorDrawable(ColorCompat.getThemedColor(this, 2130968896));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        boolean z2 = true;
        for (EligibilityChecklistView$Requirement eligibilityChecklistView$Requirement : requirements) {
            if (z2) {
                z2 = false;
            } else {
                View view = new View(getContext());
                view.setBackground(colorDrawable);
                ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = new ViewGroup$MarginLayoutParams(-1, DimenUtils.dpToPixels(1));
                viewGroup$MarginLayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                viewGroup$MarginLayoutParams.rightMargin = DimenUtils.dpToPixels(16);
                view.setLayoutParams(viewGroup$MarginLayoutParams);
                addView(view);
            }
            View viewInflate = layoutInflaterFrom.inflate(R$layout.view_eligibility_checklist_row, (ViewGroup) null, false);
            int i = R$id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R$id.description);
            if (linkifiedTextView != null) {
                i = R$id.eligibility_indicator;
                ImageView imageView = (ImageView) viewInflate.findViewById(R$id.eligibility_indicator);
                if (imageView != null) {
                    i = 2131365869;
                    TextView textView = (TextView) viewInflate.findViewById(2131365869);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                        m.checkNotNullExpressionValue(new h2(constraintLayout, linkifiedTextView, imageView, textView), "ViewEligibilityChecklist…g.inflate(layoutInflater)");
                        m.checkNotNullExpressionValue(imageView, "eligibilityIndicator");
                        imageView.setActivated(eligibilityChecklistView$Requirement.isMet());
                        m.checkNotNullExpressionValue(textView, "title");
                        textView.setText(eligibilityChecklistView$Requirement.getTitle());
                        m.checkNotNullExpressionValue(linkifiedTextView, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                        linkifiedTextView.setText(eligibilityChecklistView$Requirement.getDescription());
                        addView(constraintLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setOrientation(1);
        if (isInEditMode()) {
            CharSequence charSequenceJ = b.j(this, 2131890560, new Object[]{50}, null, 4);
            String string = getResources().getString(2131890559);
            m.checkNotNullExpressionValue(string, "resources.getString(\n   …cription,\n              )");
            String string2 = getResources().getString(2131890569);
            m.checkNotNullExpressionValue(string2, "resources.getString(\n   …_eligible\n              )");
            String string3 = getResources().getString(2131890568);
            m.checkNotNullExpressionValue(string3, "resources.getString(\n   …cription,\n              )");
            bind(n.listOf((Object[]) new EligibilityChecklistView$Requirement[]{new EligibilityChecklistView$Requirement(charSequenceJ, string, true), new EligibilityChecklistView$Requirement(string2, string3, true)}));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EligibilityChecklistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.lastRequirements = n.emptyList();
    }
}
