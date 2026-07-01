package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.p4;
import b.a.i.q4;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.views.calls.StageCallVisitCommunityView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VoiceCallActiveEventView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.voice.controls.VoiceControlsSheetView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Toolbar f2245b;

    @NonNull
    public final AppBarLayout c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final p4 e;

    @NonNull
    public final CoordinatorLayout f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final TextView h;

    @NonNull
    public final ConstraintLayout i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final MaterialButton k;

    @NonNull
    public final VideoCallParticipantView l;

    @NonNull
    public final RecyclerView m;

    @NonNull
    public final MaterialButton n;

    @NonNull
    public final ConstraintLayout o;

    @NonNull
    public final RecyclerView p;

    @NonNull
    public final StageCallVisitCommunityView q;

    @NonNull
    public final ViewStub r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final q4 f2246s;

    @NonNull
    public final ConstraintLayout t;

    @NonNull
    public final UserSummaryView u;

    @NonNull
    public final MaterialTextView v;

    @NonNull
    public final CallEventsButtonView w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final VoiceCallActiveEventView f2247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final VoiceControlsSheetView f2248y;

    public WidgetCallFullscreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull RelativeLayout relativeLayout, @NonNull p4 p4Var, @NonNull Barrier barrier, @NonNull ConstraintLayout constraintLayout2, @NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton2, @NonNull VideoCallParticipantView videoCallParticipantView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton3, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView2, @NonNull StageCallVisitCommunityView stageCallVisitCommunityView, @NonNull ViewStub viewStub, @NonNull q4 q4Var, @NonNull ConstraintLayout constraintLayout5, @NonNull UserSummaryView userSummaryView, @NonNull MaterialTextView materialTextView, @NonNull CallEventsButtonView callEventsButtonView, @NonNull VoiceCallActiveEventView voiceCallActiveEventView, @NonNull Barrier barrier2, @NonNull VoiceControlsSheetView voiceControlsSheetView, @NonNull FragmentContainerView fragmentContainerView) {
        this.a = constraintLayout;
        this.f2245b = toolbar;
        this.c = appBarLayout;
        this.d = relativeLayout;
        this.e = p4Var;
        this.f = coordinatorLayout;
        this.g = materialButton;
        this.h = textView;
        this.i = constraintLayout3;
        this.j = linearLayout;
        this.k = materialButton2;
        this.l = videoCallParticipantView;
        this.m = recyclerView;
        this.n = materialButton3;
        this.o = constraintLayout4;
        this.p = recyclerView2;
        this.q = stageCallVisitCommunityView;
        this.r = viewStub;
        this.f2246s = q4Var;
        this.t = constraintLayout5;
        this.u = userSummaryView;
        this.v = materialTextView;
        this.w = callEventsButtonView;
        this.f2247x = voiceCallActiveEventView;
        this.f2248y = voiceControlsSheetView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
