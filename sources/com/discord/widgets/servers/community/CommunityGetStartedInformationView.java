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
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewCommunityGetStartedInformationBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunityGetStartedInformationView extends CardView {
    private final ViewCommunityGetStartedInformationBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.CommunityGetStartedInformationView$initAttrs$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(CommunityGetStartedInformationView.this.getContext(), R.attr.colorHeaderPrimary));
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
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.CommunityGetStartedInformationView, 0, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tedInformationView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.communityListAdapterItemTextName");
        textView.setText(text);
        TextView textView2 = this.binding.f2182b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.communityListAdapterItemDescription");
        Intrinsics3.checkNotNullExpressionValue(text2, "descriptionText");
        textView2.setText(FormatUtils.g(text2, new Object[0], new AnonymousClass1()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_community_get_started_information, this);
        int i2 = R.id.community_guideline;
        Guideline guideline = (Guideline) findViewById(R.id.community_guideline);
        if (guideline != null) {
            i2 = R.id.community_list_adapter_item_description;
            TextView textView = (TextView) findViewById(R.id.community_list_adapter_item_description);
            if (textView != null) {
                i2 = R.id.community_list_adapter_item_icon;
                ImageView imageView = (ImageView) findViewById(R.id.community_list_adapter_item_icon);
                if (imageView != null) {
                    i2 = R.id.community_list_adapter_item_text_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.community_list_adapter_item_text_header);
                    if (constraintLayout != null) {
                        i2 = R.id.community_list_adapter_item_text_icon;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.community_list_adapter_item_text_icon);
                        if (relativeLayout != null) {
                            i2 = R.id.community_list_adapter_item_text_name;
                            TextView textView2 = (TextView) findViewById(R.id.community_list_adapter_item_text_name);
                            if (textView2 != null) {
                                ViewCommunityGetStartedInformationBinding viewCommunityGetStartedInformationBinding = new ViewCommunityGetStartedInformationBinding(this, guideline, textView, imageView, constraintLayout, relativeLayout, textView2);
                                Intrinsics3.checkNotNullExpressionValue(viewCommunityGetStartedInformationBinding, "ViewCommunityGetStartedI…ater.from(context), this)");
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
