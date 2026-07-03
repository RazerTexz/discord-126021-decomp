package p007b.p008a.p024h;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.h.a */
/* JADX INFO: compiled from: CustomTabs.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0907a extends AbstractC12240o implements Function1<String, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0907a(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(String str) {
        String str2 = str;
        C12238m.checkNotNullParameter(str2, "it");
        return Boolean.valueOf(!C12238m.areEqual(str2, this.$context.getPackageName()));
    }
}
