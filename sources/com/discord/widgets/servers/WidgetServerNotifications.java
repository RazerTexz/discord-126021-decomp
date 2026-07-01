package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.z1;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SwipeableItemTouchHelper$SwipeRevealConfiguration;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0)};
    public static final WidgetServerNotifications$Companion Companion = new WidgetServerNotifications$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;
    private NotificationsOverridesAdapter overrideAdapter;

    public WidgetServerNotifications() {
        super(R$layout.widget_server_notifications);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerNotifications$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerNotifications widgetServerNotifications, WidgetServerNotifications$Model widgetServerNotifications$Model) {
        widgetServerNotifications.configureUI(widgetServerNotifications$Model);
    }

    public static final /* synthetic */ WidgetServerNotificationsBinding access$getBinding$p(WidgetServerNotifications widgetServerNotifications) {
        return widgetServerNotifications.getBinding();
    }

    public static final /* synthetic */ NotificationsOverridesAdapter access$getOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications) {
        NotificationsOverridesAdapter notificationsOverridesAdapter = widgetServerNotifications.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        return notificationsOverridesAdapter;
    }

    public static final /* synthetic */ void access$setOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications, NotificationsOverridesAdapter notificationsOverridesAdapter) {
        widgetServerNotifications.overrideAdapter = notificationsOverridesAdapter;
    }

    private final void configureForHub() {
        View view = getBinding().h;
        m.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(8);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(8);
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setVisibility(8);
        View view2 = getBinding().p;
        m.checkNotNullExpressionValue(view2, "binding.serverNotificationsRolesDivider");
        view2.setVisibility(8);
        CheckedSetting checkedSetting2 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverNotificationsRolesSwitch");
        checkedSetting2.setVisibility(8);
        CheckedSetting checkedSetting3 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsPushSwitch");
        checkedSetting3.setVisibility(8);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.serverNotificationsOverrideTitle");
        textView.setVisibility(8);
        z1 z1Var = getBinding().f2538b;
        m.checkNotNullExpressionValue(z1Var, "binding.addOverride");
        ConstraintLayout constraintLayout = z1Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.addOverride.root");
        constraintLayout.setVisibility(8);
        View view3 = getBinding().m;
        m.checkNotNullExpressionValue(view3, "binding.serverNotificationsOverrideDivider");
        view3.setVisibility(8);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setVisibility(8);
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(8);
        View view4 = getBinding().k;
        m.checkNotNullExpressionValue(view4, "binding.serverNotificationsHighlightsDivider");
        view4.setVisibility(8);
    }

    @MainThread
    private final void configureRadio(CheckedSetting radio, int type, WidgetServerNotifications$Model model) {
        if (model.getNotificationsSetting() == type) {
            RadioManager radioManager = this.notificationSettingsRadioManager;
            if (radioManager == null) {
                m.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
            }
            radioManager.a(radio);
        }
        if (model.getIsAboveNotifyAllSize() && type == ModelNotificationSettings.FREQUENCY_ALL) {
            CharSequence charSequenceK = b.k(this, 2131892512, new Object[0], null, 4);
            int i = CheckedSetting.j;
            radio.h(charSequenceK, false);
        } else {
            int i2 = CheckedSetting.j;
            radio.h(null, false);
        }
        radio.e(new WidgetServerNotifications$configureRadio$1(model, type));
    }

    private final void configureUI(WidgetServerNotifications$Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131893382);
        setActionBarSubtitle(model.getGuild().getName());
        ModelNotificationSettings guildSettings = model.getGuildSettings();
        boolean zIsMuted = guildSettings.isMuted();
        long id2 = model.getGuild().getId();
        View view = getBinding().h;
        m.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(zIsMuted ^ true ? 0 : 8);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(zIsMuted ^ true ? 0 : 8);
        getBinding().l.updateView(new NotificationMuteSettingsView$ViewState(zIsMuted, guildSettings.getMuteEndTime(), b.h(requireContext(), 2131889221, new Object[]{model.getGuild().getName()}, null, 4), b.h(requireContext(), 2131889286, new Object[]{model.getGuild().getName()}, null, 4), b.h(requireContext(), 2131889216, new Object[0], null, 4), 2131889217, b.h(requireContext(), 2131889222, new Object[0], null, 4)), new WidgetServerNotifications$configureUI$onMute$1(this, id2), new WidgetServerNotifications$configureUI$onUnmute$1(this, id2));
        if (model.getGuild().isHub()) {
            configureForHub();
            return;
        }
        NotificationHighlightsSettingsView$ViewState notificationHighlightsSettingsView$ViewState = new NotificationHighlightsSettingsView$ViewState(model.getGuildSettings().isMuted(), model.getGuildSettings().getNotifyHighlights(), model.getIsAboveHighlightsSize());
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        View view2 = getBinding().k;
        m.checkNotNullExpressionValue(view2, "binding.serverNotificationsHighlightsDivider");
        view2.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        if (model.getHighlightsEnabled()) {
            getBinding().j.updateView(notificationHighlightsSettingsView$ViewState, new WidgetServerNotifications$configureUI$1(this, model));
        }
        getBinding().d.setOnCheckedListener(new WidgetServerNotifications$configureUI$2(this, model));
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setChecked(model.getGuildSettings().isSuppressEveryone());
        CheckedSetting checkedSetting2 = getBinding().d;
        CheckedSetting checkedSetting3 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting2.setText(b.j(checkedSetting3, 2131889274, new Object[0], null, 4));
        getBinding().q.setOnCheckedListener(new WidgetServerNotifications$configureUI$3(this, model));
        CheckedSetting checkedSetting4 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.serverNotificationsRolesSwitch");
        checkedSetting4.setChecked(model.getGuildSettings().isSuppressRoles());
        CheckedSetting checkedSetting5 = getBinding().q;
        CheckedSetting checkedSetting6 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.serverNotificationsRolesSwitch");
        checkedSetting5.setText(b.j(checkedSetting6, 2131889275, new Object[0], null, 4));
        CheckedSetting checkedSetting7 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.serverNotificationsPushSwitch");
        checkedSetting7.setChecked(model.getGuildSettings().isMobilePush() && !model.getGuildSettings().isMuted());
        if (model.getGuildSettings().isMuted()) {
            CheckedSetting.d(getBinding().o, null, 1);
        } else {
            getBinding().o.e(new WidgetServerNotifications$configureUI$4(this, model));
        }
        CheckedSetting checkedSetting8 = getBinding().f;
        CheckedSetting checkedSetting9 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.serverNotificationsFrequency1Radio");
        checkedSetting8.setText(b.j(checkedSetting9, 2131889232, new Object[0], null, 4));
        CheckedSetting checkedSetting10 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.serverNotificationsFrequency0Radio");
        configureRadio(checkedSetting10, ModelNotificationSettings.FREQUENCY_ALL, model);
        CheckedSetting checkedSetting11 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting11, "binding.serverNotificationsFrequency1Radio");
        configureRadio(checkedSetting11, ModelNotificationSettings.FREQUENCY_MENTIONS, model);
        CheckedSetting checkedSetting12 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting12, "binding.serverNotificationsFrequency2Radio");
        configureRadio(checkedSetting12, ModelNotificationSettings.FREQUENCY_NOTHING, model);
    }

    private final ItemTouchHelper createSwipeableItemTouchHelper() {
        SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration = new SwipeableItemTouchHelper$SwipeRevealConfiguration(ColorCompat.getColor(this, 2131100382), ContextCompat.getDrawable(requireContext(), 2131231713), DimenUtils.dpToPixels(8));
        return new ItemTouchHelper(new WidgetServerNotifications$createSwipeableItemTouchHelper$1(this, swipeableItemTouchHelper$SwipeRevealConfiguration, swipeableItemTouchHelper$SwipeRevealConfiguration, swipeableItemTouchHelper$SwipeRevealConfiguration));
    }

    private final WidgetServerNotificationsBinding getBinding() {
        return (WidgetServerNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.notificationSettingsRadioManager = new RadioManager(n.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g}));
        this.overrideAdapter = new NotificationsOverridesAdapter(WidgetServerNotifications$onViewBound$1.INSTANCE);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsOverrideList");
        NotificationsOverridesAdapter notificationsOverridesAdapter = this.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        recyclerView2.setAdapter(notificationsOverridesAdapter);
        createSwipeableItemTouchHelper().attachToRecyclerView(getBinding().c);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        z1 z1Var = getBinding().f2538b;
        m.checkNotNullExpressionValue(z1Var, "binding.addOverride");
        z1Var.a.setOnClickListener(new WidgetServerNotifications$onViewBound$2(longExtra));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerNotifications$Model.Companion.get(longExtra), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerNotifications$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable observableAccess$getNotificationOverrides = WidgetServerNotifications$Companion.access$getNotificationOverrides(Companion, longExtra);
        m.checkNotNullExpressionValue(observableAccess$getNotificationOverrides, "getNotificationOverrides(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableAccess$getNotificationOverrides), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerNotifications$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
