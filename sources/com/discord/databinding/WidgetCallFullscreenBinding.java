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
import com.discord.views.calls.CallEventsButtonView;
import com.discord.views.calls.StageCallVisitCommunityView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VoiceCallActiveEventView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.voice.controls.VoiceControlsSheetView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import p007b.p008a.p025i.C1028p4;
import p007b.p008a.p025i.C1035q4;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15758a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Toolbar f15759b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppBarLayout f15760c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RelativeLayout f15761d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C1028p4 f15762e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CoordinatorLayout f15763f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f15764g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15765h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final ConstraintLayout f15766i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final LinearLayout f15767j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final MaterialButton f15768k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final VideoCallParticipantView f15769l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final RecyclerView f15770m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final MaterialButton f15771n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final ConstraintLayout f15772o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final RecyclerView f15773p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final StageCallVisitCommunityView f15774q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final ViewStub f15775r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final C1035q4 f15776s;

    /* JADX INFO: renamed from: t */
    @NonNull
    public final ConstraintLayout f15777t;

    /* JADX INFO: renamed from: u */
    @NonNull
    public final UserSummaryView f15778u;

    /* JADX INFO: renamed from: v */
    @NonNull
    public final MaterialTextView f15779v;

    /* JADX INFO: renamed from: w */
    @NonNull
    public final CallEventsButtonView f15780w;

    /* JADX INFO: renamed from: x */
    @NonNull
    public final VoiceCallActiveEventView f15781x;

    /* JADX INFO: renamed from: y */
    @NonNull
    public final VoiceControlsSheetView f15782y;

    public WidgetCallFullscreenBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout, @NonNull RelativeLayout relativeLayout, @NonNull C1028p4 c1028p4, @NonNull Barrier barrier, @NonNull ConstraintLayout constraintLayout2, @NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout3, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton2, @NonNull VideoCallParticipantView videoCallParticipantView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton3, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView2, @NonNull StageCallVisitCommunityView stageCallVisitCommunityView, @NonNull ViewStub viewStub, @NonNull C1035q4 c1035q4, @NonNull ConstraintLayout constraintLayout5, @NonNull UserSummaryView userSummaryView, @NonNull MaterialTextView materialTextView, @NonNull CallEventsButtonView callEventsButtonView, @NonNull VoiceCallActiveEventView voiceCallActiveEventView, @NonNull Barrier barrier2, @NonNull VoiceControlsSheetView voiceControlsSheetView, @NonNull FragmentContainerView fragmentContainerView) {
        this.f15758a = constraintLayout;
        this.f15759b = toolbar;
        this.f15760c = appBarLayout;
        this.f15761d = relativeLayout;
        this.f15762e = c1028p4;
        this.f15763f = coordinatorLayout;
        this.f15764g = materialButton;
        this.f15765h = textView;
        this.f15766i = constraintLayout3;
        this.f15767j = linearLayout;
        this.f15768k = materialButton2;
        this.f15769l = videoCallParticipantView;
        this.f15770m = recyclerView;
        this.f15771n = materialButton3;
        this.f15772o = constraintLayout4;
        this.f15773p = recyclerView2;
        this.f15774q = stageCallVisitCommunityView;
        this.f15775r = viewStub;
        this.f15776s = c1035q4;
        this.f15777t = constraintLayout5;
        this.f15778u = userSummaryView;
        this.f15779v = materialTextView;
        this.f15780w = callEventsButtonView;
        this.f15781x = voiceCallActiveEventView;
        this.f15782y = voiceControlsSheetView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15758a;
    }
}
