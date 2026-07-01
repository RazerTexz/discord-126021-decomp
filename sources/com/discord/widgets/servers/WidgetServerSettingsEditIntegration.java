package com.discord.widgets.servers;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditIntegrationBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.g;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration extends AppFragment {
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INTEGRATION_ID = "INTENT_EXTRA_INTEGRATION_ID";
    private static final int STATE_KEY_ENABLE_TWITCH_EMOTES = 2131363149;
    private static final int STATE_KEY_EXPIRE_BEHAVIOR = 2131363152;
    private static final int STATE_KEY_GRACE_PERIOD = 2131363153;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager expiryBehaviorRadioManager;

    /* JADX INFO: renamed from: expiryBehaviorRadios$delegate, reason: from kotlin metadata */
    private final Lazy expiryBehaviorRadios;
    private RadioManager gracePeriodRadioManager;

    /* JADX INFO: renamed from: gracePeriodRadios$delegate, reason: from kotlin metadata */
    private final Lazy gracePeriodRadios;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEditIntegration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0)};
    public static final WidgetServerSettingsEditIntegration$Companion Companion = new WidgetServerSettingsEditIntegration$Companion(null);
    private static final int[] gracePeriodDays = {1, 3, 7, 14, 30};

    public WidgetServerSettingsEditIntegration() {
        super(R$layout.widget_server_settings_edit_integration);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEditIntegration$binding$2.INSTANCE, null, 2, null);
        this.expiryBehaviorRadios = g.lazy(new WidgetServerSettingsEditIntegration$expiryBehaviorRadios$2(this));
        this.gracePeriodRadios = g.lazy(new WidgetServerSettingsEditIntegration$gracePeriodRadios$2(this));
        this.state = new StatefulViews(2131363149, 2131363152, 2131363153);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model) {
        widgetServerSettingsEditIntegration.configureUI(widgetServerSettingsEditIntegration$Model);
    }

    public static final /* synthetic */ WidgetServerSettingsEditIntegrationBinding access$getBinding$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.expiryBehaviorRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ int[] access$getGracePeriodDays$cp() {
        return gracePeriodDays;
    }

    public static final /* synthetic */ RadioManager access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.gracePeriodRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.state;
    }

    public static final /* synthetic */ void access$setExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.expiryBehaviorRadioManager = radioManager;
    }

    public static final /* synthetic */ void access$setGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.gracePeriodRadioManager = radioManager;
    }

    private final void configureUI(WidgetServerSettingsEditIntegration$Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarTitle(2131892093);
        setActionBarSubtitle(model.getGuild().getName());
        boolean zAreEqual = m.areEqual(model.getIntegration().getType(), "twitch");
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.editIntegrationName");
        textView.setText(model.getIntegration().getDisplayName());
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.editIntegrationOwnerName");
        textView2.setText(model.getIntegration().getUser().getUsername());
        getBinding().l.setImageResource(zAreEqual ? 2131230949 : 2131230950);
        getBinding().p.d.setOnClickListener(new WidgetServerSettingsEditIntegration$configureUI$1(this, model));
        DimmerView.setDimmed$default(getBinding().f2560b, model.getIntegration().isSyncing(), false, 2, null);
        TextView textView3 = getBinding().p.f96b;
        m.checkNotNullExpressionValue(textView3, "binding.syncSettings.editIntegrationLastSyncTime");
        WidgetServerSettingsEditIntegrationBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        CoordinatorLayout coordinatorLayout = binding.a;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView3.setText(TimeUtils.toReadableTimeString$default(context, TimeUtils.parseUTCDate(model.getIntegration().getSyncedAt()), null, 4, null));
        TextView textView4 = getBinding().p.c;
        m.checkNotNullExpressionValue(textView4, "binding.syncSettings.edi…ntegrationSubscriberCount");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        WidgetServerSettingsEditIntegrationBinding binding2 = getBinding();
        m.checkNotNullExpressionValue(binding2, "binding");
        CoordinatorLayout coordinatorLayout2 = binding2.a;
        m.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
        Context context2 = coordinatorLayout2.getContext();
        m.checkNotNullExpressionValue(context2, "binding.root.context");
        textView4.setText(b.l(StringResourceUtilsKt.getQuantityString(resources, context2, zAreEqual ? R$plurals.num_subscribers_subscribers : R$plurals.num_members_subscribers, model.getIntegration().getSubscriberCount(), Integer.valueOf(model.getIntegration().getSubscriberCount())), new Object[0], null, 2));
        getBinding().p.f.setOnClickListener(model.getRole() != null ? new WidgetServerSettingsEditIntegration$configureUI$2(model) : null);
        TextView textView5 = getBinding().p.e;
        m.checkNotNullExpressionValue(textView5, "binding.syncSettings.editIntegrationSyncedRole");
        textView5.setText(model.getRole() != null ? model.getRole().getName() : "None");
        getBinding().p.e.setTextColor(RoleUtils.getOpaqueColor(model.getRole(), ColorCompat.getColor(this, 2131100171)));
        int iIntValue = ((Number) this.state.get(2131363152, Integer.valueOf(model.getIntegration().getExpireBehavior()))).intValue();
        RadioManager radioManager = this.expiryBehaviorRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        radioManager.a(getExpiryBehaviorRadios().get(iIntValue));
        int iIntValue2 = ((Number) this.state.get(2131363153, Integer.valueOf(getGracePeriodPosition(model.getIntegration().getExpireGracePeriod())))).intValue();
        RadioManager radioManager2 = this.gracePeriodRadioManager;
        if (radioManager2 == null) {
            m.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        radioManager2.a(getGracePeriodRadios().get(iIntValue2));
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.editIntegrationCustomEmotesContainer");
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        StatefulViews statefulViews = this.state;
        CheckedSetting checkedSetting2 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
        checkedSetting.setChecked(((Boolean) statefulViews.get(checkedSetting2.getId(), Boolean.valueOf(model.getIntegration().isEnableEmoticons()))).booleanValue());
        this.state.configureSaveActionView(getBinding().o);
        getBinding().o.setOnClickListener(new WidgetServerSettingsEditIntegration$configureUI$3(this, model));
    }

    private final WidgetServerSettingsEditIntegrationBinding getBinding() {
        return (WidgetServerSettingsEditIntegrationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExpiryBehaviorRadios() {
        return (List) this.expiryBehaviorRadios.getValue();
    }

    private final int getGracePeriodPosition(int gracePeriodDays2) {
        if (gracePeriodDays2 == 1) {
            return 0;
        }
        if (gracePeriodDays2 == 3) {
            return 1;
        }
        if (gracePeriodDays2 == 7) {
            return 2;
        }
        if (gracePeriodDays2 != 14) {
            return gracePeriodDays2 != 30 ? 0 : 4;
        }
        return 3;
    }

    private final List<CheckedSetting> getGracePeriodRadios() {
        return (List) this.gracePeriodRadios.getValue();
    }

    private final RadioManager setupRadioManager(List<CheckedSetting> checkedSettings, int stateKey) {
        RadioManager radioManager = new RadioManager(checkedSettings);
        int i = 0;
        for (Object obj : checkedSettings) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            checkedSetting.e(new WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1(checkedSetting, i, this, radioManager, stateKey));
            i = i2;
        }
        return radioManager;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.Companion.getGuildIntegrations().onIntegrationScreenClosed();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.expiryBehaviorRadioManager = setupRadioManager(getExpiryBehaviorRadios(), 2131363152);
        this.gracePeriodRadioManager = setupRadioManager(getGracePeriodRadios(), 2131363153);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        List<CheckedSetting> gracePeriodRadios = getGracePeriodRadios();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(gracePeriodRadios, 10));
        int i = 0;
        for (Object obj : gracePeriodRadios) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "radio.context");
            int[] iArr = gracePeriodDays;
            checkedSetting.setText(StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.n_days_days, iArr[i], Integer.valueOf(iArr[i])));
            arrayList.add(Unit.a);
            i = i2;
        }
        getBinding().d.e(new WidgetServerSettingsEditIntegration$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_INTEGRATION_ID, -1L);
        StoreStream.Companion.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsEditIntegration$Model.Companion.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditIntegration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditIntegration$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
