package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.discord.C5419R;
import com.discord.databinding.ViewCommunityGetStartedInformationBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunityGetStartedInformationView extends CardView {
    private final ViewCommunityGetStartedInformationBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.CommunityGetStartedInformationView$initAttrs$1 */
    /* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
    public static final class C93461 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C93461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(CommunityGetStartedInformationView.this.getContext(), C5419R.attr.colorHeaderPrimary));
        }
    }

    public CommunityGetStartedInformationView(Context context) {
        this(context, null, 0, 6, null);
    }

    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initAttrs(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C5419R.a.CommunityGetStartedInformationView, 0, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tedInformationView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f15406c.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.f15407d;
        C12238m.checkNotNullExpressionValue(textView, "binding.communityListAdapterItemTextName");
        textView.setText(text);
        TextView textView2 = this.binding.f15405b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.communityListAdapterItemDescription");
        C12238m.checkNotNullExpressionValue(text2, "descriptionText");
        textView2.setText(C1107b.m215g(text2, new Object[0], new C93461()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_community_get_started_information, this);
        int i2 = C5419R.id.community_guideline;
        Guideline guideline = (Guideline) findViewById(C5419R.id.community_guideline);
        if (guideline != null) {
            i2 = C5419R.id.community_list_adapter_item_description;
            TextView textView = (TextView) findViewById(C5419R.id.community_list_adapter_item_description);
            if (textView != null) {
                i2 = C5419R.id.community_list_adapter_item_icon;
                ImageView imageView = (ImageView) findViewById(C5419R.id.community_list_adapter_item_icon);
                if (imageView != null) {
                    i2 = C5419R.id.community_list_adapter_item_text_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C5419R.id.community_list_adapter_item_text_header);
                    if (constraintLayout != null) {
                        i2 = C5419R.id.community_list_adapter_item_text_icon;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C5419R.id.community_list_adapter_item_text_icon);
                        if (relativeLayout != null) {
                            i2 = C5419R.id.community_list_adapter_item_text_name;
                            TextView textView2 = (TextView) findViewById(C5419R.id.community_list_adapter_item_text_name);
                            if (textView2 != null) {
                                ViewCommunityGetStartedInformationBinding viewCommunityGetStartedInformationBinding = new ViewCommunityGetStartedInformationBinding(this, guideline, textView, imageView, constraintLayout, relativeLayout, textView2);
                                C12238m.checkNotNullExpressionValue(viewCommunityGetStartedInformationBinding, "ViewCommunityGetStartedI…ater.from(context), this)");
                                this.binding = viewCommunityGetStartedInformationBinding;
                                if (attributeSet != null) {
                                    initAttrs(attributeSet);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
