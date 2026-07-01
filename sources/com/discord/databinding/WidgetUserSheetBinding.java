package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetBinding implements ViewBinding {

    @NonNull
    public final TextInputEditText A;

    @NonNull
    public final TextInputLayout B;

    @NonNull
    public final Button C;

    @NonNull
    public final LinearLayout D;

    @NonNull
    public final View E;

    @NonNull
    public final MaterialButton F;

    @NonNull
    public final FrameLayout G;

    @NonNull
    public final MaterialButton H;

    @NonNull
    public final FlexboxLayout I;

    @NonNull
    public final UserProfileHeaderView J;

    @NonNull
    public final MaterialButton K;

    @NonNull
    public final CardView L;

    @NonNull
    public final UserProfileStageActionsView M;

    @NonNull
    public final TextView N;

    @NonNull
    public final UserProfileVoiceSettingsView O;

    @NonNull
    public final RolesListView P;

    @NonNull
    public final Button Q;

    @NonNull
    public final CardView R;

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f2693b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final FlexboxLayout f;

    @NonNull
    public final LinkifiedTextView g;

    @NonNull
    public final FrameLayout h;

    @NonNull
    public final Button i;

    @NonNull
    public final CardView j;

    @NonNull
    public final UserProfileAdminView k;

    @NonNull
    public final Button l;

    @NonNull
    public final TextView m;

    @NonNull
    public final UserProfileConnectionsView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final MaterialButton q;

    @NonNull
    public final MaterialButton r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2694s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final TextView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final FrameLayout w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final Button f2695x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final ImageView f2696y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final TextView f2697z;

    public WidgetUserSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull CardView cardView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FlexboxLayout flexboxLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ContentLoadingProgressBar contentLoadingProgressBar, @NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull CardView cardView2, @NonNull UserProfileAdminView userProfileAdminView, @NonNull Button button2, @NonNull TextView textView3, @NonNull UserProfileConnectionsView userProfileConnectionsView, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull FrameLayout frameLayout2, @NonNull Button button3, @NonNull ImageView imageView, @NonNull TextView textView8, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button4, @NonNull LinearLayout linearLayout4, @NonNull View view, @NonNull MaterialButton materialButton3, @NonNull FrameLayout frameLayout3, @NonNull MaterialButton materialButton4, @NonNull FlexboxLayout flexboxLayout2, @NonNull UserProfileHeaderView userProfileHeaderView, @NonNull MaterialButton materialButton5, @NonNull CardView cardView3, @NonNull UserProfileStageActionsView userProfileStageActionsView, @NonNull TextView textView9, @NonNull UserProfileVoiceSettingsView userProfileVoiceSettingsView, @NonNull RolesListView rolesListView, @NonNull Button button5, @NonNull CardView cardView4) {
        this.a = nestedScrollView;
        this.f2693b = cardView;
        this.c = simpleDraweeView;
        this.d = textView;
        this.e = textView2;
        this.f = flexboxLayout;
        this.g = linkifiedTextView;
        this.h = frameLayout;
        this.i = button;
        this.j = cardView2;
        this.k = userProfileAdminView;
        this.l = button2;
        this.m = textView3;
        this.n = userProfileConnectionsView;
        this.o = textView4;
        this.p = textView5;
        this.q = materialButton;
        this.r = materialButton2;
        this.f2694s = linearLayout2;
        this.t = linearLayout3;
        this.u = textView6;
        this.v = textView7;
        this.w = frameLayout2;
        this.f2695x = button3;
        this.f2696y = imageView;
        this.f2697z = textView8;
        this.A = textInputEditText;
        this.B = textInputLayout;
        this.C = button4;
        this.D = linearLayout4;
        this.E = view;
        this.F = materialButton3;
        this.G = frameLayout3;
        this.H = materialButton4;
        this.I = flexboxLayout2;
        this.J = userProfileHeaderView;
        this.K = materialButton5;
        this.L = cardView3;
        this.M = userProfileStageActionsView;
        this.N = textView9;
        this.O = userProfileVoiceSettingsView;
        this.P = rolesListView;
        this.Q = button5;
        this.R = cardView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
