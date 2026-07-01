package com.discord.app;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class AppActivity$a extends o implements Function0<Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppActivity$a(int i, Object obj) {
        super(0);
        this.j = i;
        this.k = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.j;
        if (i == 0) {
            invoke2();
            return Unit.a;
        }
        if (i != 1) {
            throw null;
        }
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int i = this.j;
        if (i != 0) {
            if (i == 1) {
                Objects.requireNonNull((AppActivity) this.k);
                AppActivity appActivity = (AppActivity) this.k;
                if (appActivity.toolbar == null) {
                    appActivity.n((Toolbar) appActivity.findViewById(2131361878));
                    return;
                }
                return;
            }
            throw null;
        }
        AppActivity appActivity2 = (AppActivity) this.k;
        AppActivity.m = IntentUtils.INSTANCE.consumeExternalRoutingIntent(appActivity2.c(), appActivity2);
        Intent intentC = ((AppActivity) this.k).c();
        AppActivity appActivity3 = (AppActivity) this.k;
        Objects.requireNonNull(appActivity3);
        Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("transition") : null;
        if (!(serializableExtra instanceof AppTransitionActivity$Transition)) {
            serializableExtra = null;
        }
        AppTransitionActivity$Transition appTransitionActivity$Transition = (AppTransitionActivity$Transition) serializableExtra;
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            appTransitionActivity$Transition = AppTransitionActivity$Transition.TYPE_FADE_FAST;
        } else if (appTransitionActivity$Transition == null) {
            j jVar = j.g;
            appTransitionActivity$Transition = appActivity3.g(j.d) ? AppTransitionActivity$Transition.TYPE_SLIDE_HORIZONTAL : null;
        }
        appActivity3.k = appTransitionActivity$Transition != null ? appTransitionActivity$Transition.getAnimations() : null;
        if (((AppActivity) this.k).getSupportFragmentManager().findFragmentByTag(((AppActivity) this.k).d().getName()) != null) {
            return;
        }
        j jVar2 = j.g;
        FragmentManager supportFragmentManager = ((AppActivity) this.k).getSupportFragmentManager();
        AppActivity appActivity4 = (AppActivity) this.k;
        j.g(jVar2, supportFragmentManager, appActivity4, appActivity4.d(), 0, false, null, null, 120);
    }
}
