package com.discord.widgets.mobile_reports;

import android.os.Bundle;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports$$special$$inlined$args$1 extends o implements Function0<MobileReportArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.discord.widgets.mobile_reports.MobileReportArgs] */
    @Override // kotlin.jvm.functions.Function0
    public final MobileReportArgs invoke() {
        Parcelable parcelableExtra;
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        MobileReportArgs mobileReportArgs = (MobileReportArgs) (obj instanceof MobileReportArgs ? obj : null);
        ?? r1 = mobileReportArgs;
        if (mobileReportArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (r1 != 0) {
            r1 = parcelableExtra;
            return r1;
        }
        r1 = parcelableExtra;
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(MobileReportArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.mobile_reports.MobileReportArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MobileReportArgs invoke() {
        return invoke();
    }
}
