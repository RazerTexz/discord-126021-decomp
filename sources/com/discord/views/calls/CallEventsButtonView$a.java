package com.discord.views.calls;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;

/* JADX INFO: compiled from: CallEventsButtonView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallEventsButtonView$a implements View$OnClickListener {
    public final /* synthetic */ FragmentManager j;
    public final /* synthetic */ long k;
    public final /* synthetic */ long l;

    public CallEventsButtonView$a(FragmentManager fragmentManager, long j, long j2) {
        this.j = fragmentManager;
        this.k = j;
        this.l = j2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventListBottomSheet.Companion.show(this.j, this.k, Long.valueOf(this.l));
    }
}
