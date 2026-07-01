package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetKickUserBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetKickUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetKickUserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(userName, "userName");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetKickUser widgetKickUser = new WidgetKickUser();
            Bundle bundle = new Bundle();
            bundle.putString("com.discord.intent.extra.EXTRA_USER_NAME", userName);
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundle.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            widgetKickUser.setArguments(bundle);
            widgetKickUser.show(fragmentManager, WidgetKickUser.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetKickUser() {
        super(R.layout.widget_kick_user);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetKickUser2.INSTANCE, null, 2, null);
    }

    private final WidgetKickUserBinding getBinding() {
        return (WidgetKickUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        final String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        final long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        final long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.kickUserTitle");
        FormatUtils.m(textView, R.string.kick_user_title, new Object[0], new AnonymousClass1(string));
        TextView textView2 = getBinding().f2481b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.kickUserBody");
        FormatUtils.m(textView2, R.string.kick_user_body, new Object[0], new AnonymousClass2(string));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetKickUser.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetKickUser.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetKickUser.onViewBoundOrOnResume.4

            /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetKickUser.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r7) {
                    Context context = WidgetKickUser.this.getContext();
                    Context context2 = WidgetKickUser.this.getContext();
                    AppToast.h(context, context2 != null ? FormatUtils.b(context2, R.string.kick_user_confirmed, new Object[]{string}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null, 0, null, 12);
                    WidgetKickUser.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputLayout textInputLayout = WidgetKickUser.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.kickUserReason");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().kickGuildMember(j, j2, StringsJVM.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), WidgetKickUser.this, null, 2, null), (Class<?>) WidgetKickUser.this.getClass(), (58 & 2) != 0 ? null : WidgetKickUser.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        });
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $userName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$userName = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$userName;
            Intrinsics3.checkNotNullExpressionValue(str, "userName");
            map.put("user", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $userName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$userName = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$userName;
            Intrinsics3.checkNotNullExpressionValue(str, "userName");
            map.put("user", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
