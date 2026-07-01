package com.discord.widgets.servers;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsChannelsSortActionsBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsSortActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsSortActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsChannelsSortActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsSortActionsBinding;", 0)};
    public static final WidgetServerSettingsChannelsSortActions$Companion Companion = new WidgetServerSettingsChannelsSortActions$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function1<? super Integer, Unit> sortTypeSelectedListener;

    public WidgetServerSettingsChannelsSortActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsChannelsSortActions$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI() {
        getBinding().f2551b.setOnClickListener(new WidgetServerSettingsChannelsSortActions$configureUI$1(this));
        getBinding().d.setOnClickListener(new WidgetServerSettingsChannelsSortActions$configureUI$2(this));
        getBinding().c.setOnClickListener(new WidgetServerSettingsChannelsSortActions$configureUI$3(this));
    }

    private final WidgetServerSettingsChannelsSortActionsBinding getBinding() {
        return (WidgetServerSettingsChannelsSortActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_server_settings_channels_sort_actions;
    }

    public final Function1<Integer, Unit> getSortTypeSelectedListener() {
        return this.sortTypeSelectedListener;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }

    public final void setSortTypeSelectedListener(Function1<? super Integer, Unit> function1) {
        this.sortTypeSelectedListener = function1;
    }
}
