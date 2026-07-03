package com.discord.app;

import android.content.Context;
import androidx.annotation.AnimRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import com.discord.C5419R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppTransitionActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppTransitionActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: j */
    public static boolean f14963j;

    /* JADX INFO: renamed from: k */
    public C5457a f14964k = Transition.TYPE_SLIDE_POP_VERTICAL.getAnimations();

    /* JADX INFO: compiled from: AppTransitionActivity.kt */
    public enum Transition {
        TYPE_FADE(new C5457a(C5419R.anim.activity_fade_open_in, C5419R.anim.activity_fade_open_out, C5419R.anim.activity_fade_close_in, C5419R.anim.activity_fade_close_out)),
        TYPE_FADE_FAST(new C5457a(C5419R.anim.activity_fade_open_in_fast, C5419R.anim.activity_fade_open_out_fast, C5419R.anim.activity_fade_close_in_fast, C5419R.anim.activity_fade_close_out_fast)),
        TYPE_STANDARD(new C5457a(C5419R.anim.activity_standard_open_in, C5419R.anim.activity_standard_open_out, C5419R.anim.activity_standard_close_in, C5419R.anim.activity_standard_close_out)),
        TYPE_SLIDE_HORIZONTAL(new C5457a(C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_open_out, C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out)),
        TYPE_SLIDE_HORIZONTAL_REVERSE(new C5457a(C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out, C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_open_out)),
        TYPE_SLIDE_VERTICAL(new C5457a(C5419R.anim.activity_slide_vertical_open_in, C5419R.anim.activity_slide_vertical_open_out, C5419R.anim.activity_slide_vertical_close_in, C5419R.anim.activity_slide_vertical_close_out)),
        TYPE_SLIDE_VERTICAL_WITH_FADE(new C5457a(C5419R.anim.activity_slide_vertical_open_in, C5419R.anim.activity_fade_open_out, C5419R.anim.activity_fade_close_in, C5419R.anim.activity_slide_vertical_close_out)),
        TYPE_SLIDE_POP_VERTICAL(new C5457a(C5419R.anim.activity_slide_pop_vertical_open_in, C5419R.anim.activity_slide_pop_vertical_open_out, C5419R.anim.activity_slide_pop_vertical_close_in, C5419R.anim.activity_slide_pop_vertical_close_out)),
        TYPE_SLIDE_POP_HORIZONTAL(new C5457a(C5419R.anim.activity_slide_pop_horizontal_open_in, C5419R.anim.activity_slide_pop_horizontal_open_out, C5419R.anim.activity_slide_pop_horizontal_close_in, C5419R.anim.activity_slide_pop_horizontal_close_out)),
        TYPE_NONE(new C5457a(0, 0, 0, 0));

        private final C5457a animations;

        Transition(C5457a c5457a) {
            this.animations = c5457a;
        }

        public final C5457a getAnimations() {
            return this.animations;
        }

        public final ActivityOptionsCompat toActivityOptions(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            if ((!AccessibilityUtils.INSTANCE.isReducedMotionEnabled() ? this : null) == null) {
                return null;
            }
            C5457a c5457a = this.animations;
            return ActivityOptionsCompat.makeCustomAnimation(context, c5457a.f14965a, c5457a.f14966b);
        }
    }

    /* JADX INFO: renamed from: com.discord.app.AppTransitionActivity$a */
    /* JADX INFO: compiled from: AppTransitionActivity.kt */
    public static final class C5457a {

        /* JADX INFO: renamed from: a */
        public final int f14965a;

        /* JADX INFO: renamed from: b */
        public final int f14966b;

        /* JADX INFO: renamed from: c */
        public final int f14967c;

        /* JADX INFO: renamed from: d */
        public final int f14968d;

        public C5457a(@AnimRes int i, @AnimRes int i2, @AnimRes int i3, @AnimRes int i4) {
            this.f14965a = i;
            this.f14966b = i2;
            this.f14967c = i3;
            this.f14968d = i4;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8373a(boolean z2, boolean z3) {
        C5457a c5457a;
        if (z2 && z3) {
            return;
        }
        if ((z2 || z3) && (c5457a = this.f14964k) != null) {
            overridePendingTransition(z3 ? c5457a.f14965a : c5457a.f14967c, z3 ? c5457a.f14966b : c5457a.f14968d);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        f14963j = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        m8373a(f14963j, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m8373a(f14963j, true);
        f14963j = false;
    }
}
