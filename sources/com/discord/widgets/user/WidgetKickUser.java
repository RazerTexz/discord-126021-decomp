package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetKickUserBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetKickUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetKickUserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(String userName, long guildId, long userId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(userName, "userName");
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
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
        super(C5419R.layout.widget_kick_user);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetKickUser$binding$2.INSTANCE, null, 2, null);
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
        TextView textView = getBinding().f17214f;
        C12238m.checkNotNullExpressionValue(textView, "binding.kickUserTitle");
        C1107b.m221m(textView, C5419R.string.kick_user_title, new Object[0], new C101871(string));
        TextView textView2 = getBinding().f17210b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.kickUserBody");
        C1107b.m221m(textView2, C5419R.string.kick_user_body, new Object[0], new C101882(string));
        getBinding().f17211c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetKickUser.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetKickUser.this.dismiss();
            }
        });
        getBinding().f17212d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetKickUser.onViewBoundOrOnResume.4

            /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetKickUser.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r7) {
                    Context context = WidgetKickUser.this.getContext();
                    Context context2 = WidgetKickUser.this.getContext();
                    C0876m.m170h(context, context2 != null ? C1107b.m210b(context2, C5419R.string.kick_user_confirmed, new Object[]{string}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null, 0, null, 12);
                    WidgetKickUser.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputLayout textInputLayout = WidgetKickUser.this.getBinding().f17213e;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.kickUserReason");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().kickGuildMember(j, j2, C12103t.isBlank(textOrEmpty) ^ true ? textOrEmpty : null), false, 1, null), WidgetKickUser.this, null, 2, null), (Class<?>) WidgetKickUser.this.getClass(), (58 & 2) != 0 ? null : WidgetKickUser.this.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
            }
        });
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class C101871 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $userName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101871(String str) {
            super(1);
            this.$userName = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$userName;
            C12238m.checkNotNullExpressionValue(str, "userName");
            map.put("user", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetKickUser$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetKickUser.kt */
    public static final class C101882 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $userName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101882(String str) {
            super(1);
            this.$userName = str;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$userName;
            C12238m.checkNotNullExpressionValue(str, "userName");
            map.put("user", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
