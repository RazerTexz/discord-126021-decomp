package com.discord.widgets.mobile_reports;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.report.ReportNodeBottomButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MobileReportsBottomButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsBottomButton$setup$1 implements View$OnClickListener {
    public final /* synthetic */ ReportNodeBottomButton $bottomButton;
    public final /* synthetic */ Function1 $handleButtonPress;

    public MobileReportsBottomButton$setup$1(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
        this.$handleButtonPress = function1;
        this.$bottomButton = reportNodeBottomButton;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$handleButtonPress;
        if (function1 != null) {
        }
    }
}
