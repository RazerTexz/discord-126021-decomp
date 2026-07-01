package com.discord.widgets.user;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import d0.g0.t;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserMentions$WidgetUserMentionFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0)};
    public static final WidgetUserMentions$WidgetUserMentionFilter$Companion Companion = new WidgetUserMentions$WidgetUserMentionFilter$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetUserMentions$Model$MessageLoader$Filters filters;
    private String guildName;
    private Function1<? super WidgetUserMentions$Model$MessageLoader$Filters, Unit> onFiltersUpdated;

    public WidgetUserMentions$WidgetUserMentionFilter() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserMentions$WidgetUserMentionFilter$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ Job access$delayedDismiss(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        return widgetUserMentions$WidgetUserMentionFilter.delayedDismiss();
    }

    public static final /* synthetic */ WidgetUserMentionsFilterBinding access$getBinding$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        return widgetUserMentions$WidgetUserMentionFilter.getBinding();
    }

    public static final /* synthetic */ WidgetUserMentions$Model$MessageLoader$Filters access$getFilters$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters = widgetUserMentions$WidgetUserMentionFilter.filters;
        if (widgetUserMentions$Model$MessageLoader$Filters == null) {
            m.throwUninitializedPropertyAccessException("filters");
        }
        return widgetUserMentions$Model$MessageLoader$Filters;
    }

    public static final /* synthetic */ String access$getGuildName$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        return widgetUserMentions$WidgetUserMentionFilter.guildName;
    }

    public static final /* synthetic */ Function1 access$getOnFiltersUpdated$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter) {
        Function1<? super WidgetUserMentions$Model$MessageLoader$Filters, Unit> function1 = widgetUserMentions$WidgetUserMentionFilter.onFiltersUpdated;
        if (function1 == null) {
            m.throwUninitializedPropertyAccessException("onFiltersUpdated");
        }
        return function1;
    }

    public static final /* synthetic */ void access$setFilters$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter, WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters) {
        widgetUserMentions$WidgetUserMentionFilter.filters = widgetUserMentions$Model$MessageLoader$Filters;
    }

    public static final /* synthetic */ void access$setGuildName$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter, String str) {
        widgetUserMentions$WidgetUserMentionFilter.guildName = str;
    }

    public static final /* synthetic */ void access$setOnFiltersUpdated$p(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter, Function1 function1) {
        widgetUserMentions$WidgetUserMentionFilter.onFiltersUpdated = function1;
    }

    public static final /* synthetic */ void access$updateFilters(WidgetUserMentions$WidgetUserMentionFilter widgetUserMentions$WidgetUserMentionFilter, WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters) {
        widgetUserMentions$WidgetUserMentionFilter.updateFilters(widgetUserMentions$Model$MessageLoader$Filters);
    }

    private final Job delayedDismiss() {
        CoroutineScope coroutineScope;
        View view = getView();
        if (view == null || (coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view)) == null) {
            return null;
        }
        return f.H0(coroutineScope, null, null, new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this, null), 3, null);
    }

    private final WidgetUserMentionsFilterBinding getBinding() {
        return (WidgetUserMentionsFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void updateFilters(WidgetUserMentions$Model$MessageLoader$Filters filters) {
        this.filters = filters;
        Function1<? super WidgetUserMentions$Model$MessageLoader$Filters, Unit> function1 = this.onFiltersUpdated;
        if (function1 == null) {
            m.throwUninitializedPropertyAccessException("onFiltersUpdated");
        }
        function1.invoke(filters);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_user_mentions_filter;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismissAllowingStateLoss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterThisServer");
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters = this.filters;
        if (widgetUserMentions$Model$MessageLoader$Filters == null) {
            m.throwUninitializedPropertyAccessException("filters");
        }
        checkedSetting.setChecked(!widgetUserMentions$Model$MessageLoader$Filters.getAllGuilds());
        String str = this.guildName;
        if (str == null || t.isBlank(str)) {
            CheckedSetting checkedSetting2 = getBinding().d;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.userMentionsFilterThisServer");
            checkedSetting2.setVisibility(8);
        } else {
            CheckedSetting checkedSetting3 = getBinding().d;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.userMentionsFilterThisServer");
            checkedSetting3.setVisibility(0);
            CheckedSetting checkedSetting4 = getBinding().d;
            Context context = getContext();
            checkedSetting4.setText(context != null ? b.h(context, 2131896340, new Object[]{this.guildName}, null, 4) : null);
            getBinding().d.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$1(this));
        }
        CheckedSetting checkedSetting5 = getBinding().f2683b;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.userMentionsFilterIncludeEveryone");
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters2 = this.filters;
        if (widgetUserMentions$Model$MessageLoader$Filters2 == null) {
            m.throwUninitializedPropertyAccessException("filters");
        }
        checkedSetting5.setChecked(widgetUserMentions$Model$MessageLoader$Filters2.getIncludeEveryone());
        getBinding().f2683b.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$2(this));
        CheckedSetting checkedSetting6 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.userMentionsFilterIncludeRoles");
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters3 = this.filters;
        if (widgetUserMentions$Model$MessageLoader$Filters3 == null) {
            m.throwUninitializedPropertyAccessException("filters");
        }
        checkedSetting6.setChecked(widgetUserMentions$Model$MessageLoader$Filters3.getIncludeRoles());
        getBinding().c.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$3(this));
    }
}
