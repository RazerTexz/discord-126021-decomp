package com.discord.widgets.channels;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.channels.WidgetTextInVoiceOnboarding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.TextInVoiceOnboardingManager$show$textInVoiceOnboardingNotice$1, reason: use source file name */
/* JADX INFO: compiled from: TextInVoiceOnboardingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceOnboardingManager2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Function0 $onCtaClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInVoiceOnboardingManager2(Function0 function0) {
        super(1);
        this.$onCtaClicked = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetTextInVoiceOnboarding.Companion companion = WidgetTextInVoiceOnboarding.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        companion.show(supportFragmentManager, this.$onCtaClicked);
        return true;
    }
}
