package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChoosePlanAdapterPlanItemBinding implements ViewBinding {

    @NonNull
    public final MaterialCardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2348b;

    @NonNull
    public final MaterialCardView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetChoosePlanAdapterPlanItemBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = materialCardView;
        this.f2348b = imageView;
        this.c = materialCardView2;
        this.d = textView;
        this.e = imageView2;
        this.f = textView2;
        this.g = textView3;
    }

    @NonNull
    public static WidgetChoosePlanAdapterPlanItemBinding a(@NonNull View view) {
        int i = R$id.plan_item_border;
        ImageView imageView = (ImageView) view.findViewById(R$id.plan_item_border);
        if (imageView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = R$id.plan_item_current_plan;
            TextView textView = (TextView) view.findViewById(R$id.plan_item_current_plan);
            if (textView != null) {
                i = R$id.plan_item_icon;
                ImageView imageView2 = (ImageView) view.findViewById(R$id.plan_item_icon);
                if (imageView2 != null) {
                    i = R$id.plan_item_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.plan_item_name);
                    if (textView2 != null) {
                        i = R$id.plan_item_price;
                        TextView textView3 = (TextView) view.findViewById(R$id.plan_item_price);
                        if (textView3 != null) {
                            return new WidgetChoosePlanAdapterPlanItemBinding(materialCardView, imageView, materialCardView, textView, imageView2, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
