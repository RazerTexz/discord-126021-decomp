package b.a.h;

import android.content.Context;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.h.a, reason: use source file name */
/* JADX INFO: compiled from: CustomTabs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabs extends Lambda implements Function1<String, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabs(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        String str2 = str;
        Intrinsics3.checkNotNullParameter(str2, "it");
        return Boolean.valueOf(!Intrinsics3.areEqual(str2, this.$context.getPackageName()));
    }
}
