package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;
import com.discord.views.calls.AppVideoStreamRenderer;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: compiled from: ViewVideoCallParticipantBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class h4 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f127b;

    @NonNull
    public final View c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ConstraintLayout e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ConstraintLayout k;

    @NonNull
    public final TextView l;

    @NonNull
    public final SimpleDraweeView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final ProgressBar p;

    @NonNull
    public final AppVideoStreamRenderer q;

    @NonNull
    public final LinearLayout r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final VoiceUserView f128s;

    public h4(@NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull Space space, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView4, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull ProgressBar progressBar, @NonNull AppVideoStreamRenderer appVideoStreamRenderer, @NonNull LinearLayout linearLayout2, @NonNull VoiceUserView voiceUserView) {
        this.a = view;
        this.f127b = view2;
        this.c = view3;
        this.d = imageView;
        this.e = constraintLayout;
        this.f = imageView2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = imageView3;
        this.k = constraintLayout2;
        this.l = textView5;
        this.m = simpleDraweeView;
        this.n = textView6;
        this.o = textView7;
        this.p = progressBar;
        this.q = appVideoStreamRenderer;
        this.r = linearLayout2;
        this.f128s = voiceUserView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
