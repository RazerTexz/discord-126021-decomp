package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import b.a.d.AppHelpDesk;
import com.discord.i18n.RenderContext;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemMFA$onConfigure$1 extends Lambda implements Function1<RenderContext, Unit> {
    public static final WidgetChannelsListAdapter$ItemMFA$onConfigure$1 INSTANCE = new WidgetChannelsListAdapter$ItemMFA$onConfigure$1();

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$ItemMFA$onConfigure$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            Intrinsics3.checkNotNullParameter(view, "it");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(219576828L, null), false, false, null, 28, null);
        }
    }

    public WidgetChannelsListAdapter$ItemMFA$onConfigure$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onClick", AnonymousClass1.INSTANCE);
    }
}
