package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetServerDeleteDialog widgetServerDeleteDialog = new WidgetServerDeleteDialog();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetServerDeleteDialog.INTENT_GUILD_ID, guildId);
            widgetServerDeleteDialog.setArguments(bundle);
            widgetServerDeleteDialog.show(fragmentManager, WidgetServerDeleteDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final MeUser me;

        /* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get$app_productionGoogleRelease(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
                final WidgetServerDeleteDialog$Model$Companion$get$1 widgetServerDeleteDialog$Model$Companion$get$1 = WidgetServerDeleteDialog$Model$Companion$get$1.INSTANCE;
                Object obj = widgetServerDeleteDialog$Model$Companion$get$1;
                if (widgetServerDeleteDialog$Model$Companion$get$1 != null) {
                    obj = new Func2() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog$sam$rx_functions_Func2$0
                        @Override // p658rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj2, Object obj3) {
                            return widgetServerDeleteDialog$Model$Companion$get$1.invoke(obj2, obj3);
                        }
                    };
                }
                Observable observableM11076j = Observable.m11076j(observableObserveMe$default, observableObserveGuild, (Func2) obj);
                C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…      ::Model\n          )");
                return ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild) {
            C12238m.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.guild = guild;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MeUser getMe() {
            return this.me;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
    public static final class C91561 extends AbstractC12240o implements Function1<Model, Unit> {
        public C91561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerDeleteDialog widgetServerDeleteDialog = WidgetServerDeleteDialog.this;
            C12238m.checkNotNullExpressionValue(model, "it");
            widgetServerDeleteDialog.configureUI(model);
        }
    }

    public WidgetServerDeleteDialog() {
        super(C5419R.layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerDeleteDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final void afterDeleteGuild(long guildId) {
        dismiss();
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2020-12_guild_delete_feedback", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            return;
        }
        GuildDeleteFeedbackSheetNavigator.INSTANCE.enqueueNotice(guildId);
    }

    private final void configureUI(final Model model) {
        if (model.getGuild() == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().f17482d;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? C1107b.m210b(context, C5419R.string.delete_server_title, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null);
        LinearLayout linearLayout = getBinding().f17484f;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().f17485g;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        C1107b.m221m(textView2, C5419R.string.delete_server_body, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17480b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerDeleteDialog.this.dismiss();
            }
        });
        MaterialButton materialButton = getBinding().f17481c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(model.getGuild().isOwner(model.getMe().getId()));
        getBinding().f17481c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                long id2 = model.getGuild().getId();
                TextInputLayout textInputLayout = WidgetServerDeleteDialog.this.getBinding().f17483e;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams.DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), WidgetServerDeleteDialog.this, null, 2, null).m11108k(C0879o.m183j(new Action1<Void>() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.2.1
                    @Override // p658rx.functions.Action1
                    public final void call(Void r4) {
                        ViewOnClickListenerC91552 viewOnClickListenerC91552 = ViewOnClickListenerC91552.this;
                        WidgetServerDeleteDialog.this.afterDeleteGuild(model.getGuild().getId());
                    }
                }, WidgetServerDeleteDialog.this.getContext(), null, 4));
            }
        });
    }

    private final WidgetServerDeleteDialogBinding getBinding() {
        return (WidgetServerDeleteDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.INSTANCE.get$app_productionGoogleRelease(getArgumentsOrDefault().getLong(INTENT_GUILD_ID));
        C12238m.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetServerDeleteDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91561());
    }
}
