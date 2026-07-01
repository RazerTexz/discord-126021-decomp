package com.discord.widgets.servers.creator_monetization_eligibility;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewEligibilityChecklistRowBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EligibilityChecklistView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EligibilityChecklistView extends LinearLayout {
    private List<Requirement> lastRequirements;

    /* JADX INFO: compiled from: EligibilityChecklistView.kt */
    public static final /* data */ class Requirement {
        private final CharSequence description;
        private final boolean isMet;
        private final CharSequence title;

        public Requirement(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
            Intrinsics3.checkNotNullParameter(charSequence, "title");
            Intrinsics3.checkNotNullParameter(charSequence2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            this.title = charSequence;
            this.description = charSequence2;
            this.isMet = z2;
        }

        public static /* synthetic */ Requirement copy$default(Requirement requirement, CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = requirement.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = requirement.description;
            }
            if ((i & 4) != 0) {
                z2 = requirement.isMet;
            }
            return requirement.copy(charSequence, charSequence2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMet() {
            return this.isMet;
        }

        public final Requirement copy(CharSequence title, CharSequence description, boolean isMet) {
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            return new Requirement(title, description, isMet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Requirement)) {
                return false;
            }
            Requirement requirement = (Requirement) other;
            return Intrinsics3.areEqual(this.title, requirement.title) && Intrinsics3.areEqual(this.description, requirement.description) && this.isMet == requirement.isMet;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.description;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            boolean z2 = this.isMet;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isMet() {
            return this.isMet;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Requirement(title=");
            sbU.append(this.title);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", isMet=");
            return outline.O(sbU, this.isMet, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EligibilityChecklistView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EligibilityChecklistView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bind(List<Requirement> requirements) {
        Intrinsics3.checkNotNullParameter(requirements, "requirements");
        if (Intrinsics3.areEqual(requirements, this.lastRequirements)) {
            return;
        }
        removeAllViews();
        Drawable colorDrawable = new ColorDrawable(ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        boolean z2 = true;
        for (Requirement requirement : requirements) {
            if (z2) {
                z2 = false;
            } else {
                View view = new View(getContext());
                view.setBackground(colorDrawable);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, DimenUtils.dpToPixels(1));
                marginLayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                marginLayoutParams.rightMargin = DimenUtils.dpToPixels(16);
                view.setLayoutParams(marginLayoutParams);
                addView(view);
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_eligibility_checklist_row, (ViewGroup) null, false);
            int i = R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.description);
            if (linkifiedTextView != null) {
                i = R.id.eligibility_indicator;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.eligibility_indicator);
                if (imageView != null) {
                    i = R.id.title;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.title);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new ViewEligibilityChecklistRowBinding(constraintLayout, linkifiedTextView, imageView, textView), "ViewEligibilityChecklist…g.inflate(layoutInflater)");
                        Intrinsics3.checkNotNullExpressionValue(imageView, "eligibilityIndicator");
                        imageView.setActivated(requirement.isMet());
                        Intrinsics3.checkNotNullExpressionValue(textView, "title");
                        textView.setText(requirement.getTitle());
                        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                        linkifiedTextView.setText(requirement.getDescription());
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
            CharSequence charSequenceD = FormatUtils.d(this, R.string.guild_role_subscription_settings_eligibility_requirement_members_eligible, new Object[]{50}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            String string = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_description);
            Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(\n   …cription,\n              )");
            String string2 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_eligible);
            Intrinsics3.checkNotNullExpressionValue(string2, "resources.getString(\n   …_eligible\n              )");
            String string3 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_description);
            Intrinsics3.checkNotNullExpressionValue(string3, "resources.getString(\n   …cription,\n              )");
            bind(Collections2.listOf((Object[]) new Requirement[]{new Requirement(charSequenceD, string, true), new Requirement(string2, string3, true)}));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EligibilityChecklistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.lastRequirements = Collections2.emptyList();
    }
}
