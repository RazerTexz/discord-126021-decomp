package com.discord.widgets.channels;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TextInVoiceOnboardingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceOnboardingManager$show$textInVoiceOnboardingNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Function0 $onCtaClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInVoiceOnboardingManager$show$textInVoiceOnboardingNotice$1(Function0 function0) {
        super(1);
        this.$onCtaClicked = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetTextInVoiceOnboarding$Companion widgetTextInVoiceOnboarding$Companion = WidgetTextInVoiceOnboarding.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        widgetTextInVoiceOnboarding$Companion.show(supportFragmentManager, this.$onCtaClicked);
        return true;
    }
}
