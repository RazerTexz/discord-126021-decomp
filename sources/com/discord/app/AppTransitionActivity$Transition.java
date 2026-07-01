package com.discord.app;

import android.content.Context;
import androidx.core.app.ActivityOptionsCompat;
import com.discord.R$anim;
import com.discord.utilities.accessibility.AccessibilityUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: AppTransitionActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public enum AppTransitionActivity$Transition {
    TYPE_FADE(new AppTransitionActivity$a(R$anim.activity_fade_open_in, R$anim.activity_fade_open_out, R$anim.activity_fade_close_in, R$anim.activity_fade_close_out)),
    TYPE_FADE_FAST(new AppTransitionActivity$a(R$anim.activity_fade_open_in_fast, R$anim.activity_fade_open_out_fast, R$anim.activity_fade_close_in_fast, R$anim.activity_fade_close_out_fast)),
    TYPE_STANDARD(new AppTransitionActivity$a(R$anim.activity_standard_open_in, R$anim.activity_standard_open_out, R$anim.activity_standard_close_in, R$anim.activity_standard_close_out)),
    TYPE_SLIDE_HORIZONTAL(new AppTransitionActivity$a(R$anim.activity_slide_horizontal_open_in, R$anim.activity_slide_horizontal_open_out, R$anim.activity_slide_horizontal_close_in, R$anim.activity_slide_horizontal_close_out)),
    TYPE_SLIDE_HORIZONTAL_REVERSE(new AppTransitionActivity$a(R$anim.activity_slide_horizontal_close_in, R$anim.activity_slide_horizontal_close_out, R$anim.activity_slide_horizontal_open_in, R$anim.activity_slide_horizontal_open_out)),
    TYPE_SLIDE_VERTICAL(new AppTransitionActivity$a(R$anim.activity_slide_vertical_open_in, R$anim.activity_slide_vertical_open_out, R$anim.activity_slide_vertical_close_in, R$anim.activity_slide_vertical_close_out)),
    TYPE_SLIDE_VERTICAL_WITH_FADE(new AppTransitionActivity$a(R$anim.activity_slide_vertical_open_in, R$anim.activity_fade_open_out, R$anim.activity_fade_close_in, R$anim.activity_slide_vertical_close_out)),
    TYPE_SLIDE_POP_VERTICAL(new AppTransitionActivity$a(R$anim.activity_slide_pop_vertical_open_in, R$anim.activity_slide_pop_vertical_open_out, R$anim.activity_slide_pop_vertical_close_in, R$anim.activity_slide_pop_vertical_close_out)),
    TYPE_SLIDE_POP_HORIZONTAL(new AppTransitionActivity$a(R$anim.activity_slide_pop_horizontal_open_in, R$anim.activity_slide_pop_horizontal_open_out, R$anim.activity_slide_pop_horizontal_close_in, R$anim.activity_slide_pop_horizontal_close_out)),
    TYPE_NONE(new AppTransitionActivity$a(0, 0, 0, 0));

    private final AppTransitionActivity$a animations;

    AppTransitionActivity$Transition(AppTransitionActivity$a appTransitionActivity$a) {
        this.animations = appTransitionActivity$a;
    }

    public final AppTransitionActivity$a getAnimations() {
        return this.animations;
    }

    public final ActivityOptionsCompat toActivityOptions(Context context) {
        m.checkNotNullParameter(context, "context");
        if ((!AccessibilityUtils.INSTANCE.isReducedMotionEnabled() ? this : null) == null) {
            return null;
        }
        AppTransitionActivity$a appTransitionActivity$a = this.animations;
        return ActivityOptionsCompat.makeCustomAnimation(context, appTransitionActivity$a.a, appTransitionActivity$a.f2082b);
    }
}
