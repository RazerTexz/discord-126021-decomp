package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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
                final WidgetServerDeleteDialog2 widgetServerDeleteDialog2 = WidgetServerDeleteDialog2.INSTANCE;
                Object obj = widgetServerDeleteDialog2;
                if (widgetServerDeleteDialog2 != null) {
                    obj = new Func2() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog$sam$rx_functions_Func2$0
                        @Override // rx.functions.Func2
                        public final /* synthetic */ Object call(Object obj2, Object obj3) {
                            return widgetServerDeleteDialog2.invoke(obj2, obj3);
                        }
                    };
                }
                Observable observableJ = Observable.j(observableObserveMe$default, observableObserveGuild, (Func2) obj);
                Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      ::Model\n          )");
                return ObservableExtensionsKt.computationLatest(observableJ).r();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerDeleteDialog widgetServerDeleteDialog = WidgetServerDeleteDialog.this;
            Intrinsics3.checkNotNullExpressionValue(model, "it");
            widgetServerDeleteDialog.configureUI(model);
        }
    }

    public WidgetServerDeleteDialog() {
        super(R.layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerDeleteDialog3.INSTANCE, null, 2, null);
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
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? FormatUtils.b(context, R.string.delete_server_title, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null);
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        FormatUtils.m(textView2, R.string.delete_server_body, new Object[]{model.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().f2536b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerDeleteDialog.this.dismiss();
            }
        });
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(model.getGuild().isOwner(model.getMe().getId()));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                long id2 = model.getGuild().getId();
                TextInputLayout textInputLayout = WidgetServerDeleteDialog.this.getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
                ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams.DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), WidgetServerDeleteDialog.this, null, 2, null).k(o.j(new Action1<Void>() { // from class: com.discord.widgets.servers.WidgetServerDeleteDialog.configureUI.2.1
                    @Override // rx.functions.Action1
                    public final void call(Void r4) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
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
        Intrinsics3.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetServerDeleteDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
