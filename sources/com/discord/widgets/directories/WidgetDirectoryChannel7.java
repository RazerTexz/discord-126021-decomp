package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.i.DirectoryChannelTabBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.google.android.material.tabs.TabLayout;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel7 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
    public final /* synthetic */ TabLayout $this_apply;
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public final /* synthetic */ int $position;
        public final /* synthetic */ TabLayout.Tab $tab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, TabLayout.Tab tab) {
            super(1);
            this.$position = i;
            this.$tab = tab;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            String string;
            Intrinsics3.checkNotNullParameter(viewState, "state");
            Tuples2 tuples2 = (Tuples2) _Collections.getOrNull(viewState.getMappedTabs(), this.$position);
            if (tuples2 == null) {
                StringBuilder sbU = outline.U("Missing tab for position: ");
                sbU.append(this.$position);
                throw new IllegalStateException(sbU.toString());
            }
            TabLayout.Tab tab = this.$tab;
            View viewInflate = WidgetDirectoryChannel7.this.this$0.getLayoutInflater().inflate(R.layout.directory_channel_tab, (ViewGroup) null, false);
            Objects.requireNonNull(viewInflate, "rootView");
            TextView textView = (TextView) viewInflate;
            DirectoryChannelTabBinding directoryChannelTabBinding = new DirectoryChannelTabBinding(textView, textView);
            if (((Number) tuples2.getSecond()).intValue() <= 0) {
                string = "";
            } else {
                StringBuilder sbU2 = outline.U(" (");
                sbU2.append(((Number) tuples2.getSecond()).intValue());
                sbU2.append(')');
                string = sbU2.toString();
            }
            Intrinsics3.checkNotNullExpressionValue(textView, "tabView");
            StringBuilder sb = new StringBuilder();
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) tuples2.getFirst();
            Context context = WidgetDirectoryChannel7.this.$this_apply.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            sb.append(directoryEntryCategory.getTitle(context));
            sb.append(string);
            textView.setText(sb.toString());
            Intrinsics3.checkNotNullExpressionValue(directoryChannelTabBinding, "DirectoryChannelTabBindi…text)}$count\"\n          }");
            tab.setCustomView(textView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel7(TabLayout tabLayout, WidgetDirectoryChannel widgetDirectoryChannel) {
        super(2);
        this.$this_apply = tabLayout;
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
        invoke(tab, num.intValue());
        return Unit.a;
    }

    public final void invoke(TabLayout.Tab tab, int i) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
        this.this$0.getViewModel().withViewState(new AnonymousClass1(i, tab));
    }
}
