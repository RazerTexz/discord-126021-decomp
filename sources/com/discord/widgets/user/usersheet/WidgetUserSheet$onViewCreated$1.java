package com.discord.widgets.user.usersheet;

import android.os.Bundle;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import b.a.a.d.a;
import b.a.a.d.a$b;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$onViewCreated$1(WidgetUserSheet widgetUserSheet, long j) {
        this.this$0 = widgetUserSheet;
        this.$userId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        a$b a_b = a.k;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        long j = this.$userId;
        long j2 = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID");
        Objects.requireNonNull(a_b);
        m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        a aVar = new a();
        Bundle bundleT = b.d.b.a.a.T("com.discord.intent.extra.EXTRA_USER_ID", j);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", j2);
        aVar.setArguments(bundleT);
        aVar.show(parentFragmentManager, a.class.getName());
    }
}
