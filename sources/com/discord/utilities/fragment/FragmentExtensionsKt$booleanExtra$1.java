package com.discord.utilities.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentExtensionsKt$booleanExtra$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ boolean $defaultValue;
    public final /* synthetic */ String $name;
    public final /* synthetic */ Fragment $this_booleanExtra;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentExtensionsKt$booleanExtra$1(Fragment fragment, String str, boolean z2) {
        super(0);
        this.$this_booleanExtra = fragment;
        this.$name = str;
        this.$defaultValue = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.$this_booleanExtra.getArguments();
        return arguments != null ? arguments.getBoolean(this.$name, this.$defaultValue) : this.$defaultValue;
    }
}
