package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(FragmentManager fragmentManager, String inviteCode) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
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
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions2.INSTANCE, null, 2, null);
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
        return R.layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        final String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || StringsJVM.isBlank(string)) {
            dismiss();
            return;
        }
        final String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.1

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$onResume$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
            public static final /* synthetic */ class C03101 extends FunctionReferenceImpl implements Function1<ModelInvite, Unit> {
                public C03101(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions) {
                    super(1, widgetServerSettingsInstantInvitesActions, WidgetServerSettingsInstantInvitesActions.class, "handleInviteRevoked", "handleInviteRevoked(Lcom/discord/models/domain/ModelInvite;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                    invoke2(modelInvite);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ModelInvite modelInvite) {
                    Intrinsics3.checkNotNullParameter(modelInvite, "p1");
                    ((WidgetServerSettingsInstantInvitesActions) this.receiver).handleInviteRevoked(modelInvite);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeInvite(string), false, 1, null), WidgetServerSettingsInstantInvitesActions.this, null, 2, null);
                final C03101 c03101 = new C03101(WidgetServerSettingsInstantInvitesActions.this);
                observableUi$default.k(o.h(new Action1() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$sam$rx_functions_Action1$0
                    @Override // rx.functions.Action1
                    public final /* synthetic */ void call(Object obj) {
                        Intrinsics3.checkNotNullExpressionValue(c03101.invoke(obj), "invoke(...)");
                    }
                }, WidgetServerSettingsInstantInvitesActions.this.getContext(), null));
            }
        });
        getBinding().f2573b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppToast.c(outline.x(view, "it", "it.context"), strCreateLinkFromCode, 0, 4);
                WidgetServerSettingsInstantInvitesActions.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context contextX = outline.x(view, "it", "it.context");
                String str = strCreateLinkFromCode;
                IntentUtils.performChooserSendIntent(contextX, str, FormatUtils.e(WidgetServerSettingsInstantInvitesActions.this, R.string.share_invite_mobile, new Object[]{str}, (4 & 4) != 0 ? FormatUtils.a.j : null));
                WidgetServerSettingsInstantInvitesActions.this.dismiss();
            }
        });
    }
}
