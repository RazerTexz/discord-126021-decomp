package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEndStageBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16598a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16599b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16600c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ScreenTitleView f16601d;

    public WidgetEndStageBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ScreenTitleView screenTitleView) {
        this.f16598a = nestedScrollView;
        this.f16599b = materialButton;
        this.f16600c = materialButton2;
        this.f16601d = screenTitleView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetEndStageBottomSheetBinding m8413a(@NonNull View view) {
        int i = C5419R.id.cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel);
        if (materialButton != null) {
            i = C5419R.id.confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm);
            if (materialButton2 != null) {
                i = C5419R.id.title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.title);
                if (screenTitleView != null) {
                    return new WidgetEndStageBottomSheetBinding((NestedScrollView) view, materialButton, materialButton2, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16598a;
    }
}
