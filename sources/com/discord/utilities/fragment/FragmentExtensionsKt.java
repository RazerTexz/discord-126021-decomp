package com.discord.utilities.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FragmentExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentExtensionsKt {

    /* JADX INFO: renamed from: com.discord.utilities.fragment.FragmentExtensionsKt$booleanExtra$1 */
    /* JADX INFO: compiled from: FragmentExtensions.kt */
    public static final class C67561 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ boolean $defaultValue;
        public final /* synthetic */ String $name;
        public final /* synthetic */ Fragment $this_booleanExtra;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67561(Fragment fragment, String str, boolean z2) {
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

    public static final Lazy<Boolean> booleanExtra(Fragment fragment, String str, boolean z2) {
        C12238m.checkNotNullParameter(fragment, "$this$booleanExtra");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12083g.lazy(new C67561(fragment, str, z2));
    }

    public static /* synthetic */ Lazy booleanExtra$default(Fragment fragment, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return booleanExtra(fragment, str, z2);
    }
}
