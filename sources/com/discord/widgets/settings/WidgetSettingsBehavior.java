package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior extends AppFragment {
    private static final String API_LINK = "https://discord.com/developers/docs/intro";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsBehavior.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsBehavior.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetSettingsBehavior() {
        super(C5419R.layout.widget_settings_behavior);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsBehavior$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsBehaviorBinding getBinding() {
        return (WidgetSettingsBehaviorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.form_label_mobile_notifications_behavior);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        final StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        CheckedSetting checkedSetting = getBinding().f17877f;
        checkedSetting.setChecked(userSettings.getIsShiftEnterToSendEnabled());
        checkedSetting.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettings = userSettings;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeUserSettings.setIsShiftEnterToSendEnabled(bool.booleanValue());
            }
        });
        final CheckedSetting checkedSetting2 = getBinding().f17875d;
        checkedSetting2.setChecked(userSettings.getIsDeveloperMode());
        Context context = checkedSetting2.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        C1107b.m216h(context, C5419R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4);
        Context context2 = checkedSetting2.getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.m8530h(C1107b.m216h(context2, C5419R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4), false);
        checkedSetting2.setSubtextOnClickListener(new Action0() { // from class: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$2$1
            @Override // p658rx.functions.Action0
            public final void call() {
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context context3 = checkedSetting2.getContext();
                C12238m.checkNotNullExpressionValue(context3, "context");
                UriHandler.handle$default(uriHandler, context3, "https://discord.com/developers/docs/intro", false, false, null, 28, null);
            }
        });
        checkedSetting2.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettings = userSettings;
                AppActivity appActivity = this.this$0.getAppActivity();
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeUserSettings.setIsDeveloperMode(appActivity, bool.booleanValue());
            }
        });
        CheckedSetting checkedSetting3 = getBinding().f17873b;
        checkedSetting3.setChecked(userSettings.getIsChromeCustomTabsEnabled());
        checkedSetting3.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettings = userSettings;
                C12238m.checkNotNullExpressionValue(bool, "isChecked");
                storeUserSettings.setIsChromeCustomTabsEnabled(bool.booleanValue());
            }
        });
        for (TextView textView : C12147n.listOf((Object[]) new TextView[]{getBinding().f17876e, getBinding().f17874c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
