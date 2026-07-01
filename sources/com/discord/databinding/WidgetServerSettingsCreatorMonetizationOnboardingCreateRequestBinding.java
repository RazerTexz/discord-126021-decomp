package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2559b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final EligibilityChecklistView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ViewStub g;

    @NonNull
    public final TextView h;

    @NonNull
    public final LinkifiedTextView i;

    public WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding(@NonNull ScrollView scrollView, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull EligibilityChecklistView eligibilityChecklistView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull TextView textView2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = scrollView;
        this.f2559b = materialButton;
        this.c = loadingButton;
        this.d = eligibilityChecklistView;
        this.e = imageView;
        this.f = textView;
        this.g = viewStub;
        this.h = textView2;
        this.i = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
