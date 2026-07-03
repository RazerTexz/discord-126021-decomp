package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(FragmentManager fragmentManager, String inviteCode) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(inviteCode, "inviteCode");
            WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions = new WidgetServerSettingsInstantInvitesActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetServerSettingsInstantInvitesActions.ARG_INVITE_CODE, inviteCode);
            widgetServerSettingsInstantInvitesActions.setArguments(bundle);
            widgetServerSettingsInstantInvitesActions.show(fragmentManager, WidgetServerSettingsInstantInvitesActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsInstantInvitesActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final void create(FragmentManager fragmentManager, String str) {
        INSTANCE.create(fragmentManager, str);
    }

    private final WidgetServerSettingsInstantInviteActionsBinding getBinding() {
        return (WidgetServerSettingsInstantInviteActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleInviteRevoked(ModelInvite invite) {
        StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(invite);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        final String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || C12103t.isBlank(string)) {
            dismiss();
            return;
        }
        final String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().f17680e;
            C12238m.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().f17680e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().f17678c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
            public static final /* synthetic */ class AnonymousClass1 extends C12236k implements Function1<ModelInvite, Unit> {
                public AnonymousClass1(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions) {
                    super(1, widgetServerSettingsInstantInvitesActions, WidgetServerSettingsInstantInvitesActions.class, "handleInviteRevoked", "handleInviteRevoked(Lcom/discord/models/domain/ModelInvite;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                    invoke2(modelInvite);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ModelInvite modelInvite) {
                    C12238m.checkNotNullParameter(modelInvite, "p1");
                    ((WidgetServerSettingsInstantInvitesActions) this.receiver).handleInviteRevoked(modelInvite);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeInvite(string), false, 1, null), WidgetServerSettingsInstantInvitesActions.this, null, 2, null);
                final AnonymousClass1 anonymousClass1 = new AnonymousClass1(WidgetServerSettingsInstantInvitesActions.this);
                observableUi$default.m11108k(C0879o.m181h(new Action1() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$sam$rx_functions_Action1$0
                    @Override // p658rx.functions.Action1
                    public final /* synthetic */ void call(Object obj) {
                        C12238m.checkNotNullExpressionValue(anonymousClass1.invoke(obj), "invoke(...)");
                    }
                }, WidgetServerSettingsInstantInvitesActions.this.getContext(), null));
            }
        });
        getBinding().f17677b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0876m.m165c(C1643a.m885x(view, "it", "it.context"), strCreateLinkFromCode, 0, 4);
                WidgetServerSettingsInstantInvitesActions.this.dismiss();
            }
        });
        getBinding().f17679d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context contextM885x = C1643a.m885x(view, "it", "it.context");
                String str = strCreateLinkFromCode;
                IntentUtils.performChooserSendIntent(contextM885x, str, C1107b.m213e(WidgetServerSettingsInstantInvitesActions.this, C5419R.string.share_invite_mobile, new Object[]{str}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
                WidgetServerSettingsInstantInvitesActions.this.dismiss();
            }
        });
    }
}
