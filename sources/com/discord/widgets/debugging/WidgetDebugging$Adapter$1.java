package com.discord.widgets.debugging;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.discord.app.AppLog$LoggedItem;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter$1 extends o implements Function2<List<? extends AppLog$LoggedItem>, List<? extends AppLog$LoggedItem>, Unit> {
    public final /* synthetic */ RecyclerView $recycler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging$Adapter$1(RecyclerView recyclerView) {
        super(2);
        this.$recycler = recyclerView;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends AppLog$LoggedItem> list, List<? extends AppLog$LoggedItem> list2) {
        invoke2((List<AppLog$LoggedItem>) list, (List<AppLog$LoggedItem>) list2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<AppLog$LoggedItem> list, List<AppLog$LoggedItem> list2) {
        m.checkNotNullParameter(list, "<anonymous parameter 0>");
        m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        RecyclerView$LayoutManager layoutManager = this.$recycler.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        if (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) {
            this.$recycler.scrollToPosition(0);
        }
    }
}
