package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.i18n.RenderContext;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ DragAndDropAdapter.Payload $data;

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            WidgetServerSettingsMembers.Companion companion = WidgetServerSettingsMembers.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            DragAndDropAdapter.Payload payload = WidgetServerSettingsRolesAdapter2.this.$data;
            Objects.requireNonNull(payload, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter.HelpItem");
            companion.create(context, ((WidgetServerSettingsRolesAdapter.HelpItem) payload).getGuildId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter2(DragAndDropAdapter.Payload payload) {
        super(1);
        this.$data = payload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onMembersClick", new AnonymousClass1());
    }
}
