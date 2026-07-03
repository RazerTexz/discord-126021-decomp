package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.i18n.RenderContext;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ DragAndDropAdapter.Payload $data;

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final class C93081 extends AbstractC12240o implements Function1<View, Unit> {
        public C93081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "view");
            WidgetServerSettingsMembers.Companion companion = WidgetServerSettingsMembers.INSTANCE;
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            DragAndDropAdapter.Payload payload = WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1.this.$data;
            Objects.requireNonNull(payload, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter.HelpItem");
            companion.create(context, ((WidgetServerSettingsRolesAdapter.HelpItem) payload).getGuildId());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter$RoleListHelpItem$onConfigure$1(DragAndDropAdapter.Payload payload) {
        super(1);
        this.$data = payload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8423b("onMembersClick", new C93081());
    }
}
