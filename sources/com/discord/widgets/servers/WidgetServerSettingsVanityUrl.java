package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl extends AppFragment {
    private static final long ANIMATION_DURATION = 250;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsVanityUrl.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void translateLeft(View view, int i) {
            view.animate().translationXBy(-i).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        private final void translateToOriginX(View view) {
            view.animate().translationX(0.0f).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("VANITY_URL", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsVanityUrl.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final String vanityUrl;
        private final int vanityUrlUses;

        /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(final long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11073h = Observable.m11073h(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getVanityUrl(guildId), false, 1, null), new Func4<MeUser, Long, Guild, VanityUrlResponse, Model>() { // from class: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$Model$Companion$get$1
                    @Override // p658rx.functions.Func4
                    public final WidgetServerSettingsVanityUrl.Model call(MeUser meUser, Long l, Guild guild, VanityUrlResponse vanityUrlResponse) {
                        C12238m.checkNotNullParameter(meUser, "meUser");
                        int uses = vanityUrlResponse.getUses();
                        if (l == null || guild == null || !guild.canHaveVanityURL()) {
                            return null;
                        }
                        if (guild.isOwner(meUser.getId()) || PermissionUtils.can(32L, l)) {
                            return new WidgetServerSettingsVanityUrl.Model(guildId, guild.getName(), guild.getVanityUrlCode(), uses);
                        }
                        return null;
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…ull\n          }\n        }");
                return observableM11073h;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, String str2, int i) {
            this.guildId = j;
            this.guildName = str;
            this.vanityUrl = str2;
            this.vanityUrlUses = i;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = model.guildName;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                str2 = model.vanityUrl;
            }
            String str4 = str2;
            if ((i2 & 8) != 0) {
                i = model.vanityUrlUses;
            }
            return model.copy(j2, str3, str4, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public final Model copy(long guildId, String guildName, String vanityUrl, int vanityUrlUses) {
            return new Model(guildId, guildName, vanityUrl, vanityUrlUses);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && C12238m.areEqual(this.guildName, model.guildName) && C12238m.areEqual(this.vanityUrl, model.vanityUrl) && this.vanityUrlUses == model.vanityUrlUses;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.vanityUrl;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.vanityUrlUses;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", vanityUrl=");
            sbM833U.append(this.vanityUrl);
            sbM833U.append(", vanityUrlUses=");
            return C1643a.m814B(sbM833U, this.vanityUrlUses, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final /* synthetic */ class C93181 extends C12236k implements Function1<Model, Unit> {
        public C93181(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
            super(1, widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetServerSettingsVanityUrl) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final class C93211 extends AbstractC12240o implements Function1<VanityUrlResponse, Unit> {
        public C93211() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VanityUrlResponse vanityUrlResponse) {
            invoke2(vanityUrlResponse);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VanityUrlResponse vanityUrlResponse) {
            C12238m.checkNotNullParameter(vanityUrlResponse, "<name for destructuring parameter 0>");
            String code = vanityUrlResponse.getCode();
            int uses = vanityUrlResponse.getUses();
            WidgetServerSettingsVanityUrl.this.showLoadingUI(false);
            AppFragment.hideKeyboard$default(WidgetServerSettingsVanityUrl.this, null, 1, null);
            WidgetServerSettingsVanityUrl.this.configureInviteCode(code, uses);
            StatefulViews.clear$default(WidgetServerSettingsVanityUrl.this.state, false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final class C93222 extends AbstractC12240o implements Function1<Error, Unit> {
        public C93222() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            WidgetServerSettingsVanityUrl.this.showLoadingUI(false);
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() == 50020) {
                error.setShowErrorToasts(false);
                TextView textView = WidgetServerSettingsVanityUrl.this.getBinding().f17762d;
                C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
                textView.setVisibility(0);
            }
        }
    }

    public WidgetServerSettingsVanityUrl() {
        super(C5419R.layout.widget_server_settings_vanity_url);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsVanityUrl$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.server_settings_vanity_input);
        this.guildId = C12083g.lazy(new WidgetServerSettingsVanityUrl$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsVanityUrl$loggingConfig$1.INSTANCE, 3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    /* JADX WARN: Code duplicated, block: B:31:0x0096  */
    private final void configureInviteCode(String code, int uses) {
        boolean z2;
        boolean z3;
        TextInputLayout textInputLayout = getBinding().f17760b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f17760b;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), code));
        getBinding().f17760b.clearFocus();
        if (code != null) {
            if (code.length() > 0) {
                String strM883w = C1643a.m883w("https://discord.gg/", code);
                TextView textView = getBinding().f17761c;
                C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlCurrentUrl");
                C1107b.m221m(textView, C5419R.string.vanity_url_help_extended, new Object[]{strM883w}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            }
        }
        TextView textView2 = getBinding().f17761c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlCurrentUrl");
        if (code == null) {
            z2 = false;
        } else {
            if (code.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        textView2.setVisibility(z2 ? 0 : 8);
        TextView textView3 = getBinding().f17767i;
        C12238m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlRemove");
        if (code == null) {
            z3 = false;
        } else {
            if (code.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        textView3.setVisibility(z3 ? 0 : 8);
        if (code == null) {
            getBinding().f17763e.setText(C5419R.string.vanity_url);
            return;
        }
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.vanity_url_header_uses_uses, uses, Integer.valueOf(uses));
        TextView textView4 = getBinding().f17763e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.serverSettingsVanityUrlHeader");
        C1107b.m221m(textView4, C5419R.string.vanity_url_header_uses, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureUI(final Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        showLoadingUI(false);
        setActionBarTitle(C5419R.string.vanity_url);
        setActionBarSubtitle(model.getGuildName());
        configureInviteCode(model.getVanityUrl(), model.getVanityUrlUses());
        this.state.configureSaveActionView(getBinding().f17768j);
        getBinding().f17768j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsVanityUrl.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
                long guildId = model.getGuildId();
                TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.this.getBinding().f17760b;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
                int length = textOrEmpty.length() - 1;
                int i = 0;
                boolean z2 = false;
                while (i <= length) {
                    boolean z3 = C12238m.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z3) {
                        i++;
                    } else {
                        z2 = true;
                    }
                }
                widgetServerSettingsVanityUrl.updateVanityUrl(guildId, textOrEmpty.subSequence(i, length + 1).toString());
            }
        });
        getBinding().f17767i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsVanityUrl.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsVanityUrl.this.updateVanityUrl(model.getGuildId(), "");
            }
        });
    }

    private final WidgetServerSettingsVanityUrlBinding getBinding() {
        return (WidgetServerSettingsVanityUrlBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void showLoadingUI(boolean loading) {
        ProgressBar progressBar = getBinding().f17765g;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.serverSettingsVanityUrlLoadingIndicator");
        progressBar.setVisibility(loading ? 0 : 8);
        TextView textView = getBinding().f17762d;
        C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f17767i;
        C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlRemove");
        textView2.setEnabled(!loading);
    }

    private final void updateVanityUrl(long guildId, String code) {
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateVanityUrl(guildId, new RestAPIParams.VanityUrl(code)), false, 1, null), this, null, 2, null), (Class<?>) WidgetServerSettingsVanityUrl.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C93222()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93211());
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), (Class<?>) WidgetServerSettingsVanityUrl.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93181(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17760b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new View.OnFocusChangeListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsVanityUrl.onViewBound.1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z2) {
                if (!z2) {
                    Companion companion = WidgetServerSettingsVanityUrl.INSTANCE;
                    TextView textView = WidgetServerSettingsVanityUrl.this.getBinding().f17766h;
                    C12238m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlPrefix");
                    companion.translateToOriginX(textView);
                    TextInputLayout textInputLayout2 = WidgetServerSettingsVanityUrl.this.getBinding().f17760b;
                    C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
                    companion.translateToOriginX(textInputLayout2);
                    return;
                }
                TextView textView2 = WidgetServerSettingsVanityUrl.this.getBinding().f17766h;
                C12238m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlPrefix");
                int width = textView2.getWidth();
                Companion companion2 = WidgetServerSettingsVanityUrl.INSTANCE;
                TextView textView3 = WidgetServerSettingsVanityUrl.this.getBinding().f17766h;
                C12238m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlPrefix");
                companion2.translateLeft(textView3, width);
                TextInputLayout textInputLayout3 = WidgetServerSettingsVanityUrl.this.getBinding().f17760b;
                C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.serverSettingsVanityInput");
                companion2.translateLeft(textInputLayout3, width);
            }
        });
        getBinding().f17764f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsVanityUrl.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
                TextInputLayout textInputLayout2 = widgetServerSettingsVanityUrl.getBinding().f17760b;
                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
                widgetServerSettingsVanityUrl.showKeyboard(textInputLayout2);
            }
        });
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().f17768j;
        TextInputLayout textInputLayout2 = getBinding().f17760b;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }
}
