package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.google.android.material.tabs.TabLayout;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.C1002m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1 extends AbstractC12240o implements Function2<TabLayout.Tab, Integer, Unit> {
    public final /* synthetic */ TabLayout $this_apply;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1 */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class C82931 extends AbstractC12240o implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public final /* synthetic */ int $position;
        public final /* synthetic */ TabLayout.Tab $tab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C82931(int i, TabLayout.Tab tab) {
            super(1);
            this.$position = i;
            this.$tab = tab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            String string;
            C12238m.checkNotNullParameter(viewState, "state");
            Pair pair = (Pair) C12163u.getOrNull(viewState.getMappedTabs(), this.$position);
            if (pair == null) {
                StringBuilder sbM833U = C1643a.m833U("Missing tab for position: ");
                sbM833U.append(this.$position);
                throw new IllegalStateException(sbM833U.toString());
            }
            TabLayout.Tab tab = this.$tab;
            View viewInflate = WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1.this.this$0.getLayoutInflater().inflate(C5419R.layout.directory_channel_tab, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            C1002m c1002m = new C1002m(textView, textView);
            if (((Number) pair.getSecond()).intValue() <= 0) {
                string = "";
            } else {
                StringBuilder sbM833U2 = C1643a.m833U(" (");
                sbM833U2.append(((Number) pair.getSecond()).intValue());
                sbM833U2.append(')');
                string = sbM833U2.toString();
            }
            C12238m.checkNotNullExpressionValue(textView, "tabView");
            StringBuilder sb = new StringBuilder();
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) pair.getFirst();
            Context context = WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1.this.$this_apply.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            sb.append(directoryEntryCategory.getTitle(context));
            sb.append(string);
            textView.setText(sb.toString());
            C12238m.checkNotNullExpressionValue(c1002m, "DirectoryChannelTabBindi…text)}$count\"\n          }");
            tab.setCustomView(textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1(TabLayout tabLayout, WidgetDirectoryChannel widgetDirectoryChannel) {
        super(2);
        this.$this_apply = tabLayout;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
        invoke(tab, num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(TabLayout.Tab tab, int i) {
        C12238m.checkNotNullParameter(tab, "tab");
        this.this$0.getViewModel().withViewState(new C82931(i, tab));
    }
}
