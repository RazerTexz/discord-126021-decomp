package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChoosePlanAdapterPlanItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final MaterialCardView f16376a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16377b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialCardView f16378c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16379d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f16380e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16381f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16382g;

    public WidgetChoosePlanAdapterPlanItemBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16376a = materialCardView;
        this.f16377b = imageView;
        this.f16378c = materialCardView2;
        this.f16379d = textView;
        this.f16380e = imageView2;
        this.f16381f = textView2;
        this.f16382g = textView3;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChoosePlanAdapterPlanItemBinding m8412a(@NonNull View view) {
        int i = C5419R.id.plan_item_border;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.plan_item_border);
        if (imageView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = C5419R.id.plan_item_current_plan;
            TextView textView = (TextView) view.findViewById(C5419R.id.plan_item_current_plan);
            if (textView != null) {
                i = C5419R.id.plan_item_icon;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.plan_item_icon);
                if (imageView2 != null) {
                    i = C5419R.id.plan_item_name;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.plan_item_name);
                    if (textView2 != null) {
                        i = C5419R.id.plan_item_price;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.plan_item_price);
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
        return this.f16376a;
    }
}
