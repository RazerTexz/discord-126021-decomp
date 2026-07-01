package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter extends AppFragment {
    private static final String ARG_FILTER_TYPE = "ARG_FILTER_TYPE";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private WidgetServerSettingsAuditLogFilterAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;
    private Integer filterType;
    private Long guildId;
    private final Function0<Unit> onFilterSelectedCallback;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsAuditLogFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0)};
    public static final WidgetServerSettingsAuditLogFilter$Companion Companion = new WidgetServerSettingsAuditLogFilter$Companion(null);

    public WidgetServerSettingsAuditLogFilter() {
        super(R$layout.widget_audit_log_filter);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsAuditLogFilter$binding$2.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
        this.onFilterSelectedCallback = new WidgetServerSettingsAuditLogFilter$onFilterSelectedCallback$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter, WidgetServerSettingsAuditLogFilter$Model widgetServerSettingsAuditLogFilter$Model) {
        widgetServerSettingsAuditLogFilter.configureUI(widgetServerSettingsAuditLogFilter$Model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        return widgetServerSettingsAuditLogFilter.filterPublisher;
    }

    private final void configureUI(WidgetServerSettingsAuditLogFilter$Model model) {
        if (this.filterType == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = this.adapter;
        if (widgetServerSettingsAuditLogFilterAdapter != null) {
            widgetServerSettingsAuditLogFilterAdapter.configure(model.getListItems(), this.onFilterSelectedCallback);
        }
    }

    private final WidgetAuditLogFilterBinding getBinding() {
        return (WidgetAuditLogFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        this.filterType = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_FILTER_TYPE, -1));
        this.guildId = Long.valueOf(getMostRecentIntent().getLongExtra(ARG_GUILD_ID, 0L));
        WidgetServerSettingsAuditLogFilter$Model$Companion widgetServerSettingsAuditLogFilter$Model$Companion = WidgetServerSettingsAuditLogFilter$Model.Companion;
        Context contextRequireContext = requireContext();
        Long l = this.guildId;
        long jLongValue = l != null ? l.longValue() : 0L;
        Integer num = this.filterType;
        if (num != null) {
            int iIntValue = num.intValue();
            BehaviorSubject<String> behaviorSubject = this.filterPublisher;
            m.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(widgetServerSettingsAuditLogFilter$Model$Companion.get(contextRequireContext, jLongValue, iIntValue, behaviorSubject)), this, null, 2, null), WidgetServerSettingsAuditLogFilter.class, (Context) null, (Function1) null, new WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$1(this), (Function0) null, (Function0) null, new WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$2(this), 54, (Object) null);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.auditLogFilterRecycler");
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = (WidgetServerSettingsAuditLogFilterAdapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsAuditLogFilterAdapter(recyclerView));
        widgetServerSettingsAuditLogFilterAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLogFilter$onViewCreated$$inlined$apply$lambda$1(this));
        this.adapter = widgetServerSettingsAuditLogFilterAdapter;
        setActionBarTitle(2131891231);
        Integer num = this.filterType;
        setActionBarSubtitle((num != null && num.intValue() == 0) ? 2131891183 : 2131891179);
        TextInputLayout textInputLayout = getBinding().f2228b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.auditLogFilterInput");
        Integer num2 = this.filterType;
        ViewExtensions.setSingleLineHint(textInputLayout, (num2 != null && num2.intValue() == 0) ? 2131895352 : 2131895293);
        TextInputLayout textInputLayout2 = getBinding().f2228b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.auditLogFilterInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetServerSettingsAuditLogFilter$onViewCreated$2(this));
    }
}
