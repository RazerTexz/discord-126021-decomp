package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.google.android.material.tabs.TabLayout$Tab;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1 extends o implements Function1<WidgetDirectoriesViewModel$ViewState, Unit> {
    public final /* synthetic */ int $position;
    public final /* synthetic */ TabLayout$Tab $tab;
    public final /* synthetic */ WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1(WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1 widgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1, int i, TabLayout$Tab tabLayout$Tab) {
        super(1);
        this.this$0 = widgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1;
        this.$position = i;
        this.$tab = tabLayout$Tab;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        invoke2(widgetDirectoriesViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        String string;
        m.checkNotNullParameter(widgetDirectoriesViewModel$ViewState, "state");
        Pair pair = (Pair) u.getOrNull(widgetDirectoriesViewModel$ViewState.getMappedTabs(), this.$position);
        if (pair == null) {
            StringBuilder sbU = a.U("Missing tab for position: ");
            sbU.append(this.$position);
            throw new IllegalStateException(sbU.toString());
        }
        TabLayout$Tab tabLayout$Tab = this.$tab;
        View viewInflate = this.this$0.this$0.getLayoutInflater().inflate(R$layout.directory_channel_tab, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        TextView textView = (TextView) viewInflate;
        b.a.i.m mVar = new b.a.i.m(textView, textView);
        if (((Number) pair.getSecond()).intValue() <= 0) {
            string = "";
        } else {
            StringBuilder sbU2 = a.U(" (");
            sbU2.append(((Number) pair.getSecond()).intValue());
            sbU2.append(')');
            string = sbU2.toString();
        }
        m.checkNotNullExpressionValue(textView, "tabView");
        StringBuilder sb = new StringBuilder();
        DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) pair.getFirst();
        Context context = this.this$0.$this_apply.getContext();
        m.checkNotNullExpressionValue(context, "context");
        sb.append(directoryEntryCategory.getTitle(context));
        sb.append(string);
        textView.setText(sb.toString());
        m.checkNotNullExpressionValue(mVar, "DirectoryChannelTabBindi…text)}$count\"\n          }");
        tabLayout$Tab.setCustomView(textView);
    }
}
