package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding implements ViewBinding {

    @NonNull
    public final ScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2557b;

    @NonNull
    public final CheckBox c;

    @NonNull
    public final ScrollView d;

    @NonNull
    public final ViewStub e;

    public WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding(@NonNull ScrollView scrollView, @NonNull LoadingButton loadingButton, @NonNull CheckBox checkBox, @NonNull ScrollView scrollView2, @NonNull ViewStub viewStub) {
        this.a = scrollView;
        this.f2557b = loadingButton;
        this.c = checkBox;
        this.d = scrollView2;
        this.e = viewStub;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
