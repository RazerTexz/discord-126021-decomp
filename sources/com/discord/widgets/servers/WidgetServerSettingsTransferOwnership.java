package com.discord.widgets.servers;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.WidgetServerSettingsTransferOwnership;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_USER_ID = "ARG_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsTransferOwnership.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = WidgetServerSettingsTransferOwnership.class.getSimpleName();

    /* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(long guildId, long userId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership = new WidgetServerSettingsTransferOwnership();
            Bundle bundleT = outline.T(WidgetServerSettingsTransferOwnership.ARG_GUILD_ID, guildId);
            bundleT.putLong(WidgetServerSettingsTransferOwnership.ARG_USER_ID, userId);
            widgetServerSettingsTransferOwnership.setArguments(bundleT);
            widgetServerSettingsTransferOwnership.show(fragmentManager, WidgetServerSettingsTransferOwnership.TAG);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final boolean isGuildOwner;
        private final boolean isMfaEnabled;
        private final User user;

        /* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long userId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableR = Observable.i(companion.getGuilds().observeGuild(guildId), companion.getUsers().observeUser(userId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func3<Guild, User, MeUser, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetServerSettingsTransferOwnership.Model call(Guild guild, User user, MeUser meUser) {
                        if (guild == null || meUser == null || user == null) {
                            return null;
                        }
                        return new WidgetServerSettingsTransferOwnership.Model(user, guild, meUser.getMfaEnabled(), guild.getOwnerId() == meUser.getId());
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableR);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(User user, Guild guild, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.user = user;
            this.guild = guild;
            this.isMfaEnabled = z2;
            this.isGuildOwner = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, User user, Guild guild, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                user = model.user;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                z2 = model.isMfaEnabled;
            }
            if ((i & 8) != 0) {
                z3 = model.isGuildOwner;
            }
            return model.copy(user, guild, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsMfaEnabled() {
            return this.isMfaEnabled;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsGuildOwner() {
            return this.isGuildOwner;
        }

        public final Model copy(User user, Guild guild, boolean isMfaEnabled, boolean isGuildOwner) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(user, guild, isMfaEnabled, isGuildOwner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.guild, model.guild) && this.isMfaEnabled == model.isMfaEnabled && this.isGuildOwner == model.isGuildOwner;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isMfaEnabled;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.isGuildOwner;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isGuildOwner() {
            return this.isGuildOwner;
        }

        public final boolean isMfaEnabled() {
            return this.isMfaEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", isMfaEnabled=");
            sbU.append(this.isMfaEnabled);
            sbU.append(", isGuildOwner=");
            return outline.O(sbU, this.isGuildOwner, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
            super(1, widgetServerSettingsTransferOwnership, WidgetServerSettingsTransferOwnership.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsTransferOwnership$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsTransferOwnership) this.receiver).configureUI(model);
        }
    }

    public WidgetServerSettingsTransferOwnership() {
        super(R.layout.widget_guild_transfer_ownership);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsTransferOwnership3.INSTANCE, null, 2, null);
    }

    private final void configureUI(final Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildTransferOwnershipMfaWrap");
        linearLayout.setVisibility(model.isMfaEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsTransferOwnership.this.dismiss();
            }
        });
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildTransferOwnershipConfirm");
        CheckedSetting checkedSetting = getBinding().f2455b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildTransferOwnershipAcknowledgeCheck");
        materialButton.setEnabled(checkedSetting.isChecked());
        getBinding().f2455b.setText(FormatUtils.e(this, R.string.transfer_ownership_acknowledge, new Object[]{model.getUser().getUsername()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        getBinding().f2455b.e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsTransferOwnership.this.getBinding().f2455b.toggle();
                MaterialButton materialButton2 = WidgetServerSettingsTransferOwnership.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guildTransferOwnershipConfirm");
                CheckedSetting checkedSetting2 = WidgetServerSettingsTransferOwnership.this.getBinding().f2455b;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.guildTransferOwnershipAcknowledgeCheck");
                materialButton2.setEnabled(checkedSetting2.isChecked());
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership.configureUI.3

            /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$configureUI$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
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
                public final void invoke2(Void r1) {
                    WidgetServerSettingsTransferOwnership.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().transferGuildOwnership(model.getGuild().getId(), new RestAPIParams.TransferGuildOwnership(model.getUser().getId(), WidgetServerSettingsTransferOwnership.this.getMfaCode())), false, 1, null), WidgetServerSettingsTransferOwnership.this, null, 2, null);
                Class<?> cls = WidgetServerSettingsTransferOwnership.this.getClass();
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                ObservableExtensionsKt.appSubscribe(observableUi$default, (Class<?>) cls, (58 & 2) != 0 ? null : view.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            }
        });
    }

    private final WidgetGuildTransferOwnershipBinding getBinding() {
        return (WidgetGuildTransferOwnershipBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getMfaCode() {
        TextInputLayout textInputLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildTransferOwnershipMfaCode");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildTransferOwnershipMfaCode");
            if (!(ViewExtensions.getTextOrEmpty(textInputLayout2).length() == 0)) {
                TextInputLayout textInputLayout3 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.guildTransferOwnershipMfaCode");
                return ViewExtensions.getTextOrEmpty(textInputLayout3);
            }
        }
        return null;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(ARG_GUILD_ID, -1L), getArgumentsOrDefault().getLong(ARG_USER_ID, -1L)), this, null, 2, null), (Class<?>) WidgetServerSettingsTransferOwnership.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
