package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEndStageBottomSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2382b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final ScreenTitleView d;

    public WidgetEndStageBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ScreenTitleView screenTitleView) {
        this.a = nestedScrollView;
        this.f2382b = materialButton;
        this.c = materialButton2;
        this.d = screenTitleView;
    }

    @NonNull
    public static WidgetEndStageBottomSheetBinding a(@NonNull View view) {
        int i = R.id.cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel);
        if (materialButton != null) {
            i = R.id.confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm);
            if (materialButton2 != null) {
                i = R.id.title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.title);
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
        return this.a;
    }
}
