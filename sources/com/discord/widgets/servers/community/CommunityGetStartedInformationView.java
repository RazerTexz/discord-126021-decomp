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
import b.a.k.b;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewCommunityGetStartedInformationBinding;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunityGetStartedInformationView extends CardView {
    private final ViewCommunityGetStartedInformationBinding binding;

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
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$a.CommunityGetStartedInformationView, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tedInformationView, 0, 0)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(2);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(0);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setImageDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.communityListAdapterItemTextName");
        textView.setText(text);
        TextView textView2 = this.binding.f2182b;
        m.checkNotNullExpressionValue(textView2, "binding.communityListAdapterItemDescription");
        m.checkNotNullExpressionValue(text2, "descriptionText");
        textView2.setText(b.g(text2, new Object[0], new CommunityGetStartedInformationView$initAttrs$1(this)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedInformationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_community_get_started_information, this);
        int i2 = R$id.community_guideline;
        Guideline guideline = (Guideline) findViewById(R$id.community_guideline);
        if (guideline != null) {
            i2 = R$id.community_list_adapter_item_description;
            TextView textView = (TextView) findViewById(R$id.community_list_adapter_item_description);
            if (textView != null) {
                i2 = R$id.community_list_adapter_item_icon;
                ImageView imageView = (ImageView) findViewById(R$id.community_list_adapter_item_icon);
                if (imageView != null) {
                    i2 = R$id.community_list_adapter_item_text_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.community_list_adapter_item_text_header);
                    if (constraintLayout != null) {
                        i2 = R$id.community_list_adapter_item_text_icon;
                        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.community_list_adapter_item_text_icon);
                        if (relativeLayout != null) {
                            i2 = R$id.community_list_adapter_item_text_name;
                            TextView textView2 = (TextView) findViewById(R$id.community_list_adapter_item_text_name);
                            if (textView2 != null) {
                                ViewCommunityGetStartedInformationBinding viewCommunityGetStartedInformationBinding = new ViewCommunityGetStartedInformationBinding(this, guideline, textView, imageView, constraintLayout, relativeLayout, textView2);
                                m.checkNotNullExpressionValue(viewCommunityGetStartedInformationBinding, "ViewCommunityGetStartedI…ater.from(context), this)");
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
