package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ Map $settingMap;
    public final /* synthetic */ String $settingsSubPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteHandlers$selectFeature$1(Map map, String str) {
        super(1);
        this.$settingMap = map;
        this.$settingsSubPath = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "ctx");
        Function1 function1 = (Function1) this.$settingMap.get(this.$settingsSubPath);
        if (function1 == null) {
            return true;
        }
        return true;
    }
}
